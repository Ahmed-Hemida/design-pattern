package service;

import reader.Reader;

public class CsvReader  implements Reader {

    @Override
    public String read(String path) {
        return "Reading CSV file from: " + path;
    }

}
