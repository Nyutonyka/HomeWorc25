package com.hillel;
/*
 * @author Anna Babich
 * @version 1.0.0
 */
import com.hillel.service.ConverterService;
import com.hillel.service.FileService;
import com.hillel.service.impl.FileServiceImpl;
import com.hillel.service.impl.JsonConverterServiceImpl;
import com.hillel.service.impl.YamlConverterServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Run {

    private final static String JSON = "json";
    private final static String YAML = "yaml";

    public static void main(String[] args) throws IOException {

        Path path = Path.of(System.getProperty("user.dir"));
        if (args.length > 0) {
            path = Path.of(args[0]);
        }
        System.out.println(path);

        FileService fs = new FileServiceImpl();
        List<File> filePath = fs.getFilesPath(path);

        List<File> fileValidPath = fs.getFileValidPath(filePath, List.of("json","yaml"));

        ConverterService json = new JsonConverterServiceImpl();
        ConverterService yaml = new YamlConverterServiceImpl();


        File fileDir = new File(path.toString(), "/convert");
        fileDir.mkdir();

        for (File file : fileValidPath) {
            if (fs.isFileFormat(file, YAML)) {
                long startTime = System.nanoTime();
                long yamlSize = Files.size(file.toPath())/1024;
                String str = yaml.convert(fs.readFromFile(file.toPath()));
                File destinationFile = new File(fileDir, fs.getFileName(file) + ".json");
                destinationFile.getName();
                fs.saveToFile(destinationFile, false, str);
                long jsonSize = Files.size(destinationFile.toPath())/1024;
                long duration = (System.nanoTime() - startTime)/1000000;
                String result = "file.yaml -> file.json; " + duration + " mc; old size " +
                        yamlSize + "kb, new size " + jsonSize + "kb\n";
                System.out.println(result);

                fs.saveToFile(new File(path.toString(), "log.txt"), true, result);

            } else if (fs.isFileFormat(file, JSON)) {
                long startTime = System.nanoTime();
                long jsonSize = Files.size(file.toPath())/1024;
                String str = json.convert(fs.readFromFile(file.toPath()));
                File destinationFile = new File(fileDir, fs.getFileName(file) + ".yaml");
                fs.saveToFile(destinationFile, false, str);
                long yamlSize = Files.size(destinationFile.toPath())/1024;
                fs.saveToFile(destinationFile, false, str);
                long duration = (System.nanoTime() - startTime)/1000000;
                String result = "file.json -> file.yaml; " + duration + " mc; old size " +
                        jsonSize + "kb, new size " + yamlSize + "kb\n";
                System.out.println(result);

                fs.saveToFile(new File(path.toString(), "log.txt"), true, result);
            }
        }
    }
}
