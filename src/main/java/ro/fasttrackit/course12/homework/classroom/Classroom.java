package ro.fasttrackit.course12.homework.classroom;

import ro.fasttrackit.course12.homework.student.StudentGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Integer.MIN_VALUE;

public class Classroom {
    private final List<StudentGrade> students;

    public Classroom(List<StudentGrade> students) {
        this.students = new ArrayList<>(students);
    }


    public static void saySomething() {
        System.out.println("Hi from static import");
    }

    public List<Integer> getGradesForDiscipline(String discipline) {
        List<Integer> grades = new ArrayList<>();
        for (StudentGrade student : students) {
            if (student.discipline().equalsIgnoreCase(discipline)) {
                grades.add(student.grade());
            }
        }
        return grades;
    }

    public List<Integer> getGradesForStudent(String name) {
        List<Integer> grades = new ArrayList<>();
        for (StudentGrade student : students) {
            if (student.name().equalsIgnoreCase(name)) {
                grades.add(student.grade());
            }
        }
        return grades;
    }

    public StudentGrade getMaxGrade() {
        StudentGrade result = StudentGrade.builder()
                .grade(MIN_VALUE)
                .build();

        for (StudentGrade student : students) {
            if (student.grade() > result.grade()) {
                result = student;
            }
        }

        return result;
    }

    public Map<String, List<Integer>> getGradesPerDiscipline() {
        Map<String, List<Integer>> gradesPerDiscipline = new TreeMap<>();
        for (StudentGrade student : students) {
            if (!gradesPerDiscipline.containsKey(student.discipline())) {
                List<Integer> grades = getGradesForDiscipline(student.discipline());
                gradesPerDiscipline.put(student.discipline(), grades);
            }
        }
        return gradesPerDiscipline;
    }

    public List<StudentGrade> getStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "students=" + students +
                '}';
    }
}
