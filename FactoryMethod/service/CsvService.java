package service;

import reader.Reader;
import reader.ReaderService;

public class CsvService extends ReaderService {

    @Override
    public Reader getReader() {
        return new CsvReader();
    }

}
