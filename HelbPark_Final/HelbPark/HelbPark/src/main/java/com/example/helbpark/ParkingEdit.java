
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ParkingEdit implements Initializable {

    @FXML
    private Label lblStatus ;
    @FXML
    private Label lblTotalToPay;
    @FXML
    private Button clearPlacement;
    @FXML
    private Label lblPlacementNbr;
    @FXML
    private Button btnEditImmatriculation;
    @FXML
    private Button btnModifyVehicle;
    @FXML
    private TextField editImmatriulation;
    @FXML
     ComboBox<String> myComboBox;

    File file;
    ObservableList<String> list = FXCollections.observableArrayList("moto","voiture", "camionette");
    ConstructPayment cstPayment = new ConstructPayment();
    CinemaTicket cineTicket = new CinemaTicket();


    public void changeVehicleData(Parking parking) { //methode permettant de gerer tout les label et boutton de la vue de ParkingEdit

      if (parking.isFree()){  //gere le label statut
          lblStatus.setText("Statut : Libre");
      }
      else {
          lblStatus.setText("Statut : Occupe");
          lblTotalToPay.setText("Total a payer : "+  cstPayment.getpriceTicket(parking.getTypeOfVehicule(), parking.getImmatriculation()));
      }

      clearPlacement.setOnAction(evt -> { //lorsqu'on click sur liberer l'emplacement
          if (!parking.isFree()) {
              ArrayList<String> cstPaymentList;
              ArrayList<String> cineTicketList;

              createDirectory();
              cineTicketList = cineTicket.ticketCinema(parking.getTypeOfVehicule());
              cstPaymentList =  cstPayment.getpriceTicket(parking.getTypeOfVehicule(), parking.getImmatriculation());

              try {
                  GenerateTicket gnrTicket = new GenerateTicket(cstPaymentList, file.getAbsolutePath(),parking,cineTicketList);
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }

              System.out.println("delete");
               parking.deleteParking();

           ParkingEditView.secondStage.close(); //ferme la vue d'edition

          }});

        btnModifyVehicle.setOnAction(evt -> { //button modifie le vehicle
            if (!parking.isFree()) {
                lblTotalToPay.setText("");
                System.out.println(myComboBox.getValue());
                parking.modifyButton(myComboBox.getValue());
                parking.setTypeOfVehicule(myComboBox.getValue());
                ConstructPayment cstPayment = new ConstructPayment();
                lblTotalToPay.setText("Total à payer : "+  cstPayment.getpriceTicket(parking.getTypeOfVehicule(), parking.getImmatriculation()));
            }});

        btnEditImmatriculation.setOnAction(evt -> { //button change la plaque
          if (!parking.isFree()){
              parking.setImmatriculation(editImmatriulation.getText());
              System.out.println(parking.getTypeOfVehicule());
              parking.modifyButton(parking.getTypeOfVehicule());
          }});

      lblPlacementNbr.setText("Emplacement : "+parking.getButton().getText());
    }

    private void createDirectory(){
        String path = new SimpleDateFormat("ddMMyy").format(Calendar.getInstance().getTime());
        file = new File(path);

        if (!file.exists()) {
            System.out.println(file.getAbsolutePath());
            file.mkdir();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myComboBox.getItems().addAll(list);
    }
}
