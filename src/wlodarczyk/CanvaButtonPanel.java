package wlodarczyk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvaButtonPanel extends JPanel implements ActionListener {
    private CanvaFrame frame;
    private DrawPanel panel;
    JButton colorButton1 = new JButton("Red");
    JButton colorButton2 = new JButton("Blue");
    JButton colorButton3 = new JButton("Black");
    JButton clearButton = new JButton("Clear");
    JButton exitButton = new JButton("Exit");
    JLabel color1 = new JLabel("Color: ");
    JLabel color2 = new JLabel("Black");
    JLabel figure1 = new JLabel("Figure type: ");
    JLabel figure2 = new JLabel("Oval");
    JLabel figure3 = new JLabel("Line - 1");
    JLabel figure4 = new JLabel("Rectangle - 2");
    JLabel figure5 = new JLabel("Oval - 3");
    JLabel colorManually = new JLabel("Type color code manually");
    JTextField textfield1 = new JTextField();
    JLabel infoLabel = new JLabel("");
    JButton submitButton = new JButton("Submit");


    public CanvaButtonPanel(CanvaFrame frame, DrawPanel panel){
        this.frame = frame;
        this.panel = panel;
        this.setLayout(null);
        setPreferredSize(new Dimension(200, 1000));
        colorButton1.addActionListener(this);
        colorButton1.setBounds(10, 150, 180, 50);
        this.add(colorButton1);
        colorButton2.addActionListener(this);
        colorButton2.setBounds(10, 250, 180, 50);
        this.add(colorButton2);
        colorButton3.addActionListener(this);
        colorButton3.setBounds(10, 50, 180, 50);
        this.add(colorButton3);
        clearButton.addActionListener(this);
        clearButton.setBounds(10, 350, 180, 50);
        this.add(clearButton);
        exitButton.addActionListener(this);
        exitButton.setBounds(10, 450, 180, 50);
        this.add(exitButton);
        color1.setBounds(10, 550, 180, 50);
        this.add(color1);
        color2.setBounds(65, 550, 180, 50);
        this.add(color2);
        figure1.setBounds(10, 575, 180, 50);
        this.add(figure1);
        figure2.setBounds(100, 575, 180, 50);
        this.add(figure2);
        figure3.setBounds(10, 625, 180, 50);
        this.add(figure3);
        figure4.setBounds(10, 650, 180, 50);
        this.add(figure4);
        figure5.setBounds(10, 675, 180, 50);
        this.add(figure5);
        colorManually.setBounds(10, 725, 180, 20);
        this.add(colorManually);
        textfield1.setBounds(10,750, 180, 20);
        this.add(textfield1);
        submitButton.addActionListener(this);
        submitButton.setBounds(10, 775, 180, 20);
        this.add(submitButton);
        infoLabel.setBounds(10, 800, 180, 20);
        this.add(infoLabel);


        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1, 1000);
    }

    public void setFigureType(String type){
        figure2.setText(type);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton){
            frame.dispose();
            new MainFrame();
        }

        if (e.getSource() == colorButton1){
            // RED
            panel.setColor(Color.RED);
            color2.setText("Red");
            frame.bringFocus();
        }

        if (e.getSource() == colorButton2){
            // BLUE
            panel.setColor(Color.BLUE);
            color2.setText("Blue");
            frame.bringFocus();
        }

        if (e.getSource() == colorButton3){
            // BLACK
            panel.setColor(Color.BLACK);
            color2.setText("Black");
            frame.bringFocus();
        }

        if (e.getSource() == clearButton){
            panel.clearFigures();
            frame.bringFocus();
        }

        if (e.getSource() == submitButton){
            String colorCode = textfield1.getText();
            try{
                panel.setColor(Color.decode(colorCode));
                color2.setText(colorCode);

                textfield1.setText("");
                infoLabel.setText("");
                frame.bringFocus();

            } catch (NumberFormatException ex) {
                infoLabel.setText("Wrong code!");
                textfield1.setText("");
                frame.bringFocus();
            }
        }


    }
}
