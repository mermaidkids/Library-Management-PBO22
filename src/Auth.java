public class Auth {
    static Staff staffLogged = null;

    public static Staff getstaffLogged() {
        return staffLogged;
    }

    public static boolean login(String nik, String password) {

        // contoh logim hanya 1 user
        if ((Library.staffAktif.nik.equals(nik)) && (Library.staffAktif.password.equals(password))) {
            staffLogged = Library.staffAktif;
            return true;
        } else {
            // NIK atau password salah
            return false;
        }
    }

    public static void logout() {
        staffLogged = null;
    }
}
