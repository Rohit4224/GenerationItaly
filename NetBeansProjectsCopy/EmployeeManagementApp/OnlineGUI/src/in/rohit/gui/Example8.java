package in.rohit.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class MyFrame5 extends Frame implements ActionListener
{
    Button b, b2;
    Random rnd;
    public MyFrame5(String date)
    {
        super(date);
        rnd = new Random();
        b = new Button("Close Frame");
        
        b2 = new Button("Change color");
//        setTitle("Rohit\n" +date);
//        FlowLayout fl = new FlowLayout(); // button size, position and layout will be dependent on java
        setLayout(new FlowLayout()); // setting that Flow of layout will be on java
        add(b);
        add(b2);
        
        //for event listner for close frame
//        CloseFrame obj = new CloseFrame();
        b.addActionListener(this); //b is source and obj is listner, this is called registration in java.
        
        //for event listner for change color to yellow
        b2.addActionListener(this);
        
        setBounds(50,50,400,400);
        setVisible(true);
    }
    
     //for event listner for change color to yellow
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b)
            System.exit(0);
        else 
        {
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue =  rnd.nextInt(256);
            Color c = new Color(red, green, blue);
            setBackground(c);
        }
    }
}

public class Example8
{
    public static void main(String[] args)
    {
        MyFrame5 mf = new MyFrame5("Rohit's Frame5");
        
    }
}

