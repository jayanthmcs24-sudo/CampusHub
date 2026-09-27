package com.campushub.service;

import java.util.Random;

public class AuthenticationService {
    private static final String TEACHER_USERNAME = "teacher";
    private static final String TEACHER_PASSWORD = "CampusHub@123";

    private final StudentService studentService;
    private final Random random = new Random();
    private int currentOtp;

    public AuthenticationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public boolean verifyTeacherPassword(String username, String password) {
        return TEACHER_USERNAME.equals(username)
                && TEACHER_PASSWORD.equals(password);
    }

    public int generateOtp() {
        currentOtp = 100000 + random.nextInt(900000);
        return currentOtp;
    }

    public boolean verifyOtp(String otp) {
        try {
            return Integer.parseInt(otp) == currentOtp;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean verifyStudent(String usn) {
        return studentService.isApproved(usn);
    }
}
