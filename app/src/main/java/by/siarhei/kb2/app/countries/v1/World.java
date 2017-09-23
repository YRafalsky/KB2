package by.siarhei.kb2.app.countries.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import by.siarhei.kb2.app.entities.ArmyShop;
import by.siarhei.kb2.app.entities.City;
import by.siarhei.kb2.app.models.iterators.ArmyShopsOwner;
import by.siarhei.kb2.app.models.iterators.CitiesOwner;
import by.siarhei.kb2.app.models.iterators.EntityIterator;


public class World implements Serializable, ArmyShopsOwner, CitiesOwner {
    private Country[] country;

    public World(Country[] country){
        this.country = country;
    }

    public Country getCountry(int i) {
        return country[i];
    }


    @Override
    public Iterator<ArmyShop> getArmyShops() {
        ArrayList<Iterator<ArmyShop>> iterators = new ArrayList<>();
        for (ArmyShopsOwner shop : country) {
            iterators.add(shop.getArmyShops());
        }
        return new EntityIterator<>(iterators);
    }

    @Override
    public Iterator<City> getCities() {
        ArrayList<Iterator<City>> iterators = new ArrayList<>();
        for (CitiesOwner city : country) {
            iterators.add(city.getCities());
        }
        return new EntityIterator<>(iterators);
    }
}

