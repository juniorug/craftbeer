package com.beerhouse.serviceImpl;

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
        Optional<CraftBeer> craftBeer = craftBeerRepository.findById(id);
        if (craftBeer.isPresent()) {
            craftBeer.map((Function<CraftBeer, CraftBeer>) record -> {
                record.setName(newCraftBeer.getName());
                record.setCategoryName(newCraftBeer.getCategoryName());
                record.setBreweryName(newCraftBeer.getBreweryName());
                record.setAbv(newCraftBeer.getAbv());
                record.setIbu(newCraftBeer.getIbu());
                craftBeerRepository.save(record);
                return record;
            });
            return craftBeer.get();
        }
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
