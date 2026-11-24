import java.util.List;

public class accountant  {
    double totalPayable;

    List<IPayRoll> payRolls;

    public accountant(List<IPayRoll> payRolls) {
        this.payRolls = payRolls;
    }

    public double getSalary() {
        totalPayable = 0.0;
        for (IPayRoll payRoll : payRolls) {
            totalPayable += payRoll.getSalary();
        }
        return totalPayable;
    }

}
