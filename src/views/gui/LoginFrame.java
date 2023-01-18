package views.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.AuthController;
import views.gui.home.DashboardFrame;

public class LoginFrame extends MainFrame {
    private JLabel iconLabel;
    private JLabel titleLabel;

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton masukBtn, daftarBtn, exitBtn;

    private AuthController _authC = new AuthController();

    public LoginFrame() {
        super("LOGIN", 400, 600);
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/elibrary.png", 118, 151);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 141, 49, 118, 151);

        titleLabel = new JLabel("LOGIN");
        setFontSize(titleLabel, 30);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 155, 245, 92, 40);

        usernameLabel = new JLabel("NIK");
        setFontSize(usernameLabel, 16);
        setFontStyle(usernameLabel, Font.BOLD);
        boundedAdd(usernameLabel, 42, 300, 28, 19);

        usernameField = new JTextField();
        boundedAdd(usernameField, 35, 335, 330, 35);

        passwordLabel = new JLabel("Password");
        setFontSize(passwordLabel, 16);
        setFontStyle(passwordLabel, Font.BOLD);
        boundedAdd(passwordLabel, 42, 386, 93, 19);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 35, 421, 330, 35);

        masukBtn = new JButton("Masuk");
        masukBtn.setBackground(color("#00D4FF")); // #00D4FF
        masukBtn.setForeground(color("#FFFFFF"));
        masukBtn.setFocusPainted(false);
        boundedAdd(masukBtn, 158, 467, 85, 32);

        daftarBtn = new JButton("Daftar");
        daftarBtn.setBackground(color("#F0F0F0"));
        daftarBtn.setFocusPainted(false);
        daftarBtn.setBorderPainted(false);
        setFontSize(daftarBtn, 10);
        boundedAdd(daftarBtn, 158, 506, 85, 32);

        exitBtn = new JButton("Exit");
        exitBtn.setBackground(color("#E50404"));
        exitBtn.setForeground(color("#FFFFFF"));
        exitBtn.setFocusPainted(false);
        exitBtn.setBorderPainted(false);
        setFontSize(exitBtn, 10);
        boundedAdd(exitBtn, 324, 25, 58, 32);

    }

    @Override
    protected void event() {

        exitBtn.addActionListener((event -> {
            int jawab = JOptionPane.showOptionDialog(this,
                    "Ingin Keluar?",
                    "Keluar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (jawab == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Program Akan Keluar");
                System.exit(0);
            }

        }));

        masukBtn.addActionListener((event) -> {
            String nik = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean statusLogin = _authC.login(nik, password);

            if (statusLogin == true) {
                // View Dashboard / View Home
                new DashboardFrame().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        daftarBtn.addActionListener((event) -> {
            new RegisterFrame().setVisible(true);
            dispose();
        });
    }
}
