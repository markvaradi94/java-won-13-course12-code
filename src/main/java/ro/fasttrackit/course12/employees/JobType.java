package ro.fasttrackit.course12.employees;

public enum JobType {
    DEVELOPMENT("DEV"),
    DATA_SCIENCE("DATA"),
    ADMINISTRATION("ADMIN"),
    FRONTEND("UI"),
    TESTING("TEST"),
    HUMAN_RESOURCES("HR");

    private final String jobCode;

    JobType(String jobCode) {
        this.jobCode = jobCode;
    }

    public static JobType fromCode(String jobCode) {
        if (jobCode == null) {
            return null;
        }

        for (JobType jobType : JobType.values()) {
            if (jobType.getJobCode().equalsIgnoreCase(jobCode)) {
                return jobType;
            }
        }

        return null;
    }

    public String getJobCode() {
        return jobCode;
    }
}
