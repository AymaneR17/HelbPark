

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ParkingEditView  {

    static Stage secondStage  = new Stage(); //sortit de la methode showEdit pour pouvoir .close() dans ParkingEdit
    public static void showEdit(Parking parking ) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationView.class.getResource("ParkingEditView.fxml")); 
        
        ParkingEdit controlerParkEdit = new ParkingEdit();
        fxmlLoader.setController(controlerParkEdit);
        Scene sceneTwo = new Scene(fxmlLoader.load(), 400, 400);
       
        if(controlerParkEdit!=null)
            controlerParkEdit.changeVehicleData(parking);
        secondStage.setTitle("Helb Park Edit");
        secondStage.setScene(sceneTwo);
        secondStage.show();
    }









}
