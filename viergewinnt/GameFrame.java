package viergewinnt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.applet.Main;

public class GameFrame extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID=1L;
    public PaintPanel pnl1;

    public GameFrame()
    {

        this.setSize(400, 400);
        this.setTitle("--viergewinnt--");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl1=new PaintPanel();
        pnl1.setBackground(new Color(61,93,196));
        add(pnl1, BorderLayout.CENTER);

        JPanel pnl2=new JPanel();

        pnl2.setBackground(new Color(90, 90, 90));
        add(pnl2, BorderLayout.SOUTH);
        //
        // Component lbl1=new JLabel("Spieler 1: ");
        // pnl2.add(lbl1);
        // Component txt1=new JTextField(10);
        // pnl2.add(txt1);
        // Component lbl2=new JLabel("Spieler 2: ");
        // pnl2.add(lbl2);
        // JTextField txt2=new JTextField(10);
        // pnl2.add(txt2);
         JButton btn1=new JButton("Neues Spiel");
         pnl2.add(btn1);
        
        setVisible(true);
    }

}