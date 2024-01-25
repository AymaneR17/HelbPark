

public class TicketSilverCinema implements StrategyCinema{

    char[] charTab = {'O','X','P'};

    int silverReduction;
    int silverReductionDouble;
    boolean win = false;

    @Override
    public String setPrice() {
        int random =(int) Math.random()*2;

        if (random==0){
            silverReduction =10;
        }else{
            silverReduction =15;
        }
        if (win){
            silverReductionDouble = silverReduction *2;
            return silverReductionDouble+"";
        }
        return silverReduction+"";
    }

    public String  reduction(){
        char charOne;
        char charTwo;

        int randChar =(int) Math.random()*charTab.length;

        charOne = charTab[randChar];

        randChar =(int) Math.random()*charTab.length;

        charTwo = charTab[randChar];

       if (charOne == charTwo)
            win = true;
        else
            win = false;

        return "";
    }


}
