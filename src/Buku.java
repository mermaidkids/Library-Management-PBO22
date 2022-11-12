public class Buku {
    // Attribut Class buku
    int idBuku;
    String judulBuku;
    int jmlHalaman;
    String tanggalTerbit;
    Penulis penulis;
    Penerbit penerbit;

    public Buku(){
        
    }
    // Cnstructor dengan parameter
    public Buku(int idBuku, String judulBuku,
            int jmlHalaman, String tanggalTerbit,
            Penulis penulis, Penerbit penerbit) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.jmlHalaman = jmlHalaman;
        this.tanggalTerbit = tanggalTerbit;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    // Method
    public void dataBuku() {
        System.out.println("ID buku  :" + idBuku);
        System.out.println("Judul Buku  : " + judulBuku);
        System.out.println("jumlah halaman : " + jmlHalaman);
        System.out.println("Tanggal terbit : " + tanggalTerbit);
    }
}
