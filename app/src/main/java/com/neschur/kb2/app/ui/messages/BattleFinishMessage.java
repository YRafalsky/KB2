package com.neschur.kb2.app.ui.messages;

import com.neschur.kb2.app.I18n;
import com.neschur.kb2.app.R;
import com.neschur.kb2.app.entities.Entity;
import com.neschur.kb2.app.models.Game;

import java.util.Random;

public class BattleFinishMessage extends Message {
    private boolean result;

    BattleFinishMessage(Entity entity, Game game, boolean result) {
        super(entity, game);
    }

    @Override
    public void action() {

    }

    @Override
    public String getText() {
        if (result) {
            return I18n.translate(R.string.battle_finish_win);
        } else {
            return I18n.translate(R.string.battle_finish_fail);
        }
    }
}