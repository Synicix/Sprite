package com.synicix.sprite;

import android.graphics.Bitmap;

/**
 * Created by Daniel on 4/19/2015.
 */
public class Slime extends Sprite{

    public Slime(GameView gameView, Bitmap bmp) {
        super(gameView, bmp, 2, 7);

    }

    @Override
    public void update() {
        super.update();
        if(getxSpeed() > 0)
        {
            setDirection(1);
        }
        else
        {
            setDirection(0);
        }
    }
}
