package ro.fasttrackit.course12.employees;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;

public class EmployeeReportGenerator {
    private final List<Employee> employees;

    public EmployeeReportGenerator(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    public Map<JobType, List<Employee>> groupByJobType() {
        Map<JobType, List<Employee>> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            List<Employee> employeeList = employeeMap.get(employee.jobType());
            if (employeeList == null) {
                List<Employee> list = new ArrayList<>();
                list.add(employee);
                employeeMap.put(employee.jobType(), list);
            } else {
                employeeList.add(employee);
            }
        }

        return employeeMap;
    }

    public Map<JobType, String> highestPaidByJobType() {
        Map<JobType, List<Employee>> employeeMap = groupByJobType();
        Set<JobType> jobTypes = employeeMap.keySet();
        Map<JobType, String> result = new HashMap<>();
        for (JobType jobType : jobTypes) {
            Employee highestPaidForJobType = getHighestPaidForJobType(jobType);
            result.put(jobType, employeeNameAndSalary(highestPaidForJobType));
        }

        return result;
    }

    public Map<JobType, String> totalSalariesByJobType() {
        Map<JobType, List<Employee>> employeeMap = groupByJobType();
        Set<JobType> jobTypes = employeeMap.keySet();
        Map<JobType, String> result = new HashMap<>();

        for (JobType jobType : jobTypes) {
            Integer total = totalSalaryForJobType(jobType);
            result.put(jobType, "Total salary for %s positions: %s".formatted(jobType.name(), total));
        }

        return result;
    }

    private Integer totalSalaryForJobType(JobType jobType) {
        Map<JobType, List<Employee>> employeeMap = groupByJobType();
        List<Employee> departmentEmployees = employeeMap.get(jobType);
        int sum = 0;
        for (Employee employee : departmentEmployees) {
            sum += employee.salary();
        }

        return sum;
    }

    private String employeeNameAndSalary(Employee highestPaidForJobType) {
        return "%s %s - %s".formatted(highestPaidForJobType.firstName(), highestPaidForJobType.lastName(), highestPaidForJobType.salary());
    }

    private Employee getHighestPaidForJobType(JobType jobType) {
        Map<JobType, List<Employee>> employeeMap = groupByJobType();
        List<Employee> departmentEmployees = employeeMap.get(jobType);
        Employee highestPaid = new Employee(null, null, null, null, MIN_VALUE, null);
        for (Employee departmentEmployee : departmentEmployees) {
            if (departmentEmployee.salary() > highestPaid.salary()) {
                highestPaid = departmentEmployee;
            }
        }

        return highestPaid;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
