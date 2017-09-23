package by.siarhei.kb2.app.countries.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import by.siarhei.kb2.app.R;
import by.siarhei.kb2.app.entities.ArmyShop;
import by.siarhei.kb2.app.entities.Castle;
import by.siarhei.kb2.app.entities.City;
import by.siarhei.kb2.app.entities.Entity;
import by.siarhei.kb2.app.entities.Metro;
import by.siarhei.kb2.app.models.Glade;
import by.siarhei.kb2.app.models.MapPoint;


public class Country implements Glade, Serializable {
    public final static int MAX_MAP_SIZE = 65;
    final MapPoint[][] map;
    private  ArrayList<City> cities = new ArrayList<>();

    public ArrayList<ArmyShop> getArmyShopsVar() {
        return armyShops;
    }

    private  ArrayList<ArmyShop> armyShops = new ArrayList<>();
    private  ArrayList<Castle> castles = new ArrayList<>();

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<City> getCitiesVar() {
        return this.cities;
    }

    public void setArmyShops(ArrayList<ArmyShop> armyShops) {
        this.armyShops = armyShops;
    }

    public void setCastles(ArrayList<Castle> castles) {
        this.castles = castles;
    }

    public ArrayList<Castle> getCastlesVar() {
        return this.castles;
    }


//    final BaseGenerator baseGenerator;
//    final EntityGenerator entityGenerator;
    private final Random random;

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public Metro getMetro1() {
        return metro1;
    }

    public void setMetro1(Metro metro1) {
        this.metro1 = metro1;
    }

    public Metro getMetro2() {
        return metro2;
    }

    public void setMetro2(Metro metro2) {
        this.metro2 = metro2;
    }

    private Metro metro1;
    private Metro metro2;

    public Country() {
        random = new Random();

        map = new MapPoint[MAX_MAP_SIZE][MAX_MAP_SIZE];
        for (int i = 0; i < MAX_MAP_SIZE; i++) {
            for (int j = 0; j < MAX_MAP_SIZE; j++) {
                map[i][j] = new MapPoint(this, i, j);
            }
        }

//        baseGenerator = new BaseGenerator(this);
//        entityGenerator = new EntityGenerator(this);
//
//        baseGenerator.base();
    }

    @Override
    public MapPoint getMapPoint(int x, int y) {
        return map[x][y];
    }

    @Override
    public MapPoint[][] getMapPoints() {
        return map;
    }

//    @Override
//    public Iterator<ArmyShop> getArmyShops() {
//        return entityGenerator.getArmyShops();
//    }

//    @Override
//    public Iterator<City> getCities() {
//        return entityGenerator.getCities();
//    }

//    @Override
//    public Iterator<Castle> getCastles() {
//        return null;
//    }

    public int getId() {
        return id;
    }

    @Override
    public boolean isEntity(int x, int y) {
        return map[x][y].getEntity() != null;
    }

    @Override
    public boolean isLand(int x, int y) {
        return map[x][y].getLand() == R.drawable.land;
    }

    @Override
    public Entity getEntity(int x, int y) {
        return map[x][y].getEntity();
    }

    @Override
    public boolean inBorders(int x, int y) {
        return (x > 0 && y > 0 && x < MAX_MAP_SIZE && y < MAX_MAP_SIZE);
    }

//    public void createMetro() {
//        metro1 = entityGenerator.metro();
//        metro2 = entityGenerator.metro();
//    }

//    public void createMaps() {
//        entityGenerator.updateSpell();
//    }

//    public MapPoint getLandNearCity() {
//        return getLandNearPoint(getCities().next().getMapPoint());
//    }
//
//    public MapPoint getLandNearPoint(MapPoint point) {
//        for (int x = point.getX() - 1; x <= point.getX() + 1; x++) {
//            for (int y = point.getY() - 1; y <= point.getY() + 1; y++) {
//                if (point.getGlade().getMapPoint(x, y).getLand() == R.drawable.land) {
//                    return getMapPoint(x, y);
//                }
//            }
//        }
//        return point;
//    }
//
//    public MapPoint getRandomLand() {
//        int x;
//        int y;
//        do {
//            x = random.nextInt(MAX_MAP_SIZE);
//            y = random.nextInt(MAX_MAP_SIZE);
//        } while (isEntity(x, y) || !isLand(x, y));
//        return getMapPoint(x, y);
//    }
//
//    public MapPoint getLinkedMetroPoint(Metro metro) {
//        if (metro == metro1)
//            metro = metro2;
//        else
//            metro = metro1;
//        return getLandNearPoint(metro.getMapPoint());
//    }
}

