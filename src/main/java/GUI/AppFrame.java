/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com_decom.Compressor;
import com_decom.Decompressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class AppFrame extends JFrame implements ActionListener{
    //Declaration of variables
    JButton comButton;
    JButton deComButton;
    JLabel msgcom=new JLabel();
    JLabel msgdecom=new JLabel();
    Font f1;
    AppFrame(){
        //Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        
        JLabel jl=new JLabel(" Welcome to File Compressor Application!");
        jl.setForeground(new Color(231, 171, 121));
        jl.setBackground(Color.red);
        jl.setBounds(150, 50,550, 50);
        jl.setAlignmentX(50);
        jl.setAlignmentY(80);
        Font font=new Font("Monospaced",Font.PLAIN, 20);
        f1=new Font("Monospaced",Font.PLAIN, 12);
        jl.setFont(font);
        //jl.setBounds(100, 1000, 250, 50);
        comButton=new JButton("Select File For Compression");
        comButton.setBounds(50, 200,250,50);
        comButton.addActionListener(this);
        comButton.setBackground(new Color(231, 171, 121));
        deComButton=new JButton("Select File For Decompression");
        deComButton.setBounds(400, 200, 250, 50);
        deComButton.setBackground(new Color(231, 171, 121));
        deComButton.addActionListener(this);
        this.add(comButton);
        this.add(deComButton);
        this.add(jl);
        this.add(msgcom);
        this.add(msgdecom);
        this.setSize(800, 500);
        this.setTitle("Compressor Application");
        this.getContentPane().setBackground(new Color(76, 58, 81));
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Code written in this fuction will be performed after clicking the button
        if(e.getSource()==comButton){
            msgcom.setText("");
            msgdecom.setText("");
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, ex.toString());
                }
                
            }
            msgcom.setBounds(50 ,400,300,50);
            msgcom.setText("File is compressed successfully!");
            msgcom.setFont(f1);
            msgcom.setForeground(new Color(231, 171, 121));
        }
        
        if(e.getSource()==deComButton){
            msgcom.setText("");
            msgdecom.setText("");
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, ex.toString());
                }
                
            }
            msgdecom.setBounds(50 ,400,300,50);
            msgdecom.setText("File is decompressed successfully!");
            msgdecom.setFont(f1);
            msgdecom.setForeground(new Color(231, 171, 121));
        }
    }
}
