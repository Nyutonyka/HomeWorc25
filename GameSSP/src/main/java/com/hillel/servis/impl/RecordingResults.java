package com.hillel.servis.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecordingResults {

    public String fileNameGenerator(String name) throws IOException {
        String fileName = "result_" + name.toLowerCase(Locale.ROOT) + "_" +
                new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ".txt";

        Path currentRelativePath = Paths.get("GameSSP/src/main/java/com/hillel/fileResult/");
        String s = currentRelativePath.toAbsolutePath().toString();

        File file = new File(s, File.separator.concat(fileName));

        if(!file.exists()){
            file.createNewFile();
        } else {
            String newName = file.getName().split("\\.")[0] + "_1." + file.getName().split("\\.")[1];
            new File(s, newName).createNewFile();
            return s + File.separator.concat(newName);
        }
        return s + File.separator.concat(fileName);
    }
}
