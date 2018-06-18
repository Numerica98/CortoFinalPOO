/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 *
 * @author LN710Q
 */
public class Ventana extends JPanel {
    public int WIDTH = 730, widthTF= 140, widthB=80;
    public int HEIGHT= 600, heightTF= 30, heightB= 30;
    public JTextField textF1, textF2, textF3;
    public JButton button1, button2, button3, button4, button5;
    public JLabel label1, label2, label3, label4, label5, label6;
    public JComboBox tipo;
    ButtonGroup existencia = new ButtonGroup();
    
    public Ventana(){
        textF1= new JTextField();
        textF1.setBounds(new Rectangle(100,40,widthTF,heightTF));
        
        textF2= new JTextField();
        textF2.setBounds(new Rectangle(100,90,widthTF,heightTF));
        
        textF3= new JTextField();
        textF3.setBounds(new Rectangle(100,140,widthTF,heightTF));
        
        button1= new JButton("Buscar");
        button1.setBounds(new Rectangle(270,40,widthB,heightB));
        
        button2= new JButton("Actualizar");
        button2.setBounds(new Rectangle(320,190,100,heightB));
        
        button3= new JButton("Eliminar");
        button3.setBounds(new Rectangle(430,190,widthB,heightB));
        
        button4= new JButton("Limpiar");
        button4.setBounds(new Rectangle(530,190,widthB,heightB));
        
        button5= new JButton("Insertar");
        button5.setBounds(new Rectangle(620,190,widthB,heightB));
        
        label1= new JLabel("Nombre: ");
        label1.setBounds(new Rectangle(20,40,70,30));
        
        label2= new JLabel("Codigo: ");
        label2.setBounds(new Rectangle(20,90,70,30));
        
        label3= new JLabel("Cantidad: ");
        label3.setBounds(new Rectangle(20,140,70,30));
        
        label4= new JLabel("Tipo: ");
        label4.setBounds(new Rectangle(270,90,70,30));
        
        label5= new JLabel("Disponibilidad: ");
        label5.setBounds(new Rectangle(20,190,90,30));
        
        tipo= new JComboBox();
        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");
        tipo.setBounds(new Rectangle(310,90,90,30));
        
        textF1.setEditable(true);
        textF2.setEditable(true);
        textF3.setEditable(true);
        
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){                
                //textF3.setText();
            }
        });
        
        add(label1);
        add(textF1);
        add(label2);
        add(textF2);
        add(tipo);
        add(button1);
        add(label4);
        add(label3);
        add(textF3);
        add(label5);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }    
}
