package com.example.fantasygame;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterController {

    @FXML private TextField nameField;
    @FXML private ComboBox<String> professionBox;
    @FXML private ComboBox<String> hairBox;
    @FXML private ComboBox<String> eyesBox;
    @FXML private TextArea resultArea;
    @FXML private ImageView photoView;

    @FXML
    public void initialize() {
        professionBox.getItems().addAll("Воин", "Маг", "Разведчик", "Целитель", "Проклятый");
        hairBox.getItems().addAll("Чёрные", "Белые", "Каштановые", "Синие", "Серебристые");
        eyesBox.getItems().addAll("Карие", "Зелёные", "Голубые", "Серые", "Золотые");

        professionBox.setOnAction(event -> updatePhoto());
    }

    private void updatePhoto() {
        String profession = professionBox.getValue();
        if (profession == null) {
            photoView.setImage(null);
            return;
        }

        String imagePath = switch (profession) {
            case "Воин" -> "/MyGameImages/warrior.png";
            case "Маг" -> "/MyGameImages/mage.png";
            default -> null;
        };

        if (imagePath != null) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            photoView.setImage(image);
        } else {
            photoView.setImage(null);
        }
    }

    @FXML
    private void createCharacter() {
        String name = nameField.getText();
        String profession = professionBox.getValue();
        String hair = hairBox.getValue();
        String eyes = eyesBox.getValue();

        String description = switch (profession) {
            case "Воин" -> "Сила и выносливость — твои союзники.";
            case "Маг" -> "Ты ищешь знания, но готов к сражению.";
            case "Разведчик" -> "Ты действуешь скрытно и метко.";
            case "Целитель" -> "Ты спасаешь, а не уничтожаешь.";
            case "Проклятый" -> "В тебе тьма и сила.";
            default -> "";
        };

        resultArea.setText(String.format(
                "Имя: %s\nПрофессия: %s\nВолосы: %s\nГлаза: %s\nОписание: %s",
                name, profession, hair, eyes, description
        ));
    }
}
