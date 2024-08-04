import java.io.Serializable;
import java.util.HashMap;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public abstract class Property implements PropertyPrice,Comparable, Serializable {
    private int propertID;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private float pricePerDay;
    protected Host property_owner;
    protected HashMap <Date, String> inspections=new HashMap<Date,String>();
    //-------------------------  CONSTRUCTORS --------------------------------------
    Property(){
        this.propertID = 0;
        this.noBedRooms = 0;
        this.noRooms = 0;
        this.city = "Nowhere";
        this.pricePerDay = 0;
    }
    Property(int given_id){
        this.propertID=given_id;
    }
    Property(int given_id,String given_city){
        this.propertID=given_id;
        this.city=given_city;
    }

    //-------------------------  GETTERS AND SETTERS START -------------------------
    /**
     * This method is used for getting the property id.
     * @return propertID is the returned property id.
     */
    public int getPropertID() {
        return propertID;}
    /**
     * This method is used for setting the property id.
     * @param propertID is the parameter that will be used for setting the property id.
     */
    public void setPropertID(int propertID) {
        this.propertID = propertID;}
    /**
     * This method is used for getting the number of bedrooms.
     * @return noBedrooms is the parameter returned that tells us the number of bedrooms
     */
    public int getNoBedRooms() {
        return noBedRooms;}
    /**
     * This method is used for setting the number of bedrooms.
     * @param noBedRooms is the parameter for setting the number of bedrooms
     */
    public void setNoBedRooms(int noBedRooms) {
        this.noBedRooms = noBedRooms;}
    /**
     * This method is used for getting the number of rooms.
     * @return noRooms is the parameter returned that tells us the number of rooms
     */
    public int getNoRooms() {
        return noRooms;}
    /**
     * This method is used for setting the number of rooms.
     * @param noRooms is the parameter for setting the number of rooms
     */
    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;}
    /**
     * This method is used for getting the city.
     * @return city is the parameter returned that tells us the city name.
     */
    public String getCity() {
        return city;}
    /**
     * This method is used for setting the city.
     * @param city is the parameter for setting the city.
     */
    public void setCity(String city) {
        this.city = city;}
    /**
     * This method is used for getting the priceperday.
     * @return pricePerDay is the parameter returned
     */
    public float getPricePerDay() {
        return pricePerDay;}
    /**
     * This method is used for setting the price per day.
     * @param pricePerDay is the parameter for setting the price per day.
     */
    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;}
    public Host getProperty_owner() {
        return property_owner;}
    public void setProperty_owner(Host property_owner) {
        this.property_owner = property_owner;}
    public HashMap<Date, String> getInspections() {
        return inspections;}
    public void setInspections(HashMap<Date, String> inspections) {
        this.inspections = inspections;}
    //-------------------------  GETTERS AND SETTERS END -------------------------

    public abstract double calculatePricePerDay();

    //I have no clue what in the almighty God is happening here.
    @Override
    public int compareTo(Object o) {
        return 0;}
}
