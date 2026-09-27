package com.campushub.model;

public class Student {
    private int id;
    private String usn;
    private String name;
    private int age;
    private String email;
    private String department;
    private int year;
    private String section;
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

    public Student(int id, String usn, String name, int age,
                   String email, String department, int year, String section) {
        this.id = id;
        this.usn = usn;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.year = year;
        this.section = section;
    }

    public int getId() { return id; }
    public String getUsn() { return usn; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public int getYear() { return year; }
    public String getSection() { return section; }
    public ApprovalStatus getApprovalStatus() { return approvalStatus; }

    public void setApprovalStatus(ApprovalStatus status) {
        this.approvalStatus = status;
    }

    @Override
    public String toString() {
        return usn + " - " + name + " - " + department +
                " - Year " + year + " - Section " + section +
                " - " + approvalStatus;
    }
}
