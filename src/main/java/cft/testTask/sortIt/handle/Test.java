package cft.testTask.sortIt.handle;

import cft.testTask.sortIt.config.Configuration;
import cft.testTask.sortIt.util.ReadersInitializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {


    private final Configuration configuration;
    private final List<BufferedReader> bufferedReaders;


    public Test(Configuration configuration) throws IOException {
        this.configuration = configuration;
        this.bufferedReaders = ReadersInitializer.getReaders(configuration);
    }

    public void sortTest() throws IOException {

        bufferedReaders.remove(0);
        System.out.println(bufferedReaders.size());
        for (int i = 0; i <= bufferedReaders.size()-1; i++) {
            while (bufferedReaders.get(i).readLine() != null) {
                System.out.println(bufferedReaders.get(i).readLine());
            }
        }
    }
}