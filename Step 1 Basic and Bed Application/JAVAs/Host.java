import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class Host{
    private int hostID;
    private String firstName;
    private String lastName;
    private Date registrationDate;
    //private ArrayList<Property> hosts_properties; #Bunu yanlış anlamış olabilirim.
    //-------------------------  CONSTRUCTORS -------------------------
    Host(){
        this.hostID=0;
        this.firstName="John";
        this.lastName="Doe";
        this.registrationDate=new Date();
        //this.hosts_properties=new ArrayList<>();
    }
    Host(int hostID){
        this.hostID=hostID;
    }
    Host(int hostID,String firstName, String lastName){
        this.hostID=hostID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.registrationDate=new Date();
    }
    Host(int hostID,String firstName, String lastName, Date reg_date_from_user){
        this.hostID=hostID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.registrationDate=reg_date_from_user;
    }

    //-------------------------  GETTERS AND SETTERS START -------------------------

    /**
     * This method used for getting the host id.
     * @return hostID This is the variable that is host ID.
     */
    public int getHostID() {
        return hostID;}

    /**
     * This method is used for setting the host id.
     * @param hostID is the variable we set our host id to.
     */
    public void setHostID(int hostID) {
        this.hostID = hostID;}

    /**
     * This method allows us to get the first name of the host.
     * @return firstName is the first name of the host.
     */
    public String getFirstName() {
        return firstName;}
    /**
     * This method allows us to set the first name of the host.
     * @param firstName is the first we want to set for the host.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;}

    /**
     * This method allows us to get the last name of the user.
     * @return lastName is the last name of the host we are getting.
     */
    public String getLastName() {
        return lastName;}

    /**
     * This method allows us to set the last name of the host.
     * @param lastName is the variable we are setting our hosts last name to.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;}

    /**
     * This method allows us to get the registration date.
     * @return registrationDate is the registration date variable.
     */
    public Date getRegistrationDate() {
        return registrationDate;}

    /**
     * This method allows us to set the registration date of the user.
     * @param registrationDate is the date we are setting our registration date.
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;}
    //-------------------------  GETTERS AND SETTERS END -------------------------
}