import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    private JTextField usernameField;
    private JPasswordField passwordField;

    private OnlineAuctionSystem auctionSystem;

    public AdminLogin(OnlineAuctionSystem auctionSystem) {
        super("Admin Login");
        this.auctionSystem = auctionSystem;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void authenticate() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        if (USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword)) {
            dispose(); // Close the login window upon successful login
            auctionSystem.showMenu(); // Show the menu window after successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
