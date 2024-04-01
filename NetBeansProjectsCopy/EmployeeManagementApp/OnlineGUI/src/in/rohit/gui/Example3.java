/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.rohit.gui;

import java.awt.Color;
import java.awt.Frame;
import java.util.Date;

/**
 *
 * @author rohit
 */
public class Example3 {
     public static void main(String[] args) {
        String d = new Date().toString();
        Frame fr = new Frame(d);
        fr.setBounds(50, 50, 400, 300);
        fr.setVisible(true);
        fr.setBackground(Color.RED);
//        fr.setTitle("Rohit's Application");
     }
}
