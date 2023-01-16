package views;

import java.awt.Font;
import javax.swing.*;

public class HasilCariStaff extends MainFrame {
    private JLabel titleLabel;
    private JLabel namaLabel;
    private JLabel subTitleLabel;
    private JButton tutupBtn;

    public HasilCariStaff() {
        super("STAFF RESULT", 400, 300);
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
        boundedAdd(subTitleLabel, 102, 68, 200, 27);

        tutupBtn = new JButton("Tutup");
        tutupBtn.setBackground(color("#FF4040"));
        tutupBtn.setForeground(color("#FFFFFF"));
        boundedAdd(tutupBtn, 156, 248, 88, 27);
    }

    @Override
    protected void event() {
    }
}
