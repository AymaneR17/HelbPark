

public class TicketGoldCinema implements StrategyCinema{

    String[][] tabString = new String[3][3];
    String gameGold = "PARKHELB";
    int goldReduction;
    int goldReductionDouble;
    boolean win =false;


    public String setPrice() {
        int random =(int) Math.random()*2;

        if (random==0){
            goldReduction =20;
        }else{
            goldReduction =40;
        }
        if (win){
            goldReductionDouble = goldReduction *2;
        }
        return goldReduction+"";
    }

    @Override
    public String reduction() {
        return "";
    }

    public String[][] createGrid() {

        int random;

        for (int i = 0; i < tabString.length; i++){
            for (int j = 0; j < tabString[i].length; j++){
                random = (int) Math.random() * 8;
                tabString[i][j] = String.valueOf(gameGold.charAt(random));
            }
        }

        for (int i = 0; i < tabString.length; i++) {
            for (int j = 0; j < tabString[i].length; j++) {
                if (tabString[i][0] == tabString[i][1] || tabString[i][1] == tabString[i][2] || tabString[i][0] == tabString[i][2]){
                    win = true;
                }
                if (tabString[0][j] == tabString[1][j] || tabString[1][j] == tabString[2][j] || tabString[0][j] == tabString[2][j]){
                    win = true;
                }
            }
        }
        return tabString;
    }
}
