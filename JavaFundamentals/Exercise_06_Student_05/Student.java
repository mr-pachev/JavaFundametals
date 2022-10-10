package Exercise_06_Student_05;

public class Student {
    String firstName;
    String larstName;
    double grade;

    public Student(String firstName, String larstName, double grade) {
        this.firstName = firstName;
        this.larstName = larstName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLarstName() {
        return larstName;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, larstName, grade);
    }
}
