/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortolabo1;

import GUI.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author LN710Q
 */
public class CortoLabo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana= new JFrame("Bases de datos");
        ventana.setContentPane(new Ventana());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);
    }
    
}
