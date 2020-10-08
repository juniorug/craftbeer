package com.beerhouse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.beerhouse.models.CraftBeer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CraftBeerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }
    
    private static final String RESOURCE = "craft-beers/";
    
    @Test
    public void testGetAllCraftBeers() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + RESOURCE,
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   public void testGetCraftBeerById() {
       CraftBeer craftBeer = restTemplate.getForObject(getRootUrl() + RESOURCE + "1", CraftBeer.class);
       assertNotNull(craftBeer);
   }

   @Test
   public void testCreateCraftBeer() {
       CraftBeer craftBeer = new CraftBeer();
       craftBeer.setName("Tupiniquim Bock");
       craftBeer.setCategoryName("Bock");
       craftBeer.setBreweryName("Tupiniquim");
       craftBeer.setAbv(6.5);
       craftBeer.setIbu(15);
       ResponseEntity<CraftBeer> postResponse = restTemplate.postForEntity(getRootUrl() + RESOURCE, craftBeer, CraftBeer.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   public void testUpdateCraftBeer() {
       int id = 1;
       String newName = "IPA is not APA";
       String newBreweryName ="Sensedia";
       CraftBeer craftBeer = restTemplate.getForObject(getRootUrl() + RESOURCE + id, CraftBeer.class);
       craftBeer.setName(newName);
       craftBeer.setBreweryName(newBreweryName);
       restTemplate.put(getRootUrl() + RESOURCE + id, craftBeer);
       CraftBeer updatedCraftBeer = restTemplate.getForObject(getRootUrl() + RESOURCE + id, CraftBeer.class);
       assertNotNull(updatedCraftBeer);
       assertEquals(newName, updatedCraftBeer.getName());
       assertEquals(newBreweryName, updatedCraftBeer.getBreweryName());
   }

   @Test
   public void testDeleteCraftBeer() {
        int id = 2;
        CraftBeer craftBeer = restTemplate.getForObject(getRootUrl() + RESOURCE + id, CraftBeer.class);
        assertNotNull(craftBeer);
        restTemplate.delete(getRootUrl() + RESOURCE + id);
        try {
             craftBeer = restTemplate.getForObject(getRootUrl() + RESOURCE + id, CraftBeer.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }


}
