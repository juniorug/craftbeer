package com.beerhouse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.beerhouse.models.CraftBeer;

public interface CraftBeerRepository extends CrudRepository<CraftBeer, Long> {

    @Override
    List<CraftBeer> findAll();
    
    //CraftBeer findById(Long id);
    
    CraftBeer findByName(String name);
    
    //void deleteById(Long id);
}
