/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 *
 * @author esraa
 */
public class Paint1 extends JPanel {
    private JButton button_color, Ovale ,line ,Rectangle,Pen,Erase,clearAllButton,saveButton,undoButton;
    private JCheckBox Dashed, Filled;
    Color col=Color.BLACK ;
    char currentShape ;
    ArrayList<ParentShape> allShapesArr;
    private boolean dashed;
    private boolean filled;
    private ParentShape shape;
    
    public Paint1(){
        this.setBackground(Color.white);
        this.setFocusable(true);
        dashed = false;
        filled = false;
        allShapesArr=new ArrayList<>();
        button_color = new JButton("Color");
        button_color.addActionListener((ActionEvent e) -> {
            col = JColorChooser.showDialog(null, "my color", Color.white);
        });
        this.add(button_color);
        
        Ovale = new JButton("Oval");
        Ovale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'o';
            }
        });
        this.add(Ovale);
        
        line = new JButton("Line");
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'l';
            }
        });
        this.add(line);

        Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'r';
            }
        });
        this.add(Rectangle);

        Pen = new JButton("Pen");
        Pen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'p';
            }
        });
        this.add(Pen);
        
        Erase = new JButton("Erase");
        Erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = 'e';
            }
        });
        this.add(Erase);
        Dashed = new JCheckBox("Dash", false);
        Dashed.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dashed = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        this.add(Dashed);
        Filled = new JCheckBox("Fill", false);
        Filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                filled = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        this.add(Filled);
      clearAllButton = new JButton("Clear All");
    clearAllButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearAll(); 
        }

            private void clearAll() {
                allShapesArr.clear();
                repaint();
            }
    });
    this.add(clearAllButton);
    saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SaveDrawings.Picture(Paint1.this); 
        }
    });
    this.add(saveButton);
    undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (allShapesArr.size() > 0) {
            allShapesArr.remove(allShapesArr.size() - 1);
            repaint(); 
        } 
            }
        });
        this.add(undoButton);


        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x1 = e.getX();
                int y1 = e.getY();
                switch (currentShape) {
                    case 'l':
                        shape = new Line(x1, y1, x1, y1, col, dashed);
                        break;
                    case 'o':
                        shape = new Oval(x1, y1, x1, y1, col, dashed, filled);
                        break;
                    case 'r':
                        shape = new Rectangle(x1, y1, x1, y1, col, dashed, filled);
                        break;
                    case 'p':
                        shape = new Pen(x1, y1, x1, y1, col, dashed);
                        break;
                    case 'e':
                        shape = new Erase(x1, y1, x1, y1);
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int x2 = e.getX();
                int y2 = e.getY();
                shape.setx2(x2);
                shape.sety2(y2);
                allShapesArr.add(shape);
                shape = null;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x2 = e.getX();
                int y2 = e.getY();
                shape.setx2(x2);
                shape.sety2(y2);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ParentShape shapevalue : allShapesArr) {
            shapevalue.draw(g);
        }
        if (shape != null) {
            shape.draw(g);
        }
    }
}
