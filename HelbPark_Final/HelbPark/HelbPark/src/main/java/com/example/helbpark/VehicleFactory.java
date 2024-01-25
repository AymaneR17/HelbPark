
public final class VehicleFactory // classe de fabrique des vehicule
{
    private static volatile VehicleFactory instance = null;
    private VehicleFactory()
    {
        super();
    }

    public final static VehicleFactory getInstance(){
        synchronized (VehicleFactory.class) {
          if (VehicleFactory.instance==null) {
              VehicleFactory.instance = new VehicleFactory();
          }
        }
        return VehicleFactory.instance;
    }
    public Vehicle newVehicle(String immatriculation,String type){
        return new Vehicle(immatriculation,type);
    }


}
