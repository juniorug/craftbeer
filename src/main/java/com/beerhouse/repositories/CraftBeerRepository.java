package com.beerhouse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beerhouse.models.CraftBeer;

@Repository
public interface CraftBeerRepository extends JpaRepository<CraftBeer, Long> {

    //@Override
    //List<CraftBeer> findAll();
    
    Optional<CraftBeer> findById(Long id);
    
    List<CraftBeer> findByName(String name);
    
    //void deleteById(Long id);
}
