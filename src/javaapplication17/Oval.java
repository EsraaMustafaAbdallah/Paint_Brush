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

/**
 *
 * @author esraa
 */
public class Oval extends ParentShape {
    
    public Oval(int x1, int y1, int x2, int y2, Color color, boolean dot, boolean fill) {
        super(x1, y1, x2, y2, color, dot, fill);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getcol());
        int width = Math.abs(getx2() - getx1());
        int height = Math.abs(gety2() - gety1());
        int x = Math.min(getx1(), getx2());
        int y = Math.min(gety1(), gety2());
        if (getFill()) {
            g2d.fillOval(x, y, width, height);
        } else {
            if (getDot()) {
                float dash1[] = {5.0f};
                BasicStroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
                g2d.setStroke(dashedStroke);
            } else {
                g2d.setStroke(new BasicStroke());
            }
            g2d.drawOval(x, y, width, height);
        }
    }
}
