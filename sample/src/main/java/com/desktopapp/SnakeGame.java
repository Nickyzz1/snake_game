package com.desktopapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    private Pane gamePane;
    private Label scoreLabel;
    private Polygon triangle1;
    private Polygon triangle2;
    private static final double MOVE_DISTANCE = 5.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("SnakeGame.fxml"));
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Inicializa os elementos da interface
        gamePane = (Pane) root.lookup("#gamePane");
        scoreLabel = (Label) root.lookup("#scoreLabel");

        // Localiza os triângulos
        triangle1 = (Polygon) gamePane.lookup("#react1");
        triangle2 = (Polygon) gamePane.lookup("#react2");

        // Configura o evento de teclado
        Scene scene = primaryStage.getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    moveTriangles(0, -MOVE_DISTANCE);
                    break;
                case S:
                    moveTriangles(0, MOVE_DISTANCE);
                    break;
                case A:
                    moveTriangles(-MOVE_DISTANCE, 0);
                    break;
                case D:
                    moveTriangles(MOVE_DISTANCE, 0);
                    break;
            }
        });
    }

    private void moveTriangles(double deltaX, double deltaY) {
        triangle1.setLayoutX(triangle1.getLayoutX() + deltaX);
        triangle1.setLayoutY(triangle1.getLayoutY() + deltaY);
        triangle2.setLayoutX(triangle2.getLayoutX() + deltaX);
        triangle2.setLayoutY(triangle2.getLayoutY() + deltaY);
    }
}
