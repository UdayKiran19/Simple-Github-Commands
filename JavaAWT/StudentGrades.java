import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    public static void main(String[] args) {
        // Creating a HashMap to store student names and their grades
        Map<String, Integer> studentGrades = new HashMap<>();

        // Adding entries to the map
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("David", 90);

        // Displaying the map
        System.out.println("Student Grades: " + studentGrades);

        // Retrieving a student's grade
        String studentName = "Bob";
        if (studentGrades.containsKey(studentName)) {
            System.out.println(studentName + "'s grade: " + studentGrades.get(studentName));
        } else {
            System.out.println(studentName + " is not in the grade list.");
        }

        // Removing a student from the map
        studentGrades.remove("Charlie");
        System.out.println("Student Grades after removing Charlie: " + studentGrades);

        // Iterating over the map entries
        System.out.println("All students and their grades:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
    }
}
