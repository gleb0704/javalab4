package core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    //чтение всех строк из файла в массив
    public static String[] readLinesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        return lines.toArray(new String[0]);
    }

    //запись массива строк в файл
    public static void writeLinesToFile(String filePath, String[] lines) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, List.of(lines));
    }
}