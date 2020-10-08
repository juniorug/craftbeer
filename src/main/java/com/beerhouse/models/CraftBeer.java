package com.beerhouse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CraftBeer")
public class CraftBeer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "name", unique = true)
    public String name;

    @Size(min = 2, max = 50)
    @Column(name = "categoryName", unique = false)
    public String categoryName;

    @Size(min = 2, max = 50)
    @Column(name = "breweryName", unique = false)
    public String breweryName;

    @Column(name = "abv", unique = false, precision = 2, scale = 1)
    public double abv;

    @Column(name = "ibu", columnDefinition = "Decimal(2) default '0'")
    public int ibu;

    public CraftBeer() {

    }

    public CraftBeer(String name, String categoryName) {
        this.name = name;
        this.categoryName = categoryName;
    }

    public CraftBeer(Long id, String name, String categoryName, String breweryName, double abv, int ibu) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.breweryName = breweryName;
        this.abv = abv;
        this.ibu = ibu;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

}
