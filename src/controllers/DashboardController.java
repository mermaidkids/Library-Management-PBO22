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
}
