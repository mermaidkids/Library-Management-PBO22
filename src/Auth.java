public class Auth {
    static Staff staffLogged = null;

    public static void initialStaff() {

        Staff staff1 = new Staff("Agus", "12345", "123");
        Staff staff2 = new Staff("Budi", "54321", "123");

        Library.staffList.add(staff1);
        Library.staffList.add(staff2);

    }

    public static boolean login(String nik, String password) {
        Staff staff = Library.findStaff(nik);

        if (staff != null) {
            if (staff.password.equals(password)) {
                staffLogged = staff;
                return true;
            } else {
                staffLogged = null;
            }
        }
        return false;
    }

    public static void logout() {
        staffLogged = null;
    }
}
