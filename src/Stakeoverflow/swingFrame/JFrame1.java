/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow.swingFrame;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Naimish
 */
public class JFrame1 extends JFrame{

    JTextField jTextField= null;
    
    public JFrame1() throws HeadlessException {
        super("JFrame");
        setSize(200, 200);
        
        jTextField = new JTextField();
        add(jTextField);
        setVisible(true);
        jTextField.setBounds(10, 10, 100, 100);
    }
    
    public void setValueToText(String value){
        jTextField.setText(value);
    }
    
    public static void main(String[] args) {
        JFrame1 jf= new JFrame1();
    }
}
