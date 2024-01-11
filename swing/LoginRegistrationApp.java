import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegistrationApp extends JFrame {

    public LoginRegistrationApp() {
        initializeUI();
    }

    private void initializeUI() {
        // Set up the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login and Registration");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(43, 52, 66)); // Dark Blue background

        // Create panels for login and registration
        JPanel loginPanel = createLoginPanel();
        JPanel registrationPanel = createRegistrationPanel();

        // Create a tabbed pane for easy navigation
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Registration", registrationPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));
        loginPanel.setBackground(new Color(43, 52, 66));

        // Components for login panel
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel forgotPasswordLabel = new JLabel("<html><u>Forgot Password?</u></html>");
        forgotPasswordLabel.setForeground(new Color(251, 238, 193)); // Light Blue
        usernameField.setForeground(new Color(225,225,225));

        // Add components to the login panel
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(forgotPasswordLabel);

        // Set component styles
        setComponentStyles(usernameField);
        setComponentStyles(passwordField);
        setButtonStyles(loginButton);
        setLinkStyles(forgotPasswordLabel);

        // Add action listeners for buttons
        loginButton.addActionListener(e -> {
            // Implement login logic here
            // For example, check username and password
            // Show welcome screen on successful login
            showWelcomeScreen(usernameField.getText());
        });

        return loginPanel;
    }

    private JPanel createRegistrationPanel() {
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridLayout(5, 1));
        registrationPanel.setBackground(new Color(43, 52, 66));

        // Components for registration panel
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField nameField = new JTextField();
        JCheckBox agreeCheckbox = new JCheckBox("I agree to the terms and conditions");
        JButton signupButton = new JButton("Signup");

        // Add components to the registration panel
        registrationPanel.add(usernameField);
        registrationPanel.add(passwordField);
        registrationPanel.add(nameField);
        registrationPanel.add(agreeCheckbox);
        registrationPanel.add(signupButton);

        // Set component styles
        setComponentStyles(usernameField);
        setComponentStyles(passwordField);
        setComponentStyles(nameField);
        setCheckboxStyles(agreeCheckbox);
        setButtonStyles(signupButton);

        // Add action listener for the signup button
        signupButton.addActionListener(e -> {
            // Implement registration logic here
            // For example, validate input fields and create a new user account
            // Show welcome screen on successful registration
            showWelcomeScreen(usernameField.getText());
        });

        return registrationPanel;
    }

    private void setComponentStyles(JComponent component) {
        component.setBackground(new Color(55, 71, 90)); // Content box color
        component.setForeground(Color.WHITE);
        component.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        component.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void setButtonStyles(JButton button) {
        setComponentStyles(button);
        button.setBackground(new Color(43, 52, 66)); // Dark Blue button color
        button.setFocusPainted(false);
        button.addActionListener(e -> button.setBackground(new Color(61, 76, 97))); // Hover effect
    }

    private void setLinkStyles(JLabel label) {
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label.setForeground(new Color(55, 71, 90)); // Hover effect
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                label.setForeground(new Color(251, 238, 193));
            }
        });
    }

    private void setCheckboxStyles(JCheckBox checkbox) {
        checkbox.setBackground(new Color(43, 52, 66)); // Dark Blue background
        checkbox.setForeground(Color.WHITE);
        checkbox.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        checkbox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void showWelcomeScreen(String username) {
        JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
        // Implement logic to switch to the welcome screen or another view
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginRegistrationApp());
    }
}
