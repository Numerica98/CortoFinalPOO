/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BaseDeDatos.Producto;
import BaseDeDatos.ProductoDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    public JLabel label1, label2, label3, label4, label5;
    
    public JTextField textF1, textF2, textF3;
    public JComboBox tipo;
    
    ButtonGroup disponibilidad = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton button1, button2, button3, button4, button5;
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Control de producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(label4);
        container.add(label5);
        container.add(si);
        container.add(no);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(button5);
        container.add(table);
        setSize(730,600);
        eventos();
    }
    
    public final void agregarLabels(){
        label1 = new JLabel("Nombre: ");
        label2= new JLabel("Codigo: ");
        label3 = new JLabel("Cantidad: ");
        label4= new JLabel("Tipo: ");
        label5 = new JLabel("Disponibilidad: ");
        label1.setBounds(20, 40, 70, 30);
        label2.setBounds(20,90,70,30);
        label3.setBounds(20,140,70,30);
        label4.setBounds(270,90,70,30);
        label5.setBounds(20,190,90,30);
        
    }
    
    public final void formulario(){
        textF1 = new JTextField();
        tipo = new JComboBox();
        textF2 = new JTextField();
        textF3 = new JTextField();
        si = new JRadioButton("si",true);
        no = new JRadioButton("no");
        resultados = new JTable();
        button1 = new JButton("Buscar");
        button2 = new JButton("Actualizar");
        button3 = new JButton("Eliminar");
        button4 = new JButton("Limpiar");
        button5 = new JButton("Insertar");
        
        table = new JPanel();
        
        tipo.addItem("Fruta");
        tipo.addItem("Verdura");
        tipo.addItem("Bebida");
        tipo.addItem("Dulce");
        
        disponibilidad = new ButtonGroup();
        disponibilidad.add(si);
        disponibilidad.add(no);
        
        textF1.setBounds(100, 40, 140, 30);
        textF2.setBounds(100, 90, 140, 30);
        textF3.setBounds(100, 140, 140, 30);
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        
        tipo.setBounds(310,90,90,30);
        button1.setBounds(270, 40, 80,30);
        button2.setBounds(320,190,100,30);
        button3.setBounds(430,190,80,30);
        button4.setBounds(530,190,80,30);
        button5.setBounds(620,190,80,30);
        resultados=new JTable();
        table.setBounds(10, 250, 500,200);
        table.add(new JScrollPane(resultados));
        
    }
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch (column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
          
            
        };
        
        tm.addColumn("ID");
        tm.addColumn("Nombre");
        tm.addColumn("Codigo");
        tm.addColumn("Tipo");
        tm.addColumn("Cantidad");
        tm.addColumn("Precio");
        tm.addColumn("Disponibilidad");
        
        ProductoDao pd = new ProductoDao();
        ArrayList<Producto> productos = pd.readAll();
        
        for (Producto pro : productos){
            tm.addRow(new Object[]{pro.getId(),pro.getNombre(),pro.getCodigo(),pro.getTipo(),pro.getCantidad(),pro.getPrecio(),pro.isDisponibilidad()});
        }
        
        resultados.setModel(tm);
    }
    
    public void eventos(){
        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ProductoDao pd = new ProductoDao();
                Producto p = new Producto(textF2.getText(),tipo.getSelectedItem().toString(),
                true);
                
                if(no.isSelected()){
                    p.setDisponibilidad(false);
                }
                
                if(pd.create(p)){
                    JOptionPane.showMessageDialog(null,"Producto registrado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de crear el producto");
                }
            }
        
        });
        
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ProductoDao pd = new ProductoDao();
                Producto p = new Producto(textF2.getText(),tipo.getSelectedItem().toString(),
                true);
                
                if(no.isSelected()){
                    p.setDisponibilidad(false);
                }
                
                if(pd.update(p)){
                    JOptionPane.showMessageDialog(null,"Producto Modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de modificar el producto");
                }
            }
        
        });
        
    button3.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            ProductoDao pd = new ProductoDao();
            if(pd.delete(textF2.getText())){
                JOptionPane.showMessageDialog(null,"Producto eliminado");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null,"Ocurrio un problema al momento de eliminar el producto");
            }
        }
    });
    
    button1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            ProductoDao pd = new ProductoDao();
            Producto p = pd.read(textF2.getText());
            if(p == null){
                JOptionPane.showMessageDialog(null,"El producto buscado no se ha encontrado");
            }else{
                textF2.setText(p.getCodigo());
                tipo.setSelectedItem(p.getTipo());
                
                
                if(p.isDisponibilidad()){
                    si.setSelected(true);
                }else{
                    no.setSelected(true);
                }
            }
        }
    });
    
    button4.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            limpiarCampos();
        }
    });
    }
    public void limpiarCampos(){
        textF2.setText("");
        tipo.setSelectedItem("FRAM");
        
    }
}
