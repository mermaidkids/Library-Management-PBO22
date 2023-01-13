package models;

import entity.*;
import java.util.ArrayList;

public class Staff {
    public static ArrayList<StaffEntity> staffList = new ArrayList<>();
    private static StaffEntity staffLogged = null;

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
