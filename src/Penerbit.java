public class Penerbit extends Identitas {
    // Attribut Class Penerbit
    String alamatPenerbit;

    public Penerbit() {

    }

    public Penerbit(String namaPenerbit) {
        this.nama = namaPenerbit;
        this.alamatPenerbit = "-";
    }

    public Penerbit(String namaPenerbit, String alamatPenerbit) {
        this.nama = namaPenerbit;
        this.alamatPenerbit = alamatPenerbit;
    }

    // Method
    public void dataPenerbit() {
        System.out.println("Nama Penerbit     :" + nama);
        System.out.println("Alamat Penerbit :" + alamatPenerbit);

    }
}
