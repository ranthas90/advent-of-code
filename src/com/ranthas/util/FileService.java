package com.ranthas.util;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<String> readAllLinesFromFile(String filePath) throws IOException;

    String readFile(String filePath) throws IOException;
}
