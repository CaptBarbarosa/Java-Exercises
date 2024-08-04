import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * This class is written Kaan Tandogan and JDK21 is used.
 * @author KAAN TANDOGAN 2316784
 * @version JDK21
 */
public class BASIC{
    /**
     * This is the main function. I am not doing a lot here, actually. It just holds my program.
     * @param args Main gets the command line arguments if exists.
     */

    public static void main(String[] args) {
        BASIC basic_program=new BASIC();
        PopulateData.populateData(basic_program);
        //basic_program.populateData(basic_program);
        basic_program.menu();
    }
    protected ArrayList<User> users;
    protected ArrayList<Property>properties;

    /**
     * This is the Constructor of the BASIC class.
     */
    BASIC(){
        users=new ArrayList<User>();
        properties=new ArrayList<Property>();
    }
    //-------------------------  GETTERS AND SETTERS START -------------------------

    /**
     * Getter of the User
     * @return users this method returns the users.
     */
    public ArrayList<User> getUsers() {
        return users;}

    /**
     * Setter of the user.
     * @param users .When a user is given this function sets it.
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;}

    /**
     * Getter of the Property.
     * @return properties .
     */
    public ArrayList<Property> getProperties() {
        return properties;}

    /**
     * Setter of the Property.
     * @param properties it sets the properties if given by the user.
     */
    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;}
    //-------------------------  GETTERS AND SETTERS END -------------------------

    /**
     * In the populateData method at the beginning I created a date for the registrationDate variable of the host, and then created the host.
     * Afterwards, I created the property. And added the host I created in the previous step. And added the property I created to my arrayList.
     * Then I created 2 dates. One for the starting and one for the ending date of the booking.
     * I created a new booking with some made-up values and added the 2 dates I created in the previous step and the property I created 2 steps ago.
     * Then created a user and put the booking I created a step ago.
     * I have done this 3 times.
     * Please note that I set isPaid to true. Because I didn't want user tp be confused when calculating the totalCost(Total cost doesn't count the already paid bookings)
     */
    /*
    public void populateData(){//I was required to fill the class with some made-up data and here I did that.
        Host host_to_add;
        Property property_to_add;
        Booking booking_to_add;
        Date my_date,ending_date;
        User user_to_add;

        my_date=new Date(1998-1900,01,02);//The date here is for the registrationDate of the host.
        host_to_add=new Host(1,"Obi Wan ","Kenobi",my_date);
        property_to_add=new Property(1,2,5,"California",1500,host_to_add);//Here I created a property with a host.
        properties.add(property_to_add);//I added the property I created to my arraylist.
        my_date=new Date(2023-1900,02,02);//The date here is for the start date of the booking.
        ending_date=new Date(2023-1900,02,03);//The date here is for the ending date of the booking.
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);//Here I have created a booking to add to the user.
        user_to_add=new User(1,"Alexander","Alekhine",booking_to_add,my_date); //Here I have created a user with booking and other details.
        users.add(user_to_add);//I added the user I created to my Arraylist.

        //In the below, I basically did what I did in the upper. I was carefull not to repeat IDs.
        my_date=new Date(1999-1900,02,03);
        host_to_add=new Host(2,"Admiral","Thrawn",my_date);
        property_to_add=new Property(2,1,3,"New York",1700,host_to_add);
        properties.add(property_to_add);
        my_date=new Date(2023-1900,03,03);
        ending_date=new Date(2023-1900,03,04);
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);
        user_to_add=new User(2,"Bobby","Fischer",booking_to_add,my_date);
        users.add(user_to_add);

        my_date=new Date(2000-1900,03,04);
        host_to_add=new Host(3,"Master","Yoda",my_date);
        property_to_add=new Property(3,3,2,"Florida",1400,host_to_add);
        properties.add(property_to_add);
        my_date=new Date(2023-1900,04,05);
        ending_date=new Date(2023-1900,04,06);
        booking_to_add=new Booking(my_date,ending_date,true,1,property_to_add);
        user_to_add=new User(3,"Michael","Tal",booking_to_add,my_date);
        users.add(user_to_add);
    }
    */
    /**
     * Shows the menu and provides user with some options.
     */
    public void menu(){ //This part of my code doesn't reeally  need explanation. I just asked user what s/he wants to do and directed the user to the appropriate place.
        int selected;
        Scanner input_scanner=new Scanner(System.in);
        do {
            System.out.println("\n-------------------------------------------------------\nWhat would you like to do?\nPress:\n1.) To add user.\n2.) To delete a user\n3.) To get user details.\n4.) To add property.\n5.)To delete property\n6.)To get property details.\n7.)To add booking.\n8) To get user bookings.\n9.) To get booking costs.\n10.) To list users.\n11.) To list properties.\n12.) To exit.\n-------------------------------------------------------\n");
            System.out.print("Please enter your selection: ");
            selected=input_scanner.nextInt();
            if(selected<0 || selected > 12){
                System.out.println("Please enter an input within the range of 1 and 11.");}
            else if(selected==1){
                int id_to_add;
                System.out.print("Enter the id of the member you want to add: ");
                id_to_add=input_scanner.nextInt();
                addUser(id_to_add);}
            else if(selected==2){
                int target_id;
                System.out.print("Enter the id of the member you want to delete: ");
                target_id=input_scanner.nextInt();
                deleteUser(target_id);}
            else if(selected==3){
                int id_to_search;
                System.out.print("Enter the id of the user you want to get details of: ");
                id_to_search=input_scanner.nextInt();
                getUserDetails(id_to_search);}
            else if (selected==4){
                addProperty();}
            else if (selected==5){
                int id_to_del;
                System.out.print("Enter the id of the property you want to delete: ");
                id_to_del=input_scanner.nextInt();
                deleteProperty(id_to_del);
            }
            else if (selected==6){
                int prop_id;
                System.out.print("Enter a property id: ");
                prop_id=input_scanner.nextInt();
                getProperyDetails(prop_id);
            }
            else if(selected==7){
                int user_id,property_id;
                System.out.print("Please enter a user id: ");
                user_id=input_scanner.nextInt();
                System.out.print("Please enter a property id: ");
                property_id=input_scanner.nextInt();
                addBooking(user_id,property_id);
            }
            else if (selected==8){
                int user_id;
                System.out.print("Please enter a user id: ");
                user_id=input_scanner.nextInt();
                getUserBooking(user_id);
            }
            else if (selected==9){
                int user_id,property_id;
                System.out.print("Please enter a user id: ");
                user_id=input_scanner.nextInt();
                System.out.print("Please enter a property id: ");
                property_id=input_scanner.nextInt();
                getBookingCost(user_id,property_id);
            }
            else if (selected==10){
                listUser();}
            else if(selected==11){
                listProperties();}
        }while (selected!=12);
        exit();

    }

    /**
     * This method creates a Date. There are a lot of things to consider when creating a date.
     * For example user should enter 3 "/" operators. If more or less entered the method should warn the user.
     * It checks if the dates and the months are making sense. For example, a user shouldn't be able to enter 14th month. Or 37th day.
     * @return to_return Returns the date it has created.
     */
    public Date createDate(){ //In this part of my code I basically created the date. I checked whether or not the user provided some non-sensical data. For example 13'th month or 32th day of the month.
        Date to_return=new Date();
        Scanner input_scanner=new Scanner(System.in);
        String date_entered;
        boolean exit_condition=false;
        int day,month,year;
        do{
            System.out.print("Enter the date in dd/MM/yyyy format: "); //Took the string
            date_entered=input_scanner.next();
            String [] parts= date_entered.split("/"); //Splitted the parts
            if (parts.length == 3 && parts[0].length() == 2 && parts[1].length() == 2 && parts[2].length() == 4){ //If more than necessary "/" entered gave error.
                day=Integer.parseInt(parts[0]);
                if(day<0 || day >31){ //If day is out of the limit I gave warning.
                    System.out.println("You entered an invalid date!!");
                }
                else{
                    month=Integer.parseInt(parts[1]);
                    if(month<0 || month > 12){
                        System.out.println("You entered an invalid month!!!");
                    }
                    else{
                        year=Integer.parseInt(parts[2]);
                        to_return=new Date(year-1900,month,day);
                        exit_condition=true;
                    }
                }
            }
        }while(!exit_condition);
        return to_return;
    }

    /**
     * This method checks whether or not the id given by the user already exists in the arraylist and if exists it gives warning, for a new user a new id is required.
     * While writing this code I thought the user must enter a name and surname under all circumstances but date of birth shouldn't be mandatory. So I provide the user with option of passing the date of birth if s/he wishes to do so.
     * @param id_to_add .This parameter is the id that I want to create a user with.
     */
    public void addUser(int id_to_add) { //This part of my code is for adding user. I basically checked the user id(To see if the user already exists.) and added if the id doens't exists.
        Scanner input_scanner = new Scanner(System.in);
        boolean is_valid = true;
        int different_users_id;
        String name, surname, dob;
        for (int i = 0; i < users.size(); i++) {
            different_users_id = users.get(i).getUserId(); //Here I got the user's id.
            if (different_users_id == id_to_add) { //Here I checked and gave warning if the id is already there.
                System.out.println("A user with the id of " + id_to_add + " already exists. Please enter a unique id!");
                is_valid = false;
                break;
            }
        }
        if (is_valid) { // If the user with the specified ID doesn't exists. I asked name and surname. The user(you) can add the the user with the name and surname. However, adding a birthday is not mandatory for I have a constructor for both if the d.o.b is entered and not entered.
            System.out.print("\nPlease enter the user name: ");
            name = input_scanner.next();
            System.out.print("\nPlease enter the user surname: ");
            surname = input_scanner.next();
            System.out.println("If you want to include the user's date of birth enter it in the format of dd/MM/yyyy else just write pass.");
            dob = input_scanner.next();
            if (dob.equals("pass")) {
                User user_to_add = new User(id_to_add, name, surname);
                users.add(user_to_add);
            }
            else {
                Date date_to_add_to_user=createDate();
                User user_to_add = new User(id_to_add, date_to_add_to_user, name, surname);
                users.add(user_to_add);
            }
        }
    }

    /**
     * This method checks whether the user with the given id exists in the arraylist or not. If the user doesn't exist, it gives warning and if exists it removes him/her
     * @param target_id this parameter is used for finding the target.
     */
    public void deleteUser(int target_id){ // Just like the previous example, the user might mistakely try to delete a user that doesn't exists in the array. So for that I checked whether or not the user with the specified ID exists. If doesn't exists I gave a warning. And if exists I deleted it.
        boolean is_found=false;
        for (int i=0;i<this.users.size();i++){ //Here I am checking all of my users array.
            if (target_id == this.users.get(i).getUserId()){ //If the ID matches I delete it here.
                is_found=true;
                this.users.remove(this.users.get(i)); //I deleted it here.
                System.out.println("The user with the id "+target_id+" is deleted!!\n"); //Told the operation is successfull.
                break;
            }
        }
        if(!is_found){ //If the user not found I gave warning to the user.
            System.out.println("The user with the id"+target_id+" is not found.");
        }
    }

    /**
     * After traversing the arraylist if the user exists this method publishes the details of that user.
     * If the user doesn't exist in the list, this method gives a warning.
     * @param id_to_search this parameter is used for searching the user.
     */
    public void getUserDetails(int id_to_search){//In this method, checked whether the user exists. Gave details if the user exists and gave warning otherwise.
        int current_id; //Current id is the id of the user I am checking at that instance.
        boolean is_found=false;
        for(int i=0;i<this.users.size();i++){
            current_id=this.users.get(i).getUserId(); //Got the id of the user I am checking at that instant.
            if(current_id==id_to_search){ //If the id's match I am giving the details of that user.
                System.out.println("the first name is: "+users.get(i).getFirstName()+" the last name is: "+users.get(i).getLastName()+" D.O.B. is: "+users.get(i).getDateOfBirth());
                is_found=true;
                break;
            }
        }
        if(!is_found){
            System.out.println("User with id "+id_to_search+" not found");
        }
    }

    /**
     * The addProperty method creates a property. As understandable, all properties should have and host. And therefore this method first checks whether the host with the given id exists or not.
     * If the host with the id doesn't exist it asks the user whether it wants to check for another id or it wants to create a new user with the ID s/he specified.
     * After these steps it starts to create a new property. User has to enter a price for day for it is necessary for our future calculations. But other than that, this method
     * provides user with some sort of options on which property constructor the user wants to use.
     */
    public void addProperty(){
        Scanner input_scanner = new Scanner(System.in);
        int id, host_id, property_host_index=-1, noBedRooms, noRooms;
        float pricePerDay=-1;
        boolean exit_condition=false,is_host_found=false;
        String city,user_decision,host_name,host_surname,wants_to_add_date;
        Date host_date;
        Host host_of_the_property=new Host(); // Even though I am getting the host in every situation, the assignment asked me to construct it.
                // This first do-while loop is about whether the Property owner exists or not.
        do{//The property needs to have a host. In this do-while loop I checked whether the host exists or not. If the host with the given ID doesn't exists I gave the user 2 options. Asked if the user wishes to create a host or would like to check a host with another id.
            System.out.print("Please enter the ID of the host of the property: ");
            host_id=input_scanner.nextInt();//I got the host id to check whether the host exists here.
            for (int i=0;i<this.properties.size();i++){ //In this for loop I checked the host. If the host exists my program shouldn't ask whether the user wants to add a host. So I have is_host_found boolean here.
                if(this.properties.get(i).property_owner.getHostID()==host_id){
                    property_host_index=i; //To add a property I need a host. If the host exists I can get the host from property index.
                    is_host_found=true;
                    exit_condition=true;
                    break;
                }
            }
            if (!is_host_found){//There are 3 constructors other than the default constructor in the Host.java. With respect to user's decision I chose one of them.
                System.out.print("The host with the specified ID couldn't been found. You can either check for another host or you can add a new host. Would you like to add the host?(y/n): ");
                user_decision=input_scanner.next();
                if(user_decision.equals("y")){//If the user wants to add a host I am doing it in this if statement. I thought of creating a function called host_creation() but this is only used here. So I decided against it.
                    System.out.print("Please enter the host id: ");
                    host_id=input_scanner.nextInt();
                    System.out.print("\nPlase enter the host name (If you want to pass write pass): "); //I have a constructor for Host with just id. So I can give the user the choice of passing this.
                    host_name=input_scanner.next();
                    if(!host_name.equals("pass")){ //I the user decides not to pass the user has to enter a surname because I don't have a constructor for just id and name.
                        System.out.print("\nPlease enter the host name: ");
                        host_surname=input_scanner.next();
                        System.out.println("Do you want to add date(y/n): "); //Adding the registration date is up to user.
                        wants_to_add_date=input_scanner.next();
                        if(wants_to_add_date.equals("y")){
                            host_date=createDate();
                            host_of_the_property=new Host(host_id,host_name,host_surname,host_date);
                            exit_condition=true;
                        }
                        else {
                            host_of_the_property=new Host(host_id,host_name,host_surname);
                            exit_condition=true;
                        }
                    }
                    else {
                        host_of_the_property=new Host(host_id);
                        exit_condition=true;
                    }
                }
            }
            else {//If the host with the specified ID already exists then I am getting it here.
                host_of_the_property=this.properties.get(property_host_index).property_owner;
            }
        }while(!exit_condition);

        do{//In this part of my code I got the property ID. The property ID has to be unique. So, if the user enters a Property ID that already exists, my program give a warning.
            System.out.print("Please enter a property id: ");
            id=input_scanner.nextInt();
            exit_condition=false;
            for(int i=0;i<this.properties.size();i++){
                    if (id==this.properties.get(i).getPropertID()){
                        exit_condition=true;
                        break;}}
            if(exit_condition){
                System.out.println("A property with that id already exists!!");}
        }while (exit_condition);
        do{
            exit_condition=true;
            System.out.print("Enter the price per day: ");
            pricePerDay=input_scanner.nextFloat();
            if (pricePerDay<0){
                System.out.println("You need to enter a value greater than 0.");
                exit_condition=false;
            }
        }while (!exit_condition);
        //In the property class I have 3 constructors. Here and below, I got which constructor the user wishes to use.
        System.out.print("Enter the number of bedrooms (If you wish not to enter press -1): ");
        noBedRooms=input_scanner.nextInt();
        if(noBedRooms==-1){
            System.out.println("Enter the name of the city (If you wish not to enter write 'pass')");
            city=input_scanner.next();
            if(city.equals("pass")){
                Property property_to_add=new Property(id,pricePerDay,host_of_the_property);
                this.properties.add(property_to_add);
            }
            else {
                Property property_to_add=new Property(id,city,pricePerDay,host_of_the_property);
                this.properties.add(property_to_add);
            }
        }
        else{
            do {
                exit_condition=false;
                System.out.println("Enter the number of Rooms: ");
                noRooms=input_scanner.nextInt();
                if(noRooms>0){
                    exit_condition=true;
                }
            }while (!exit_condition);
            System.out.println("Enter the name of the city: ");
            city=input_scanner.next();
            Property property_to_add=new Property(id, noBedRooms, noRooms, city, pricePerDay,host_of_the_property);
            this.properties.add(property_to_add);
        }

    }
    /**
     * In the deleteProperty we do get a id to delete integer from the user. After that, we are checking if the Property with the given id exists.
     * If the id doesn't exist, we are giving a warning to the user about the issue.
     * And if the id exists we are deleting it.
     * You can check the code more in detail.
     * @param id_to_del With the id_to_del parameter we are searching the property.
     */
    public void deleteProperty(int id_to_del){ // I got the id of the property that I want to delete, I checked it's existance and delete it if exists, gave warning if it doesn't.
        boolean is_exists=false;
        for(int i=0;i<properties.size();i++){
            if (this.properties.get(i).getPropertID()==id_to_del){
                is_exists=true;
                System.out.println("The user with the id "+id_to_del+" is deleted!!\n");
                this.properties.remove(this.properties.get(i));
                break;
            }
        }
        if(!is_exists){
            System.out.println("The property with the specified id doesn't exists!!!");
        }
    }

    /**
     * This method publishes the property details if the property with the specified if exists. If the property doesn't exist the method gives warning.
     * @param prop_id This parameter is used for searching the property.
     */
    public void getProperyDetails(int prop_id){ // In this part of my code I got the property id from the user. Checked whether or not the property with the specified id exists. And showed it's details if exists. Gave warning if it doesn't.
        boolean is_found=false;
        for (int i=0;i<this.properties.size();i++){
            if(prop_id==this.properties.get(i).getPropertID()){
                is_found=true;
                System.out.println("The property id is: "+this.properties.get(i).getPropertID()+" number of bedrooms is: "+this.properties.get(i).getNoBedRooms()+" the number of rooms is: "+this.properties.get(i).getNoRooms()+" city the property is in is: "+this.properties.get(i).getCity()+" the price per day is: "+this.properties.get(i).getPricePerDay()+" and the property id is: "+this.properties.get(i).getPropertID());
            }
        }
        if(!is_found){
            System.out.println("The property with the specified id couldn't be found!!!");
        }
    }

    /**
     * This function allows the user of the application to add booking to a specific user to a specific property.
     * Because of the different booking constructors this method is able to provide user with some decision-making.
     * Takes user id and takes property id. Controls their existence and gives warning in case of an error. And creates a booking if there are no problems.
     * @param user_id This is user id parameter which is necessary for checking the existence of the user.
     * @param property_id This is property id parameter which is necessary for checking the existence of the property.
     */
    public void addBooking(int user_id,int property_id){
        boolean valid_user_id=false,valid_property_id=false;
        int user_index=0,property_index=0;
        Date starting_date,ending_date;
        String is_paid;
        Scanner input_scanner = new Scanner(System.in);
        for(int i=0;i<this.users.size();i++){ //In this part of the code I checked whether the entered user_id exists or not.Got its index if exists.
            if(this.users.get(i).getUserId()==user_id){
                valid_user_id=true;
                user_index=i;
                break;
            }
        }
        if(!valid_user_id){//Gave an error message if the user doesn't exists.
            System.out.println("The user id entered is not valid!");
        }
        for (int i=0;i<this.properties.size();i++){ //In this part,I checked whether or not the property ID given exists. Got its index if exists.
            if(this.properties.get(i).getPropertID()==property_id){
                property_index=i;
                valid_property_id=true;
                break;
            }
        }
        if(!valid_property_id){//Gave an error message if the property doesn't exists.
            System.out.println("The property id entered is not valid!");
        }
        if(valid_property_id && valid_user_id){
            System.out.println("Now please enter the starting date of the booking");
            starting_date=createDate();
            System.out.println("Now please enter the ending date of the booking");
            ending_date=createDate();//I have to have the starting and ending date of the booking.
            System.out.print("Did the user paid for the booking (y/n) (To pass this question write pass)");
            is_paid=input_scanner.next();
            if(is_paid.equals("y")){
                Booking to_add=new Booking(starting_date,ending_date,true,property_id,this.properties.get(property_index));
                this.users.get(user_index).setUsers_Booking(to_add);
            }
            else if(is_paid.equals("n")){
                Booking to_add=new Booking(starting_date,ending_date,false,property_id,this.properties.get(property_index));
                this.users.get(user_index).setUsers_Booking(to_add);
            }
            else if(is_paid.equals("pass")){
                Booking to_add=new Booking(starting_date,ending_date,property_id,this.properties.get(property_index));
                this.users.get(user_index).setUsers_Booking(to_add);

            }
        }
    }

    /**
     * If the user exists this method shows all of its bookings and if the user doesn't exist it gives an error message.
     * @param user_id This is user_id parameter, an integer, used for checking the existence of a given user.
     */
    public void getUserBooking(int user_id){ //In this part of my code I got the bookings of the specified user.
        boolean is_found=false;
        for(int i=0;i<this.users.size();i++){
            if(this.users.get(i).getUserId()==user_id){
                System.out.println("The user with the id "+user_id+" has the following bookings:");
                is_found=true;
                this.users.get(i).show_users_Bookings(); //I send to the show the users booking method in the User.java class.
            }
        }
        if(!is_found){
            System.out.println("This user with the id: "+user_id+" doesn't exists ");
        }
    }

    /**
     * This method gets the users id and a property id, and if the user made any booking on that property it gives the total booking cost.
     * @param userId The userId is used for checking the existence of the user.
     * @param propertyId The propertyId is used for checking the existence of the property.
     * Checks whether the user exists or not and if exists checks for the existence of the property. If the property isn't found it gives a warning and if the property is found
     * it calculates the cost with the help of totalCost method, which is a method of the User class, and adds the costs. If there is more than one booking on a given property
     * it adds all of them.
     */
    public void getBookingCost(int userId, int propertyId){ //At the beginning I checked whether or not the user exists. If exists I checked whether the property exists. And if the property exists I got the totalCost from the booking and added if there is more than one booking to the same property by the same user.
        boolean user_found=false,property_found=false;
        int user_index,property_index=0;
        float total_cost=0;
        for(user_index=0;user_index<this.users.size();user_index++){ //Checked if the user entered exists.
            if(userId==this.users.get(user_index).getUserId()){
                user_found=true;
                break;}
        }
        if(!user_found){
            System.out.println("The user with the id: "+userId+" couldn't be found");
        }
        else {
            for (int i = 0; i < this.users.get(user_index).users_Booking.size(); i++) {
                if (!this.users.get(user_index).users_Booking.get(i).isPaid()) {
                    total_cost += this.users.get(user_index).users_Booking.get(i).totalCost();
                    property_found = true;}
            }
            if(!property_found){
                System.out.println("Property with the id: "+propertyId+" couldn't been found");}
        }
        if(property_found){
            System.out.println("The total cost of user "+userId+" is: "+total_cost);}
    }

    /**
     * This method shows all the active users ,if a user is deleted it doesn't show.
     */
    public void listUser(){
        System.out.println("\n---------------\nThe users are as follows:");
        for(int i=0;i<users.size();i++) {
            System.out.println("For user: "+i +" the user id is:"+users.get(i).getUserId()+" the first name is: "+users.get(i).getFirstName()+" the last name is: "+users.get(i).getLastName()+" D.O.B. is: "+users.get(i).getDateOfBirth());}
    }

    /**
     * Shows all the active properties, if a property is deleted it doesn't show.
     */
    public void listProperties(){
        System.out.println("\n---------------\nThe properties are as follows:");
        for(int i=0;i<properties.size();i++){
            System.out.println("For property: "+i+" the id is:"+properties.get(i).getPropertID()+" number of bedrooms is: "+properties.get(i).getNoBedRooms()+" number of rooms is: "+properties.get(i).getNoRooms()+ " city is: "+properties.get(i).getCity()+" and price per day is: "+properties.get(i).getPricePerDay());
        }
    }

    /**
     * Tells Goodbye as all good programs should do ...
     */
    public void exit(){
        System.out.println("GOOODBYEE");}
}
