/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Property {
    private int propertID;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private float pricePerDay;
    //private int hosts_id;
    protected Host property_owner;

    //-------------------------  CONSTRUCTORS --------------------------------------
    Property() {
        propertID = 0;
        noBedRooms = 0;
        noRooms = 0;
        city = "Nowhere";
        pricePerDay = 0;
    }
    Property(int propertID, int noBedRooms, int noRooms, String city, float pricePerDay,Host property_owner) {
        this.propertID = propertID;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.property_owner=property_owner;
        //this.hosts_id = -1;
    }
    Property(int propertID, float pricePerDay,Host property_owner) {
        this.propertID = propertID;
        this.pricePerDay = pricePerDay;
        this.property_owner=property_owner;
        this.noRooms=0;
        this.noBedRooms=0;
        this.city="Nowhere";

    }
    Property(int propertID,String city, float pricePerDay,Host property_owner) {
        this.propertID=propertID;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.noRooms=0;
        this.noBedRooms=0;
        this.property_owner=property_owner;
    }

    //-------------------------  GETTERS AND SETTERS START -------------------------

    /**
     * This method returns the property id.
     * @return propertID is the property id returned.
     */
    public int getPropertID() {
        return propertID;}

    /**
     * This method is used for setting the property id.
     * @param propertID is the variable we are setting our property id to.
     */
    public void setPropertID(int propertID) {
        this.propertID = propertID;}

    /**
     * This method returns the number of bedrooms.
     * @return noBedRooms is the returned number of bedrooms in a property.
     */
    public int getNoBedRooms() {
        return noBedRooms;}

    /**
     * This method allows us to set the number of bedrooms set.
     * @param noBedRooms is the variable we are using to set the number of bedrooms in Property class.
     */
    public void setNoBedRooms(int noBedRooms) {
        this.noBedRooms = noBedRooms;}

    /**
     * This method allows us to get the number of rooms in Property class.
     * @return noRooms is the number of rooms
     */
    public int getNoRooms() {
        return noRooms;}

    /**
     * Thi method allows us to set the number of rooms.
     * @param noRooms is the variable used for setting the number of rooms.
     */
    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;}

    /**
     * This method allows us to get the city name of the property is in.
     * @return city This variable is the name of the city.
     */
    public String getCity() {
        return city;}

    /**
     * This method allows us to set the city name in Property class.
     * @param city is the variable used for setting city name
     */
    public void setCity(String city) {
        this.city = city;}

    /**
     * This method allows us to get the price per day in a Property.
     * @return pricePerDay is the variable that gives us the price per day.
     */
    public float getPricePerDay() {
        return pricePerDay;}

    /**
     * This method allows us to set the price per day.
     * @param pricePerDay this variable allows us to set the price per day.
     */
    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;}
    //-------------------------  GETTERS AND SETTERS END -------------------------
}
