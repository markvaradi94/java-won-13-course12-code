package ro.fasttrackit.course12.homework.student;

public record StudentGrade(
        String name,
        String discipline,
        Integer grade
) {

    private StudentGrade(StudentGradeBuilder builder) {
        this(builder.name, builder.discipline, builder.grade);
    }

    public static StudentGradeBuilder builder() {
        return new StudentGradeBuilder();
    }

    public static class StudentGradeBuilder {
        private String name;
        private String discipline;
        private Integer grade;

        public StudentGradeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentGradeBuilder discipline(String discipline) {
            this.discipline = discipline;
            return this;
        }

        public StudentGradeBuilder grade(Integer grade) {
            this.grade = grade;
            return this;
        }

        public StudentGrade build() {
            return new StudentGrade(this);
        }
    }
}
