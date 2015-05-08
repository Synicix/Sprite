package com.synicix.sprite;

import android.graphics.Bitmap;

/**
 * Created by Synicix on 4/22/2015.
 */
public class Map extends Sprite {
    public Map(GameView g, Bitmap b) {
        super(g, b, 1, 1);
        setDirection(0);
        setX(0);
        setY(0);
    }

    public void update()
    {
        setX(getX()-5);

    }
}
