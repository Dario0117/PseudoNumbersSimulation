/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

/**
 *
 * @author esteb
 */
public class anim_pos {
    private int x,y;
    private int index;

    public anim_pos(int x, int y, int empty) {
        this.x = x;
        this.y = y;
        this.index = empty;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int empty) {
        this.index = empty;
    }
    
    
}
