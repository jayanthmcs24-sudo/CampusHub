package com.campushub.service;

import com.campushub.model.Staff;
import java.util.ArrayList;
import java.util.List;

public class StaffService {
    private final List<Staff> staff = new ArrayList<>();

    public void addStaff(Staff value) { staff.add(value); }
    public List<Staff> getAllStaff() { return staff; }
}
