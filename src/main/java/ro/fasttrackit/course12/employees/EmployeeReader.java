package ro.fasttrackit.course12.employees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Path.of;

public class EmployeeReader {
    private final String inputFile;

    public EmployeeReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<Employee> readEmployees() throws IOException {
        Scanner scanner = new Scanner(of(inputFile));
        List<Employee> employees = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            employees.add(buildEmployee(line));
        }

        return employees;
    }

    private Employee buildEmployee(String line) {
        String[] tokens = line.split("[|]");
        return new Employee(tokens[0],
                tokens[1],
                Integer.parseInt(tokens[2]),
                tokens[3],
                Integer.parseInt(tokens[4]),
                JobType.fromCode(tokens[5])
        );
    }

    public String getInputFile() {
        return inputFile;
    }
}
