import javax.swing.*;
import java.awt.*;

public class CustomerSearchGUI extends JFrame{

    public CustomerSearchGUI() {
            setTitle("Customer Search");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(2, 1));
            getContentPane().setBackground(new Color(156, 50, 248));

            add(new JLabel("Enter your search query:"));

            JPanel searchPanel = new JPanel();
            searchPanel.setBackground(Color.WHITE);

            JTextField searchField = new JTextField(20);
            searchPanel.add(searchField);

            JButton searchButton = new JButton("Search");
            searchPanel.add(searchButton);

            add(searchPanel);

            setVisible(true);
        }
    }
