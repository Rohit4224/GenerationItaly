/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.rohit.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame6 extends Frame implements ActionListener
{
    Button b1, b2, b3;
    int titleNumer;
    MyFrame6(String title)
    {
//        super(title);
        b1 = new Button("Close Frame");
        b2 = new Button("Increment");
        b3 = new Button("Decrement");
        
        titleNumer = 0;
        setTitle("" + titleNumer);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setBounds(100, 100, 400, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
            System.exit(0);
        else if (e.getSource() == b2)
        {
            titleNumer++;
            setTitle(String.valueOf(titleNumer));
        }
        else if (e.getSource() == b3)
        {
            titleNumer--;
            setTitle("" + titleNumer);
        }
            
    }
}

public class Example9
{
    public static void main(String[] args) {
        int num = 0;
        MyFrame6 mf6 = new MyFrame6("Rohit's Frame");
    }
}
