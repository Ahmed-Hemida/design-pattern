public class Student implements ILead {
    private double totalHours;

    public Student(double totalHours) {
        this.totalHours = totalHours;
    }

    @Override
    public double getTotalHours() {
        return totalHours;
    }

}
