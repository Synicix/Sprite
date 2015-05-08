package com.synicix.sprite;

import java.util.Random;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class Sprite {
    private int maxSpeed= 40;
    private GameView gameView;
    private Bitmap bitmap;
    private int x, y, xSpeed, ySpeed, width, height, direction, bitmapRows, bitmapColumns, currentFrame, numberOfFrames;

    public Sprite(GameView g, Bitmap b, int r, int c) {
        bitmap = b;
        gameView = g;

        numberOfFrames = 1;

        bitmapRows = r;
        bitmapColumns = c;

        width = b.getWidth() / c;
        height = b.getHeight() / r;

        Random rnd = new Random();
        //x = rnd.nextInt(gameView.getWidth() - width);
        //y = rnd.nextInt(gameView.getHeight() - height);
        xSpeed = rnd.nextInt(maxSpeed * 2) - maxSpeed;
        ySpeed = rnd.nextInt(maxSpeed * 2) - maxSpeed;
        currentFrame = rnd.nextInt(c);
    }

    public void update() {
        if (x >= gameView.getWidth() - width - xSpeed || x + xSpeed <= 0) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        if (y >= gameView.getHeight() - height - ySpeed || y + ySpeed <= 0) {
            ySpeed = -ySpeed;
        }
        y = y + ySpeed;
        currentFrame = ++currentFrame % numberOfFrames;
    }

    public void onDraw(Canvas canvas) {
        update();
        int srcX = currentFrame* width;
        int srcY = direction * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bitmap, src, dst, null);
    }


    public boolean isCollision(float x2, float y2) {
        return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
    }

    public void setDirection(int d)
    {
        direction = d;
    }

    public void setMaxSpeed(int s)
    {
        maxSpeed = s;
    }

    public void setX(int i)
    {
        x = i;
    }

    public void setY(int i)
    {
        y = i;
    }

    public void setxSpeed(int s)
    {
        xSpeed = s;
    }

    public void setySpeed(int s)
    {
        ySpeed = s;
    }

    public void setCurrentFrame(int i)
    {
        currentFrame = i;
    }

    public void setNumberOfFrames(int i)
    {
        numberOfFrames = i;
    }


    public int getDirection()
    {
        return direction;
    }

    public int getMaxSpeed()
    {
        return maxSpeed;
    }

    public int getxSpeed()
    {
        return xSpeed;
    }

    public int getySpeed()
    {
        return ySpeed;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public GameView getGameView()
    {
        return gameView;
    }

    public int getCurrentFrame()
    {
        return currentFrame;
    }

    public int getNumberOfFrames()
    {
        return numberOfFrames;
    }


}