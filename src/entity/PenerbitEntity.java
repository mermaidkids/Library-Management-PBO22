package entity;

public class PenerbitEntity extends IdentitasEntity {
    // Attribut Class Penerbit
    String alamatPenerbit;

    public PenerbitEntity() {

    }

    public PenerbitEntity(String namaPenerbit) {
        this.nama = namaPenerbit;
        this.alamatPenerbit = "-";
    }

    public PenerbitEntity(String namaPenerbit, String alamatPenerbit) {
        this.nama = namaPenerbit;
        this.alamatPenerbit = alamatPenerbit;
    }

    // Method
    public void dataPenerbit() {
        System.out.println("Nama Penerbit     :" + nama);
        System.out.println("Alamat Penerbit :" + alamatPenerbit);

    }
}
