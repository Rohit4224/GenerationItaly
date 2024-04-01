package in.rohit.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame2 extends Frame implements ActionListener
{
    Button b, b2;
    public MyFrame2(String date)
    {
        super(date);
        b = new Button("Close Frame");
        
        b2 = new Button("Change color");
//        setTitle("Rohit\n" +date);
//        FlowLayout fl = new FlowLayout(); // button size, position and layout will be dependent on java
        setLayout(new FlowLayout()); // setting that Flow of layout will be on java
        add(b);
        add(b2);
        
        //for event listner for close frame
        CloseFrame obj = new CloseFrame();
        b.addActionListener(obj); //b is source and obj is listner, this is called registration in java.
        
        //for event listner for change color to yellow
        b2.addActionListener(this);
        
        setBounds(50,50,400,400);
        setVisible(true);
    }
    
    //for event listner for change color to yellow
    @Override
    public void actionPerformed(ActionEvent e)
    {
        setBackground(Color.yellow);
    }
}

//for event listner for close frame
class CloseFrame implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
}

public class Example5
{
    public static void main(String[] args)
    {
        MyFrame2 mf = new MyFrame2("Rohit's Frame5");
        
    }
}
