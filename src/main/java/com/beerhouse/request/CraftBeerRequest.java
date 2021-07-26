package com.beerhouse.request;

import com.beerhouse.models.CraftBeer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CraftBeerRequest {

  private Long id;

  private String name;

  private String categoryName;

  private String breweryName;

  private double abv;

  private int ibu;

  public CraftBeer toEntity() {
    return CraftBeer.builder().name(name).categoryName(categoryName).breweryName(breweryName).abv(abv).ibu(ibu).build();
  }

}