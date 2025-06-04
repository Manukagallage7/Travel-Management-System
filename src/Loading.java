import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for(int i=1; i<= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value < max){ 
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false); 
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel Management System");
        text.setBounds(70, 20, 600, 45);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");;
        loading.setBounds(170, 140, 300, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(loading);

        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(90, 310, 500, 45);
        lblusername.setForeground(Color.BLUE);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 25));
        add(lblusername);


        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("User");
    }
}
