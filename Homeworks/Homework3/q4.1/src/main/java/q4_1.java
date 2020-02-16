import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class q4_1 {

    public static void main(String[] args) {
        Student s1 = new Student("Adam", new Date(2100, Calendar.JANUARY,1));
        Student s2 = new Student("Nicola", new Date(2010,Calendar.JANUARY,1));
        Student s3 = new Student("Soleil", new Date(2010,Calendar.FEBRUARY,1));
        Student s4 = new Student("Weston", new Date(2020,Calendar.JANUARY,1));
        ArrayList<Student> list = new ArrayList<>();
        list.add(s4);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.sort(Student.getCompByName);
        System.out.println("Sorted list by name");
        for(Student s : list){
            System.out.println(s.getName() + " " + s.getWhenEnrolled().toString() + " year:" + s.getWhenEnrolled().getYear());

        }

        System.out.println("");
        list.sort(Student.getCompByDate);
        System.out.println("Sorted list by Date");
        for(Student s : list){
            System.out.println(s.getName() + " " + s.getWhenEnrolled().toString() + " year:" + s.getWhenEnrolled().getYear());

        }

    }
}
