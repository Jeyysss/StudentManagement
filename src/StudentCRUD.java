import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentCRUD {
    private Connection con;
    private Scanner sc;

    public StudentCRUD() {
        con = DbConnection.getConnection();
        sc = new Scanner(System.in);
    }

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, course);

            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // View Students
    public void viewStudents() {
        try {
            String query = "SELECT * FROM students";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Age: " + rs.getInt("age") +
                        " | Course: " + rs.getString("course"));
            }
        } catch (Exception e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }

    // Update Student
    public void updateStudent() {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new Course: ");
            String course = sc.nextLine();

            String query = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated successfully!");
            } else {
                System.out.println("❌ Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student deleted successfully!");
            } else {
                System.out.println("❌ Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
