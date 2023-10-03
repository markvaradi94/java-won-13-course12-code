package ro.fasttrackit.course12.homework.student;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader {
    private final String inputFile;

    public StudentReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<StudentGrade> readStudents() throws IOException {
        Scanner scanner = new Scanner(Path.of(inputFile));
        List<StudentGrade> students = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            students.add(buildStudentGrade(line));
        }

        return students;
    }

    private StudentGrade buildStudentGrade(String line) {
        String[] tokens = line.split("[|]");
        return StudentGrade.builder()
                .name(tokens[0])
                .discipline(tokens[1])
                .grade(Integer.parseInt(tokens[2]))
                .build();
    }

    public String getInputFile() {
        return inputFile;
    }
}
