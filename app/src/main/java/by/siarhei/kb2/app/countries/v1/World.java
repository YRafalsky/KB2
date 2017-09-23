package by.siarhei.kb2.app.countries.v1;

import java.io.Serializable;

public class World implements Serializable {
    public Country[] getCountries() {
        return countries;
    }

    private Country[] countries;

    public World(Country[] country){
        this.countries = country;
    }

    public Country getCountry(int i) {
        return countries[i];
    }
//
//
//    @Override
//    public Iterator<ArmyShop> getArmyShops() {
//        ArrayList<Iterator<ArmyShop>> iterators = new ArrayList<>();
//        for (ArmyShopsOwner shop : countries) {
//            iterators.add(shop.getArmyShops());
//        }
//        return new EntityIterator<>(iterators);
//    }
//
//    @Override
//    public Iterator<City> getCities() {
//        ArrayList<Iterator<City>> iterators = new ArrayList<>();
//        for (CitiesOwner city : countries) {
//            iterators.add(city.getCities());
//        }
//        return new EntityIterator<>(iterators);
//    }
}

