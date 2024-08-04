import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Booking{
    private Date startDate;
    private Date endDate;
    private boolean isPaid;
    private int property_id;
    private Property property_to_point;
    //-------------------------  CONSTRUCTORS --------------------------------------
    Booking(){
        this.startDate=new Date();
        this.endDate=new Date();
        this.isPaid=false;
        this.property_id=-1;
        this.property_to_point = new Property();
    }
    Booking(Date startDate,Date endDate,int property_id,Property property_to_point){
        this.startDate=startDate;
        this.endDate=endDate;
        this.isPaid=false;
        this.property_id=property_id;
        this.property_to_point=property_to_point;

    }
    Booking(Date startDate,Date endDate,boolean isPaid,int property_id,Property property_to_point){
        this.startDate=startDate;
        this.endDate=endDate;
        this.isPaid=isPaid;
        this.property_id=property_id;
        this.property_to_point=property_to_point;
        }
    Booking(Date startDate,Date endDate,Property property_to_point){
        this.startDate=startDate;
        this.endDate=endDate;
        this.isPaid=false;
        this.property_id=property_to_point.getPropertID();
        this.property_to_point=property_to_point;
    }
    //-------------------------  GETTERS AND SETTERS START -------------------------

    /**
     * This method returns the starts date of the booking.
     * @return startDate This variable returned is the starting date of the booking
     */
    public Date getStartDate() {
        return startDate;}

    /**
     * This method is used for setting the starting date of the booking.
     * @param startDate This variable is the starting date that the method sets.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;}

    /**
     * This method gets the ending date of the booking.
     * @return endingDate This variable is the returned ending date of the booking
     */
    public Date getEndDate() {
        return endDate;}

    /**
     * This method is used for setting the start date to the desired date.
     * @param endDate This variable is used for setting the
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;}

    /**
     * This method returns if a boolean value that determines whether the user paid for the booking or not.
     * @return isPaid This returning variable is a boolean that tells us whether the booking is paid or not.
     */
    public boolean isPaid() {
        return isPaid;}

    /**
     * This method allows user to set isPaid
     * @param paid This variable allows user to set isPaid boolean of Booking class.
     * This method can come handy in case of a user mistake while creating a booking.
     */
    public void setPaid(boolean paid) {
        isPaid = paid;}

    /**
     * I made a mistake This method is used for getting which property the user booked.
     * @return property_id is the property id that the user booked.
     */
    public int getProperty_id() {
        return property_id;
    }

    /**
     * This method returns the property of the booking.
     * @return property_to_point is the returned property.
     */
    public Property getProperty_to_point() {
        return property_to_point;
    }

    /**
     * This method is used for setting the property.
     * @param property_to_point is the property that we are setting.
     */
    public void setProperty_to_point(Property property_to_point) {
        this.property_to_point = property_to_point;
    }

    /**
     * This method is used for setting property id.
     * @param property_id is the parameter used for setting property id.
     */
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }
    //-------------------------  GETTERS AND SETTERS END -------------------------

    /**
     * This method returns the totalCost, a float value, by calculating how many days a customer spends in a property and multiplying it with the pricing per day.
     * @return to_return This variable is the total booking cost calculated.
     */
    public float totalCost(){ //In this function I calculated the totalCost.
        int days=0;
        float to_return=0;
        Date start,end;
        start=this.startDate;
        end=this.endDate;
        days=(end.getDay()-start.getDay())+30*(end.getMonth()-start.getMonth())+365*(end.getYear()-start.getYear());
        to_return=this.property_to_point.getPricePerDay()*days;
        return to_return;
    }
}