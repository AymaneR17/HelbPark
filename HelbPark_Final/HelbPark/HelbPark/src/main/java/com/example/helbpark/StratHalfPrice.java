

public class StratHalfPrice implements StrategyTicket{

    int priceBikeMotor = 10;
    int priceCar = 20;
    int priceVan = 30;
    int price;
    int reduction;
    double percentFifty = 0.5;


    @Override
    public void setPrice(String type) {
        if (type.equals("moto")){
            reduction = (int) (priceBikeMotor*percentFifty);
            price = reduction;
        } else if (type.equals("voiture")) {
            reduction = (int) (priceCar*percentFifty);
            price = reduction;
        } else if (type.equals("camionette")) {
            reduction = (int) (priceVan*percentFifty);
            price = reduction;
        }
    }

    @Override
    public String getPrice() {
        return price+"";
    }

    @Override
    public String getReduc() {
        return reduction+"";
    }


}
