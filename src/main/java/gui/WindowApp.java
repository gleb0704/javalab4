package gui;

import core.DataProcessor;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Обработка данных (Вариант 2)");

        Label inputLabel = new Label("Входные данные (по одному числу на строку):");

        TextArea inputTextArea = new TextArea();
        inputTextArea.setPrefRowCount(12);
        inputTextArea.setText("3\n1\n3\n7\n7\n5\n9\n9\n15\n12\n10");

        Button processButton = new Button("Запустить");

        Label outputLabel = new Label("Результат:");
        ListView<String> outputListView = new ListView<>();

        processButton.setOnAction(e -> {
            String rawText = inputTextArea.getText();
            String[] inputLines = rawText.split("\\r?\\n");

            String[] resultLines = DataProcessor.processPipeline(inputLines);

            outputListView.getItems().clear();
            outputListView.getItems().addAll(resultLines);
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(
                inputLabel,
                inputTextArea,
                processButton,
                outputLabel,
                outputListView
        );

        Scene scene = new Scene(root, 350, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}