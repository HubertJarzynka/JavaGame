package Snake;

import com.sun.tools.javac.Main;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    static final int UP = 0,RIGHT = 1,DOWN = 2,LEFT = 3;

    int posX,posY,oldPosX,oldPosY;

    Block previous;
    int direction = LEFT;

    int maxX, maxY;

    public Block(int x, int y,Block p, Field f) {
        super(Main_UI.block_size,Main_UI.block_size);
        posX = x;
        posY = y;

        setTranslateX(posX * Main_UI.block_size);
        setTranslateY(posY * Main_UI.block_size);
        previous = p;
        maxX = f.getW();
        maxY = f.getH();

    }

    public void update() {
        oldPosX = posX;
        oldPosY = posY;
        if(previous == null) {
            switch(direction) {
                case UP: moveUP();break;
                case RIGHT: moveRIGHT();break;
                case DOWN: moveDOWN();break;
                case LEFT: moveLEFT();break;
            }
        }else {
            posX = previous.oldPosX;
            posY = previous.oldPosY;
        }
        updatePosition();
    }
    public void moveUP() {
        posY--;
        if(posY < 0) {
            posY = maxY - 1;
        }
    }
    public void moveDOWN() {
        posY++;
        if(posY >= maxY) {
            posY = 0;
        }
    }
    public void moveRIGHT() {
        posX++;
        if (posX >= maxX) {
            posX = 0;
        }
    }
    public void moveLEFT() {
        posX--;
        if(posX < 0) {
            posX = maxX - 1;
        }

    }
    public void updatePosition() {

        setTranslateX(posX * Main_UI.block_size);
        setTranslateY(posY * Main_UI.block_size);
    }

}
