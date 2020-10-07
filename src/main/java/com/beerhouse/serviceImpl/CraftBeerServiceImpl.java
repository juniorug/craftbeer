package com.beerhouse.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.models.CraftBeer;
import com.beerhouse.repositories.CraftBeerRepository;
import com.beerhouse.services.CraftBeerService;


@Service
public class CraftBeerServiceImpl implements CraftBeerService {

    @Autowired
    private CraftBeerRepository craftBeerRepository;
    
    @Override
    public void save(CraftBeer CraftBeer) {
    	craftBeerRepository.save(CraftBeer); 
    }
    
    @Override
    public List<CraftBeer> getAll() {
        List<CraftBeer> craftBeers = new ArrayList<CraftBeer>();
        Iterable<CraftBeer> getAll = craftBeerRepository.findAll();
        System.out.println(getAll.toString());
        getAll.forEach(craftBeers::add);
        return craftBeers;
    }
    
    @Override
    public CraftBeer findById(Long id) {
        return craftBeerRepository.findOne(id);
    }
    
    @Override
    public List<CraftBeer> findByName(String name) {
        return craftBeerRepository.findByName(name);
    }
    

    @Override
    public void deleteById(Long id) {
        craftBeerRepository.delete(id);
    }

    @Override
    public CraftBeer update(Long id, CraftBeer newCraftBeer) {
        return craftBeerRepository.findOne(id);
            /*.map(craftBeer -> {
                craftBeer.setName(newCraftBeer.getName());
                craftBeerRepository.save(craftBeer);
            })*/

    }
}
