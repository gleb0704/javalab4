package models;

public class InputArgs {
    private String inputFile;
    private String outputFile;

    public InputArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ("-i".equals(args[i]) && i + 1 < args.length) {
                inputFile = args[i + 1];
            } else if ("-o".equals(args[i]) && i + 1 < args.length) {
                outputFile = args[i + 1];
            }
        }
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public boolean isValid() {
        return inputFile != null && !inputFile.trim().isEmpty();
    }
}