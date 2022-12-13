package views;

import java.util.Scanner;

import controllers.AuthController;

public class LoginPage extends AuthController {
    Scanner input = new Scanner(System.in);
    AuthController auth = new AuthController();

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

        boolean statusLogin = auth.login(nik, password);

        if (statusLogin == true) {
            new HomePage();
        } else {
            loginGagal();
        }
    }

    void loginGagal() {
        System.out.println("--------------------");
        System.out.println("---- LOGIN GAGAL ---");
        System.out.println("---- NIK/PASSWORD SALAH ---");
        System.out.println("--------------------");

    }
}
