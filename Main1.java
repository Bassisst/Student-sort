package light;

public class Main1 {
    public static void main(String[] args) {
        Group group = new Group();

       
        group.addStudent(new Student("Ivan", "Durov", 20));
        group.addStudent(new Student("Denys", "Marandyok", 21));
        group.addStudent(new Student("Maksym", "Fastow", 19));

        System.out.println("до сортировки:");
        group.showStudents();

        group.sortStudentsByLastName();

        System.out.println("после сортировки:");
        group.showStudents();
    }
}
