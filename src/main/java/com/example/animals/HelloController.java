package com.example.animals;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {

    @FXML
    TextField fileName;

    @FXML
    HBox animalsBox;
    @FXML
    TextArea txtLines;
    @FXML
    Button start;

    public void loadText()
    {
        TextField txtFileName;
        String fname = fileName.getText();
        txtLines.clear();
        animalsBox.getChildren().clear();

        try {
            List<String> lines = Files.readAllLines(Path.of(fname), StandardCharsets.UTF_8);
            for (String str : lines) {
                txtLines.setText(txtLines.getText()+ "\n" + str);
                String[]mas=str.split(" ");

                Button animalButton = new Button(str);
                animalsBox.getChildren().add(animalButton);
                animalButton.setOnAction(actionEvent -> {
                    txtLines.setText(mas[1]);
                });
                

            }

        }
        catch(IOException e)
            {
                txtLines.setText("Файл не открылся!");
            }

            }
}