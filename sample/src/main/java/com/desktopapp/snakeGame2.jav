package com.desktopapp;

import javafx.fxml.FXML;
import javafx.scene.shape.Polygon; // para usar o polygon
import javafx.scene.input.KeyEvent;
import java.scene.transform.Rotate;

public class SnakeGame {

    @FXML
    private Polygon react1;

    @FXML
    private Polygon react2;

    private double speed = 5.0; //velocidade de movimento
    private double anguloAtual = 0; 

    @FXML
    public void initialize() {
        //  meuLabel.setText("Olá, Mundo!"); // Inicializa o label com um texto
        scene.setOnKeyPressed(event ->{
            handleKeyPress(avent);
        }); // indica um método dessa mesma clasee 
    }

    // public void initialize() {
    //     myButton.setOnAction(e -> handleButtonClick());
    // }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) { // getcode pega qualq tela
            case W: // Para cima
                react1.setLayoutY(react1.getLayoutY() - speed);
                anguloAtual -= 15;
                react1.getTransforms().clear();
                react1.Rotate()
                react2.setLayoutY(react2.getLayoutY() - speed);
                break;
            case S: // Para baixo
                react1.setLayoutY(react1.getLayoutY() + speed);
                react2.setLayoutY(react2.getLayoutY() + speed);
                break;
            case A: // Para esquerda
                react1.setLayoutX(react1.getLayoutX() - speed);
                react2.setLayoutX(react2.getLayoutX() - speed);
                react1.getTransforms().add(new Rotate(-90, react1.getLayoutX() + (react1.getBoundsInLocal().getWidth() / 2), react1.getLayoutY() + (react1.getBoundsInLocal().getHeight() / 2)));
                break;
            case D: // Para direita
                react1.setLayoutX(react1.getLayoutX() + speed);
                react2.setLayoutX(react2.getLayoutX() + speed);
                react1.getTransforms().add(new Rotate(90, react1.getLayoutX() + (react1.getBoundsInLocal().getWidth() / 2), react1.getLayoutY() + (react1.getBoundsInLocal().getHeight() / 2)));
                break;
            default:
                break;
        }
    }
}
