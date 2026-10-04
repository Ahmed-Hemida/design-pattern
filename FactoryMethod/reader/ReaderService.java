package reader;
public abstract class ReaderService {

    public String readData(String path) {
        Reader reader = getReader();
        System.out.println("Using reader: " + reader.getClass().getSimpleName());
        System.out.println("Reading data from: " + path);
        System.out.println("Data read successfully...");
        return reader.read(path);
    }

    protected abstract Reader getReader();

}
