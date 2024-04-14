/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author esraaa
 */
public class Pen extends ParentShape {
    private ArrayList<Integer> Elxat = new ArrayList<Integer>();
    private ArrayList<Integer> Elyat = new ArrayList<Integer>();

    public Pen(int x1, int y1, int x2, int y2, Color color, boolean dot) {
        super(x1, y1, x2, y2, color, dot, false);
    }

    @Override
    public void draw(Graphics g) {
        if(getDot()){
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            Elxat.add(getx2());
            Elyat.add(gety2());
            g2d.setColor(getcol());
            for (int i = 0; i < Elxat.size() - 1; i++) {
                g2d.drawLine(Elxat.get(i), Elyat.get(i), Elxat.get(i + 1), Elyat.get(i + 1));
            }
        }
        else{
            Elxat.add(getx2());
            Elyat.add(gety2());
            g.setColor(getcol());
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setStroke(new BasicStroke(2));
            for (int i = 0; i < Elxat.size() - 1; i++) {
                g2d.drawLine(Elxat.get(i), Elyat.get(i), Elxat.get(i + 1), Elyat.get(i + 1));
            }
        }
    }
    
}
