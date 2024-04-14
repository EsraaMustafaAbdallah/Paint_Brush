/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author esraa
 */
public abstract class ParentShape {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color col;
    private boolean dot;
    private boolean fill;

    public ParentShape(int x1, int y1, int x2, int y2, Color color, boolean dot, boolean fill) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.col = color;
        this.dot = dot;
        this.fill = fill;
    }
    
    public abstract void draw(Graphics g);   
    
    public void setx2(int x){
        x2 =x;
    }
    public void sety2(int y){
        y2 =y;
    }
    public int getx1(){
        return x1;
    }
    public int getx2(){
        return x2;
    }
    public int gety2(){
        return y2;
    }
    public int gety1(){
        return y1;
    }
    public Color getcol(){
        return col;
    }
    public boolean getDot(){
        return dot;
    }
    public boolean getFill(){
        return fill;
    }
}