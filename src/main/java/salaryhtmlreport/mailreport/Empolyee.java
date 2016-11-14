package salaryhtmlreport.mailreport;

public class Empolyee {
    private final String name;
    private final double salary;

    public Empolyee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
