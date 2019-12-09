package com.ranthas.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readAllLinesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    @Override
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
