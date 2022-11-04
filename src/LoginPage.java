import java.util.Scanner;

public class LoginPage {
    Scanner input = new Scanner(System.in);

    public LoginPage() {
        while (true) {
            login();
        }
    }

    private void login() {
        String nik, password;

        System.out.println("--------------------");
        System.out.println("---- LOGIN STAFF ---");
        System.out.println("--------------------");
        System.out.println("NIK     :");
        nik = input.nextLine();
        System.out.println("Password     :");
        password = input.nextLine();
        System.out.println("--------------------");

        boolean statusLogin = Auth.login(nik, password);

        if (statusLogin == true) {
            System.out.println("Berhasil Login");
        } else {
            logingagal();
        }
    }

    void logingagal() {
        System.out.println("--------------------");
        System.out.println("---- LOGIN GAGAL ---");
        System.out.println("---- NIK/PASSWORD SALAH ---");
        System.out.println("--------------------");

    }
}
