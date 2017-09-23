package by.siarhei.kb2.app.countries.v1.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import by.siarhei.kb2.app.R;
import by.siarhei.kb2.app.countries.v1.Country;
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

public class CountryMethods {
    private final Random random = new Random();
    private Country country;
    public CountryMethods(Country country) {
        this.country = country;
    }

    public MapPoint getLandNearCity() {
        return getLandNearPoint(getCities().next().getMapPoint());
    }

    public MapPoint getLandNearPoint(MapPoint point) {
        for (int x = point.getX() - 1; x <= point.getX() + 1; x++) {
            for (int y = point.getY() - 1; y <= point.getY() + 1; y++) {
                if (point.getGlade().getMapPoint(x, y).getLand() == R.drawable.land) {
                    return country.getMapPoint(x, y);
                }
            }
        }
        return point;
    }

    public MapPoint getRandomLand() {
        int x;
        int y;
        do {
            x = random.nextInt(country.MAX_MAP_SIZE);
            y = random.nextInt(country.MAX_MAP_SIZE);
        } while (country.isEntity(x, y) || !country.isLand(x, y));
        return country.getMapPoint(x, y);
    }

    public MapPoint getLinkedMetroPoint(Metro metro) {
        if (metro == country.getMetro1())
            metro = country.getMetro2();
        else
            metro = country.getMetro1();
        return getLandNearPoint(metro.getMapPoint());
    }

    public Iterator<City> getCities() {
        ArrayList<Iterator<City>> iterators = new ArrayList<>();
        for (CitiesOwner city : country.getCitiesVar()) {
            iterators.add(city.getCities());
        }
        return new EntityIterator<>(iterators);
    }

    public Iterator<ArmyShop> getArmyShops() {
        ArrayList<Iterator<ArmyShop>> iterators = new ArrayList<>();
        for (ArmyShopsOwner armyShop : country.getArmyShopsVar()) {
            iterators.add(armyShop.getArmyShops());
        }
        return new EntityIterator<>(iterators);
    }
}
