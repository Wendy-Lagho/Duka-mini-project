import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DukaGUI extends JFrame implements ActionListener {

    private final JButton customerButton;
    private final JButton sellerButton;

    public DukaGUI() {
        setTitle("Duka");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);

        customerButton = new JButton("Customer");
        customerButton.addActionListener(this);
        panel.add(customerButton);

        sellerButton = new JButton("Seller");
        sellerButton.addActionListener(this);
        panel.add(sellerButton);

        add(new JLabel("Welcome to Duka!"));
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerButton) {
            JOptionPane.showMessageDialog(this, "You clicked the customer button!");
        } else if (e.getSource() == sellerButton) {
            new SellerDetailsGUI();
        }
    }

    public static void main(String[] args) {
        new DukaGUI();
    }

}

