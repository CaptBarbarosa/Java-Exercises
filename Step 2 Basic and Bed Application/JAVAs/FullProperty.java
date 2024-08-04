/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class FullProperty extends Property {
    private double propertySize;
    FullProperty(){
        this.propertySize=-1;}
    FullProperty(int propertID,int noRooms,float pricePerDay,Host property_owner,int propertySize){
        this.propertySize=propertySize;
        setPropertID(propertID);
        setNoRooms(noRooms);
        setPricePerDay(pricePerDay);
        setProperty_owner(property_owner);
    }
    FullProperty(int propertID,int noRooms,int noBedRooms,String city,float pricePerDay,Host property_owner,int propertySize){
        this.propertySize=propertySize;
        setPropertID(propertID);
        setNoRooms(noRooms);
        setNoBedRooms(noBedRooms);
        setCity(city);
        setPricePerDay(pricePerDay);
        setProperty_owner(property_owner);
    }
    /**
     * This method returns the property size.
     * @return propertySize is the returned size of the property.
     */
    public double getPropertySize() {
        return propertySize;}
    /**
     * This method sets the property size
     * @param propertySize is the size of our property that we'll set to.
     */
    public void setPropertySize(double propertySize) {
        this.propertySize = propertySize;}
    /**
     * This method is used to calculate the price paid per day with respect to the property size.
     */
    @Override
    public double calculatePricePerDay(){
        float tax;
        if(this.propertySize<200){
            tax=1;}
        else if(this.propertySize<300){
            tax=3;}
        else{
            tax=4;}
        return (1.0+tax/100)*getPricePerDay();}
}
