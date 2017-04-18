package com.jetbrains;

// Lab Seven, GC Java Bootcamp. Lydia Latocki

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class LabSeven_Arrays {
    private static Scanner scnr = new Scanner(System.in);

    // list student data for in separate arrays
    private static String[] stFirstName = {"BONNIE", "CLYDE", "HENRY", "EDWARD", "BOZO"};
    private static String[] stLastName  = {"PARKER", "BARROW", "JEKYLL", "HYDE", "CLOWN"};
    private static int[]    age         = { 38, 45, 58, 58, 22};
    private static String[] course      = { "Java Bootcamp", ".Net Bootcamp", "Front-End Bootcamp", "Java Bootcamp", ".Net Bootcamp"};
    private static String[] dish        = { "Cranberry Scone", "Roast Duck", "Yorkshire Pudding", "Cream Tea", "Ice Cream"};


    public static void main(String[] args) {

        // prompt user to enter name of student searched
        System.out.println("What is the first name of the student you would like to learn about?");
        String nameInput = scnr.nextLine();
        String nameInUpCase = nameInput.toUpperCase();

        who(nameInUpCase);
    }

    public static void who(String nameInUpCase){  // use this method to check if student is in that course
        int foundWho = 0; // index in the first name array
        for (int i = 0; i < stFirstName.length; i++) {
            if (stFirstName[i].equals(nameInUpCase)){

                System.out.printf("You must be looking for our Student named %-6s %s\n", stFirstName[i], stLastName[i]);
                foundWho = i;
                break;
            }
            else {
                System.out.println("We have not student by that name.");// Item from firstNameSearch does not exist in stFirstName
            }
        }

        String more = "";

        boolean doAgain; // check to continue searching other variables of students in class

        do {
                try {
                    System.out.println("Would you like to learn about " + nameInUpCase + "?"); // return to verify this is the student to be checked
                } catch (InputMismatchException e) {
                    System.out.print("There is no student with that name in this class.");// return to say no student found
                }
                System.out.println("Continue? (y/n)"); // user continue another variable of verified student
                char userChar = scnr.nextLine().charAt(0);

                if (userChar == 'Y' || userChar == 'y') { // if continue, run this
                    System.out.println("Enter one of the following inputs to learn about " +  nameInUpCase + ":" +
                            "\nAGE \nCOURSE \nPOTLUCK"); //more statement
                    more = scnr.nextLine();

                    switch (more) { // take the new variable and run through these cases

                        case "COURSE": // must be a string literal that matches what user has typed in
                            //course[foundWho];
                            System.out.println(course[foundWho]);
                            break;
                        case "AGE":
                            //age[foundWho];
                            System.out.println(age[foundWho]);
                            break;
                        case "POTLUCK":
                            //dish[foundWho];
                            System.out.println(dish[foundWho]);
                        break;
                        default:
                            System.out.println("Sorry, cannot complete this request. Goodbye."); // return when none existent variable is being checked
                            break;
                    }
                    doAgain = true;
                }
                else {
                    doAgain = false;
                    System.out.println("Goodbye.");
                }
        }
        while (doAgain);// tell method what to run
    }
}