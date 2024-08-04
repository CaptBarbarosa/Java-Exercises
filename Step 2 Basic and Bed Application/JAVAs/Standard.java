import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Standard extends Customer{
    //-------------------------  CONSTRUCTORS --------------------------------------
    Standard(){}
    Standard(String preferredPaymentMethod,Date registration_date){
        setPreferredPaymentMethod(preferredPaymentMethod);
        set_Registration_Date(registration_date);}
    Standard(String preferredPaymentMethod,Date registration_date,Booking booking_to_add){
        setPreferredPaymentMethod(preferredPaymentMethod);
        set_Registration_Date(registration_date);
        setUsers_Booking(booking_to_add);}
    Standard(int userId, Date date_of_Birth_from_user, String firstName, String lastName, String preferredPaymentMethod,Date registration_date){
        setUserId(userId);
        setDateOfBirth(date_of_Birth_from_user);
        setFirstName(firstName);
        setLastName(lastName);
        set_Registration_Date(registration_date);
        setPreferredPaymentMethod(preferredPaymentMethod);}
    Standard(int userId, Date date_of_Birth_from_user, String firstName, String lastName, String preferredPaymentMethod,Date registration_date,Booking booking_to_add){
        setUserId(userId);
        setDateOfBirth(date_of_Birth_from_user);
        setFirstName(firstName);
        setLastName(lastName);
        set_Registration_Date(registration_date);
        setPreferredPaymentMethod(preferredPaymentMethod);
        setUsers_Booking(booking_to_add);}
    Standard(int userId,String firstName, String lastName,String preferredPaymentMethod,Date registration_date){
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setPreferredPaymentMethod(preferredPaymentMethod);
        set_Registration_Date(registration_date);}
    Standard(int userId,String firstName, String lastName,String preferredPaymentMethod,Date registration_date,Booking booking_to_add){
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setPreferredPaymentMethod(preferredPaymentMethod);
        set_Registration_Date(registration_date);
        setUsers_Booking(booking_to_add);
    }
    Standard(int userId,String firstName, String lastName,Date dob,Date registration_date,String preferredPaymentMethod){
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dob);
        set_Registration_Date(registration_date);
        setPreferredPaymentMethod(preferredPaymentMethod);}
    Standard(int userId,String firstName, String lastName,String preferredPaymentMethod,Booking booking_to_add){
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setPreferredPaymentMethod(preferredPaymentMethod);
        setUsers_Booking(booking_to_add);}
    /**
     * This method is used for getting the discount percentage.
     * @return percentage is the returned double variable that tells us the discount percentage.
     */
    @Override
    public double discountPercentage(){
        double percentage;
        Date current_date=new Date();
        int current_year=(current_date.getYear()+1900)-get_Registration_Date().getYear();
        if (current_year<10){percentage=0;}
        else {percentage=0.02;}
        return percentage;
    }
    /*
    @Override
    public void setUsers_Booking(Booking to_add){}*/
}
