package entity;

import models.Library;

public class BukuEntity extends KoleksiEntity {
    // Attribut Class buku
    private String judulBuku;
    private int jmlHalaman;
    private String genreBuku;
    private String tanggalTerbit;
    private PenulisEntity penulis;
    private PenerbitEntity penerbit;

    public BukuEntity() {

    }

    // Cnstructor dengan parameter
    public BukuEntity(String judulBuku, int jmlHalaman, String genreBuku, String tanggalTerbit, boolean status) {

        idBukuBaru();
        this.judulBuku = judulBuku;
        this.jmlHalaman = jmlHalaman;
        this.genreBuku = genreBuku;
        this.tanggalTerbit = tanggalTerbit;
        this.status = status;

    }

    public BukuEntity(String judulBuku,
            int jmlHalaman, String genreBuku, String tanggalTerbit,
            PenulisEntity penulis, PenerbitEntity penerbit, boolean status) {
        idBukuBaru();
        this.judulBuku = judulBuku;
        this.jmlHalaman = jmlHalaman;
        this.genreBuku = genreBuku;
        this.tanggalTerbit = tanggalTerbit;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.status = status;
    }

    private void idBukuBaru() {

        if (Library.bukuList.size() == 0) {
            // Jika ArrayList buku MASIH Kosong,
            // maka atur idBuku menjadi 1
            this.idKoleksi = 1;
        } else {
            // Jika ArrayList Buku TIDAK Kosong, maka

            // Ambil index Terakhir dalam List
            int indexTerakhirDalamList = Library.bukuList.size() - 1;

            // Ambil Object Buku dalam List berdasarkan indexnya.
            BukuEntity bukuTerakhirDalamList = Library.bukuList.get(indexTerakhirDalamList);

            // Ambil idBuku pada Object Buku terakhir
            int idBukuTerakhir = bukuTerakhirDalamList.idKoleksi;

            // Id Buku yang baru
            this.idKoleksi = idBukuTerakhir + 1;
        }
    }

    // Method
    public void dataBuku() {
        System.out.println("ID buku  :" + idKoleksi);
        System.out.println("Judul Buku  : " + judulBuku);
        System.out.println("jumlah halaman : " + jmlHalaman);
        System.out.println("Genre Buku  : " + genreBuku);
        System.out.println("Tanggal terbit : " + tanggalTerbit);
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public int getJmlHalaman() {
        return jmlHalaman;
    }

    public void setJmlHalaman(int jmlHalaman) {
        this.jmlHalaman = jmlHalaman;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public PenulisEntity getPenulis() {
        return penulis;
    }

    public void setPenulis(PenulisEntity penulis) {
        this.penulis = penulis;
    }

    public PenerbitEntity getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(PenerbitEntity penerbit) {
        this.penerbit = penerbit;
    }

    public String getGenreBuku() {
        return genreBuku;
    }

    public String getNamaPenulis() {
        return penulis.getNama();
    }

    public String getNamaPenerbit() {
        return penerbit.getNama();
    }

    public void setGenreBuku(String genreBuku) {
        this.genreBuku = genreBuku;
    }

}
