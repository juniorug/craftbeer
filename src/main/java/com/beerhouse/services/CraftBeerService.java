package com.beerhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.beerhouse.models.CraftBeer;

@Component("CraftBeerService")
public interface CraftBeerService {

    void save(CraftBeer CraftBeer);

    List<CraftBeer> findAll();

    Optional<CraftBeer> findById(Long id);

    CraftBeer findByName(String name);

    void deleteById(Long id);

    Optional<CraftBeer> update(Long id, CraftBeer CraftBeer);

}
