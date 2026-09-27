package com.campushub.gui;

import com.campushub.model.ApprovalStatus;
import com.campushub.model.Student;
import com.campushub.service.AuthenticationService;
import com.campushub.service.StudentService;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends Frame {
    private final StudentService studentService = new StudentService();
    private final AuthenticationService authService =
            new AuthenticationService(studentService);

    private final CardLayout cardLayout = new CardLayout();
    private final Panel cards = new Panel(cardLayout);

    public LoginFrame() {
        super("CampusHub");
        setSize(650, 430);
        setLocationRelativeTo(null);

        seedDemoStudent();

        cards.add(homePanel(), "home");
        cards.add(studentLoginPanel(), "studentLogin");
        cards.add(teacherLoginPanel(), "teacherLogin");
        cards.add(studentRegisterPanel(), "register");

        add(cards);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    private Panel homePanel() {
        Panel panel = new Panel(new GridLayout(5, 1, 10, 10));

        panel.add(new Label("CampusHub", Label.CENTER));
        panel.add(new Label(
                "College Management & Communication System", Label.CENTER));

        Button student = new Button("Student Login");
        Button teacher = new Button("Teacher / Staff Login");
        Button register = new Button("Register Student Profile");

        student.addActionListener(e -> cardLayout.show(cards, "studentLogin"));
        teacher.addActionListener(e -> cardLayout.show(cards, "teacherLogin"));
        register.addActionListener(e -> cardLayout.show(cards, "register"));

        panel.add(student);
        panel.add(teacher);
        panel.add(register);

        return panel;
    }

    private Panel studentLoginPanel() {
        Panel panel = new Panel(new GridLayout(4, 2, 8, 8));

        TextField usn = new TextField();
        TextField password = new TextField();
        password.setEchoChar('*');
        Label result = new Label();

        panel.add(new Label("USN"));
        panel.add(usn);
        panel.add(new Label("Password"));
        panel.add(password);

        Button login = new Button("Login");
        Button back = new Button("Back");

        login.addActionListener(e -> {
            if (authService.verifyStudent(usn.getText())) {
                result.setText("Login successful.");
            } else {
                result.setText("Student not found or not approved.");
            }
        });

        back.addActionListener(e -> cardLayout.show(cards, "home"));

        panel.add(login);
        panel.add(back);
        panel.add(result);

        return panel;
    }

    private Panel teacherLoginPanel() {
        Panel panel = new Panel(new GridLayout(6, 2, 8, 8));

        TextField username = new TextField();
        TextField password = new TextField();
        password.setEchoChar('*');
        TextField otp = new TextField();
        Label result = new Label();

        Button verifyPassword = new Button("Verify Password");
        Button verifyOtp = new Button("Verify OTP");
        Button back = new Button("Back");

        verifyPassword.addActionListener(e -> {
            if (authService.verifyTeacherPassword(
                    username.getText(), password.getText())) {

                int generatedOtp = authService.generateOtp();

                System.out.println("CampusHub DEMO OTP: " + generatedOtp);
                result.setText("Password accepted. Check console for OTP.");
            } else {
                result.setText("Invalid teacher credentials.");
            }
        });

        verifyOtp.addActionListener(e -> {
            if (authService.verifyOtp(otp.getText())) {
                result.setText("Teacher verification successful.");
            } else {
                result.setText("Invalid OTP.");
            }
        });

        back.addActionListener(e -> cardLayout.show(cards, "home"));

        panel.add(new Label("Username"));
        panel.add(username);
        panel.add(new Label("Password"));
        panel.add(password);
        panel.add(new Label("OTP"));
        panel.add(otp);
        panel.add(verifyPassword);
        panel.add(verifyOtp);
        panel.add(back);
        panel.add(result);

        return panel;
    }

    private Panel studentRegisterPanel() {
        Panel panel = new Panel(new GridLayout(9, 2, 6, 6));

        TextField usn = new TextField();
        TextField name = new TextField();
        TextField email = new TextField();
        TextField year = new TextField("3");
        TextField section = new TextField("A");

        CheckboxGroup group = new CheckboxGroup();
        Checkbox cse = new Checkbox("CSE", group, true);
        Checkbox ise = new Checkbox("ISE", group, false);
        Checkbox ece = new Checkbox("ECE", group, false);
        Checkbox eee = new Checkbox("EEE", group, false);
        Checkbox aiml = new Checkbox("AI&ML", group, false);

        Panel departments = new Panel(new FlowLayout());
        departments.add(cse);
        departments.add(ise);
        departments.add(ece);
        departments.add(eee);
        departments.add(aiml);

        Button submit = new Button("Submit for Verification");
        Button back = new Button("Back");
        Label result = new Label();

        panel.add(new Label("USN"));
        panel.add(usn);
        panel.add(new Label("Name"));
        panel.add(name);
        panel.add(new Label("Email"));
        panel.add(email);
        panel.add(new Label("Year"));
        panel.add(year);
        panel.add(new Label("Section"));
        panel.add(section);
        panel.add(new Label("Department"));
        panel.add(departments);

        submit.addActionListener(e -> {
            try {
                int id = studentService.getAllStudents().size() + 1;

                Student student = new Student(
                        id,
                        usn.getText().trim(),
                        name.getText().trim(),
                        19,
                        email.getText().trim(),
                        group.getSelectedCheckbox().getLabel(),
                        Integer.parseInt(year.getText().trim()),
                        section.getText().trim()
                );

                studentService.register(student);
                result.setText("Profile submitted: PENDING.");
            } catch (Exception ex) {
                result.setText("Error: " + ex.getMessage());
            }
        });

        back.addActionListener(e -> cardLayout.show(cards, "home"));

        panel.add(submit);
        panel.add(back);
        panel.add(result);

        return panel;
    }

    private void seedDemoStudent() {
        Student student = new Student(
                1,
                "1BM23CS001",
                "Demo Student",
                19,
                "student@college.edu",
                "CSE",
                3,
                "A"
        );

        student.setApprovalStatus(ApprovalStatus.APPROVED);
        studentService.register(student);
    }
}
