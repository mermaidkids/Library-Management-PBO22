package views.gui;

import java.awt.Font;
import javax.swing.*;

import entity.BukuEntity;
import models.Library;

public class CariBukuFrame extends MainFrame {
    private JLabel titleLabel;
    private JLabel judulBukuLabel;
    private JButton iconBtn;
    private JTextField judulBukuField;

    public CariBukuFrame() {
        super("Find Book", 400, 300);
    }

    @Override
    protected void component() {
        titleLabel = new JLabel("CARI BUKU");
        setFontSize(titleLabel, 24);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 122, 47, 140, 29);

        judulBukuLabel = new JLabel("MASUKKAN JUDUL");
        setFontSize(judulBukuLabel, 15);
        setFontStyle(judulBukuLabel, Font.BOLD);
        boundedAdd(judulBukuLabel, 136, 127, 150, 18);

        judulBukuField = new JTextField();
        boundedAdd(judulBukuField, 65, 150, 235, 32);

        ImageIcon imgLoad = loadImage("src/assets/search.png", 29, 31);
        iconBtn = new JButton(imgLoad);
        boundedAdd(iconBtn, 302, 150, 29, 31);
    }

    @Override
    protected void event() {
        iconBtn.addActionListener((event -> {
            String judulBuku = judulBukuField.getText();
            BukuEntity buku = Library.findBukuByTitle(judulBuku);
            if (buku != null) {
                new LihatBukuFrame(buku).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Maaf,Buku yang anda cari tidak ada",
                        "404 not found",
                        JOptionPane.ERROR_MESSAGE);
            }
        }));

    }
}
