import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<StudentObj> roster = new ArrayList<StudentObj>();

        // Load data
        StudentObj s1 = new StudentObj("Alice", 101);
        s1.add(85); s1.add(90); s1.add(78);
        roster.add(s1);

        StudentObj s2 = new StudentObj("Bob", 102);
        s2.add(92); s2.add(88); s2.add(95);
        roster.add(s2);

        StudentObj s3 = new StudentObj("Charlie", 103);
        s3.add(70); s3.add(60); s3.add(65);
        roster.add(s3);

        // Processing every student's grade
        System.out.println("Processing...");
        for(int i = 0; i < roster.size(); i++) {
            StudentObj temp = roster.get(i);
            double avgGrade = temp.getAvgGrade();
            String letterGrade = "";
            if (avgGrade >= 90) letterGrade = "A";
            else if (avgGrade >= 80) letterGrade = "B";
            else if (avgGrade >= 70) letterGrade = "C";
            else if (avgGrade >= 60) letterGrade = "D";
            else letterGrade = "F";

            // Printing out data
            System.out.println("ID: " + temp.id + " | Name: " + temp.name + " | Avg: "
                    + avgGrade + " | Grade: " + letterGrade);
        }

        // Find student with highest grade
        double bestGrade = -1;
        String bestName = "";
        for (StudentObj i : roster) {
            if (i.getAvgGrade() > bestGrade) {
                bestGrade = i.getAvgGrade();
                bestName = i.name;
            }
        }
        System.out.println("Top: " + bestName + " with " + bestGrade);

        // Finding failing students
        System.out.println("Needs Help:");
        for(StudentObj z : roster) {
            if(z.getAvgGrade() < 70) {
                System.out.println(z.name);
            }
        }
    }
}