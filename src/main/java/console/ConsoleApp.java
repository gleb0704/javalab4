package console;

import core.DataProcessor;
import core.FileUtils;
import models.InputArgs;

public class ConsoleApp {
    public static void main(String[] args) {

        InputArgs inputArgs = new InputArgs(args);

        if (!inputArgs.isValid()) {
            System.out.println("Ошибка: Не указан входной файл.");
            System.out.println("");
            return;
        }

        try {
            String[] inputLines = FileUtils.readLinesFromFile(inputArgs.getInputFile());
            System.out.println("Данные прочитаны. Количество строк: " + inputLines.length);

            String[] resultLines = DataProcessor.processPipeline(inputLines);

            if (inputArgs.getOutputFile() != null) {
                FileUtils.writeLinesToFile(inputArgs.getOutputFile(), resultLines);
                System.out.println("Результат сохранен в файл: " + inputArgs.getOutputFile());
            } else {
                System.out.println("Результат обработки");
                for (String line : resultLines) {
                    System.out.println(line);
                }
                System.out.println("");
            }

        } catch (Exception e) {
            System.err.println("Произошла критическая ошибка: " + e.getMessage());
        }
    }
}
