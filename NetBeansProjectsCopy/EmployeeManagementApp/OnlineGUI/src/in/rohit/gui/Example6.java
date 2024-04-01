package in.rohit.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame3 extends Frame implements ActionListener
{
    Button b, b2;
    public MyFrame3(String date)
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
        else if (e.getSource() == b2)
            setBackground(Color.yellow);
    }
}

public class Example6
{
    public static void main(String[] args)
    {
        MyFrame3 mf = new MyFrame3("Rohit's Example 6");
        
    }
}
