import java.util.List;

public class CompositeDesignPattern {

    public static void main(String[] args) {

        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);

        Father father1 = new Father().setChileds(List.of(student1, student2));
        Father father2 = new Father().setChileds(List.of(student3));

        Salesman salesman = new Salesman(List.of(father1, father2, student4));
        Teacher teacher1 = new Teacher(List.of(student5, student6));
        Teacher teacher2 = new Teacher(List.of(student1, student2, student3));

        accountant accountant = new accountant(List.of(salesman, teacher1, teacher2
            
        ));

        // System.out.println("Total Salary: " + salesman.getSalary());
        System.out.println("Total Payable: " + accountant.getSalary());
    }

}
