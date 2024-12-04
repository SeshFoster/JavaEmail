package org.example;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String departament;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailBoxCapacity = 500;
    private String companySuffix = "aeycompany.com";
    private String alernateEmail;

    // TODO:: Costructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New worker: " + firstName);

        // TODO:: Call a method asking for department - return the department
        this.departament = setDepartament();
        // TODO:: Call a method that returns a random password

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // TODO:: Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departament + "." + companySuffix;
    }

    // Ask for the deparment
    private String setDepartament() {
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if(depChoice == 2) {return "dev";}
        else if(depChoice == 3) {return "acct";}
        else {return ""; }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPORSTUWXZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alernateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    
    public int getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlernateEmail() { return alernateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
