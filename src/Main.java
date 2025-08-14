import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCRUD crud = new StudentCRUD();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> crud.addStudent();
                case 2 -> crud.viewStudents();
                case 3 -> crud.updateStudent();
                case 4 -> crud.deleteStudent();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
