import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public abstract class User{
    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Date registration_date;
    //-------------------------  CONSTRUCTORS --------------------------------------
    User(){
        this.userId=-1;
        this.dateOfBirth=new Date();//null olabilir belki
        this.firstName="John";
        this.lastName="Doe";
        this.registration_date=new Date();//null olabilir belki
    }
    User(int given_id){
        this.userId=given_id;
    }
    User(int given_id,String given_name){
        this.userId=given_id;
        this.firstName=given_name;
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
     * This method returns the date of registration of a user.
     * @return registration_date This method returns the registration date of the user.
     */
    public Date get_Registration_Date() {
        return this.registration_date;}
    /**
     * This method sets the user's registration date to the given date.
     * @param registration_date This variable is the given date to set the date of registration.
     */
    public void set_Registration_Date(Date registration_date) {
        this.registration_date = registration_date;}
    //-------------------------  GETTERS AND SETTERS END -------------------------
}
