package com.mygdx.bird;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class buff extends Actor {
    Rectangle bounds;
    AssetManager manager;



    public buff() {
        bounds = new Rectangle();
        setVisible(false);
        setSize(30, 75);
    }

    @Override
    public void act(float delta) {
        moveBy(-200 * delta, 0);
        bounds.setPosition(getX(), getY());
        if (!isVisible()) {
            setVisible(true);
        }


        if (getX() < -64) {
            remove();
        }
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Texture texture = manager.get("amogus.png", Texture.class);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation(), 0, 0, texture.getWidth(), texture.getHeight(), false, false);
    }


    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public AssetManager getAssetManager() {
        return manager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.manager = assetManager;
    }
}