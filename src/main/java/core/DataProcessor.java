package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataProcessor {

    /**
     * ВАРИАНТ 2: Возвращает числа, которые остаются на своих местах
     * при сортировке исходного списка по возрастанию.
     */
    public static List<Integer> processVariant2(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            return result;
        }

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        // сравниваем элементы
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(sortedList.get(i))) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    public static String[] processPipeline(String[] inputLines) {
        List<Integer> numbers = new ArrayList<>();
        int errorCount = 0;

        for (int i = 0; i < inputLines.length; i++) {
            String line = inputLines[i].trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                numbers.add(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                errorCount++;
                System.err.printf("Ошибка формата в строке %d: '%s' (пропущено)%n", i + 1, line);
            }
        }

        if (errorCount > 0) {
            System.err.printf("Всего пропущено некорректных строк: %d%n", errorCount);
        }

        // бизнес-логика
        List<Integer> processedData = processVariant2(numbers);

        String[] resultLines = new String[processedData.size()];
        for (int i = 0; i < processedData.size(); i++) {
            resultLines[i] = String.valueOf(processedData.get(i));
        }

        return resultLines;
    }
}