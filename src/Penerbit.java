public class Penerbit {
    // Attribut Class Penerbit
    String namaPenerbit;
    String alamatPenerbit;

    public Penerbit(String namaPenerbit, String alamatPenerbit) {
        this.namaPenerbit = namaPenerbit;
        this.alamatPenerbit = alamatPenerbit;
    }

    // Method
    public void dataPenerbit() {
        System.out.println("Nama Penerbit     :" + namaPenerbit);
        System.out.println("Alamat Penerbit :" + alamatPenerbit);

    }
}
