package views;

import java.util.Scanner;

import entity.BukuEntity;
import entity.PenerbitEntity;
import entity.PenulisEntity;
import models.Library;

public class BukuPage {
    private Scanner input = new Scanner(System.in);

    private void lihatBuku(BukuEntity buku) {
        PenulisEntity penulis = buku.penulis;
        PenerbitEntity penerbit = buku.penerbit;

        System.out.println("---------------------------------------");
        System.out.println("ID Buku        : " + buku.idKoleksi);
        System.out.println("Judul Buku     : " + buku.judulBuku);
        System.out.println("Jumlah Halaman : " + buku.jmlHalaman);
        if (penulis != null) {
            System.out.println("Nama Penulis   : " + penulis.nama);
        } else {
            System.out.println("Nama Penulis   : Tidak diketahui");
        }
        if (penerbit != null) {
            System.out.println("Penerbit       : " + penerbit.nama);
        } else {
            System.out.println("Penerbit       : Tidak diketahui");
        }
        System.out.println("Tanggal Terbit : " + buku.tanggalTerbit);
        System.out.println("---------------------------------------");

    }

    public void lihatBuku() {
        System.out.println("============== LIHAT BUKU =============");
        for (BukuEntity buku : Library.bukuList) {
            lihatBuku(buku);
        }
        System.out.println("=======================================");

        System.out.print("Lanjut ...");
        input.nextLine();
        System.out.println();
    }

    public void tambahBuku() {
        String judulBuku;
        int jmlHalaman;
        String tanggalTerbit;
        PenulisEntity penulis = null;
        PenerbitEntity penerbit = null;

        System.out.println("============== TAMBAH BUKU ============");
        System.out.print("Judul Buku        : ");
        judulBuku = input.nextLine();

        System.out.print("Jumlah Halaman    : ");
        jmlHalaman = input.nextInt();

        input.nextLine();

        System.out.print("Tanggal Terbit    : ");
        tanggalTerbit = input.nextLine();

        System.out.print("Masukan Penulis (y/n) ? ");
        char masukanPenulis = input.nextLine().charAt(0);

        if (masukanPenulis == 'y') {
            String namaPenulis;
            System.out.print("  Nama Penulis    : ");
            namaPenulis = input.nextLine();
            penulis = new PenulisEntity(namaPenulis);
        }

        System.out.print("Masukan Penerbit (y/n) ? ");
        char masukanPenerbit = input.nextLine().charAt(0);

        if (masukanPenerbit == 'y') {
            String namaPenerbit, alamatPenerbit;

            System.out.print("  Nama Penerbit   : ");
            namaPenerbit = input.nextLine();

            System.out.print("  Alamat Penerbit : ");
            alamatPenerbit = input.nextLine();

            penerbit = new PenerbitEntity(namaPenerbit, alamatPenerbit);
        }

        BukuEntity bukuBaru = new BukuEntity(judulBuku, jmlHalaman, tanggalTerbit, penulis, penerbit, true);

        Library.tambahBuku(bukuBaru);

        System.out.println("Berhasil Menambahkan Buku");

        System.out.println("=======================================");

        System.out.print("Lanjut ...");
        input.nextLine();
        System.out.println();
    }

    public void editBuku(BukuEntity buku, int pilihEdit) {
        switch (pilihEdit) {
            case 1:
                String judulBukuBaru;
                System.out.println("Judul Buku          : " + buku.judulBuku);
                System.out.print("Masukan Judul Baru  : ");
                judulBukuBaru = input.nextLine();
                buku.setJudulBuku(judulBukuBaru);
                break;
            case 2:
                int jmlHalaman;
                System.out.println("Jumlah Halaman              : " + buku.jmlHalaman);
                System.out.print("Masukan Jumlah Halaman Baru : ");
                jmlHalaman = input.nextInt();
                input.nextLine();
                buku.setJmlHalaman(jmlHalaman);
                break;
        }

        Library.updateBuku(buku);
        System.out.println("Berhasil Mengubah Data Buku");

        System.out.print("Lanjut ...");
        input.nextLine();
        System.out.println();
    }

    public void editBuku(BukuEntity buku) {
        System.out.println("---------------------------------------");
        System.out.println("Ingin mengubah apa ? ");

        int pilihEdit;
        System.out.print("""
                1. Judul Buku
                2. Jumlah Halaman
                3. Tanggal Terbit
                4. Penulis
                5. Penerbit
                6. Status
                0. Selesai
                Pilih: """);
        pilihEdit = input.nextInt();
        input.nextLine();

        editBuku(buku, pilihEdit);
        System.out.println("---------------------------------------");

    }

    public void editBuku() {
        int idKoleksi;

        System.out.println("=============== EDIT BUKU =============");

        System.out.print("Masukan ID Buku: ");
        idKoleksi = input.nextInt();
        input.nextLine();

        BukuEntity buku = Library.findBukuById(idKoleksi);

        if (buku != null) {
            editBuku(buku);
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }

        System.out.println("=======================================");
    }

    private void hapusBuku(BukuEntity buku) {
        System.out.println("=============== KONFIRMASI ============");

        lihatBuku(buku);

        System.out.println("Ingin Menghapus Buku ini ? (y/n) ");
        char konf = input.nextLine().charAt(0);

        if (konf == 'y') {
            Library.deleteBuku(buku);
        }

    }

    public void hapusBuku() {
        int idKoleksi;

        System.out.println("============== HAPUS  BUKU ============");

        System.out.print("Masukan ID Buku: ");
        idKoleksi = input.nextInt();
        input.nextLine();

        BukuEntity buku = Library.findBukuById(idKoleksi);

        if (buku != null) {
            hapusBuku(buku);
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }

        System.out.println("=======================================");
    }
}