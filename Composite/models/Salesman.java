import java.util.List;

public class Salesman implements IPayRoll {

    private double totalSalary;
    List<ILead> leads;
    Salesman(List<ILead> leads) {
        this.leads = leads;
    }

    public double getSalary() {
         totalSalary= 0.0;

        for (ILead lead : leads) {
            totalSalary += lead.getTotalHours() * 100;
        }
        return totalSalary;
    }

}
