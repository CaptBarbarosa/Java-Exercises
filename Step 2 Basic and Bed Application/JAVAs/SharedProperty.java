/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class SharedProperty extends Property {
    //-------------------------  CONSTRUCTORS --------------------------------------
    SharedProperty(int propertID,int noRooms,float pricePerDay,Host property_owner){
        setPropertID(propertID);
        setNoRooms(noRooms);
        setPricePerDay(pricePerDay);
        setProperty_owner(property_owner);
    }
    SharedProperty(int propertID,int noRooms,int noBedRooms,String city,float pricePerDay,Host property_owner){
        setPropertID(propertID);
        setNoRooms(noRooms);
        setNoBedRooms(noBedRooms);
        setCity(city);
        setPricePerDay(pricePerDay);
        setProperty_owner(property_owner);
    }

    /**
     * This method is used for calculating the price per day.
     * @return getPricePerDay()/getNoRooms() is the returned float variable that tells us the calculated price per day.
     */
    @Override
    public double calculatePricePerDay() {
        return getPricePerDay()/getNoRooms();
    }
}
