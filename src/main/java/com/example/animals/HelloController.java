package com.example.animals;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

    Model model = new Model();

    public void loadText()
    {
        TextField txtFileName;
        String fname = fileName.getText();
        txtLines.clear();
        animalsBox.getChildren().clear();

        try {
            List<String> lines = Files.readAllLines(Path.of(fname), StandardCharsets.UTF_8);
            model.loadAnimals(lines);

            for (Animals beast : model.animals) {
                makeButtons(beast);
            }

        }
        catch(IOException e)
            {
                txtLines.setText("Файл не открылся!");
            }

            }

    private void makeButtons(Animals beast) {
        Pane pan = new VBox();
        //Label animalLabel = new Label(beast.name.get());
        TextField textName = new TextField();                   //вместо налдписи - редактируемое поле
        textName.textProperty().bindBidirectional(beast.name);  //связь между текстовым полем и именем животного
        pan.getChildren().add(textName);
        if(beast instanceof Purring)
        {
            Button bpur = new Button("Мур");
            pan.getChildren().add(bpur);
            bpur.setOnAction(actionEvent -> txtLines.setText(((Purring) beast).purring()));
        }
        if(beast instanceof Growls)
        {
            Button bgrowl = new Button("Р-ррр");
            pan.getChildren().add(bgrowl);
            bgrowl.setOnAction(actionEvent -> txtLines.setText(((Growls) beast).growl()));
        }
        if(beast instanceof Howls)
        {
            Button b = new Button("Выть");
            pan.getChildren().add(b);
            b.setOnAction(a->txtLines.setText(((Howls) beast).howls()));
        }
        if(beast instanceof Yelling)
        {
            Button b = new Button("Иа-иа");
            pan.getChildren().add(b);
            b.setOnAction(a->txtLines.setText(((Yelling) beast).yelling()));
        }
        animalsBox.getChildren().add(pan);
    }
}