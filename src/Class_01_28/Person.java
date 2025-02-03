package Class_01_28;

public class Person {
    private String name;
    private int age;
    private String email;
    // Default constructor!!!!!!

    public Person() {
    }
    // Parameterized constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // Override toString() for readable output
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
