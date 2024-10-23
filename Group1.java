package dark;

import java.util.Arrays;
import java.util.Comparator;

public class Group1 {
    private String groupName;
    private Student[] students = new Student[10];
    private int studentCount = 0;

    public Group1(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Group: " + groupName + "\n");
        for (Student student : students) {
            if (student != null) {
                sb.append(student).append("\n");
            }
        }
        return sb.toString();
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                studentCount++;
                return;
            }
        }
        throw new GroupOverflowException("Cannot add student. Group is full.");
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if (student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with last name " + lastName + " not found.");
    }

    public boolean removeStudentByID(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
                studentCount--;
                return true;
            }
        }
        return false;
    }


    public void sortStudentsByLastName() {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return 1;
                }
                if (s2 == null) {
                    return -1;
                }
                return s1.getLastName().compareToIgnoreCase(s2.getLastName());
            }
        });
    }
}

