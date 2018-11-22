package models;

public class Player {

    private int x, y;
    private final String name;
    private Sprite[] playerSprites; //Sprites for left, right, walking, running, attacking, etc.

    //Future framework
    private double experience;
    private int level; //level 3, 50, etc.

    public Player(int x, int y, String name, Sprite... playerSprites) {
        this.x = 0;
        this.y = 0;
        this.name = name;
        this.playerSprites = playerSprites;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
