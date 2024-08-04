import java.util.Date;

/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class PopulateData {
    public static void populateData(BASIC basic_program){
        Host host_to_add;
        SharedProperty shared_property_to_add;
        FullProperty fullProperty_to_add;
        Booking booking_to_add;
        Date my_date,ending_date;
        User user_to_add;

        my_date=new Date(1998-1900,01,02);
        host_to_add=new Host(1,my_date,"Obi Wan ","Kenobi",100);
        shared_property_to_add = new SharedProperty(1,2,50,host_to_add);
        basic_program.users.add(host_to_add);
        basic_program.properties.add(shared_property_to_add);
        my_date=new Date(2023-1900,02,02);//The date here is for the start date of the booking.
        ending_date=new Date(2023-1900,02,03);//The date here is for the ending date of the booking.
        booking_to_add=new Booking(my_date,ending_date,true,1,shared_property_to_add);//Here I have created a booking to add to the user.
        user_to_add=new Gold(9,"Alexander","Alekhine","IDFK",1,booking_to_add); //Here I have created a user with booking and other details.
        basic_program.users.add(user_to_add);//I added the user I created to my Arraylist.

        host_to_add=new Host(2,"Admiral","Thrawn",200);
        fullProperty_to_add=new FullProperty(2,1,3,"New York",100,host_to_add,250);
        basic_program.users.add(host_to_add);
        basic_program.properties.add(fullProperty_to_add);
        my_date=new Date(2023-1900,03,03);
        ending_date=new Date(2023-1900,03,04);
        booking_to_add=new Booking(my_date,ending_date,true,1,fullProperty_to_add);
        user_to_add=new Standard(8,"Bobby","Fischer","Unknown",booking_to_add);
        basic_program.users.add(user_to_add);

        //Gold(int userId,String firstName, String lastName,String preferredPaymentMethod,int goldLevel)
        host_to_add=new Host(3,"Master","Yoda",300);
        fullProperty_to_add=new FullProperty(3,4,300,host_to_add,400);
        basic_program.users.add(host_to_add);
        basic_program.properties.add(fullProperty_to_add);
        my_date=new Date(2023-1900,03,03);
        ending_date=new Date(2023-1900,03,04);
        booking_to_add=new Booking(my_date,ending_date,true,1,fullProperty_to_add);
        user_to_add = new Gold(7,"Michael","Tal","Unknown",3,booking_to_add);
        basic_program.users.add(user_to_add);
    }
}
