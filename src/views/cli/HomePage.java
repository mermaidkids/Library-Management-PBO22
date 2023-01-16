package views.cli;

import java.util.Scanner;

public class HomePage {
    private Scanner input = new Scanner(System.in);
    private BukuPage bukuPage;

    public HomePage() {
        bukuPage = new BukuPage();
        initialPage();
    }

    private void initialPage() {

        System.out.println("=======================================");
        System.out.println("--------------- LIBRARY ---------------");
        System.out.println("=======================================");
        int menu;
        do {
            System.out.print("""
                    1. Lihat Buku
                    2. Tambah Buku
                    3. Edit Buku
                    4. Hapus Buku
                    5. Cari Buku (dengan nama)
                    6. Cari Buku (dengan Id)
                    7. Filter buku (dengan genre)
                    8. Cari staff (dengan nik)
                    0. Keluar
                    """);
            System.out.print("Pilih Menu: ");
            menu = input.nextInt();

            System.out.println();

            switchMenu(menu);
        } while (menu != 0);
    }

    private void switchMenu(int menu) {
        switch (menu) {
            case 1:
                bukuPage.lihatBuku();
                break;
            case 2:
                bukuPage.tambahBuku();
                break;

            case 3:
                bukuPage.editBuku();
                break;

            case 4:
                bukuPage.hapusBuku();
                break;

            case 5:
                bukuPage.cariBukuByTitle();
                break;

            case 6:
                bukuPage.cariBukuById();
                break;

            case 7:
                bukuPage.filterBuku();
                break;

            case 8:
                bukuPage.cariStaff();
                break;

            default:
                System.out.println("Menu Tidak Valid!");
                break;
        }
    }
}