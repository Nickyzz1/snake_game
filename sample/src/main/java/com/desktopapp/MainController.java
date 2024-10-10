package com.desktopapp;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
    private Integer id;

    @FXML
    protected Button btLogin;
    @FXML
    protected TextField tfLogin;

    public static Scene CreateScene(Integer id) throws Exception {
        URL sceneUrl = MainController.class.getResource("login-scene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        MainController controller = loader.getController();
        controller.setId(id);
        return scene;
    }

    @FXML
    protected void initialize(URL location, ResourceBundle resources) {
        this.btLogin.setText(id != null ? id.toString() : "Login");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @FXML
    protected void submit(ActionEvent e) throws Exception {
        // Aqui você pode adicionar sua lógica de validação de login
        showAlert("Logando com sucesso");

        // Se o login for bem-sucedido, abra a cena do jogo
        switchToSnakeGame();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION, message);
        alert.showAndWait();
    }

    private void switchToSnakeGame() throws Exception {
        Stage currentStage = (Stage) btLogin.getScene().getWindow();
        currentStage.close();
    
        // Criar a nova cena do jogo
        Stage newStage = new Stage();
        SnakeGame game = new SnakeGame();
        game.start(newStage);
    }
    
}
