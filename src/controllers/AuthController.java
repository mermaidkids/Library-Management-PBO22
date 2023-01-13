package controllers;

import entity.StaffEntity;
// import models.Library;
import models.Staff;

public class AuthController {

    public void initialStaff() {

        StaffEntity staff1 = new StaffEntity("Agus", "12345", "123");
        StaffEntity staff2 = new StaffEntity("Budi", "54321", "123");

        Staff.staffList.add(staff1);
        Staff.staffList.add(staff2);

    }

    public boolean regisStaff(String nama, String nik, String password) {
        if (Staff.findStaff(nik) == null) {
            StaffEntity staffbaru = new StaffEntity(nama, nik, password);
            Staff.regisStaff(staffbaru);
            return true;
        }
        return true;
    }

    public boolean login(String nik, String password) {
        StaffEntity staff = Staff.findStaff(nik);

        if (staff != null) {
            if (staff.getPassword().equals(password)) {
                Staff.setStaffLogged(staff);
                return true;
            } else {
                Staff.setStaffLogged(null);
            }
        }
        return false;
    }

    public void logout() {
        Staff.setStaffLogged(null);
    }

}
