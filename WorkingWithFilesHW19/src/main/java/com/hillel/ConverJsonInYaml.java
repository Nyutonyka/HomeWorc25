package com.hillel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ConverJsonInYaml implements FileFormatConversion{

    @Override
    public List<String> getFilePath(Path path) throws IOException{
        return List.of(path.toFile().list());
    }

    @Override
    public List<String> getFileValidPath(List<String> filesPath) {
        List<String> fileValidPath = null;
        for (String s : filesPath){
            if(!s.endsWith(".yaml")){
                fileValidPath = new ArrayList<>(Collections.singleton(s));
            }
        }
        return fileValidPath;
    }

    @Override
    public long fileConvert(Path path)throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map[] obj =  mapper.readValue(new File(String.valueOf(path)), Map[].class);
        //System.out.println(obj);
        Yaml yaml = new Yaml();
        String t = yaml.dump(obj);
       // System.out.println(t);
        String s =  Paths.get("").toAbsolutePath().toString();
        String fileName = "src/main/java/com/hillel/convertet/User_Data.yaml";
        File file = new File(s, File.separator.concat(fileName));

        OutputStream outputStream =
                new FileOutputStream(file, false);
        outputStream.write(t.getBytes(StandardCharsets.UTF_8));
        long size = file.length();
        return size;
    }

    @Override
    public String saveResult(String content) throws IOException{
        String s =  Paths.get("").toAbsolutePath().toString();
        String fileName = "result.log";
        File file = new File(s, File.separator.concat(fileName));

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileOutputStream fos = new FileOutputStream(file, true);
        fos.write(content.getBytes(StandardCharsets.UTF_8));
       return content;
    }
}
