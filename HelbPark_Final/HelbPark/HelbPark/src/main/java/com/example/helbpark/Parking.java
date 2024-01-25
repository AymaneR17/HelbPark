

import javafx.scene.control.Button;

public class Parking {

    private Button button;
    private Vehicle vehicle;
    private int placeNumber;
    private String typeOfVehicule;
    private boolean isfree = true;



    public Parking(int placeNumber) {

        this.placeNumber =placeNumber;
        button = new Button(" " + placeNumber);
        button.setStyle("-fx-base:green");
    }

    public Object modifyButton(String type) {
        if (type.equals("moto")) {
            button.setStyle("-fx-base: lightblue");
            button.setText(placeNumber + "\n" + vehicle.getImmatriculation());
        } else if (type.equals("voiture")) {
            button.setStyle("-fx-base: red");
            button.setText(placeNumber+ "\n" + vehicle.getImmatriculation());
        } else if (type.equals("camionette")) {
            button.setStyle("-fx-base: purple");
            button.setText(placeNumber + "\n" + vehicle.getImmatriculation());
        } else {
            button.setStyle("-fx-base: green");
            button.setText(placeNumber+"");
        }
        return null;
    }

        public boolean isFree () {
            return isfree;
        }

        public String getTypeOfVehicule () {
            return typeOfVehicule;
        }

        public void setTypeOfVehicule (String typeOfVehicule){
        this.typeOfVehicule = typeOfVehicule;
        }

        public String getImmatriculation () {
            return vehicle.getImmatriculation();
        }


        public void setImmatriculation (String immatriculation){
            vehicle.setImmatriculation(immatriculation);
            modifyButton(typeOfVehicule);
        }

        public Integer getPlaceNumber() {
            return placeNumber;
        }
        public void addVehicle (String immatriculation, String type) {

            typeOfVehicule = type;
            vehicle = VehicleFactory.getInstance().newVehicle(immatriculation, type);
            isfree = false;
            modifyButton(type);
        }

        public void deleteParking () { //si on libere l'emplacement
            isfree = true;
            vehicle= null;
            modifyButton("");
        }

        public Button getButton ()
        {
            return button;
        }
    }

