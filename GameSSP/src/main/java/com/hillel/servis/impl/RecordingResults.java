package com.hillel.servis.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class RecordingResults {

    public String fileNameGenerator(String name) throws IOException {
        String fileName = "result_" + name.toLowerCase(Locale.ROOT) + "_"  + ".txt";

        Path currentRelativePath = Paths.get("GameSSP/src/main/java/com/hillel/fileResult/");
        String s = currentRelativePath.toAbsolutePath().toString();

        File file = new File(s, File.separator.concat(fileName));

        if(!file.exists()){
            file.createNewFile();
        }
        return s + File.separator.concat(fileName);
    }

    public void appendToFile(File file, String content)
            throws IOException {

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }
    }
}
