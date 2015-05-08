package com.synicix.sprite;

import android.graphics.Bitmap;

/**
 * Created by Daniel on 4/19/2015.
 */
public class KingSlime extends Sprite{

    public KingSlime(GameView g, Bitmap b) {
        super(g, b, 4, 13);
        setDirection(1);
        setNumberOfFrames(7);
    }

}
