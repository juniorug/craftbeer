package com.beerhouse.serviceImpl;

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
    public Optional<CraftBeer> findById(Long id) {
        return craftBeerRepository.findById(id);
    }

    @Override
    public CraftBeer findByName(String name) {
        return craftBeerRepository.findByName(name);
    }
    
    @Override
    public List<CraftBeer> findAll() {
        return craftBeerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        craftBeerRepository.deleteById(id);
    }

    @Override
    public Optional<CraftBeer> update(Long id, CraftBeer newCraftBeer) {
        return craftBeerRepository.findById(id);
            /*.map(craftBeer -> {
                craftBeer.setName(newCraftBeer.getName());
                craftBeerRepository.save(craftBeer);
            })*/

    }
}
