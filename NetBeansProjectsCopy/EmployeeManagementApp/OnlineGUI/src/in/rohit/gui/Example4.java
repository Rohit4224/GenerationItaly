/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.rohit.gui;

import java.awt.Frame;
import java.util.Date;

class MyFrame extends Frame 
{
    public MyFrame(String date)
    {
        super(date);
//        setTitle("Rohit\n" +date);
        setBounds(50,50,400,400);
        setVisible(true);
    }
}

public class Example4 {
    public static void main(String[] args) {
        Date d = new Date();
        MyFrame mf = new MyFrame(d.toString());
    }
}
