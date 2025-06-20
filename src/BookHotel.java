import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel,cac,cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
    JButton checkprice, bookhotel, back;
    
    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Book Hotel");
        text.setBounds(150, 15, 200, 35);
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

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 25);
        add(lblpackage);

        chotel = new Choice();
        chotel.add("Hotel 1");
        chotel.add("Hotel 2");
        chotel.add("Hotel 3");
        chotel.add("Hotel 4");
        chotel.add("Hotel 5");
        chotel.add("Hotel 6");
        chotel.add("Hotel 7");
        chotel.add("Hotel 8");
        chotel.add("Hotel 9");
        chotel.add("Hotel 10");
        chotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        chotel.setBounds(250, 110, 200, 25);
        add(chotel);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);

        tfpersons = new JTextField();
        tfpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);

        tfdays = new JTextField();
        tfdays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("Ac / Non-Ac");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);

        cac = new Choice();
        cac.add("Ac");
        cac.add("Non-Ac");
        cac.setBounds(250, 230, 200, 25);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 25);
        add(cfood);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 100, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 20);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelnumber.setBounds(250, 350, 200, 20);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelphone.setBounds(250, 390, 200, 20);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labeltotal.setBounds(250, 430, 200, 25);
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
        checkprice.setBounds(40, 490, 150, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 490, 150, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360, 490, 150, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 400);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try {
                Conn c = new Conn();
                ResultSet rs  = c.s.executeQuery("SELECT * FROM hotel WHERE name = '" + chotel.getSelectedItem() + "'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total += total * persons * days;
                        labeltotal.setText("Rs" + total);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(ae.getSource() == bookhotel){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "','" + tfdays.getText() + "','"+cac.getSelectedItem()+"','" + cfood.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labeltotal.getText() + "')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    

    public static void main(String[] args){
        new BookHotel("Senitha7");
    }
}
