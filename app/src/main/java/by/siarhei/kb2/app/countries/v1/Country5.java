package by.siarhei.kb2.app.countries.v1;

import by.siarhei.kb2.app.R;

public class Country5 extends Country {

    public Country5(boolean hard) {
        super();
        this.id = 4;
        sand();
        baseGenerator.river(10);
        entityGenerator.citiesAndCastles();
        entityGenerator.guidePosts();
        entityGenerator.goldChests(60, getId());
        entityGenerator.armies(5, 5);
        createMetro();

        if (hard) {
            stones(0.75);
        } else {
            stones(0.6);
        }
    }

    private void sand() {
        for (int i = 6; i < 59; i++) {
            for (int j = 6; j < 11; j++) {
                map[i][j].setLand(R.drawable.sand);
                map[j][i].setLand(R.drawable.sand);
            }
        }
        for (int i = 6; i < 59; i++) {
            for (int j = 54; j < 59; j++) {
                map[j][i].setLand(R.drawable.sand);
                map[i][j].setLand(R.drawable.sand);
            }
        }
    }

    private void stones(double frequency) {
        for (int i = 11; i < MAX_MAP_SIZE - 11; i++) {
            for (int j = 11; j < MAX_MAP_SIZE - 11; j++) {
                if (Math.random() < frequency) {
                    if ((map[i][j].getLand() == R.drawable.land) &&
                            (map[i][j].getEntity() == null)) {
                        map[i][j].setLand(R.drawable.stone);
                    }
                }
            }
        }
    }
}
