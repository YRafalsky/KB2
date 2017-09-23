package by.siarhei.kb2.app.countries.v1.helpers;

import by.siarhei.kb2.app.countries.generators.v1.EntityGenerator;
import by.siarhei.kb2.app.countries.v1.Country;
import by.siarhei.kb2.app.countries.v1.Country5;
import by.siarhei.kb2.app.countries.v1.CountryTest;
import by.siarhei.kb2.app.countries.v1.World;
import by.siarhei.kb2.app.models.v1.helpers.Consts;

/**
 * Created by yuri on 9/22/17.
 */

public class WorldGenerator {
    public static World GenerateWorld(int mode){
        EntityGenerator.reset();
        Country[] generatedCountry = null;
            switch (mode) {
                case Consts.MODE_TEST:
                    generatedCountry = testWorld();
                    break;
                case Consts.MODE_GAME:
                    generatedCountry = hardWorld();
                    break;
                case Consts.MODE_TRAINING:
                    generatedCountry = defaultWorld();
                    break;
            }
        return new World(generatedCountry);
    }

    private static Country[] testWorld() {
        Country[] country = new Country[5];
        country[0] = new CountryTest();
        country[1] = CountryGenerator.CreateCountry2(true);
        country[2] = CountryGenerator.CreateCountry3(true);
        country[3] = CountryGenerator.CreateCountry4(true);
        country[4] = new Country5(true);
        return country;
    }

    private static Country[] hardWorld() {
        Country[] country = new Country[5];
        country[0] = CountryGenerator.CreateCountry1(true);
        country[1] = CountryGenerator.CreateCountry2(true);
        country[2] = CountryGenerator.CreateCountry3(true);
        country[3] = CountryGenerator.CreateCountry4(true);
        country[4] = new Country5(true);
        return country;
    }

    private static Country[] defaultWorld() {
        Country[] country = new Country[5];
        country[0] = CountryGenerator.CreateCountry1(false);
        country[1] = CountryGenerator.CreateCountry2(false);
        country[2] = CountryGenerator.CreateCountry3(false);
        country[3] = CountryGenerator.CreateCountry4(false);
        country[4] = new Country5(false);
        return country;
    }
}
