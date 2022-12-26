package com.hillel.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileService {

    List<File> getFilesPath(Path path) throws IOException;

    List<File> getFileValidPath(List<File> filesPath, List<String> extensions);

    void saveToFile(File file, boolean append, String value) throws IOException;

    String readFromFile(Path path);

    boolean isFileFormat(File file, String ext);

    String getFileName(File file);
}
