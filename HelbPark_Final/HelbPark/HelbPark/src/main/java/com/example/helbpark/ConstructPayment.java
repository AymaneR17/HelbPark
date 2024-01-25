

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConstructPayment {

    private int motorBikePrice=10;
    private int carPrice = 20;
    private  int vanPrice = 30;

    StrategyTicket strategyPrice =new StratBasicPrice();
    ArrayList<String> parkingPrice = new ArrayList<>();



    public ArrayList<String> getpriceTicket(String type, String immatriculation){  // ici nous reprenons les bons prix dans une liste selon le jour

        Format format = new SimpleDateFormat("HH.mm.ss Z");
        format = new SimpleDateFormat("EEEE");
        String str = format.format(new Date());
        format = new SimpleDateFormat("dd");
        int day = Integer.parseInt(format.format(new Date()));


        if( type.equals("moto") && str.equals("mardi")){
            strategyPrice = new StratHalfPrice();
            strategyPrice.setPrice(type);
            parkingPrice.add(str+" – Moitie Prix Pour les Moto");
        }
        else if(str.equals("mercredi") && immatriculation.contains("P") ){
            strategyPrice = new StratPercentTwentyFivePrice();
            strategyPrice.setPrice(type);
            parkingPrice.add(str+" - 25% de reduction pour les vehicules dont la plaque d’immatriculation contient la lettre « P »");
        }

        else if( str.equals("samedi") && day%2==0){
            strategyPrice = new StratHalfPrice();
            strategyPrice.setPrice(type);
            parkingPrice.add(str+" – Moitie prix les jours pairs");
        }
        else if(str.equals("vendredi") && type.equals("camionette")){
            strategyPrice = new StratHalfPrice();
            strategyPrice.setPrice(type);
            parkingPrice.add(str+" – Moitié prix pour les camionettes");
        }
        else{
            strategyPrice = new StratBasicPrice();
            strategyPrice.setPrice(type);
            parkingPrice.add(str+" - Prix de base");
        }

        if (type.equals("moto"))
            parkingPrice.add(motorBikePrice+"");
        else if(type.equals("voiture"))
            parkingPrice.add(carPrice+"");
        else if(type.equals("camionette"))
            parkingPrice.add(vanPrice+"");

        parkingPrice.add(strategyPrice.getPrice());

        return parkingPrice;
    }
}
