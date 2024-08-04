import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Host extends User {
    private double taxNumber;
    //-------------------------  CONSTRUCTORS --------------------------------------
    Host(){
        this.taxNumber=-1;}
    Host(double taxNumber){
        this.taxNumber=taxNumber;}
    Host(int userId, Date date_of_Birth_from_user, String firstName, String lastName,double taxNumber){
        this.taxNumber=taxNumber;
        setUserId(userId);
        setDateOfBirth(date_of_Birth_from_user);
        setFirstName(firstName);
        setLastName(lastName);}
    Host(int userId,String firstName, String lastName,double taxNumber){
        this.taxNumber=taxNumber;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
    }
    Host(int userId, Date registration_date, String firstName, String lastName, Date dob, double taxNumber){
        this.taxNumber=taxNumber;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dob);
        set_Registration_Date(registration_date);}
    Host(int userId, String firstName, String lastName, double taxNumber,Date registration_date){
        this.taxNumber=taxNumber;
        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        set_Registration_Date(registration_date);}
    //-------------------------  GETTERS AND SETTERS START -------------------------
    /**
     * This method is used for getting the tax number.
     * @return taxNumber is the returned taxNumber.
     */
    public double getTaxNumber() {
        return taxNumber;}
    /**
     * This method is used for setting the taxNumber.
     * @param taxNumber this parameter is used for setting the taxNumber.
     */
    public void setTaxNumber(double taxNumber) {
        this.taxNumber = taxNumber;}
}
