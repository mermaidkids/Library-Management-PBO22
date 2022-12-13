package controllers;

import entity.AkunEntity;
import entity.StaffEntity;
import models.Library;

public class AuthController extends AkunEntity {
    StaffEntity staffLogged = null;

    public void initialStaff() {

        StaffEntity staff1 = new StaffEntity("Agus", "12345", "123");
        StaffEntity staff2 = new StaffEntity("Budi", "54321", "123");

        Library.staffList.add(staff1);
        Library.staffList.add(staff2);

    }

    public boolean login(String nik, String password) {
        StaffEntity staff = Library.findStaff(nik);

        if (staff != null) {
            if (staff.getPassword().equals(password)) {
                staffLogged = staff;
                return true;
            } else {
                staffLogged = null;
            }
        }
        return false;
    }

    public void logout() {
        staffLogged = null;
    }
}
