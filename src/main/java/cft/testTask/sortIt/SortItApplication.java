package cft.testTask.sortIt;

import cft.testTask.sortIt.config.Configuration;
import cft.testTask.sortIt.handle.Handler;
import cft.testTask.sortIt.handle.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;

public class SortItApplication {

    public static void main(String[] args) throws IOException {


        System.out.println("jar started");
        Configuration configuration = new Configuration(args);
//        Path path = Path.of(configuration.getOutputFileName());
//        Files.createFile(path);
//        try (Writer writer = new FileWriter(configuration.getOutputFileName())) {
//
//            //writer.write("hello");
//            BufferedWriter bw = new BufferedWriter(writer);
//            bw.write("hello");
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }

        Handler handler = new Handler(configuration);
        handler.sort();
        ArrayList<Integer> arry = new ArrayList<Integer>();


        HashSet h = new HashSet();
        h.add(' ');
        System.out.println(h.add("kva"));
    }

}
