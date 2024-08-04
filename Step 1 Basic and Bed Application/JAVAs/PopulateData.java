import java.util.Date;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class PopulateData {
    public static void populateData(BASIC basic_program){//I was required to fill the class with some made-up data and here I did that.
        Host host_to_add;
        Property property_to_add;
        Booking booking_to_add;
        Date my_date,ending_date;
        User user_to_add;

        my_date=new Date(1998-1900,01,02);//The date here is for the registrationDate of the host.
        host_to_add=new Host(1,"Obi Wan ","Kenobi",my_date);
        property_to_add=new Property(1,2,5,"California",1500,host_to_add);//Here I created a property with a host.
        basic_program.properties.add(property_to_add);//I added the property I created to my arraylist.
        my_date=new Date(2023-1900,02,02);//The date here is for the start date of the booking.
        ending_date=new Date(2023-1900,02,03);//The date here is for the ending date of the booking.
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);//Here I have created a booking to add to the user.
        user_to_add=new User(1,"Alexander","Alekhine",booking_to_add,my_date); //Here I have created a user with booking and other details.
        basic_program.users.add(user_to_add);//I added the user I created to my Arraylist.

        //In the below, I basically did what I did in the upper. I was carefull not to repeat IDs.
        my_date=new Date(1999-1900,02,03);
        host_to_add=new Host(2,"Admiral","Thrawn",my_date);
        property_to_add=new Property(2,1,3,"New York",1700,host_to_add);
        basic_program.properties.add(property_to_add);
        my_date=new Date(2023-1900,03,03);
        ending_date=new Date(2023-1900,03,04);
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);
        user_to_add=new User(2,"Bobby","Fischer",booking_to_add,my_date);
        basic_program.users.add(user_to_add);

        my_date=new Date(2000-1900,03,04);
        host_to_add=new Host(3,"Master","Yoda",my_date);
        property_to_add=new Property(3,3,2,"Florida",1400,host_to_add);
        basic_program.properties.add(property_to_add);
        my_date=new Date(2023-1900,04,05);
        ending_date=new Date(2023-1900,04,06);
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);
        user_to_add=new User(3,"Michael","Tal",booking_to_add,my_date);
        basic_program.users.add(user_to_add);
    }
}
