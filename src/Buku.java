public class Buku extends Koleksi {
    // Attribut Class buku

    String judulBuku;
    int jmlHalaman;
    String tanggalTerbit;
    Penulis penulis;
    Penerbit penerbit;

    public Buku() {

    }

    // Cnstructor dengan parameter
    public Buku(String judulBuku, int jmlHalaman, String tanggalTerbit, boolean status) {

        idBukuBaru();
        this.judulBuku = judulBuku;
        this.jmlHalaman = jmlHalaman;
        this.tanggalTerbit = tanggalTerbit;
        this.penulis = null;
        this.penerbit = null;
        this.status = status;

    }

    public Buku(String judulBuku,
            int jmlHalaman, String tanggalTerbit,
            Penulis penulis, Penerbit penerbit, boolean status) {
        idBukuBaru();
        this.judulBuku = judulBuku;
        this.jmlHalaman = jmlHalaman;
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
            Buku bukuTerakhirDalamList = Library.bukuList.get(indexTerakhirDalamList);

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
        System.out.println("Tanggal terbit : " + tanggalTerbit);
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public void setJmlHalaman(int jmlHalaman) {
        this.jmlHalaman = jmlHalaman;
    }

}
