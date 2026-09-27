package com.campushub.service;

import com.campushub.model.ApprovalStatus;
import com.campushub.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void register(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (findStudentByUsn(student.getUsn()) != null)
            throw new IllegalArgumentException("USN already exists.");
        students.add(student);
    }

    public List<Student> getAllStudents() { return students; }

    public Student findStudentByUsn(String usn) {
        if (usn == null) return null;
        for (Student student : students) {
            if (student.getUsn().equalsIgnoreCase(usn.trim())) return student;
        }
        return null;
    }

    public boolean approveStudent(String usn) {
        Student student = findStudentByUsn(usn);
        if (student == null) return false;
        student.setApprovalStatus(ApprovalStatus.APPROVED);
        return true;
    }

    public boolean rejectStudent(String usn) {
        Student student = findStudentByUsn(usn);
        if (student == null) return false;
        student.setApprovalStatus(ApprovalStatus.REJECTED);
        return true;
    }

    public boolean isApproved(String usn) {
        Student student = findStudentByUsn(usn);
        return student != null &&
                student.getApprovalStatus() == ApprovalStatus.APPROVED;
    }
}
