package by.siarhei.kb2.app.countries.v1.helpers;

import by.siarhei.kb2.app.R;
import by.siarhei.kb2.app.countries.generators.v1.BaseGenerator;
import by.siarhei.kb2.app.countries.generators.v1.EntityGenerator;
import by.siarhei.kb2.app.countries.v1.Country;
import by.siarhei.kb2.app.entities.ArmyShop;
import by.siarhei.kb2.app.entities.Captain;
import by.siarhei.kb2.app.entities.Castle;
import by.siarhei.kb2.app.entities.CastleLeft;
import by.siarhei.kb2.app.entities.CastleRight;
import by.siarhei.kb2.app.entities.City;
import by.siarhei.kb2.app.entities.GoldChest;
import by.siarhei.kb2.app.entities.Metro;


/**
 * Created by yuri on 9/22/17.
 */

public class CountryGenerator {
    public static Country CreateCountry1(boolean hard) {
        Country country = new Country();
        country.setId(0);
        BaseGenerator baseGenerator = new BaseGenerator(country);
        EntityGenerator entityGenerator = new EntityGenerator(country);

        baseGenerator.base();
        baseGenerator.river(30);
        baseGenerator.river(20);
        baseGenerator.river(40);

        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(40, country.getId());
        entityGenerator.armies(10, 1, 0);
        entityGenerator.mapNext();
        entityGenerator.captains(30, 400);
        country.setMetro1(entityGenerator.metro());
        country.setMetro2(entityGenerator.metro());
        if (hard) {
            baseGenerator.landscape(0.33, R.drawable.forest);
            baseGenerator.landscape(0.33, R.drawable.stone);
        } else {
            baseGenerator.landscape(0.14, R.drawable.forest);
            baseGenerator.landscape(0.05, R.drawable.stone);
        }
        return country;
    }


    public static Country CreateCountry2(boolean hard)  {
        Country country = new Country();
        country.setId(1);
        BaseGenerator baseGenerator = new BaseGenerator(country);
        EntityGenerator entityGenerator = new EntityGenerator(country);
        baseGenerator.river(40);
        baseGenerator.river(50);
        baseGenerator.river(30);
        baseGenerator.river(50);
        baseGenerator.river(50);

        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(40, country.getId());
        entityGenerator.armies(5, 2);
        entityGenerator.mapNext();
        entityGenerator.captains(150, 1200);
        country.setMetro1(entityGenerator.metro());
        country.setMetro2(entityGenerator.metro());

        if (hard) {
            baseGenerator.landscape(0.125, R.drawable.water);
            baseGenerator.landscape(0.125, R.drawable.forest);
            baseGenerator.landscape(0.05, R.drawable.stone);
        } else {
            baseGenerator.landscape(0.14, R.drawable.water);
            baseGenerator.landscape(0.08, R.drawable.forest);
            baseGenerator.landscape(0.03, R.drawable.stone);
        }
        return country;
    }

    public static Country CreateCountry3(boolean hard)  {
        Country country = new Country();
        country.setId(2);
        BaseGenerator baseGenerator = new BaseGenerator(country);
        EntityGenerator entityGenerator = new EntityGenerator(country);
        baseGenerator.river(40);
        baseGenerator.river(30);

        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(40, country.getId());
        entityGenerator.armies(5, 3);
        entityGenerator.mapNext();
        country.setMetro1(entityGenerator.metro());
        country.setMetro2(entityGenerator.metro());

        if (hard) {
            baseGenerator.landscape(0.7, R.drawable.forest);
        } else {
            baseGenerator.landscape(0.5, R.drawable.forest);
        }
        return country;
    }

    public static Country CreateCountry4(boolean hard)  {
        Country country = new Country();
        country.setId(3);
        BaseGenerator baseGenerator = new BaseGenerator(country);
        EntityGenerator entityGenerator = new EntityGenerator(country);
        baseGenerator.river(40);
        baseGenerator.river(30);

        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(40, country.getId());
        entityGenerator.armies(5, 4);
        entityGenerator.mapNext();
        country.setMetro1(entityGenerator.metro());
        country.setMetro2(entityGenerator.metro());

        if (hard) {
            baseGenerator.landscape(0.7, R.drawable.stone);
        } else {
            baseGenerator.landscape(0.5, R.drawable.stone);
        }
        return country;
    }

    public static Country CreateCountry5(boolean hard)  {
        Country country = new Country();
        country.setId(4);
        BaseGenerator baseGenerator = new BaseGenerator(country);
        EntityGenerator entityGenerator = new EntityGenerator(country);
        baseGenerator.sand();
        baseGenerator.river(10);
        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(60, country.getId());
        entityGenerator.armies(5, 5);
        country.setMetro1(entityGenerator.metro());
        country.setMetro2(entityGenerator.metro());

        if (hard) {
            baseGenerator.stones(0.75);
        } else {
            baseGenerator.stones(0.6);
        }
        return country;
    }

    public static Country CreateCountryTest()  {
        Country country = new Country();
        country.setId(0);

        new ArmyShop(country.getMapPoint(5, 8), 0);
        new ArmyShop(country.getMapPoint(5, 9), 0);
        new ArmyShop(country.getMapPoint(5, 10), 0);

        Captain captain = new Captain(country.getMapPoint(8, 5));
        captain.generateArmy(28, 0);

        Castle castle = new Castle(country.getMapPoint(8, 8), 0);
        new CastleRight(country.getMapPoint(9, 8));
        new CastleLeft(country.getMapPoint(7, 8));
        castle.generateArmy(50, 0);

        new GoldChest(country.getMapPoint(5, 6), 1);

        new City(country.getMapPoint(6, 5), 0, castle);
        return country;
    }

}
