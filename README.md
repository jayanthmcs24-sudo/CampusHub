# CampusHub

A Java 21 + AWT college management and communication system.

## Features
- Student login
- Teacher/staff login
- Teacher password + simulated OTP verification
- Student profile registration
- Staff approval workflow: PENDING / APPROVED / REJECTED
- Department selection using AWT CheckboxGroup
- Student, staff, club and library management
- Announcements
- Reusable lobbies
- Private messages
- Java Collections and service-layer design

## Demo teacher login
Username: `teacher`
Password: `CampusHub@123`

After the password is accepted, the demo OTP is printed in the IntelliJ Run/Terminal console.

## Important
This is a learning MVP. The OTP is simulated and credentials are demo credentials. Production authentication should use password hashing, secure credential storage and a real OTP provider.

## Run
Use Java 21 and run:

`com.campushub.Main`
