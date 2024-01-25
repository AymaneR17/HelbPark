

public class TicketStdCine  implements StrategyCinema {
    int stdReduction;

    @Override
    public String setPrice() {
        int random =(int) Math.random()*2;

        if (random==0){
            stdReduction=5;
        }else{
            stdReduction=10;
        }
        return stdReduction+"";
    }

    @Override
    public String reduction() {
    return "";
    }


}
