package by.siarhei.kb2.app.models.v1.helpers;

import by.siarhei.kb2.app.controllers.GameCallback;
import by.siarhei.kb2.app.models.v1.Game;

/**
 * Created by yuri on 9/22/17.
 */

public class GameGenerator {
    public static Game generateGame(GameCallback callbacks, int mode) {
        Game game = new Game(callbacks, mode);
        World       world = new World(mode);
//        player = new Player(world.getCountry(0), mode);
//        if (mode == MODE_GAME) {
//            weeks = 200 - 1;
//        } else if (mode == MODE_TRAINING) {
//            weeks = 600 - 1;
//        }
        return null;
    }
}
