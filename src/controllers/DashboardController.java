package controllers;

import java.util.ArrayList;
import entity.BukuEntity;
import entity.StaffEntity;
import models.Library;
import models.Staff;

public class DashboardController {

    public void toView() {

    }

    public StaffEntity staffLogged() {
        return Staff.getStaffLogged();
    }

    public ArrayList<BukuEntity> bukuList() {
        return Library.getBukuList();
    }

    public void updateBuku(BukuEntity buku) {
        Library.updateBuku(buku);
    }

    public void getIndex(int index) {
        Library.findBukuById(index);
    }

    public void delete(int index) {
        Library.deleteBuku(index);
    }

}
