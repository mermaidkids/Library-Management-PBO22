package entity;

public class StaffEntity {
    // Attribut class staff
    private String namaStaff;
    private String nik;
    private String password;

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

    // public StaffEntity() {

    // }

    public StaffEntity(String namaStaff, String nik, String password) {
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

    public String getNamaStaff() {
        return namaStaff;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

}
