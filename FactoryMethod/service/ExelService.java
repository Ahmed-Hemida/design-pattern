package service;

import reader.Reader;
import reader.ReaderService;

public class ExelService extends ReaderService {

    @Override
    protected Reader getReader() {
        return new ExelReader();
    }

}
