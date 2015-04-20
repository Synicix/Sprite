package com.synicix.sprite;

import android.graphics.Bitmap;

/**
 * Created by Daniel on 4/19/2015.
 */
public class KingSlime extends Sprite{

    public KingSlime(GameView g, Bitmap b) {
        super(g, b, 4, 13);
        setDirection(1);
    }
//fix this
    public void update() {
        if (getX() >= getGameView().getWidth() - getWidth() - getxSpeed() || getX() + getxSpeed() <= 0) {
            setxSpeed(-getxSpeed());
        }
        x = x + xSpeed;
        if (getY() >= gameView.getHeight() - height - ySpeed || y + ySpeed <= 0) {
            ySpeed = -ySpeed;
        }
        y = y + ySpeed;
        currentFrame = ++currentFrame % bitmapColumns;
    }
}
