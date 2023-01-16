package models;

import entity.*;
import java.util.ArrayList;

public class Staff {
    public static ArrayList<StaffEntity> staffList = new ArrayList<>();
    private static StaffEntity staffLogged = null;

    public static void initialStaff() {

        StaffEntity staff1 = new StaffEntity("Agus", "12345", "123");
        StaffEntity staff2 = new StaffEntity("Budi", "54321", "123");

        staffList.add(staff1);
        staffList.add(staff2);

    }

    public static ArrayList<StaffEntity> all() {
        return staffList;
    }

    public static StaffEntity findStaff(String nik) {
        for (StaffEntity staff : staffList) {
            if (staff.getNik().equals(nik)) {
                return staff;
            }
        }
        return null;
    }

    public static void regisStaff(StaffEntity data) {
        staffList.add(data);
    }

    public static StaffEntity getStaffLogged() {
        return staffLogged;
    }

    public static void setStaffLogged(StaffEntity staffLogged) {
        Staff.staffLogged = staffLogged;
    }

}
