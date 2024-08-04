import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class User{
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    protected ArrayList<Booking> users_Booking;
    //-------------------------  CONSTRUCTORS --------------------------------------
    User(){
        this.userId=-1;
        this.dateOfBirth=new Date();
        this.firstName="John";
        this.lastName="Doe";
        this.users_Booking=new ArrayList<Booking>();}
    User(int userId,Date date_of_Birth_from_user,String firstName, String lastName){
        this.userId=userId;
        this.dateOfBirth=date_of_Birth_from_user;
        this.firstName=firstName;
        this.lastName=lastName;
        this.users_Booking=new ArrayList<Booking>();}
    User(int userId,String firstName, String lastName){
        Date dob=new Date();
        this.userId=userId;
        this.dateOfBirth=dob;
        this.firstName=firstName;
        this.lastName=lastName;
        this.users_Booking=new ArrayList<Booking>();}
    User(int userId,String firstName, String lastName,Booking booking_to_add,Date dob){
        //Date dob=new Date();
        this.userId=userId;
        this.dateOfBirth=dob;
        this.firstName=firstName;
        this.lastName=lastName;
        this.users_Booking=new ArrayList<Booking>();
        this.users_Booking.add(booking_to_add);
    }
    //-------------------------  GETTERS AND SETTERS START -------------------------

    /**
     * This method returns the user id.
     * @return userID This variable is useful for checking the existence of the user.
     */
    public int getUserId() {
        return userId;}

    /**
     * This method is useful for setting up a user id.
     * @param userId This variable is the users id given to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;}

    /**
     * This method returns the date of birth of a user.
     * @return dateOfBirth This method returns the date of birth of the user.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;}

    /**
     * This method sets the user's date of birth to the given date.
     * @param dateOfBirth This variable is the given date to set the date of birth.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;}

    /**
     * This method is used for getting the users name.
     * @return firstName This method returns the users first name.
     */
    public String getFirstName() {
        return firstName;}

    /**
     * This method is used for setting the firstname of user.
     * @param firstName This variable is the first name given by the user to set the firstname in this class.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    /**
     * This method is used for getting the lastname of the user.
     * @return lastname This method returns the last name of the user.
     */
    public String getLastName() {
        return lastName;}

    /**
     * This method is used for setting the lastname of the user.
     * @param lastName This variable is used for setting the firstname of the user.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;}

    /**
     * This method is used for setting the user's booking.
     * This method is mainly used at the populateData method, which is in the BASIC class.
     * @param users_new_booking This parameter is used for setting a booking to the user.
     */
    public void setUsers_Booking(Booking users_new_booking) {
        this.users_Booking.add(users_new_booking);
    }

    /**
     * This method is used for getting the user's bookings.
     * @return users_Booking This method returns the users bookings.
     */
    public ArrayList<Booking> getUsers_Booking() {
        return users_Booking;
    }
    //-------------------------  GETTERS AND SETTERS END -------------------------

    /**
     * The show_users_Bookings method shows the user's booking.
     */
    public void show_users_Bookings(){ // This method works with the getUserBooking method in the BASIC.java.
        if (this.users_Booking.size()==0){ //I have been told that the next assignments were going to be addition to this assignment and I thought in the future assignment we might be able to delete booking as well, so I put this here.
            System.out.println("This user has never booked.");}
        for (int i=0;i<this.users_Booking.size();i++){
            System.out.println("Booking is from "+this.users_Booking.get(i).getStartDate()+" to: "+this.users_Booking.get(i).getEndDate() + "in the property with the id: "+this.users_Booking.get(i).getProperty_id());}
    }
}
