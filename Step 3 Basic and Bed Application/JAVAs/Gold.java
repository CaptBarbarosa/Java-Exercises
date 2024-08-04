import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Gold extends Customer {
    private int goldLevel;
    //-------------------------  CONSTRUCTORS --------------------------------------
    Gold(){
        this.goldLevel=-1;}
    Gold(int userId,int goldLevel, String preferredPaymentMethod){
        this.goldLevel = goldLevel;
        setUserId(userId);
        setPreferredPaymentMethod(preferredPaymentMethod);}
    Gold(int userId,int goldLevel, String preferredPaymentMethod,Booking booking_to_add){
        this.goldLevel = goldLevel;
        setUserId(userId);
        setPreferredPaymentMethod(preferredPaymentMethod);
        setUsers_Booking(booking_to_add);}
    Gold(int userId,String firstName, String lastName,String preferredPaymentMethod,int goldLevel){
        this.goldLevel=goldLevel;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setPreferredPaymentMethod(preferredPaymentMethod);}
    Gold(int userId, String firstName, String lastName, String preferredPaymentMethod,int goldLevel,Booking booking_to_add){
        this.goldLevel=goldLevel;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setPreferredPaymentMethod(preferredPaymentMethod);
        setUsers_Booking(booking_to_add);}
    Gold(int userId,String firstName, String lastName,Date dob,Date registration_date,String preferredPaymentMethod,int goldLevel){
        this.goldLevel=goldLevel;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dob);
        set_Registration_Date(registration_date);
        setPreferredPaymentMethod(preferredPaymentMethod);}
    Gold(int userId,String firstName, String lastName,Date dob,Date registration_date,String preferredPaymentMethod,int goldLevel,Booking booking_to_add){
        this.goldLevel=goldLevel;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dob);
        set_Registration_Date(registration_date);
        setPreferredPaymentMethod(preferredPaymentMethod);
        setUsers_Booking(booking_to_add);}
    //-------------------------  GETTERS AND SETTERS START -------------------------
    /**
     * This method is used to get the gold Level.
     * @return goldLevel is the returned gold levelç
     */
    public int getGoldLevel() {
        return goldLevel;}
    /**
     * This method is used for setting the goldLevelç
     * @param goldLevel this parameter is used for setting the goldLevel.
     */
    public void setGoldLevel(int goldLevel) {
        this.goldLevel = goldLevel;}

    //-------------------------  GETTERS AND SETTERS END -------------------------
    /**
     * This method is used for calculating the discount percentage.
     * @return ((double)this.goldLevel)/100
     */
    @Override
    public double discountPercentage() {return ((double)this.goldLevel)/100;}
}
