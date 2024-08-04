import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.Date;

/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class PopulateData {
    /**
     * Populate data class is very unnecessary.
     * But I didn't want to delete it in case you want my code to automatically fill some values.
     */
    public static void populateData(BASIC basic_program){
        Host host_to_add;
        SharedProperty shared_property_to_add;
        FullProperty fullProperty_to_add;
        Booking booking_to_add;
        Date my_date,ending_date;
        User user_to_add;

        my_date=new Date(1998-1900,01,02); //BirthDate
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

    /**
     * If the .dat files exists it opens and reads them. Creates properties and users to a basic and returns that basic
     * @return to_return. to_return is the Basic returned.
     */
    public static BASIC read_and_fill_Data(){
        Date dob,rd;
        Gold gold_user_to_add;
        Standard standard_user_to_add;
        Host host_user_to_add;
        FullProperty full_property_to_add;
        SharedProperty shared_property_to_add;
        JFrame frame = new JFrame();
        BASIC to_return=new BASIC();
        DataInputStream gold_stream = null, standard_stream = null, host_stream = null, shared_property_stream = null, full_property_stream = null;
        java.io.File file = new java.io.File("gold.dat");
        if(file.exists()) {
            try {
                gold_stream = new DataInputStream(new FileInputStream("gold.dat"));
                String entire_line;
                String [] parts;
                while((entire_line= gold_stream.readLine())!=null){
                    parts=entire_line.split(",");
                    //System.out.println("--->>>Now Reading: "+entire_line);
                    gold_user_to_add=new Gold();
                    gold_user_to_add.setUserId(Integer.parseInt(parts[0]));
                    dob=to_return.createDate(parts[1]);
                    gold_user_to_add.setDateOfBirth(dob);
                    gold_user_to_add.setFirstName(parts[2]);
                    gold_user_to_add.setLastName(parts[3]);
                    rd=to_return.createDate(parts[4]);
                    gold_user_to_add.set_Registration_Date(rd);
                    gold_user_to_add.setPreferredPaymentMethod(parts[5]);
                    gold_user_to_add.setGoldLevel(Integer.parseInt(parts[6]));
                    to_return.users.add(gold_user_to_add);
                }
                gold_stream.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: Failed to create gold stream in reading", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        java.io.File standard_file = new java.io.File("standard.dat");
        if(standard_file.exists()) {
            try {
                standard_stream = new DataInputStream(new FileInputStream("standard.dat"));
                String entire_line;
                String [] parts;
                while((entire_line= standard_stream.readLine())!=null){
                    parts=entire_line.split(",");
                    //System.out.println("--->>>Now Reading: "+entire_line);
                    standard_user_to_add=new Standard();
                    standard_user_to_add.setUserId(Integer.parseInt(parts[0]));
                    dob=to_return.createDate(parts[1]);
                    standard_user_to_add.setDateOfBirth(dob);
                    standard_user_to_add.setFirstName(parts[2]);
                    standard_user_to_add.setLastName(parts[3]);
                    rd=to_return.createDate(parts[4]);
                    standard_user_to_add.set_Registration_Date(rd);
                    standard_user_to_add.setPreferredPaymentMethod(parts[5]);
                    to_return.users.add(standard_user_to_add);
                }
                standard_stream.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: Failed to create standard stream for reading the files", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        java.io.File host_file = new java.io.File("host.dat");
        if(host_file.exists()) {
            try {
                host_stream = new DataInputStream(new FileInputStream("host.dat"));
                String entire_line;
                String [] parts;
                while((entire_line= host_stream.readLine())!=null){
                    parts=entire_line.split(",");
                    //System.out.println("--->>>Now Reading: "+entire_line);
                    host_user_to_add=new Host();
                    host_user_to_add.setUserId(Integer.parseInt(parts[0]));
                    dob=to_return.createDate(parts[1]);
                    host_user_to_add.setDateOfBirth(dob);
                    host_user_to_add.setFirstName(parts[2]);
                    host_user_to_add.setLastName(parts[3]);
                    rd=to_return.createDate(parts[4]);
                    host_user_to_add.set_Registration_Date(rd);
                    host_user_to_add.setTaxNumber(Double.parseDouble(parts[5]));
                    to_return.users.add(host_user_to_add);
                }
                host_stream.close();
            } catch (Exception ex) {
                //System.out.println(ex);
                JOptionPane.showMessageDialog(frame, "Error: Failed to create host_stream for reading the files", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        java.io.File full_property_file = new java.io.File("full.dat");
        if(full_property_file.exists()){
            try{
                full_property_stream= new DataInputStream(new FileInputStream("full.dat"));
                String entire_line;
                String [] parts;
                while((entire_line= full_property_stream.readLine())!=null){
                    parts=entire_line.split(",");
                    full_property_to_add=new FullProperty();
                    full_property_to_add.setPropertID(Integer.parseInt(parts[0]));
                    full_property_to_add.setNoBedRooms(Integer.parseInt(parts[1]));
                    full_property_to_add.setNoRooms(Integer.parseInt(parts[2]));
                    full_property_to_add.setCity(parts[3]);
                    full_property_to_add.setPricePerDay(Float.parseFloat(parts[4]));
                    full_property_to_add.setPropertySize(Double.parseDouble(parts[5]));
                    to_return.properties.add(full_property_to_add);
                }
                full_property_stream.close();
            }catch (Exception ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(frame, "Error: Failed to create full_property_stream for reading the files", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        java.io.File shared_property_file = new java.io.File("shared.dat");
        if(shared_property_file.exists()){
            try{
                shared_property_stream= new DataInputStream(new FileInputStream("shared.dat"));
                String entire_line;
                String [] parts;
                while((entire_line= shared_property_stream.readLine())!=null){
                    parts=entire_line.split(",");
                    shared_property_to_add=new SharedProperty();
                    shared_property_to_add.setPropertID(Integer.parseInt(parts[0]));
                    shared_property_to_add.setNoBedRooms(Integer.parseInt(parts[1]));
                    shared_property_to_add.setNoRooms(Integer.parseInt(parts[2]));
                    shared_property_to_add.setCity(parts[3]);
                    shared_property_to_add.setPricePerDay(Float.parseFloat(parts[4]));
                    to_return.properties.add(shared_property_to_add);
                }
                shared_property_stream.close();
            }catch (Exception ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(frame, "Error: Failed to create shared_property_stream for reading the files", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return to_return;
    }

    /**
     * It gets a basic class. Reads its data and saves them to the correct .dat files.
     * @param basic_program is the basic class we got.
     */
    public static void save_the_BASIC(BASIC basic_program) {
        JFrame frame = new JFrame();
        DataOutputStream host_stream=null,gold_stream=null,standard_stream=null;
        try {
            host_stream     = new DataOutputStream(new FileOutputStream("host.dat"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: Failed to create host streams", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try{
            gold_stream     = new DataOutputStream(new FileOutputStream("gold.dat"));
        }catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Error: Failed to create gold streams", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try{
            standard_stream = new DataOutputStream(new FileOutputStream("standard.dat"));
        }catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Error: Failed to create standard streams", "Error", JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 0; i < basic_program.users.size(); i++) {
            //System.out.println("<<<<<<NOW DEALING WITH: "+basic_program.users.get(i).getFirstName());
            if (basic_program.users.get(i) instanceof Host){
                String registration_date_to_add=basic_program.users.get(i).get_Registration_Date().getDay()+"/"+basic_program.users.get(i).get_Registration_Date().getMonth()+"/"+(basic_program.users.get(i).get_Registration_Date().getYear()+1900);
                String birth_date_to_add=basic_program.users.get(i).getDateOfBirth().getDay()+"/"+basic_program.users.get(i).getDateOfBirth().getMonth()+"/"+(basic_program.users.get(i).getDateOfBirth().getYear()+1900);
                //System.out.println("--->Registration Date: "+registration_date_to_add+"\nBirth Date: "+birth_date_to_add);
                String to_save = basic_program.users.get(i).getUserId() + "," + birth_date_to_add + "," + basic_program.users.get(i).getFirstName() + "," + basic_program.users.get(i).getLastName() + "," + registration_date_to_add + "," + ((Host) basic_program.users.get(i)).getTaxNumber() + "\n";
                //System.out.println("--------->Host that I'll write is: " + to_save);
                try {
                    assert host_stream != null;
                    host_stream.write(to_save.getBytes());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error while writing to gold.dat", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (basic_program.users.get(i) instanceof Standard) {
                String registration_date_to_add=basic_program.users.get(i).get_Registration_Date().getDay()+"/"+basic_program.users.get(i).get_Registration_Date().getMonth()+"/"+(basic_program.users.get(i).get_Registration_Date().getYear()+1900);
                String birth_date_to_add=basic_program.users.get(i).getDateOfBirth().getDay()+"/"+basic_program.users.get(i).getDateOfBirth().getMonth()+"/"+(basic_program.users.get(i).getDateOfBirth().getYear()+1900);
                //System.out.println("--->Registration Date: "+registration_date_to_add+"\nBirth Date: "+birth_date_to_add);
                String to_save = basic_program.users.get(i).getUserId() + "," + birth_date_to_add + "," + basic_program.users.get(i).getFirstName() + "," + basic_program.users.get(i).getLastName() + "," + registration_date_to_add + "," +((Standard) basic_program.users.get(i)).getPreferredPaymentMethod()+"\n";
                //System.out.println("--------->STANDARD can be seen: " + to_save);
                try {
                    assert standard_stream != null;
                    standard_stream.write(to_save.getBytes());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error while writing to gold.dat", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (basic_program.users.get(i) instanceof Gold) {
                String registration_date_to_add=basic_program.users.get(i).get_Registration_Date().getDay()+"/"+basic_program.users.get(i).get_Registration_Date().getMonth()+"/"+(basic_program.users.get(i).get_Registration_Date().getYear()+1900);
                String birth_date_to_add=basic_program.users.get(i).getDateOfBirth().getDay()+"/"+basic_program.users.get(i).getDateOfBirth().getMonth()+"/"+(basic_program.users.get(i).getDateOfBirth().getYear()+1900);
                //System.out.println("--->Registration Date: "+registration_date_to_add+"\nBirth Date: "+birth_date_to_add);
                String to_save = basic_program.users.get(i).getUserId() + "," + birth_date_to_add + "," + basic_program.users.get(i).getFirstName() + "," + basic_program.users.get(i).getLastName() + "," + registration_date_to_add + "," +((Gold) basic_program.users.get(i)).getPreferredPaymentMethod()+","+((Gold) basic_program.users.get(i)).getGoldLevel()+"\n";
                //System.out.println("--->>>i is:"+ i +" Now Writing: " + to_save);
                try {
                    assert gold_stream != null;
                    gold_stream.write(to_save.getBytes());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error while writing to gold.dat", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        DataOutputStream shared_property_stream=null, full_property_stream=null;
        try {
            full_property_stream = new DataOutputStream(new FileOutputStream("full.dat"));
            shared_property_stream = new DataOutputStream(new FileOutputStream("shared.dat"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: Failed to create one or more streams", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(int i=0;i<basic_program.properties.size();i++){
            if(basic_program.properties.get(i) instanceof SharedProperty){
                String to_save = basic_program.properties.get(i).getPropertID()+","+basic_program.properties.get(i).getNoBedRooms()+","+basic_program.properties.get(i).getNoRooms()+","+basic_program.properties.get(i).getCity()+","+basic_program.properties.get(i).getPricePerDay()+"\n";
                try{
                    assert shared_property_stream != null;
                    shared_property_stream.write(to_save.getBytes());
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(frame, "Error while writing to shared.dat", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(basic_program.properties.get(i) instanceof FullProperty){
                String to_save = basic_program.properties.get(i).getPropertID()+","+basic_program.properties.get(i).getNoBedRooms()+","+basic_program.properties.get(i).getNoRooms()+","+basic_program.properties.get(i).getCity()+","+basic_program.properties.get(i).getPricePerDay()+","+((FullProperty) basic_program.properties.get(i)).getPropertySize()+"\n";
                try{
                    assert full_property_stream != null;
                    full_property_stream.write(to_save.getBytes());
                }
                catch (Exception ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(frame, "Error while writing to shared.dat", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
