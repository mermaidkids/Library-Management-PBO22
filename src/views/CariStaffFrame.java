package views;

import java.awt.Font;
import javax.swing.*;

import entity.StaffEntity;
import models.Staff;

public class CariStaffFrame extends MainFrame {
    private JLabel titleLabel;
    private JLabel nikLabel;
    private JButton iconBtn;
    private JTextField nikField;

    public CariStaffFrame() {
        super("Find Staff", 400, 300);
    }

    @Override
    protected void component() {
        titleLabel = new JLabel("CARI STAFF");
        setFontSize(titleLabel, 24);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 122, 47, 140, 29);

        nikLabel = new JLabel("MASUKKAN NIK");
        setFontSize(nikLabel, 15);
        setFontStyle(nikLabel, Font.BOLD);
        boundedAdd(nikLabel, 136, 127, 126, 18);

        nikField = new JTextField();
        boundedAdd(nikField, 65, 150, 235, 32);

        ImageIcon imgLoad = loadImage("src/assets/search.png", 29, 31);
        iconBtn = new JButton(imgLoad);
        boundedAdd(iconBtn, 302, 150, 29, 31);
    }

    @Override
    protected void event() {
        iconBtn.addActionListener((event -> {
            String nik = nikField.getText();
            StaffEntity staff = Staff.findStaff(nik);
            if (staff != null) {
                new HasilCariStaff(nik).setVisible(true);
            } else {
                System.out.println("Data Staff Tidak Ditemukan !");
            }
        }));

    }

}
