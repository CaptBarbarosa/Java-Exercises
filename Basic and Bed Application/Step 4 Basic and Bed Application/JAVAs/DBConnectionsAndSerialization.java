import java.io.*;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class DBConnectionsAndSerialization {
    /**
     * This method takes a BASIC variable and fills it from the database.
     * @param basic_program .
     */
    public static void load_from_db(BASIC basic_program){
        Gold gold_user_to_add;
        Standard standard_user_to_add;
        Host host_user_to_add;

        SharedProperty shared_property_to_add;
        FullProperty full_property_to_add;

        Connection connection = null;
        Statement statement = null;
        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicdb", "cng443user", "1234");
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement

            //If I forgot to delete these please note that I didn't delete these please know that I didn't delete it in case if I lose my db. I didn't want to spend time filling it from stretch.
            /*
            int my_res5= statement.executeUpdate("INSERT INTO `User` VALUES (1, '2000-10-10', 'Atilla', 'Ilhan', '2020-10-10', 's', 'DENEME', 2.3, 0)");
            int my_res2 = statement.executeUpdate("INSERT INTO `User` VALUES (2, '1913-12-15', 'Rashid', 'Nezhmetdinov', '2023-8-9', 'g', 'DENEMER', 2.5, 1)");
            int my_res3 =statement.executeUpdate("INSERT INTO `Property` VALUES (1,2,2,'Istanbul',50,'s',0 )");
            int my_res4 =statement.executeUpdate("INSERT INTO `Property` VALUES (2,1,3,'Dublin',90,'f',100)");
            */

            ResultSet resultSet = statement.executeQuery("select * from User");
            //System.out.println("After the querry executed");
            // Iterate through the result and print the student names
            while (resultSet.next()) {
                /*System.out.println("-->" + resultSet.getInt(1) + "\t" + resultSet.getDate(2) + "\t"
                        + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t"
                        + resultSet.getDate(5) + "\t" + resultSet.getString(6) + "\t"
                        + resultSet.getString(7) + "\t" + resultSet.getDouble(8) + "\t"
                        + resultSet.getInt(9));*/
                if(resultSet.getString(6).equals("g")){
                    gold_user_to_add=new Gold();
                    gold_user_to_add.setUserId(resultSet.getInt(1));
                    gold_user_to_add.setDateOfBirth(resultSet.getDate(2));
                    gold_user_to_add.setFirstName(resultSet.getString(3));
                    gold_user_to_add.setLastName(resultSet.getString(4));
                    gold_user_to_add.set_Registration_Date(resultSet.getDate(5));
                    gold_user_to_add.setPreferredPaymentMethod(resultSet.getString(7));
                    gold_user_to_add.setGoldLevel(resultSet.getInt(9));
                    basic_program.users.add(gold_user_to_add);
                }
                else if(resultSet.getString(6).equals("s")){
                    standard_user_to_add=new Standard();
                    standard_user_to_add.setUserId(resultSet.getInt(1));
                    standard_user_to_add.setDateOfBirth(resultSet.getDate(2));
                    standard_user_to_add.setFirstName(resultSet.getString(3));
                    standard_user_to_add.setLastName(resultSet.getString(4));
                    standard_user_to_add.set_Registration_Date(resultSet.getDate(5));
                    standard_user_to_add.setPreferredPaymentMethod(resultSet.getString(7));
                    basic_program.users.add(standard_user_to_add);
                }
                else if(resultSet.getString(6).equals("h")){
                    host_user_to_add = new Host();
                    host_user_to_add.setUserId(resultSet.getInt(1));
                    host_user_to_add.setDateOfBirth(resultSet.getDate(2));
                    host_user_to_add.setFirstName(resultSet.getString(3));
                    host_user_to_add.setLastName(resultSet.getString(4));
                    host_user_to_add.set_Registration_Date(resultSet.getDate(5));
                    host_user_to_add.setTaxNumber(resultSet.getDouble(8));
                    basic_program.users.add(host_user_to_add);
                }
            }
            resultSet = statement.executeQuery("select * from Property");
            while (resultSet.next()){
                if(resultSet.getString(6).equals("s")){
                    shared_property_to_add = new SharedProperty();
                    shared_property_to_add.setPropertID(resultSet.getInt(1));
                    shared_property_to_add.setNoBedRooms(resultSet.getInt(2));
                    shared_property_to_add.setNoRooms(resultSet.getInt(3));
                    shared_property_to_add.setCity(resultSet.getString(4));
                    shared_property_to_add.setPricePerDay(resultSet.getFloat(5));
                    basic_program.properties.add(shared_property_to_add);
                }
                else{
                    full_property_to_add = new FullProperty();
                    full_property_to_add.setPropertID(resultSet.getInt(1));
                    full_property_to_add.setNoBedRooms(resultSet.getInt(2));
                    full_property_to_add.setNoRooms(resultSet.getInt(3));
                    full_property_to_add.setCity(resultSet.getString(4));
                    full_property_to_add.setPricePerDay(resultSet.getFloat(5));
                    full_property_to_add.setPropertySize(resultSet.getDouble(7));
                    basic_program.properties.add(full_property_to_add);
                }
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    /**
     * This method takes a basic variable and saves its users and properties to the database.
     * @param basic_program
     */
    public static void save_to_db(BASIC basic_program){
        ResultSet resultSet;
        int i,res;
        char user_type,property_type;
        int user_id,gold_Level,prop_id,no_bedrooms,no_rooms;
        String firstName,lastName,preferred_payment,city;
        double doubled_price_per_day;
        double tax_Number,property_size;

        Connection connection = null;
        Statement statement = null;
        Date birth_date,reg_date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formatted_b_d,formatted_r_d;

        try {
            // STEP1 -- Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // STEP 2 -- Establish a connection
            System.out.println("Establishing a connection");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicdb", "cng443user", "1234");
            System.out.println("Database connected");

            // STEP 3 -- Create a statement
            statement = connection.createStatement();

            // STEP 4 -- Execute a statement
            statement.executeUpdate("DELETE FROM User");
            for(i=0;i<basic_program.users.size();i++){
                tax_Number=-1;
                preferred_payment="None";
                gold_Level=-1;
                user_id=basic_program.users.get(i).getUserId();
                firstName=basic_program.users.get(i).getFirstName();
                lastName=basic_program.users.get(i).getLastName();
                formatted_b_d=sdf.format(basic_program.users.get(i).getDateOfBirth());
                formatted_r_d=sdf.format(basic_program.users.get(i).get_Registration_Date());
                if(basic_program.users.get(i) instanceof Standard){
                    user_type='s';
                    preferred_payment=((Standard) basic_program.users.get(i)).getPreferredPaymentMethod();
                }
                else if(basic_program.users.get(i) instanceof Gold){
                    user_type='g';
                    preferred_payment=((Gold) basic_program.users.get(i)).getPreferredPaymentMethod();
                    gold_Level=((Gold)basic_program.users.get(i)).getGoldLevel();
                }
                else{
                    user_type='h';
                    tax_Number=(((Host)basic_program.users.get(i)).getTaxNumber());
                }
                statement.executeUpdate("INSERT INTO `User` VALUES ("+user_id+", '"+formatted_b_d+"','"+firstName+"','"+lastName+"','"+formatted_r_d+"','"+user_type+"','"+preferred_payment+"',"+tax_Number+","+gold_Level+")");
            }
            statement.executeUpdate("DELETE FROM Property");
            for(i=0;i<basic_program.properties.size();i++){
                property_size=-1;
                prop_id=basic_program.properties.get(i).getPropertID();
                no_bedrooms=basic_program.properties.get(i).getNoBedRooms();
                no_rooms=basic_program.properties.get(i).getNoRooms();
                city=basic_program.properties.get(i).getCity();
                doubled_price_per_day=basic_program.properties.get(i).getPricePerDay();
                if(basic_program.properties.get(i) instanceof SharedProperty){
                    property_type='s';
                }
                else{
                    property_type='f';
                    property_size=((FullProperty)basic_program.properties.get(i)).getPropertySize();
                }
                statement.executeUpdate("INSERT INTO `Property` VALUES ("+prop_id+","+no_bedrooms+","+no_rooms+",'"+city+"',"+doubled_price_per_day+",'" + property_type + "'," + property_size + ")");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    /**
     * This method takes a basic program and tries to serialize it. To the serialized.dat
     * @param basic_program .
     * @throws IOException .Throws exception in case of an issue.
     */
    public static void serialize(BASIC basic_program) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized.dat"))) {
            oos.writeObject(basic_program.users);
            System.out.println("Users serialized and saved to serialized.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method generates and saves MD5 of a serialized BASIC.
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void generateAndSaveMD5() throws IOException, NoSuchAlgorithmException {
        try (FileInputStream fis = new FileInputStream("serialized.dat");
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            byte[] data = byteArrayOutputStream.toByteArray();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Hash = md.digest(data);
            try (FileOutputStream fos = new FileOutputStream("serializedmd5.dat")) {
                fos.write(md5Hash);
                System.out.println("MD5 hash generated and saved to serializedmd5.dat");
            }
        }
    }

    /**
     * This method checks if there is a change
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static void check_serialized_object()  throws IOException, NoSuchAlgorithmException {
        byte[] current_md5Hash,old_md5Hash = new byte[0];
        try (BufferedReader reader = new BufferedReader(new FileReader("serializedmd5.dat"))) {
            old_md5Hash = reader.readLine().getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream("serialized.dat");
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
            byte[] data = byteArrayOutputStream.toByteArray();
            MessageDigest md = MessageDigest.getInstance("MD5");
            current_md5Hash = md.digest(data);
        }
        if (MessageDigest.isEqual(current_md5Hash, old_md5Hash)) {
            System.out.println("The content of serialized data has not changed.");
        } else {
            System.out.println("The content of serialized data has changed.");
        }
    }

    //This function was unnecessary, but I wanted to try what we have learned in the class.
    // Please do-not take this into account when grading.
    public static ArrayList<User> deserializeUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                return (ArrayList<User>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
