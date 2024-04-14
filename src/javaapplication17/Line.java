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
public class Line extends ParentShape {
    public Line(int x1, int y1, int x2, int y2, Color color, boolean dotted){
        super(x1,y1,x2,y2,color,dotted,false);
    }
    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getcol());
        if (getDot()) {
            float dash1[] = {5.0f};
            BasicStroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
            g2d.setStroke(dashedStroke);
        } else {
            g2d.setStroke(new BasicStroke());
        }
        g2d.drawLine(getx1(), gety1(), getx2(), gety2());
    }
    
}
