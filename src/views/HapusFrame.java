package views;

import java.awt.Font;
import javax.swing.*;

import entity.BukuEntity;

public class HapusFrame extends MainFrame {

    private JLabel titleLabel;
    private JLabel captionLabel;
    private JLabel bukuLabel;
    private JButton hapusBtn;
    private JButton batalBtn;
    private BukuEntity buku;

    public HapusFrame() {
        super("Registrasi", 400, 200);

    }

    @Override
    protected void component() {
        titleLabel = new JLabel("HAPUS BUKU");
        setFontSize(titleLabel, 24);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 130, 20, 158, 29);

        captionLabel = new JLabel("Yakin ingin menghapus");
        setFontSize(captionLabel, 13);
        setFontStyle(captionLabel, Font.BOLD);
        boundedAdd(captionLabel, 89, 84, 168, 16);

        bukuLabel = new JLabel(buku.getJudulBuku());
        setFontSize(bukuLabel, 13);
        setFontStyle(bukuLabel, Font.BOLD);
        boundedAdd(bukuLabel, 89, 84, 168, 16);

        hapusBtn = new JButton("Hapus");
        hapusBtn.setBackground(color("#00D4FF"));
        hapusBtn.setForeground(color("#FFFFFF"));
        boundedAdd(hapusBtn, 314, 151, 70, 30);

        batalBtn = new JButton("Batal");
        batalBtn.setBackground(color("#00D4FF"));
        batalBtn.setForeground(color("#FFFFFF"));
        boundedAdd(batalBtn, 225, 151, 70, 30);

    }

    @Override
    protected void event() {

    }

}
