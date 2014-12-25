/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow.swingFrame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Naimish
 */
public class JFrame2 extends JFrame{

    JButton jButton= null;
    JFrame1 frame1=null;
    
    public JFrame2() throws HeadlessException {
        super("JFrame");
        
        frame1=new JFrame1();
        
        jButton = new JButton("Clieck Me");
        add(jButton);
        setVisible(true);
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                frame1.setValueToText("Hi");
            }
        });
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        JFrame2 jf= new JFrame2();
        jf.setSize(200, 200);
    }
}
