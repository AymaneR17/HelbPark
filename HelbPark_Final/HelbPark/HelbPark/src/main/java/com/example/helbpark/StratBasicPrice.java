
public class StratBasicPrice implements StrategyTicket{

    int priceBikeMotor = 10;
    int priceCar = 20;
    int priceVan = 30;
    int price;

    @Override
    public void setPrice(String type) {
        if (type.equals("moto")){
            price = priceBikeMotor;
        } else if (type.equals("voiture")) {
            price = priceCar;

        } else if (type.equals("camionette")) {
            price = priceVan;
        }
    }

    @Override
    public String getPrice() {
        return price+"";
    }

    @Override
    public String getReduc() {
        return null;
    }




}
