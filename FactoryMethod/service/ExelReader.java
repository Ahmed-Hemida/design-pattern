package service;

import reader.Reader;

public class ExelReader implements Reader {

    @Override
    public String read(String path) {
        return "Reading Excel file from: " + path;
    }
}
