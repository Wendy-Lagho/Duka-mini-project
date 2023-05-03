import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class SellerDetailsGUI extends JFrame implements ActionListener {

    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField phoneField;
    private final JTextField passwordField;
    private final JButton submitButton;

    public SellerDetailsGUI() {
        setTitle("Seller Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));
        getContentPane().setBackground(new Color(166, 214, 222));

        add(new JLabel("Full Name (in capital letters):"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Business Email Address:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Password:"));
        passwordField = new JTextField();
        add(passwordField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String password = passwordField.getText();

            try {
                // connect to database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duka", "root", "password");
                Statement stmt = conn.createStatement();

                // insert seller details into database
                String sql = "INSERT INTO sellers (name, email, phone, password) VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + password + "')";
                stmt.executeUpdate(sql);

                // show success message
                JOptionPane.showMessageDialog(this, "Seller details saved successfully.");

                // close database connection and dispose of GUI
                conn.close();
                dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error saving seller details: " + ex.getMessage());
            }
        }
    }
}
