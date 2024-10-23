package dark;

import java.util.Scanner;

public class StudentCreator {
    private Scanner scanner = new Scanner(System.in);

    
    private String inputName() {
        System.out.print("Enter student's first name: ");
        return scanner.nextLine();
    }

    
    private String inputLastName() {
        System.out.print("Enter student's last name: ");
        return scanner.nextLine();
    }

    
    private Human.Gender inputGender() {
        while (true) {
            System.out.print("Enter student's gender (MALE/FEMALE): ");
            String genderInput = scanner.nextLine().trim().toUpperCase();
            if (genderInput.equals("MALE")) {
                return Human.Gender.MALE;
            } else if (genderInput.equals("FEMALE")) {
                return Human.Gender.FEMALE;
            } else {
                System.out.println("Invalid input. Please enter MALE or FEMALE.");
            }
        }
    }

    
    private int inputID() {
        System.out.print("Enter student's ID number: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid ID number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    
    private String inputGroupName() {
        System.out.print("Enter student's group name: ");
        scanner.nextLine();  
        return scanner.nextLine();
    }

   
    public Student createStudent() {
        String firstName = inputName();
        String lastName = inputLastName();
        Human.Gender gender = inputGender();
        int id = inputID();
        String groupName = inputGroupName();
        
        return new Student(firstName, lastName, gender, id, groupName);
    }
}
