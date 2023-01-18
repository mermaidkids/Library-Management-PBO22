package models;

import java.util.ArrayList;
import entity.*;

public class Library {

    public static ArrayList<BukuEntity> bukuList = new ArrayList<>();

    BukuEntity buku = new BukuEntity();

    public static ArrayList<BukuEntity> getBukuList() {
        return bukuList;
    }

    public static void initialBuku() {
        PenulisEntity penulis = new PenulisEntity("Agus Budi Cahyani");
        PenerbitEntity penerbit = new PenerbitEntity("PT Cetak Buku");
        BukuEntity buku1 = new BukuEntity("Judul 1", 123, "Horror", "01/01/2000", penulis, penerbit, true);

        bukuList.add(buku1);

    }

    public static BukuEntity findBukuById(int id) {
        for (BukuEntity buku : bukuList) {
            if (buku.getIdKoleksi() == id) {
                return buku;
            }
        }
        return null;
    }

    public static BukuEntity filterBukuByGenre(String genre) {
        for (BukuEntity buku : bukuList) {
            if (buku.getGenreBuku().contains(genre)) {
                return buku;
            }
        }
        return null;
    }

    public static BukuEntity findBukuByTitle(String title) {
        for (BukuEntity buku : bukuList) {
            if (buku.getJudulBuku().equals(title)) {
                return buku;
            }
        }
        return null;
    }

    private static int indexData(BukuEntity buku) {
        for (int i = 0; i < bukuList.size(); i++) {
            if (bukuList.get(i).getIdKoleksi() == buku.getIdKoleksi()) {
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

    public static void deleteBuku(int index) {
        bukuList.remove(index);
    }

    public static void getIndex(int index) {
        bukuList.get(index);
    }
}
