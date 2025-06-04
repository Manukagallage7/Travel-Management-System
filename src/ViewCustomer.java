import java.awt.*;
import javax.swing.*;


public class ViewCustomer extends JFrame{

    ViewCustomer(){
        setBounds(450, 180, 900, 620);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel("");
        labelusername.setBounds(30, 50, 150, 25);
        add(labelusername);

        

        setVisible(true);
        
    }

    

    public static void main(String[] args){
        new ViewCustomer();
    }
    
}
