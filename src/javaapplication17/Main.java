/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication17;

import javax.swing.JFrame;

/**
 *
 * @author esraa
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         JFrame f = new JFrame("paint_prush") ;
        Paint1 mypanel = new Paint1();
        f.setContentPane(mypanel);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
