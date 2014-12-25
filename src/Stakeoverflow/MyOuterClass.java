/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stakeoverflow;

import java.util.ArrayList;

/**
 *
 * @author Naimish
 */
public class MyOuterClass {
    
    ArrayList<String> as=new ArrayList<>();

    public MyOuterClass() {
        as.add("a");
        as.add("b");
        as.add("c");
        as.add("d");
    }
    
    public class MyInnerClass{
        public void modify(){
            System.out.println(as.get(1));
        }
    }
    
    public static void main(String[] args) {
        
    }
}
