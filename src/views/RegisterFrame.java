package views;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.AuthController;

public class RegisterFrame extends MainFrame {
    private JLabel iconLabel;
    private JLabel titleLabel;
    private JLabel namaLabel, nikLabel, passwordLabel;
    private JTextField namaField, nikField;
    private JPasswordField passwordField;

    private JButton daftarBtn, masukDisiniBtn;
    private AuthController _authC = new AuthController();

    public RegisterFrame() {
        super("Registrasi", 400, 600);
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/elibrary.png", 176, 98);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 107, 24, 176, 98);

        titleLabel = new JLabel("REGISTRASI");
        setFontSize(titleLabel, 32);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 105, 133, 191, 39);

        namaLabel = new JLabel("NAMA LENGKAP");
        setFontSize(namaLabel, 16);
        setFontStyle(namaLabel, Font.BOLD);
        boundedAdd(namaLabel, 30, 192, 131, 19);

        namaField = new JTextField();
        boundedAdd(namaField, 30, 227, 330, 35);

        nikLabel = new JLabel("NIK");
        setFontSize(nikLabel, 16);
        setFontStyle(nikLabel, Font.BOLD);
        boundedAdd(nikLabel, 37, 278, 91, 19);

        nikField = new JTextField();
        boundedAdd(nikField, 30, 313, 330, 35);

        passwordLabel = new JLabel("PASSWORD");
        setFontSize(passwordLabel, 16);
        setFontStyle(passwordLabel, Font.BOLD);
        boundedAdd(passwordLabel, 37, 364, 93, 19);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 30, 399, 330, 35);

        daftarBtn = new JButton("DAFTAR");
        daftarBtn.setBackground(color("#00D4FF")); // #00D4FF
        daftarBtn.setForeground(color("#FFFFFF"));
        daftarBtn.setFocusPainted(false);
        boundedAdd(daftarBtn, 132, 489, 112, 34);

        masukDisiniBtn = new JButton("MASUK DISINI");
        masukDisiniBtn.setBackground(color("#9C9C9C"));
        masukDisiniBtn.setFocusPainted(false);
        masukDisiniBtn.setBorderPainted(false);
        setFontSize(masukDisiniBtn, 10);
        boundedAdd(masukDisiniBtn, 143, 536, 91, 24);
    }

    @Override
    protected void event() {
        daftarBtn.addActionListener((event) -> {
            String nama, nik, password;
            nama = namaField.getText();
            nik = nikField.getText();
            password = String.valueOf(passwordField.getPassword());

            _authC.regisStaff(nama, nik, password);

        });

        masukDisiniBtn.addActionListener((event) -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

    }

}
