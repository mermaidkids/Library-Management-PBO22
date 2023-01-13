package views;

import java.util.Scanner;

import controllers.AuthController;

public class LoginPage {
    Scanner input = new Scanner(System.in);
    AuthController auth = new AuthController();

    public LoginPage() {
        int pil;
        do {
            System.out.print("""
                    1. Login
                    2. Register
                    pilih(1/2) : """);
            pil = input.nextInt();
            input.nextLine();
            switch (pil) {
                case 1:
                    login();
                    break;
                case 2:
                    regis();
                    break;
                default:
                    System.out.println("tidak valid");
                    break;

            }
        } while (pil != 0);
    }

    private void regis() {
        String nama, nik, password;

        System.out.println("-----------------------");
        System.out.print("Masukkan Nama   : ");
        nama = input.nextLine();
        System.out.print("Masukkan Nik    : ");
        nik = input.nextLine();
        System.out.print("Masukkan Password   : ");
        password = input.nextLine();
        System.out.println("------------------------");

        boolean statusRegis = auth.regisStaff(nama, nik, password);

        if (statusRegis == true) {
            System.out.println("Register berhasil");
            login();
        } else {
            System.out.println("User telah ada");
            login();
        }
    }

    private void login() {
        String nik, password;

        System.out.println("--------------------");
        System.out.println("---- LOGIN STAFF ---");
        System.out.println("--------------------");
        System.out.print("NIK     :");
        nik = input.nextLine();
        System.out.print("Password     :");
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
