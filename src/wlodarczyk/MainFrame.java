package wlodarczyk;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    static int width1 = 1000;
    static int height1 = 550;
    JButton button1 = new JButton("Running button");
    JButton button2 = new JButton("Canva");
    JButton button3 = new JButton("Exit");
    JLabel infoLabel = new JLabel("Igor Wlodarczyk", SwingConstants.CENTER);

    public MainFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(width1, height1);
        this.setResizable(false);
        this.setTitle("Igor Wlodarczyk Lab4");
        this.setLayout(null);

        button1.addActionListener(this);
        button1.setBounds(400, 100, 200, 50);
        this.add(button1);

        button2.addActionListener(this);
        button2.setBounds(400, 200, 200, 50);
        this.add(button2);

        button3.addActionListener(this);
        button3.setBounds(400, 300, 200, 50);
        this.add(button3);

        infoLabel.setBounds(400, 400, 200, 50);
        this.add(infoLabel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
            dispose();
            new ButtonFrame();
        }
        if (e.getSource() == button2){
            dispose();
            new CanvaFrame();
        }
        if (e.getSource() == button3){
            dispose();
        }
    }
}
