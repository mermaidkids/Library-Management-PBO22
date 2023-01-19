package views.gui;

import java.awt.Font;
import javax.swing.*;

import entity.*;
import views.gui.home.*;

public class LihatBukuFrame extends MainFrame {
    private JLabel titleLabel;
    private JLabel namaBukuLabel;
    private JLabel halamanBukuLabel;
    private JLabel genreBukuLabel;
    private JLabel tanggalTerbitLabel;
    private JLabel penulisLabel;
    private JLabel namaPenulisLabel, namaPenerbitLabel, emailPenulisLabel, alamatPenerbitLabel;
    private JTextField namaPenulisField, namaPenerbitField, emailPenulisField, alamatPenerbitField;
    private JLabel penerbitLabel;
    private JTextField namaBukuField, halamanField, genreField, tanggalField;
    private JButton tutupBtn;

    PenulisEntity penulis = null;
    PenerbitEntity penerbit = null;
    DashboardFrame _dashboardF = new DashboardFrame();
    private BukuEntity _bukuC;

    public LihatBukuFrame(BukuEntity buku) {
        super("LIHAT BUKU", 400, 600);
        this._bukuC = buku;

    }

    @Override
    protected void component() {

        titleLabel = new JLabel("LIHAT BUKU");
        setFontSize(titleLabel, 32);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 80, 19, 239, 39);

        namaBukuLabel = new JLabel("Judul Buku");
        setFontSize(namaBukuLabel, 15);
        setFontStyle(namaBukuLabel, Font.BOLD);
        boundedAdd(namaBukuLabel, 34, 79, 82, 18);

        namaBukuField = new JTextField(_bukuC.getJudulBuku());
        namaBukuField.setEditable(false);
        boundedAdd(namaBukuField, 34, 105, 333, 24);

        halamanBukuLabel = new JLabel("Jumlah Halaman Buku");
        setFontSize(halamanBukuLabel, 15);
        setFontStyle(halamanBukuLabel, Font.BOLD);
        boundedAdd(halamanBukuLabel, 34, 135, 163, 18);

        halamanField = new JTextField(String.valueOf(_bukuC.getJmlHalaman()));
        halamanField.setEditable(false);
        boundedAdd(halamanField, 34, 161, 333, 24);

        genreBukuLabel = new JLabel("Genre Buku");
        setFontSize(genreBukuLabel, 15);
        setFontStyle(genreBukuLabel, Font.BOLD);
        boundedAdd(genreBukuLabel, 34, 191, 86, 18);

        genreField = new JTextField(_bukuC.getGenreBuku());
        genreField.setEditable(false);
        boundedAdd(genreField, 34, 217, 333, 24);

        tanggalTerbitLabel = new JLabel("Tanggal Terbit");
        setFontSize(tanggalTerbitLabel, 15);
        setFontStyle(tanggalTerbitLabel, Font.BOLD);
        boundedAdd(tanggalTerbitLabel, 34, 247, 106, 18);

        tanggalField = new JTextField(_bukuC.getTanggalTerbit());
        tanggalField.setEditable(false);
        boundedAdd(tanggalField, 34, 273, 333, 24);

        penulisLabel = new JLabel("Penulis");
        setFontSize(penulisLabel, 15);
        setFontStyle(penulisLabel, Font.BOLD);
        boundedAdd(penulisLabel, 34, 304, 54, 18);

        namaPenulisLabel = new JLabel("Nama Penulis :");
        setFontSize(namaPenulisLabel, 10);
        setFontStyle(namaPenulisLabel, Font.BOLD);
        boundedAdd(namaPenulisLabel, 37, 354, 72, 12);

        namaPenulisField = new JTextField(_bukuC.getNamaPenulis());
        namaPenulisField.setEditable(false);
        boundedAdd(namaPenulisField, 114, 349, 248, 24);

        emailPenulisLabel = new JLabel("Email Penulis :");
        setFontSize(emailPenulisLabel, 10);
        setFontStyle(emailPenulisLabel, Font.BOLD);
        boundedAdd(emailPenulisLabel, 37, 384, 70, 12);

        emailPenulisField = new JTextField(_bukuC.getEmailPenulis());
        emailPenulisField.setEditable(false);
        boundedAdd(emailPenulisField, 114, 379, 248, 24);

        penerbitLabel = new JLabel("Penerbit");
        setFontSize(penerbitLabel, 15);
        setFontStyle(penerbitLabel, Font.BOLD);
        boundedAdd(penerbitLabel, 33, 423, 63, 18);

        namaPenerbitLabel = new JLabel("Nama Penerbit :");
        setFontSize(namaPenerbitLabel, 10);
        setFontStyle(namaPenerbitLabel, Font.BOLD);
        boundedAdd(namaPenerbitLabel, 37, 467, 78, 12);

        namaPenerbitField = new JTextField(_bukuC.getNamaPenerbit());
        namaPenerbitField.setEditable(false);
        boundedAdd(namaPenerbitField, 119, 461, 248, 24);

        alamatPenerbitLabel = new JLabel("alamat Penerbit :");
        setFontSize(alamatPenerbitLabel, 10);
        setFontStyle(alamatPenerbitLabel, Font.BOLD);
        boundedAdd(alamatPenerbitLabel, 30, 496, 85, 12);

        alamatPenerbitField = new JTextField(_bukuC.getAlamatPenerbit());
        alamatPenerbitField.setEditable(false);
        boundedAdd(alamatPenerbitField, 119, 490, 248, 24);

        tutupBtn = new JButton("Tutup");
        tutupBtn.setBackground(color("#FF4040"));
        tutupBtn.setForeground(color("#FFFFFF"));
        boundedAdd(tutupBtn, 292, 540, 74, 30);

    }

    @Override
    protected void event() {

        tutupBtn.addActionListener((event -> {
            dispose();
        }));

    }
}
