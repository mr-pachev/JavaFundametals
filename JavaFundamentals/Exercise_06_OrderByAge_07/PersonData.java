package Exercise_06_OrderByAge_07;

public class PersonData {
    String firstName;
    String id;
    int age;

    public PersonData(String firstName, String id, int age) {
        this.firstName = firstName;
        this.id = id;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.firstName, this.id, this.age);
    }
}
