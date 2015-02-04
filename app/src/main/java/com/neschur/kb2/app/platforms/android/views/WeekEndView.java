package com.neschur.kb2.app.platforms.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.MotionEvent;

import com.neschur.kb2.app.R;
import com.neschur.kb2.app.controllers.ViewController;
import com.neschur.kb2.app.models.Player;

public class WeekEndView extends ViewImpl {
    private final Player player;

    public WeekEndView(Context context, ViewController controller) {
        super(context, controller);
        this.player = controller.getGame().getPlayer();
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        viewController.viewClose();
        return super.onTouchEvent(event);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        String text = i18n.translate(R.string.messages_weekEnd_title);

        int delta = ((int)getDefaultPaint().measureText(text) + 1 - getWidth())/2;
        delta = (delta > 0) ? delta : 0;
        canvas.drawText(text, delta, textHeight(), getDefaultPaint());

        drawItem(canvas, 3, "money", player.getMoney());
        drawItem(canvas, 4, "salary", player.getSalary());
        drawItem(canvas, 5, "armySalary", player.getSalary());

        drawItem(canvas, 7, "armyRefresh", null);
        drawItem(canvas, 8, "armyRefresh2", null);
        drawItem(canvas, 10, "armyRefresh3", null);
        drawItem(canvas, 12, "cityRefresh", null);
    }

    private void drawItem(Canvas canvas, int n, String attr, Integer value) {
        String text;
        if(value != null)
            text = i18n.translate("messages_weekEnd_" + attr) + ": " + value;
        else
            text = i18n.translate("messages_weekEnd_" + attr);
        canvas.drawText(text,
                10, textHeight() * (n), getDefaultPaint());
    }
}

