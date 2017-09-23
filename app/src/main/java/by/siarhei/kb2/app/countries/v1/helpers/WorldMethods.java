package by.siarhei.kb2.app.countries.v1.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import by.siarhei.kb2.app.R;
import by.siarhei.kb2.app.countries.v1.Country;
import by.siarhei.kb2.app.countries.v1.World;
import by.siarhei.kb2.app.entities.ArmyShop;
import by.siarhei.kb2.app.entities.City;
import by.siarhei.kb2.app.entities.Metro;
import by.siarhei.kb2.app.models.MapPoint;
import by.siarhei.kb2.app.models.iterators.ArmyShopsOwner;
import by.siarhei.kb2.app.models.iterators.CitiesOwner;
import by.siarhei.kb2.app.models.iterators.EntityIterator;

/**
 * Created by yuri on 9/22/17.
 */

public class WorldMethods {
    private final Random random = new Random();
    private World world;
    public WorldMethods(World world) {
        this.world = world;
    }

    public Iterator<ArmyShop> getArmyShops() {
        ArrayList<Iterator<ArmyShop>> iterators = new ArrayList<>();
        for (Country country: world.getCountries()) {
            iterators.add(new CountryMethods(country).getArmyShops());
        }
//        for (ArmyShopsOwner shop : country) {
//            iterators.add(shop.getArmyShops());
//        }
        return new EntityIterator<>(iterators);
    }

    public Iterator<City> getCities() {
        ArrayList<Iterator<City>> iterators = new ArrayList<>();
        for (Country country: world.getCountries()) {
            iterators.add(new CountryMethods(country).getCities());
        }
//        for (CitiesOwner city : country) {
//            iterators.add(city.getCities());
//        }
        return new EntityIterator<>(iterators);
    }
}
