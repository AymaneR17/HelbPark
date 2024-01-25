

import java.util.ArrayList;

public class CinemaTicket {
    int allChance = 10;
    int betterChance = 5;
    int lowChance = 2;
    int random;
    StrategyCinema ticket;

    ArrayList<String> setTicketCinema = new ArrayList<>();

    public ArrayList<String> ticketCinema(String type){ // permet de savoir quel ticket le vehicule aura selon les chances possibles

        random = (int) (Math.random()*allChance);
        System.out.println(random);
        if (type.equals("moto")){
            if (random<lowChance+betterChance && random>betterChance){
                ticket = new TicketSilverCinema();
                setTicketCinema.add("_sil");
                setTicketCinema.add("Ticket Silver");

            } else if (random < betterChance ) {// plus de chance d'avoir un ticket standart
                ticket = new TicketStdCine();
                setTicketCinema.add("_std");
                setTicketCinema.add("Ticket Standart");
            }
            else {
                ticket = new TicketGoldCinema();
                setTicketCinema.add("_gol");
                setTicketCinema.add("Ticket Gold");
            }

        } else if (type.equals("voiture")) {
            if (random<lowChance+betterChance && random>betterChance){
                ticket = new TicketStdCine();
                setTicketCinema.add("_std");
                setTicketCinema.add("Ticket Standart");

            } else if (random < betterChance ) {// +de chance d'avoir un ticket silver
                ticket = new TicketSilverCinema();
                setTicketCinema.add("_sil");
                setTicketCinema.add("Ticket Silver");
            }
            else {

                ticket = new TicketGoldCinema();
                setTicketCinema.add("_gol");
                setTicketCinema.add("Ticket Gold");
            }
        }else if (type.equals("camionette")) {

            if (random<lowChance+betterChance && random>betterChance) {
                ticket = new TicketSilverCinema();
                setTicketCinema.add("_sil");
                setTicketCinema.add("Ticket Silver");

            } else if (random < betterChance ) {// plus de chance d'avoir un ticket gold
                ticket = new TicketGoldCinema();
                setTicketCinema.add("_gol");
                setTicketCinema.add("Ticket Gold");
            } else {

                ticket = new TicketStdCine();
                setTicketCinema.add("_std");
                setTicketCinema.add("Ticket Standart");
            }
        }
        setTicketCinema.add(ticket.reduction());
        setTicketCinema.add(ticket.setPrice()+"");

        return setTicketCinema;
    }
}
