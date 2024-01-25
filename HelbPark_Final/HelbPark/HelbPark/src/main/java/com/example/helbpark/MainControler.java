

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainControler implements Initializable {
    private final int ROW_COUNT = 4;
    private final int COL_COUNT = 5;
    private final int prefWidth = 105;
    private final int prefHeight = 57;

    private int cptLine=0;
    private Timeline timeline;

    File f ;


    @FXML
    private Button readbtn;
    @FXML
    private GridPane grid;


    ArrayList<String> listFile;
    private static ArrayList <Parking> parkingList = new ArrayList<>();

    public void createButton() {
        int counter =0;

        for (int i = 0; i <ROW_COUNT ; i++)
        {
            for (int j = 0; j <COL_COUNT ; j++)
            {
                Parking parking = new Parking(counter);

                parking.getButton().setPrefWidth(prefWidth);
                parking.getButton().setPrefHeight(prefHeight);
                grid.add(parking.getButton(),j,i);
                counter++;
                parkingList.add(parking);
            }
        }
        createParkingEdit();
    }

    private void createParkingEdit(){

        for (Parking parking : parkingList) { //si clique sur un button ouvre la fenetre edit
            parking.getButton().setOnAction(actionEvent -> {
                try {
                    ParkingEditView.showEdit(parking);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }


    public void singleFileChooser() throws IOException {

        //choix du fichier texte

        FileChooser fileChoose = new FileChooser();
        fileChoose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files,",listFile));
        f = fileChoose.showOpenDialog(null);

        if (f != null)
        {
            readbtn.setStyle("-fx-base:lightgreen");
        }
        getFileLine();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { // ce qui debutera des le lancement de l'appli
                                                                    // lancement du choix du fichier texte avant l'interface

        listFile = new ArrayList();
        listFile.add("*.txt");

        createButton();

        try {
            singleFileChooser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getFileLine() throws IOException {

        String fileContent;


        fileContent= Files.readAllLines(Paths.get(f.getAbsolutePath())).get(cptLine);
        String[] data = fileContent.split(",");

        System.out.println(fileContent);
        Parking parking = actualLine();


        if(timeline!=null) { // permet de recuperer la premiere donnée du fichier texte qui sont les secondes a
                             // respecter entre chaque arrivé de vehicule
            timeline.stop();
        }
        timeline= new Timeline(new KeyFrame(Duration.seconds(Integer.parseInt(data[0])),
                evt-> {
                parking.addVehicle(data[2],data[1]);
                cptLine++;
                    try {
                        getFileLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

        ));
        timeline.setCycleCount(1);
        timeline.play();
    }

    public Parking actualLine() {
        for (Parking parking : parkingList) {

            if (parking.isFree())
                return parking;
        }
        return null;
    }
}
