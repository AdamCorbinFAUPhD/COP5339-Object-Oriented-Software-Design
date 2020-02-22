import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

class Student {
    private String name = "";
    private Date whenEnrolled;

    /*@invariant name will not change after object creation*/
    /*@invariant whenEnrolled date will not change after object creation*/

    /**
     * @param name         - String name of the student
     * @param whenEnrolled - Date object of when the student was enrolled
     */
    public Student(String name, Date whenEnrolled) {
        this.name = name;
        this.whenEnrolled = whenEnrolled;
    }

    /**
     * @return retrieves the name from the student
     * @Precondition: None
     * @Postcondition: Returns back the students name
     */
    public String getName() {
        return name;
    }

    /**
     * @return retrieves the date when enrolled from the student
     * @Precondition: None
     * @Postcondition: the date object is cloned so the caller cant not manipulate the internal date
     */
    public Date getWhenEnrolled() {
        //Clone the whenEnrolled object so the date cant be changed
        return (Date) whenEnrolled.clone();
    }

    /**
     * This comparator is used to sort students by their name
     */
    public static Comparator<Student> getCompByName() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    /**
     * This comparator is used to sort students by their enroll date
     */
    public static Comparator<Student> getCompByDate() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getWhenEnrolled().compareTo(o2.getWhenEnrolled());
            }
        };
    }

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
        list.sort(Student.getCompByName());
        System.out.println("Sorted list by name");
        for(Student s : list){
            System.out.println(s.getName() + " " + s.getWhenEnrolled().toString() + " year:" + s.getWhenEnrolled().getYear());
        }

        System.out.println("");
        list.sort(Student.getCompByDate());
        System.out.println("Sorted list by Date");
        for(Student s : list){
            System.out.println(s.getName() + " " + s.getWhenEnrolled().toString() + " year:" + s.getWhenEnrolled().getYear());
        }
    }
}