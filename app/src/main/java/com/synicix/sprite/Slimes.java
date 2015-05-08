package com.synicix.sprite;

import android.graphics.Bitmap;

/**
 * Created by Synicix on 4/22/2015.
 */
public class Slimes extends Sprite{

    public Slimes(GameView g, Bitmap b) {
        super(g, b, 55, 10);
        setDirection(54);
        setNumberOfFrames(7);
    }
}
