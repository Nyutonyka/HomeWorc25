package com.hillel.servis.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Locale;

public class RecordingResults {

    public String fileNameGenerator(String name){

        String s =  Paths.get("").toAbsolutePath().toString();
        String fileName = "result_" + name.toLowerCase(Locale.ROOT) + "_"  + ".txt";
        File file = new File(s, File.separator.concat(fileName));

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return s + File.separator.concat(fileName);
    }

    public void appendToFile(File file, String content){
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
