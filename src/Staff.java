public class Staff extends Akun {
    // Attribut class staff
    String namaStaff;

    public Staff() {

    }

    public Staff(String namaStaff, String nik, String password) {
        this.namaStaff = namaStaff;
        this.nik = nik;
        this.password = password;
    }

    // Method
    public void dataStaff() {
        System.out.println("Nama staff  :" + namaStaff);
        System.out.println("NIK Staff   :" + nik);
        System.out.println("Password    :" + password);
    }
}
