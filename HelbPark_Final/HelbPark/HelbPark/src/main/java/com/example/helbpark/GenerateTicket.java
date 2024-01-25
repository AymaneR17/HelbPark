

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GenerateTicket { // classe qui va generer le fichier texte


    public GenerateTicket(ArrayList<String> strategyPrice, String path, Parking parking, ArrayList<String>cineTicketList) throws IOException {


        FileWriter fw = new FileWriter(path + "/" + parking.getImmatriculation() + cineTicketList.get(0));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yyyy");

        Calendar calendar = Calendar.getInstance();

        fw.write("Date : " + simpleDateFormat.format(calendar.getTime())+"\n");
        fw.write("Place occupee : " + parking.getPlaceNumber()+ "\n");
        fw.write("Type de vehicule : " + parking.getTypeOfVehicule()+"\n");
        fw.write("Immatriculation : " + parking.getImmatriculation() + "\n");
        fw.write("Prix de base : " + strategyPrice.get(1)+"\n");
        fw.write("Reduction : " + strategyPrice.get(0)+"\n");
        fw.write("Total à payer : " + strategyPrice.get(2)+"\n");
        fw.write("Code promo Cine : "+"BTF958"+"\n");
        fw.write(cineTicketList.get(1)+" Valeur : "+cineTicketList.get(3)+" %"+"\n");
        fw.write("Jeu : "+cineTicketList.get(3)+"\n");


        fw.close();

    }
}
