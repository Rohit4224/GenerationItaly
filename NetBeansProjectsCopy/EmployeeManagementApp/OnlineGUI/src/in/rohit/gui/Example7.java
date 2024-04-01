package in.rohit.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame4 extends Frame implements ActionListener
{
    Button b, b2,b3,b4;
    public MyFrame4(String date)
    {
        super(date);
        b = new Button("Close Frame");
        
        b2 = new Button("Change to yellow");
        b3 = new Button("Change to red");
        
        b4 = new Button("Change black");
//        setTitle("Rohit\n" +date);
//        FlowLayout fl = new FlowLayout(); // button size, position and layout will be dependent on java
        setLayout(new FlowLayout()); // setting that Flow of layout will be on java
        add(b);
        add(b2);
        add(b3);
        add(b4);
        
        //for event listner for close frame
//        CloseFrame obj = new CloseFrame();
        b.addActionListener(this); //b is source and obj is listner, this is called registration in java.
        
        //for event listner for change color to yellow
        b2.addActionListener(this);
        
        b3.addActionListener(this);
        b4.addActionListener(this);
        
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
        else if (e.getSource() == b3)
            setBackground(Color.RED);
        else if (e.getSource() == b4)
            setBackground(Color.BLACK);
    }
}

public class Example7
{
    public static void main(String[] args)
    {
        MyFrame4 mf = new MyFrame4("Rohit's Example 7");
        
    }
}
