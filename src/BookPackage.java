import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
    JButton checkprice, bookpackage, back;
    
    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Book Package");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 25);
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 100, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 25);
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 25);
        add(cpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField();
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 190, 100, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(250, 190, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 230, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(250, 230, 200, 20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(250, 270, 200, 20);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 310, 150, 25);
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labeltotal.setBounds(250, 310, 200, 25);
        add(labeltotal);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM customer WHERE username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(40, 380, 150, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 150, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360, 380, 150, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 120000;
            } else if(pack.equals("Silver Package")){
                cost += 80000;
            } else {
                cost += 50000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText("Rs " + cost);
        } else if(ae.getSource() == bookpackage){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookpackage VALUES('" + labelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labeltotal.getText() + "')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
            } catch (Exception e) {
            }
        } else {
            setVisible(false);
        }
    }
    

    public static void main(String[] args){
        new BookPackage("");
    }
}
