

public  class Vehicle
{
    String type;
    String immatriculation;

    public Vehicle(String immatriculation, String type){
      this.immatriculation = immatriculation;
      this.type = type;
     }

    public  String getType(){
    return type;
    }
    public  String getImmatriculation(){
        return immatriculation;
    }

    public  void setType(String newType){
        this.type = newType;
    }

    public  void setImmatriculation(String newImmatriculation){
        this.immatriculation=newImmatriculation;
    }

}
