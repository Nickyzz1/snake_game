package com.desktopapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// apliocation é uma classe do javafx para fazer coisas gráficas

public class App extends Application {
    public static void main(String[] args) {
        launch(args); // faz a janela
    }

    @Override
    // janela principal
    public void start(Stage primaryStage) throws Exception { //podem ter execessão
        // Cria a cena inicial com id 1
        Scene scene = MainController.CreateScene(1);
        
        primaryStage.setTitle("Login cartas");
        
        // fefine a cena no estágio primário
        primaryStage.setScene(scene); 
        
        // exibe a janela
        primaryStage.show();
    }
}
