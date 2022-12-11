package com.games.flappy.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private static final int FLUX = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 52;
    private Texture topTube, btmTube;
    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop, boundsBot;
    private Random rand;

    public Tube(float x) {
        topTube = new Texture("toptube.png");
        btmTube = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x, rand.nextInt(FLUX) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - btmTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x, posBotTube.y, btmTube.getWidth(), btmTube.getHeight());
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUX) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - btmTube.getHeight());
        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBot.setPosition(posBotTube.x, posBotTube.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);
    }

    public Texture getTopTube() { return topTube; }

    public Texture getBtmTube() { return btmTube; }

    public Vector2 getPosTopTube() { return posTopTube; }

    public Vector2 getPosBotTube() { return posBotTube; }

    public void dispose() {
        topTube.dispose();
        btmTube.dispose();
        System.out.println("Play state disposed");
    }
}
