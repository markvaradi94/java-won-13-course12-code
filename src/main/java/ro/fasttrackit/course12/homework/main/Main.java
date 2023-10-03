package ro.fasttrackit.course12.homework.main;

import ro.fasttrackit.course12.homework.classroom.Classroom;
import ro.fasttrackit.course12.homework.student.StudentGrade;
import ro.fasttrackit.course12.homework.student.StudentReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        StudentGrade studentGrade = StudentGrade.builder()
//                .name("Marius")
//                .discipline("Physics")
//                .grade(8)
//                .build();
//
//        System.out.println(studentGrade);

        StudentReader reader = new StudentReader("files/grades.txt");
        List<StudentGrade> students = reader.readStudents();
//        for (StudentGrade studentGrade : reader.readStudents()) {
//            System.out.println(studentGrade);
//        }

        Classroom classroom = new Classroom(students);
        List<StudentGrade> classList = classroom.getStudents();
        classList.add(new StudentGrade("Test", "Test", 20));
        students.add(new StudentGrade("Test", "Test", 20));

        System.out.println(classroom.getGradesForDiscipline("mathematics"));
        System.out.println(classroom.getGradesForStudent("dulf Siguror"));
        System.out.println(classroom.getMaxGrade());
        System.out.println(classroom.getGradesPerDiscipline());
    }
}
