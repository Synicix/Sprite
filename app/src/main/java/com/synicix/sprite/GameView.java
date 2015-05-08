package com.synicix.sprite;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
    private Bitmap bmp;
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private long lastClick;

    public GameView(Context context) {
        super(context);
        gameLoopThread = new GameLoopThread(this);
        holder = getHolder();
        holder.addCallback(new Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                createSprites();
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });

    }

    private void createSprites() {
        sprites.add(new Map(this, BitmapFactory.decodeResource(getResources(), R.drawable.mapone)));

        for(int i=0; i<10; i++)
        {
            //sprites.add(new Slime(this,BitmapFactory.decodeResource(getResources(), R.drawable.slime)));
        }
        sprites.add(new KingSlime(this,BitmapFactory.decodeResource(getResources(), R.drawable.kingslime)));
        //sprites.add(new Slimes(this, BitmapFactory.decodeResource(getResources(), R.drawable.slimes)));


}

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.rgb(32,32,32));
        for (Sprite sprite : sprites) {
            sprite.onDraw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (System.currentTimeMillis() - lastClick > 500) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
                for (int i = sprites.size() - 1; i >= 0; i--) {
                    Sprite sprite = sprites.get(i);
                    if (sprite.isCollision(event.getX(), event.getY())) {
                        sprites.remove(sprite);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public void pauseThreads()
    {
        gameLoopThread.onPause();
    }

    public void resumeThreads()
    {
        gameLoopThread.onResume();
    }
}