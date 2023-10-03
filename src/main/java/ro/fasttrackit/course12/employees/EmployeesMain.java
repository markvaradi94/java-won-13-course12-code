package ro.fasttrackit.course12.employees;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static ro.fasttrackit.course12.employees.JobType.FRONTEND;

public class EmployeesMain {
    public static void main(String[] args) throws IOException {
        EmployeeReader reader = new EmployeeReader("files/input/employees.txt");
        List<Employee> employees = reader.readEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        EmployeeReportGenerator reportGenerator = new EmployeeReportGenerator(employees);
        Map<JobType, List<Employee>> jobTypeMap = reportGenerator.groupByJobType();

        for (Map.Entry<JobType, List<Employee>> entry : jobTypeMap.entrySet()) {
            System.out.println(entry);
        }

        // for each job type, return the employee name and salary for the highest earning employee
        // Map<JobType, String>  --> Frontend = Lucas Lopes - 89000

//        System.out.println(reportGenerator.getHighestPaidForJobType(FRONTEND));


        // Map<JobType, String> ---> Frontend = Total salary for frontend positions: 500000

        System.out.println("==========================================================");
        Map<JobType, String> jobTypeStringMap = reportGenerator.highestPaidByJobType();
        for (Map.Entry<JobType, String> entry : jobTypeStringMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("==========================================================");
        Map<JobType, String> totalSalariesByJobType = reportGenerator.totalSalariesByJobType();
        for (Map.Entry<JobType, String> entry : totalSalariesByJobType.entrySet()) {
            System.out.println(entry);
        }
    }
}
