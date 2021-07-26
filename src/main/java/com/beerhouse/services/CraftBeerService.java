package com.beerhouse.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.beerhouse.models.CraftBeer;

@Component("CraftBeerService")
public interface CraftBeerService {

    void save(CraftBeer craftBeer);

    List<CraftBeer> getAll();

    CraftBeer findById(Long id);

    List<CraftBeer> findByName(String name);

    CraftBeer update(Long id, CraftBeer craftBeer);

    void deleteById(Long id);

    void deleteAll();

}
