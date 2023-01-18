package views.gui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        ImageIcon imgLoad = loadImage("src/assets/elibrary.png", 86, 109);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 152, 36, 86, 109);

        titleLabel = new JLabel("REGISTRASI");
        setFontSize(titleLabel, 32);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 105, 158, 191, 39);

        namaLabel = new JLabel("NAMA LENGKAP");
        setFontSize(namaLabel, 16);
        setFontStyle(namaLabel, Font.BOLD);
        boundedAdd(namaLabel, 30, 217, 131, 19);

        namaField = new JTextField();
        boundedAdd(namaField, 30, 252, 330, 35);

        nikLabel = new JLabel("NIK");
        setFontSize(nikLabel, 16);
        setFontStyle(nikLabel, Font.BOLD);
        boundedAdd(nikLabel, 37, 303, 28, 19);

        nikField = new JTextField();
        boundedAdd(nikField, 30, 338, 330, 35);

        passwordLabel = new JLabel("PASSWORD");
        setFontSize(passwordLabel, 16);
        setFontStyle(passwordLabel, Font.BOLD);
        boundedAdd(passwordLabel, 37, 389, 93, 19);

        passwordField = new JPasswordField();
        boundedAdd(passwordField, 30, 424, 330, 35);

        daftarBtn = new JButton("DAFTAR");
        daftarBtn.setBackground(color("#00D4FF")); // #00D4FF
        daftarBtn.setForeground(color("#FFFFFF"));
        daftarBtn.setFocusPainted(false);
        boundedAdd(daftarBtn, 132, 489, 112, 34);

        masukDisiniBtn = new JButton("MASUK");
        masukDisiniBtn.setBackground(color("#9C9C9C"));
        masukDisiniBtn.setFocusPainted(false);
        masukDisiniBtn.setBorderPainted(false);
        setFontSize(masukDisiniBtn, 10);
        boundedAdd(masukDisiniBtn, 143, 536, 91, 24);
    }

    @Override
    protected void event() {

        daftarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama, nik, password;
                    nama = namaField.getText();
                    nik = nikField.getText();
                    password = String.valueOf(passwordField.getPassword());
                    _authC.regisStaff(nama, nik, password);
                    JOptionPane.showMessageDialog(null, "Registrasi Berhasil", "Information",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Registrasi Gagal, lengkapi data dengan benar", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        masukDisiniBtn.addActionListener((event) -> {
            new LoginFrame().setVisible(true);
            dispose();
        });

    }

}
