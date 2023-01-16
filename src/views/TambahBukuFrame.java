package views;

import java.awt.Font;
import javax.swing.*;

public class TambahBukuFrame extends MainFrame {
    private JLabel titleLabel;
    private JLabel namaBukuLabel;
    private JLabel halamanBukuLabel;
    private JLabel genreBukuLabel;
    private JLabel tanggalTerbitLabel;
    private JLabel penulisLabel;
    private JLabel penerbitLabel, yLabel1, yLabel2, tLabel1, tLabel2;
    private JTextField namaBukuField, halamanField, genreField, tanggalField, penulisField, penerbitField;
    private JRadioButton yaButton1, yaButton2, tidakButton1, tidakButton2;
    private JButton tambahBtn, batalBtn;
    private ButtonGroup G1, G2;

    public TambahBukuFrame() {
        super("Tambah Buku", 400, 600);
    }

    @Override
    protected void component() {

        titleLabel = new JLabel("TAMBAH BUKU");
        setFontSize(titleLabel, 32);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 80, 53, 239, 39);

        namaBukuLabel = new JLabel("Judul Buku");
        setFontSize(namaBukuLabel, 15);
        setFontStyle(namaBukuLabel, Font.BOLD);
        boundedAdd(namaBukuLabel, 33, 123, 82, 18);

        namaBukuField = new JTextField();
        boundedAdd(namaBukuField, 33, 149, 333, 24);

        halamanBukuLabel = new JLabel("Jumlah Halaman Buku");
        setFontSize(halamanBukuLabel, 15);
        setFontStyle(halamanBukuLabel, Font.BOLD);
        boundedAdd(halamanBukuLabel, 33, 179, 163, 18);

        halamanField = new JTextField();
        boundedAdd(halamanField, 33, 205, 333, 24);

        genreBukuLabel = new JLabel("Genre Buku");
        setFontSize(genreBukuLabel, 15);
        setFontStyle(genreBukuLabel, Font.BOLD);
        boundedAdd(genreBukuLabel, 33, 235, 86, 18);

        genreField = new JTextField();
        boundedAdd(genreField, 33, 261, 333, 24);

        tanggalTerbitLabel = new JLabel("Tanggal Terbit");
        setFontSize(tanggalTerbitLabel, 15);
        setFontStyle(tanggalTerbitLabel, Font.BOLD);
        boundedAdd(tanggalTerbitLabel, 33, 291, 106, 18);

        tanggalField = new JTextField();
        boundedAdd(tanggalField, 33, 317, 333, 24);

        penulisLabel = new JLabel("Penulis");
        setFontSize(penulisLabel, 15);
        setFontStyle(penulisLabel, Font.BOLD);
        boundedAdd(penulisLabel, 33, 347, 54, 18);

        yaButton1 = new JRadioButton();
        boundedAdd(yaButton1, 36, 375, 9, 9);

        yLabel1 = new JLabel("Ya");
        setFontSize(yLabel1, 10);
        setFontStyle(yLabel1, Font.BOLD);
        boundedAdd(yLabel1, 52, 374, 12, 12);

        tidakButton1 = new JRadioButton();
        boundedAdd(tidakButton1, 81, 375, 9, 9);

        tLabel1 = new JLabel("Tidak");
        setFontSize(tLabel1, 10);
        setFontStyle(tLabel1, Font.BOLD);
        boundedAdd(tLabel1, 97, 374, 28, 12);

        G1 = new ButtonGroup();
        G1.add(yaButton1);
        G1.add(tidakButton1);

        penulisField = new JTextField();
        boundedAdd(penulisField, 33, 393, 333, 24);

        penerbitLabel = new JLabel("Penerbit");
        setFontSize(penerbitLabel, 15);
        setFontStyle(penerbitLabel, Font.BOLD);
        boundedAdd(penerbitLabel, 33, 423, 63, 18);

        yaButton2 = new JRadioButton();
        boundedAdd(yaButton2, 36, 451, 9, 9);

        yLabel2 = new JLabel("Ya");
        setFontSize(yLabel2, 10);
        setFontStyle(yLabel2, Font.BOLD);
        boundedAdd(yLabel2, 52, 450, 12, 12);

        tidakButton2 = new JRadioButton();
        boundedAdd(tidakButton2, 81, 451, 9, 9);

        tLabel2 = new JLabel("Tidak");
        setFontSize(tLabel2, 10);
        setFontStyle(tLabel2, Font.BOLD);
        boundedAdd(tLabel2, 97, 450, 28, 12);

        G2 = new ButtonGroup();
        G2.add(yaButton2);
        G2.add(tidakButton2);

        penerbitField = new JTextField();
        boundedAdd(penerbitField, 33, 469, 333, 24);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#5BFF40"));
        tambahBtn.setForeground(color("#FFFFFF"));
        boundedAdd(tambahBtn, 292, 540, 74, 30);

        batalBtn = new JButton("Batal");
        batalBtn.setBackground(color("#FF4040"));
        batalBtn.setForeground(color("#FFFFFF"));
        boundedAdd(batalBtn, 196, 540, 74, 30);

    }

    @Override
    protected void event() {
        tambahBtn.addActionListener((event -> {
            if (yaButton1.isSelected()) {

            }
        }));

    }

}
