import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentHomeworkApp {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader file = new FileReader(args[0]);
        Scanner input = new Scanner(file);
        ArrayList<Student> sRecord = new ArrayList<>();
        ArrayList<Homework> hwRecord = new ArrayList<>();

        while (input.hasNext()) {
            String[] data = input.next().split(":");
            // Check student
            boolean same = false;
            for (Student s : sRecord) {
                if (s.isSame(data[0])) {
                    s.hRecord.add(new Homework(data[1], data[2]));
                    same = true;
                    break;
                }
            }
            if (!same) {
                sRecord.add(new Student(data[0], data[1], data[2]));
            }
            // End check            

            // Check homework
            boolean already = false;
            for (Homework h : hwRecord) {
                if (h.isAlready(data[1])) {
                    already = true;
                    break;
                }
            }
            if (!already) {
                hwRecord.add(new Homework(data[1]));
            }
            // End check
        }
        // Print score table
        System.out.print("          ");
        for (Homework h : hwRecord) {
            System.out.print(h);
        }
        System.out.println("");
        // End print scorc table

        // Print each student detail
        for (Student s : sRecord) {
            System.out.print(s + " ");
            for (Homework hw : hwRecord) {
                if(s.isSubmit(hw.getHomewrk())){
                    s.printSubmitScore(hw.getHomewrk());
                } else {
                    System.out.print(" " + hw.getScore() +" ");
                }
            }
            System.out.println("");
        }
        // End print student detail
    }
}
