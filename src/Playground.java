import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Playground extends Application implements Initializable{

    Stage stage;
    Parent root;
    Scene scene;

    @FXML
    TextField tf00;
    @FXML
    TextField tf01;
    @FXML
    TextField tf02;

    @FXML
    TextField tf10;
    @FXML
    TextField tf11;
    @FXML
    TextField tf12;

    @FXML
    TextField tf20;
    @FXML
    TextField tf21;
    @FXML
    TextField tf22;

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonLoad;

    @FXML
    private Button buttonReset;

    private String[] currentPositions = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};

    private TicTacToe saveGame;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            saveGame = new TicTacToe("savegame");
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    save();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonLoad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("TicTatToe.fxml"));
        scene = new Scene(root, 800,600);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    private void reset(){
        tf00.setText("");
        tf01.setText("");
        tf02.setText("");
        tf10.setText("");
        tf11.setText("");
        tf12.setText("");
        tf20.setText("");
        tf21.setText("");
        tf22.setText("");
    }

    private void load() throws IOException{
        tf00.setText(saveGame.positions[0]);
        tf01.setText(saveGame.positions[1]);
        tf02.setText(saveGame.positions[2]);
        tf10.setText(saveGame.positions[3]);
        tf11.setText(saveGame.positions[4]);
        tf12.setText(saveGame.positions[5]);
        tf20.setText(saveGame.positions[6]);
        tf21.setText(saveGame.positions[7]);
        tf22.setText(saveGame.positions[8]);
    }

    private void save() throws IOException {
        currentPositions[0]=tf00.getText();
        currentPositions[1]=tf01.getText();
        currentPositions[2]=tf02.getText();
        currentPositions[3]=tf10.getText();
        currentPositions[4]=tf11.getText();
        currentPositions[5]=tf12.getText();
        currentPositions[6]=tf20.getText();
        currentPositions[7]=tf21.getText();
        currentPositions[8]=tf22.getText();

        saveGame.updatePositions(currentPositions);
        saveGame.writePositionsIntoFile();
    }
}
