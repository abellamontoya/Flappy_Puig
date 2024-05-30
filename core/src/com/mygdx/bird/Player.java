package com.mygdx.bird;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    private Rectangle bounds;
    private AssetManager manager;
    private float speedy;
    private float gravity;
    private Texture normalTexture;
    private Texture boostedTexture;
    private boolean isBoosted;
    private boolean invincible;

    public Player() {
        setX(200);
        setY(280 / 2 - 64 / 2);
        setSize(64, 45);
        bounds = new Rectangle();
        speedy = 0;
        gravity = 850f;
        normalTexture = new Texture("bird.png");
        boostedTexture = new Texture("amogus.png");
    }


    @Override
    public void act(float delta) {
        // Actualiza la posición del jugador con la velocidad vertical
        moveBy(0, speedy * delta);
        speedy -= gravity * delta;
        bounds.set(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Cambia la textura según el estado de isBoosted
        if (isBoosted) {
            batch.draw(boostedTexture, getX(), getY(), getWidth(), getHeight());
        } else {
            batch.draw(normalTexture, getX(), getY(), getWidth(), getHeight());
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setManager(AssetManager manager) {
        this.manager = manager;
    }

    public void impulso() {
        speedy = 400f;
    }

    public void setBoosted(boolean boosted) {

        isBoosted = boosted;
        if (boosted) {
            setSize(getWidth() * 2.3f, getHeight() * 3.1f);
        } else {
            setSize(74, 45);
        }
    }



    @Override
    public boolean remove() {
        normalTexture.dispose();
        boostedTexture.dispose();
        return super.remove();
    }
}