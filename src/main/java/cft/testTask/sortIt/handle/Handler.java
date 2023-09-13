package cft.testTask.sortIt.handle;

import cft.testTask.sortIt.config.Configuration;
import cft.testTask.sortIt.util.ReadersInitializer;
import cft.testTask.sortIt.util.WriterInitializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private final Configuration configuration;
    private final List<BufferedReader> bufferedReaders;


    public Handler(Configuration configuration) throws IOException {
        this.configuration = configuration;
        this.bufferedReaders = ReadersInitializer.getReaders(configuration);
    }


    public String getStringFromFile(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public int getNumberFromFile(File file, BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public void sort() throws IOException {

        configuration.getSortMode().compareFunc.apply(3, 7);
        ArrayList<Integer> intFromFiles = new ArrayList<>();
        int lastWrittenValue;
        int fileIndex = 0;
        try(Writer outputWriter = WriterInitializer.createFileAndGetWriter(Path.of(configuration.getOutputFileName()))) {
            for (int i = 0; i <= bufferedReaders.size() - 1; i++) {
                //TODO  что если был импутфайл пустой
                intFromFiles.add(Integer.parseInt(bufferedReaders.get(i).readLine()));
            }

            int writtenToFileValue = intFromFiles.get(0);
            while (!bufferedReaders.isEmpty()) {
                for (int i = 0; i <= bufferedReaders.size() - 1; i++) {
                    if (configuration.getSortMode().compareFunc.apply(intFromFiles.get(i), writtenToFileValue)) {
                        writtenToFileValue = intFromFiles.get(i);
                        lastWrittenValue = intFromFiles.get(i);
                        fileIndex = i;
                    }
                }
                outputWriter.write(writtenToFileValue+ "\n");
                System.out.println("writing " + writtenToFileValue);
                String nextLine = bufferedReaders.get(fileIndex).readLine();
                System.out.println("nextLine: "+nextLine);
                if (nextLine != null) {
                    intFromFiles.set(fileIndex, Integer.parseInt(nextLine));
                    writtenToFileValue = Integer.parseInt(nextLine);
                } else bufferedReaders.remove(fileIndex);
            }
        }        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//        Path path = Path.of(configuration.getOutputFileName());
//        Files.createFile(path);
//        Writer writer = new FileWriter(configuration.getOutputFileName());
//        BufferedWriter bw = new BufferedWriter(writer);
