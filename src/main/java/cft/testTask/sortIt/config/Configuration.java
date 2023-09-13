package cft.testTask.sortIt.config;

import java.util.ArrayList;
import java.util.List;

public class Configuration {

    private final SortMode sortMode;
    private final FileContentType fileContentType;
    private final String outputFileNames;
    private final List<String> inputFileNames = new ArrayList<>();

    public Configuration(String[] args) {
        if (args.length == 3) {
            this.sortMode = SortMode.ASC;
            this.fileContentType = FileContentType.getFileContentType(args[0]);
            this.outputFileNames = args[1];
            //this.inputFileNames = List.of(args[2].split(" "));
        } else if (args.length >= 4) {
            this.sortMode = SortMode.getSortModeByCode(args[0]);
            this.fileContentType = FileContentType.getFileContentType(args[1]);
            this.outputFileNames = args[2];
            for(int i=3;i<=args.length-1;i++) {
                this.inputFileNames.add(args[i]);
            }
        } else {
            throw new RuntimeException("wrong number of params expected 3 or 4, got " + args.length);
        }
    }

    public List<String> getInputFileNames() {
        return inputFileNames;
    }

    public String getOutputFileName() {
        return outputFileNames;
    }

    public FileContentType getFileContentType() {
        return fileContentType;
    }

    public SortMode getSortMode() {
        return sortMode;
    }
}
