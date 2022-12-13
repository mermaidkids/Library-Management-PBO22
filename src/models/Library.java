package models;

import java.util.ArrayList;
import entity.*;
//import entity.Penerbit;
//import entity.Penulis;
//import entity.Staff;

public class Library {

    public static ArrayList<BukuEntity> bukuList = new ArrayList<>();
    public static ArrayList<StaffEntity> staffList = new ArrayList<>();
    BukuEntity buku = new BukuEntity();

    public static void initialBuku() {
        PenulisEntity penulis = new PenulisEntity("Agus Budi Cahyani");
        PenerbitEntity penerbit = new PenerbitEntity("PT Cetak Buku");
        BukuEntity buku1 = new BukuEntity("Judul 1", 123, "01/01/2000", penulis, penerbit, true);
        BukuEntity buku2 = new BukuEntity("Judul 2", 200, "01/01/2000", null, null, true);

        bukuList.add(buku1);
        bukuList.add(buku2);
    }

    public static StaffEntity findStaff(String nik) {
        for (StaffEntity staff : staffList) {
            if (staff.getNik().equals(nik)) {
                return staff;
            }
        }
        return null;
    }

    public static BukuEntity findBukuById(int id) {
        for (BukuEntity buku : bukuList) {
            if (buku.idKoleksi == id) {
                return buku;
            }
        }
        return null;
    }

    public static BukuEntity findBukuByTitle(String title) {
        for (BukuEntity buku : bukuList) {
            if (buku.judulBuku.contains(title)) {
                return buku;
            }
        }
        return null;
    }

    private static int indexData(BukuEntity buku) {
        for (int i = 0; i < bukuList.size(); i++) {
            if (bukuList.get(i).idKoleksi == buku.idKoleksi) {
                return i;
            }
        }
        return -1;
    }

    public static void tambahBuku(BukuEntity buku) {
        bukuList.add(buku);
    }

    public static void updateBuku(BukuEntity buku) {
        int indexBukuList = indexData(buku);

        if (indexBukuList != -1) {
            bukuList.set(indexBukuList, buku);
        }
    }

    public static void deleteBuku(BukuEntity buku) {
        bukuList.remove(buku);

    }
}
