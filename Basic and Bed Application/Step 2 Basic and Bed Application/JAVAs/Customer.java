import java.util.ArrayList;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public abstract class Customer extends User{
    private String preferredPaymentMethod;
    protected ArrayList<Booking> users_Booking;
    //-------------------------  CONSTRUCTORS --------------------------------------
    Customer(){
        this.preferredPaymentMethod="unspecified";
        this.users_Booking=new ArrayList<Booking>();}
    //-------------------------  GETTERS AND SETTERS START -------------------------
    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;}
    public void setPreferredPaymentMethod(String preferredPaymentMethod){
        this.preferredPaymentMethod = preferredPaymentMethod;}

    //-------------------------  GETTERS AND SETTERS END -------------------------
    public abstract double discountPercentage();
    /**
     * This method adds a new booking to the users booking array.
     * @param users_new_booking this parameter is used for adding the booking.
     */
    public void setUsers_Booking(Booking users_new_booking) {
        this.users_Booking.add(users_new_booking);
    }
    /**
     * This method shows all the bookings the user has made.
     */
    public void show_Users_Bookings(){
        if(this.users_Booking.isEmpty()){
            System.out.println("This user has never booked");}
        else {
            for(int i = 0; i < this.users_Booking.size(); i++) {
                System.out.println("Booking date is from: "+this.users_Booking.get(i).getStartDate()+" to: "+this.users_Booking.get(i).getEndDate()+"in the property with the id: "+this.users_Booking.get(i).getProperty_id());}}
    }
    public ArrayList<Booking> getUsers_Booking() {
        return users_Booking;
    }
}
