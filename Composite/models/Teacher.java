import java.util.List;

public class Teacher implements IPayRoll {
    private double totalSalary;
    List<Student> Students;
    Teacher(List<Student> Students) {
        this.Students = Students;
    }

    public double getSalary() {
         totalSalary= 0.0;

        for (ILead student : Students) {
            totalSalary += student.getTotalHours() * 100;
        }
        return totalSalary;
    }

}
