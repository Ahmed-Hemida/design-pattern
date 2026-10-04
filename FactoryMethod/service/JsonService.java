package service;

import reader.Reader;
import reader.ReaderService;

public class JsonService extends ReaderService {

    @Override
    public Reader getReader() {
        return new JsonReader();
    }

}
