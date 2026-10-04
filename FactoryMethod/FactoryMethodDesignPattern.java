
import reader.ReaderService;
import service.CsvService;
import service.ExelService;
import service.JsonService;

public class FactoryMethodDesignPattern {
    public static void main(String[] args) {
        
         ReaderService  ExelService = new ExelService();
        ExelService.readData("path/to/excel/file.xlsx");
       
        System.err.println("-----------------------------");
        ReaderService csvService = new CsvService();
        csvService.readData("path/to/csv/file.csv");

        System.err.println("-----------------------------");

        ReaderService jsonService = new JsonService();
        jsonService.readData("path/to/json/file.json");
    }

}
