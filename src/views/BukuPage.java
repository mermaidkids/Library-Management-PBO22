package views;

import java.util.Scanner;

import entity.BukuEntity;
import entity.PenerbitEntity;
import entity.PenulisEntity;
import entity.StaffEntity;
import models.Library;
import models.Staff;

public class BukuPage extends Library {
    private Scanner input = new Scanner(System.in);

    private void lihatBuku(BukuEntity buku) {
        PenulisEntity penulis = buku.getPenulis();
        PenerbitEntity penerbit = buku.getPenerbit();

        System.out.println("---------------------------------------");
        System.out.println("ID Buku        : " + buku.getIdKoleksi());
        System.out.println("Judul Buku     : " + buku.getJudulBuku());
        System.out.println("Jumlah Halaman : " + buku.getJmlHalaman());
        System.out.println("Genre Buku     : " + buku.getGenreBuku());
        if (penulis != null) {
            System.out.println("Nama Penulis   : " + penulis.getNama());
        } else {
            System.out.println("Nama Penulis   : Tidak diketahui");
        }
        if (penerbit != null) {
            System.out.println("Penerbit       : " + penerbit.getNama());
        } else {
            System.out.println("Penerbit       : Tidak diketahui");
        }
        System.out.println("Tanggal Terbit : " + buku.getTanggalTerbit());
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
        String genreBuku;
        String tanggalTerbit;

        PenulisEntity penulis = null;
        PenerbitEntity penerbit = null;

        System.out.println("============== TAMBAH BUKU ============");
        System.out.print("Judul Buku        : ");
        judulBuku = input.nextLine();

        System.out.print("Jumlah Halaman    : ");
        jmlHalaman = input.nextInt();

        input.nextLine();

        System.out.print("Genre Buku      :");
        genreBuku = input.nextLine();

        System.out.print("Tanggal Terbit    : ");
        tanggalTerbit = input.nextLine();

        System.out.print("Masukan Penulis (y/n) ? ");
        char masukanPenulis = input.nextLine().charAt(0);

        if (masukanPenulis == 'y') {
            String namaPenulis;
            String emailPenulis;
            System.out.print("  Nama Penulis    : ");
            namaPenulis = input.nextLine();
            System.out.print(" Email Penulis  : ");
            emailPenulis = input.nextLine();
            penulis = new PenulisEntity(namaPenulis, emailPenulis);
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

        BukuEntity bukuBaru = new BukuEntity(judulBuku, jmlHalaman, genreBuku, tanggalTerbit, penulis, penerbit, true);

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
                System.out.println("Judul Buku          : " + buku.getJudulBuku());
                System.out.print("Masukan Judul Baru  : ");
                judulBukuBaru = input.nextLine();
                buku.setJudulBuku(judulBukuBaru);
                break;

            case 2:
                int jmlHalaman;
                System.out.println("Jumlah Halaman              : " + buku.getJmlHalaman());
                System.out.print("Masukan Jumlah Halaman Baru : ");
                jmlHalaman = input.nextInt();
                input.nextLine();
                buku.setJmlHalaman(jmlHalaman);
                break;

            case 3:
                String genreBuku;
                System.out.println("Genre Buku              : " + buku.getGenreBuku());
                System.out.print("Masukan Genre Baru : ");
                genreBuku = input.nextLine();

                buku.setGenreBuku(genreBuku);
                break;

            case 4:
                String tglTerbit;
                System.out.println("Tanggal Terbit            : " + buku.getTanggalTerbit());
                System.out.print("Masukan Tanggal Terbit Baru : ");
                tglTerbit = input.nextLine();

                buku.setTanggalTerbit(tglTerbit);
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
                3. Genre Buku
                4. Tanggal Terbit
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

        System.out.print("Ingin Menghapus Buku ini ? (y/n) ");
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

    public void cariBukuByTitle() {

        System.out.print("Masukkan Judul Buku : ");
        String judulBuku = input.nextLine();
        BukuEntity buku = Library.findBukuByTitle(judulBuku);
        if (buku != null) {
            lihatBuku(buku);
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }
    }

    public void cariBukuById() {

        System.out.print("Masukkan Id Buku : ");
        int idBuku = input.nextInt();
        input.nextLine();
        BukuEntity buku = Library.findBukuById(idBuku);
        if (buku != null) {
            lihatBuku(buku);
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }
    }

    public void filterBuku() {

        System.out.print("Masukkan genre Buku : ");
        String genre = input.nextLine();

        BukuEntity buku = Library.filterBukuByGenre(genre);
        if (buku != null) {
            lihatBuku(buku);
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }

    }

    public void cariStaff() {

        System.out.print("Masukkan nik Staff : ");
        String nik = input.nextLine();
        StaffEntity staff = Staff.findStaff(nik);
        if (staff != null) {
            System.out.println(staff.getNamaStaff());
        } else {
            System.out.println("Data Buku Tidak Ditemukan !");
        }
    }

}