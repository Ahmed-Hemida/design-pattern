package service;

import reader.Reader;

public class JsonReader  implements Reader {

    @Override
    public String read(String path) {
        return "Reading JSON file from: " + path;
    }

}
