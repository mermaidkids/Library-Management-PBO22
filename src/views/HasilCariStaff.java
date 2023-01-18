package views;

import java.awt.Font;
import javax.swing.*;

import entity.StaffEntity;
import models.Staff;

public class HasilCariStaff extends MainFrame {
    private JLabel titleLabel;
    private JLabel namaLabel;
    private JLabel subTitleLabel;
    private JButton tutupBtn;

    StaffEntity staff;

    public HasilCariStaff(String nik) {
        super("STAFF RESULT", 400, 300);
        staff = Staff.getStaffLogged();
    }

    @Override
    protected void component() {
        titleLabel = new JLabel("STAFF DITEMUKAN");
        setFontSize(titleLabel, 24);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 86, 69, 228, 29);

        namaLabel = new JLabel("NAMA :");
        setFontSize(namaLabel, 20);
        setFontStyle(namaLabel, Font.BOLD);
        boundedAdd(namaLabel, 163, 126, 74, 24);

        subTitleLabel = new JLabel(staff.getNamaStaff());
        setFontSize(subTitleLabel, 20);
        setFontStyle(subTitleLabel, Font.BOLD);
        boundedAdd(subTitleLabel, 86, 159, 227, 29);

        tutupBtn = new JButton("Tutup");
        tutupBtn.setBackground(color("#FF4040"));
        tutupBtn.setForeground(color("#FFFFFF"));
        boundedAdd(tutupBtn, 156, 248, 88, 27);
    }

    @Override
    protected void event() {
        tutupBtn.addActionListener((event -> {
            dispose();
        }));
    }

}
