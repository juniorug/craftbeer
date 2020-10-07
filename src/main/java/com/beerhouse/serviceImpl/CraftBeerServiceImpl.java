package com.beerhouse.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.models.CraftBeer;
import com.beerhouse.repositories.CraftBeerRepository;
import com.beerhouse.services.CraftBeerService;


@Service
public class CraftBeerServiceImpl<U> implements CraftBeerService {

    @Autowired
    private CraftBeerRepository craftBeerRepository;
    
    @Override
    public void save(CraftBeer CraftBeer) {
    	craftBeerRepository.save(CraftBeer); 
    }
    
    @Override
    public List<CraftBeer> getAll() {
//        List<CraftBeer> craftBeers = new ArrayList<CraftBeer>();
//        Iterable<CraftBeer> getAll = craftBeerRepository.findAll();
//        getAll.forEach(craftBeers::add);
        return craftBeerRepository.findAll();
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
    public CraftBeer update(Long id, CraftBeer newCraftBeer) {
         craftBeerRepository.findById(id)
         .map((Function<CraftBeer, CraftBeer>) record -> { 
                record.setName(newCraftBeer.getName());
                record.setCategoryName(newCraftBeer.getCategoryName());
                record.setBreweryName(newCraftBeer.getBreweryName());
                record.setAbv(newCraftBeer.getAbv());
                record.setIbu(newCraftBeer.getIbu());
                craftBeerRepository.save(record);
                return record;
            });
        return null;

    }
    
    @Override
    public void deleteById(Long id) {
        craftBeerRepository.delete(id);
    }
    
    @Override
    public void deleteAll() {
        craftBeerRepository.deleteAll();
    }
}
