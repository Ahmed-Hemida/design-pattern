import java.util.List;

public class Father implements ILead {
    private double totalHours;
    List<Student> students;


    public Father setChileds(List<Student> students) {
        this.students = students;
        return this ;
    }


    
    @Override
    public double getTotalHours() {
        totalHours = 0.0;
        for (Student student : students) {
            totalHours += student.getTotalHours();
        }
        return totalHours;
    }

}
