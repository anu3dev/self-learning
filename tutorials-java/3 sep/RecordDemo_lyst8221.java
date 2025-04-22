// client ->          A -> B -> C -> D
// DTO -> Data Transfer Object / Data Carry Object / Models

// POJO

// rollno, name, subjects, schoolName


import java.util.Objects;

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student(11,"Deb", "Java");
        Student s2 = new Student(11,"Deb", "Java");
        System.out.println(s1.subject());

        System.out.println(s1.equals(s2));

    }
}

record Student(int rollNo, String name, String subject){

}

//
//class Student
//{
//    private int rollNo;
//    private String name;
//    private String subject;
//
//    public Student(int rollNo, String name, String subject) {
//        this.rollNo = rollNo;
//        this.name = name;
//        this.subject = subject;
//    }
//    public int getRollNo() {
//        return rollNo;
//    }
//    public String getName() {
//        return name;
//    }
//    public String getSubject() {
//        return subject;
//    }
//    @Override
//    public String toString() {
//        return "Student{" +
//                "rollNo=" + rollNo +
//                ", name='" + name + '\'' +
//                ", subject='" + subject + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return rollNo == student.rollNo && Objects.equals(name, student.name) && Objects.equals(subject, student.subject);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(rollNo, name, subject);
//    }
//}