

public class StratPercentTwentyFivePrice implements  StrategyTicket {

    int priceBikeMotor = 10;
    int priceCar = 20;
    int priceVan = 30;
    double percentTwentyFive = 0.25;
    int reduction;
    int price ;


    @Override
    public void setPrice(String type) {
        if (type.equals("moto")){
            reduction = (int) (priceBikeMotor*percentTwentyFive);
            price = reduction;
        } else if (type.equals("voiture")) {
            reduction = (int) (priceCar*percentTwentyFive);
            price = reduction;
        } else if (type.equals("camionette")) {
            reduction = (int) (priceVan*percentTwentyFive);
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
