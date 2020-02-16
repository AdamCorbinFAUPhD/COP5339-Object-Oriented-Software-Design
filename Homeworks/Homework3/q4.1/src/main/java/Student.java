import java.util.Comparator;
import java.util.Date;

class Student{
    private String name = "";
    private Date whenEnrolled;

    public Student(String name, Date whenEnrolled){
        this.name = name;
        this.whenEnrolled = whenEnrolled;
    }

    /**
     * @return retrieves the name from the student
     * Precondition:None
     * Postcondition: None
     */
    public String getName() {
        return name;
    }

    /**
     * @return retrieves the date when enrolled from the student
     * Precondition:None
     * Postcondition: the date object is cloned so the caller cant not manipulate the internal date
     */
    public Date getWhenEnrolled() {
        //Clone the whenEnrolled object so the date cant be changed
        return (Date) whenEnrolled.clone();
    }

    /**
     * This comparator is used to sort students by their name
     */
    public static Comparator<Student> getCompByName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    /**
     * This comparator is used to sort students by their enroll date
     */
    public static Comparator<Student> getCompByDate = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getWhenEnrolled().compareTo(o2.getWhenEnrolled());
        }
    };
}