// Kaan Tandogan
// 2316784
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BASIC {
    public static void main(String[] args) {
        //BASIC basic_program = new BASIC();
        BASIC basic_program=PopulateData.read_and_fill_Data();
        //PopulateData.populateData(basic_program);
        JFrame main_frame = basic_program.menu(basic_program);
        //for(int i=0;i<basic_program.users.size();i++){ System.out.println("->The user in the system is: "+basic_program.users.get(i).getFirstName()+" "+basic_program.users.get(i).getLastName());}
    }
    protected ArrayList<User> users;
    protected ArrayList<Property> properties;
    BASIC() {
        users=new ArrayList<User>();
        properties=new ArrayList<Property>();
    }
    /**
     * This listener listens what the user has chosen in menu and proceeds to the correct method.
     */
    public JFrame menu(BASIC my_basic) {
        //System.out.println("IN THE MENU");
        JFrame frame = new JFrame("BASIC APPLICATION"); //Frame Name
        JPanel mainPanel = new JPanel(new BorderLayout()); //Created my panel.

        JMenu menu; //I am told to use menu. So I am using it here.
        JMenuItem i1;
        JMenuBar mb = new JMenuBar();
        menu= new JMenu("About Author");
        i1=new JMenuItem("Kaan Tandogan 2316784");
        menu.add(i1);
        mb.add(menu);
        frame.setJMenuBar(mb);


        // Created my panel here.
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        //Below I created different buttons for the options.
        JButton add_user = new JButton("Add User");
        JButton delete_user = new JButton("Delete User");
        JButton get_user_details = new JButton("Get User Details");
        JButton add_property = new JButton("Add Property");
        JButton delete_property = new JButton("Delete Property");
        JButton get_property_details = new JButton("Get Property Details");
        JButton add_booking = new JButton("Add Booking");
        JButton get_booking_cost = new JButton("Get Booking Cost");
        JButton get_user_booking = new JButton("Get User Booking");
        JButton list_users = new JButton("List Users");
        JButton list_properties = new JButton("List Properties");
        JButton get_discount = new JButton("Get Discount For User");
        JButton add_inspection = new JButton("Add Inspection To Property");
        JButton compare = new JButton("Compare Property Prices");

        // I added the buttons to my panel.
        buttonPanel.add(add_user);
        buttonPanel.add(delete_user);
        buttonPanel.add(get_user_details);
        buttonPanel.add(add_property);
        buttonPanel.add(delete_property);
        buttonPanel.add(get_property_details);
        buttonPanel.add(add_booking);
        buttonPanel.add(get_booking_cost);
        buttonPanel.add(get_user_booking);
        buttonPanel.add(list_users);
        buttonPanel.add(list_properties);
        buttonPanel.add(get_discount);
        buttonPanel.add(add_inspection);
        buttonPanel.add(compare);
        JPanel selectPanel = new JPanel();
        JLabel selectLabel = new JLabel("Select:");
        selectPanel.add(selectLabel);

        mainPanel.add(selectPanel, BorderLayout.WEST);// I added the Select panel to the left side
        mainPanel.add(buttonPanel, BorderLayout.CENTER);// I added the button panel to the center

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 500); // I adjusted the size accordingly
        frame.setLocationRelativeTo(null);

        ButtonListener listener = new ButtonListener();
        add_user.addActionListener(listener);
        delete_user.addActionListener(listener);
        get_user_details.addActionListener(listener);
        add_property.addActionListener(listener);
        delete_property.addActionListener(listener);
        get_property_details.addActionListener(listener);
        add_booking.addActionListener(listener);
        get_booking_cost.addActionListener(listener);
        get_user_booking.addActionListener(listener);
        list_users.addActionListener(listener);
        list_properties.addActionListener(listener);
        get_discount.addActionListener(listener);
        add_inspection.addActionListener(listener);
        compare.addActionListener(listener);

        frame.setTitle("BASIC_ASSIGNMENT_3");
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                PopulateData.save_the_BASIC(my_basic);
            }
        });

        return frame;
    }
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { //Here I am basically checking with button the user pressed. So I can go to the correct method.
            if (e.getSource() instanceof JButton) {
                JButton sourceButton = (JButton) e.getSource();
                System.out.println("User selected: " + sourceButton.getText());
                if(sourceButton.getText().equals("Add User")){
                    addUser();
                }
                else if(sourceButton.getText().equals("Delete User")){
                    deleteUser();
                }
                else if(sourceButton.getText().equals("Get User Details")){
                    getUserDetails();
                }
                else if(sourceButton.getText().equals("Add Property")){
                    addProperty();
                }
                else if(sourceButton.getText().equals("Delete Property")){
                    deleteProperty();
                }
                else if(sourceButton.getText().equals("Get Property Details")){
                    getPropertyDetails();
                }
                else if(sourceButton.getText().equals("Add Booking")){
                    addBooking();
                }
                else if(sourceButton.getText().equals("Get Booking Cost")){
                    getBookingCost();
                }
                else if(sourceButton.getText().equals("Get User Booking")){
                    getUserBooking();
                }
                else if(sourceButton.getText().equals("List Users")){
                    listUsers();
                }
                else if(sourceButton.getText().equals("List Properties")){
                    listProperties();
                }
                else if(sourceButton.getText().equals("Get Discount For User")){
                    getUserDiscount();
                }
                else if(sourceButton.getText().equals("Add Inspection To Property")){
                    addInspection();
                }
                else if(sourceButton.getText().equals("Compare Property Prices")){
                    comparePropertyClasses();
                }
            }
        }
    }

    //-----------------------------THIS PART IS FOR ADDING USER--------------------------------------------------------
    public void addUser(){ //Here I have created my GUI. I used ComboBox for giving the user to choose between a host or customer.
        JFrame frame = new JFrame("Host and Client Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Select whether you want to add a host or client");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Host", "Client"});
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(comboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton moveForwardButton = new JButton("Move Forward");

        addUserButtonListener listener = new addUserButtonListener(comboBox);

        moveForwardButton.addActionListener(listener);

        buttonPanel.add(moveForwardButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(comboBoxPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * This listener gets what the user has chosen and proceeds to the correct method.
     */
    private class addUserButtonListener implements ActionListener { //Here I checked whether the user selected host or customer.
        private final JComboBox<String> comboBox;
        public addUserButtonListener(JComboBox<String> comboBox) {
            this.comboBox = comboBox;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedOption = (String) comboBox.getSelectedItem();
            Window window = SwingUtilities.windowForComponent(comboBox);
            if (window instanceof JFrame) {
                JFrame frame = (JFrame) window;
                frame.dispose();
            }
            System.out.println("User selected: " + selectedOption);
            if(selectedOption.equals("Host")){
                addHost();
            }
            else{
                addCustomer();
            }

        }
    }
    public void addHost() { // I created another GUI for user to enter the details of the host.
        JFrame hostFrame = new JFrame("Host Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(400, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(7, 2));
        hostPanel.add(new JLabel("(*)User ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);
        hostPanel.add(new JLabel("Name"));
        JTextField nameField = new JTextField();
        hostPanel.add(nameField);
        hostPanel.add(new JLabel("Surname"));
        JTextField surnameField = new JTextField();
        hostPanel.add(surnameField);
        hostPanel.add(new JLabel("Date Of Birth(dd/MM/yyyy) if you want to skip write pass"));
        JTextField dobField = new JTextField();
        hostPanel.add(dobField);
        hostPanel.add(new JLabel("Registration Date(dd/MM/yyyy format)"));
        JTextField regDateField = new JTextField();
        hostPanel.add(regDateField);
        hostPanel.add(new JLabel("(*)Please enter a tax number"));
        JTextField taxNumberField = new JTextField();
        hostPanel.add(taxNumberField);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new HostButtonListener(nameField, surnameField, taxNumberField, dobField, regDateField, userIDField,hostFrame));
        hostPanel.add(nextButton);

        hostFrame.add(hostPanel);
        hostFrame.setVisible(true);
    }
    /**
     * This listener gets what fields the user has filled and creates and saves the host wrt to the fields filled.
     */
    private class HostButtonListener implements ActionListener { //Just like the previous ones this one also listens. And creates a host if there are no problems.
        private JTextField nameField;
        private JTextField surnameField;
        private JTextField taxNumberField;
        private JTextField dobField;
        private JTextField regDateField;
        private JTextField userIDField;
        private JFrame hostFrame;
        public HostButtonListener(JTextField nameField, JTextField surnameField, JTextField taxNumberField, JTextField dobField, JTextField regDateField, JTextField userIDField, JFrame hostFrame) {
            this.nameField = nameField;
            this.surnameField = surnameField;
            this.taxNumberField = taxNumberField;
            this.dobField = dobField;
            this.regDateField = regDateField;
            this.userIDField=userIDField;
            this.hostFrame = hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the button click event here
            // You can access the text from the fields using getText() method
            boolean all_is_well=true,correct_user_id_entered=true;
            int user_id=0,different_users_id;
            String name = nameField.getText();
            String surname = surnameField.getText();
            double taxNumber=0;
            Date dob=null;
            Date regDate = null;
            JFrame frame = new JFrame("Error message");

            try {
                user_id = Integer.parseInt(userIDField.getText());
                taxNumber = Double.parseDouble(taxNumberField.getText());
                if(user_id<0){ //Made sure  user_id is positive.
                    JOptionPane.showMessageDialog(frame, "Error: User ID cannot be less than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    all_is_well=false;
                    correct_user_id_entered=false;
                }
                if(taxNumber<0){//Made sure tax number is positive.
                    JOptionPane.showMessageDialog(frame, "Error: Tax Number has to be positive", "Error", JOptionPane.ERROR_MESSAGE);
                    all_is_well=false;
                }
                if(!dobField.getText().isEmpty()){ //If date of birth is not empty I took it and made sure the date is entered in right format.
                    System.out.println("Text got is: "+regDateField.getText());
                    dob = createDate(regDateField.getText());
                    if(dob==null) {
                        JOptionPane.showMessageDialog(frame, "Error: You entered the birth date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
                if(!regDateField.getText().isEmpty()){//If date of registration is not empty I took it and made sure the date is entered in right format.
                    regDate=createDate(regDateField.getText());
                    if(regDate==null){
                        JOptionPane.showMessageDialog(frame, "Error: You entered the registration date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
            }
            catch (Exception ex){ // If the user enters characters and stuff it gives an error.
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user id AND tax number", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
                correct_user_id_entered=false;
            }

            if(correct_user_id_entered){ //Checked whether the entered user id has a duplicate.
                for (int i = 0; i < users.size(); i++) { //If the user id entered is in a valid form(Not a char or string and positive) I checked the existence of the user.
                    different_users_id = users.get(i).getUserId(); //Here I got the user's id.
                    if (different_users_id == user_id) { //Here I checked and gave warning if the id is already there.
                        String message = "A user with the id of " + user_id + " already exists. Please enter a unique id!";
                        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well=false;
                        break;
                    }
                }
            }

            // For example, print the values
            if(all_is_well) { //If everthing is fine for know I created a host user and added that to my users.
                //System.out.println("Name: " + name + "Surname: " + surname+"Tax Number: " + taxNumber+"Date of Birth: " + dob+"Registration Date: " + regDate+"User ID: " + user_id);
                Host host_to_add=new Host();
                host_to_add.setUserId(user_id);
                host_to_add.setTaxNumber(taxNumber);
                if(!nameField.getText().isEmpty()){ host_to_add.setFirstName(name); }
                if(!surnameField.getText().isEmpty()){ host_to_add.setLastName(surname); }
                if(dob!=null){ host_to_add.setDateOfBirth(dob); }
                if(regDate!=null){ host_to_add.set_Registration_Date(regDate); }
                users.add(host_to_add);
                hostFrame.dispose();
            }
        }
    }
    public void addCustomer() { // Created a GUI where user has to choose between standard or gold
        JFrame customerFrame = new JFrame("Customer Type");
        customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerFrame.setSize(400, 300);
        customerFrame.setLocationRelativeTo(null);

        String[] customerTypes = {"Standard", "Gold"};
        JComboBox<String> customerTypeComboBox = new JComboBox<>(customerTypes);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new selectedCustomertypeButtonListener());

        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.add(new JLabel("Select Customer Type:"));
        customerPanel.add(customerTypeComboBox);
        customerPanel.add(nextButton);

        JScrollPane scrollPane = new JScrollPane(customerPanel);

        customerFrame.add(scrollPane);
        customerFrame.setVisible(true);
    }
    /**
     * This listener gets what the kind of customer(Gold/Standard) the user has chosen and adds it.
     */
    private class selectedCustomertypeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { // I listened what entered and go to the correct method.
            JComboBox<String> customerTypeComboBox = (JComboBox<String>) ((Component) e.getSource()).getParent().getComponent(1);
            String selectedCustomerType = (String) customerTypeComboBox.getSelectedItem();
            System.out.println("Selected Customer Type: " + selectedCustomerType);

            JFrame customerFrame = (JFrame) SwingUtilities.getWindowAncestor(customerTypeComboBox);
            if (customerFrame != null) {
                customerFrame.dispose();
            }
            if (selectedCustomerType.equals("Standard")){
                addStandardUser();
            }
            else{
                addGoldUser();
            }
        }
    }
    public void addStandardUser(){ //If the user decides to create a standard user this GUI gets opened.
        JFrame hostFrame = new JFrame("Standard User Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(400, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(7, 2));
        hostPanel.add(new JLabel("(*)User ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);
        hostPanel.add(new JLabel("Name"));
        JTextField nameField = new JTextField();
        hostPanel.add(nameField);
        hostPanel.add(new JLabel("Surname"));
        JTextField surnameField = new JTextField();
        hostPanel.add(surnameField);
        hostPanel.add(new JLabel("Date Of Birth(dd/MM/yyyy)"));
        JTextField dobField = new JTextField();
        hostPanel.add(dobField);
        hostPanel.add(new JLabel("Registration Date(dd/MM/yyyy format)"));
        JTextField registrationField = new JTextField();
        hostPanel.add(registrationField);
        hostPanel.add(new JLabel("Preferred Payment Method"));
        JTextField paymentMethodField = new JTextField();
        hostPanel.add(paymentMethodField);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new AddStandardUserActionListener(userIDField, nameField, surnameField, dobField, registrationField, paymentMethodField));
        hostPanel.add(nextButton);

        hostFrame.add(hostPanel);
        hostFrame.setVisible(true);
    }

    /**
     * This listener gets the text areas filled by user. Gives error in case of an error and creates
     * and creates standard user and saves it.
     */
    private class AddStandardUserActionListener implements ActionListener {
        private JTextField nameField;
        private JTextField surnameField;
        private JTextField dobField;
        private JTextField registrationField;
        private JTextField paymentMethodField;
        private JTextField userID;

        public AddStandardUserActionListener(JTextField userIDField, JTextField nameField, JTextField surnameField, JTextField dobField, JTextField registrationField, JTextField paymentMethodField) {
            this.nameField = nameField;
            this.surnameField = surnameField;
            this.dobField = dobField;
            this.registrationField = registrationField;
            this.paymentMethodField = paymentMethodField;
            this.userID = userIDField;
        }

        @Override
        public void actionPerformed(ActionEvent e) { //Here I almost have done the same thing what I have done in the add host method.
            boolean all_is_well=true,correct_user_id_entered=true;
            int user_id=0,different_users_id;
            String name = nameField.getText();
            String surname = surnameField.getText();
            Date dob=null;
            Date regDate = null;
            JFrame frame = new JFrame("Error message");
            String payment_method=null;

            try { //I gave various warnings.
                user_id = Integer.parseInt(userID.getText());
                if(user_id<0){
                    JOptionPane.showMessageDialog(frame, "Error: User ID cannot be less than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    all_is_well=false;
                    correct_user_id_entered=false;
                }
                if(!dobField.getText().isEmpty()){
                    dob = createDate(registrationField.getText());
                    System.out.println("dob is: "+dob);
                    if(dob==null) {
                        JOptionPane.showMessageDialog(frame, "Error: You entered the birth date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
                if(!registrationField.getText().isEmpty()){
                    regDate=createDate(registrationField.getText());
                    if(regDate==null){
                        JOptionPane.showMessageDialog(frame, "Error: You entered the registration date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
                if(paymentMethodField.getText()!=null){
                    payment_method=paymentMethodField.getText();
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
                correct_user_id_entered=false;
            }
            if(correct_user_id_entered){ //Checked whether the entered user id has a duplicate.
                for(int i = 0; i < users.size(); i++) {
                    different_users_id = users.get(i).getUserId(); //Here I got the user's id.
                    if (different_users_id == user_id) { //Here I checked and gave warning if the id is already there.
                        String message = "A user with the id of " + user_id + " already exists. Please enter a unique id!";
                        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well=false;
                        break;
                    }
                }
            }
            if(all_is_well) { // If everything is fine I created a new standard user and added to the users of the BASIC.
                //System.out.println("Name: " + name + "Surname: " + surname+"Tax Number: " + taxNumber+"Date of Birth: " + dob+"Registration Date: " + regDate+"User ID: " + user_id);
                Standard standard_user_to_add=new Standard();
                standard_user_to_add.setUserId(user_id);
                if(!nameField.getText().isEmpty()){ standard_user_to_add.setFirstName(name); }
                if(!surnameField.getText().isEmpty()){ standard_user_to_add.setLastName(surname); }
                if(dob!=null){ standard_user_to_add.setDateOfBirth(dob); }
                if(regDate!=null){ standard_user_to_add.set_Registration_Date(regDate); }
                if(payment_method!=null){standard_user_to_add.setPreferredPaymentMethod(payment_method);}
                users.add(standard_user_to_add);
                JOptionPane.showMessageDialog(null, "Standard User added successfully!");
            }
            JFrame hostFrame = (JFrame) SwingUtilities.getWindowAncestor(nameField);
            if (hostFrame != null) {
                hostFrame.dispose();
            }
        }
    }
    public void addGoldUser(){ //Created a GUI that asks user to add necessary parts for the creation of Gold user type.
        JFrame hostFrame = new JFrame("Gold User Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(400, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(8, 2));
        hostPanel.add(new JLabel("(*)User ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);
        hostPanel.add(new JLabel("Name"));
        JTextField nameField = new JTextField();
        hostPanel.add(nameField);
        hostPanel.add(new JLabel("Surname"));
        JTextField surnameField = new JTextField();
        hostPanel.add(surnameField);
        hostPanel.add(new JLabel("Date Of Birth(dd/MM/yyyy) if you want to skip write pass"));
        JTextField dobField = new JTextField();
        hostPanel.add(dobField);
        hostPanel.add(new JLabel("Registration Date(dd/MM/yyyy format)"));
        JTextField registrationField = new JTextField();
        hostPanel.add(registrationField);
        hostPanel.add(new JLabel("Preferred Payment Method"));
        JTextField paymentMethodField = new JTextField();
        hostPanel.add(paymentMethodField);
        hostPanel.add(new JLabel("(*)Gold Level(1,2 or 3)"));//To be honest I wasn't very relaxed with comboboxes and after failing couple of times I decided to take this as a text.
        JTextField goldLevelField = new JTextField();
        hostPanel.add(goldLevelField);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new AddGoldUserActionListener(userIDField, nameField, surnameField, dobField, registrationField, paymentMethodField,goldLevelField));
        hostPanel.add(nextButton);

        hostFrame.add(hostPanel);
        hostFrame.setVisible(true);
    }
    /**
     * This listener gets the text areas filled by user. Gives error in case of an error and creates
     * and creates gold user and saves it.
     */
    private class AddGoldUserActionListener implements ActionListener { //Listened and gave warning in case of an error. And created and added a Gold user if there is none.
        private JTextField nameField;
        private JTextField surnameField;
        private JTextField dobField;
        private JTextField registrationField;
        private JTextField paymentMethodField;
        private JTextField userID;
        private JTextField goldLevelField;

        public AddGoldUserActionListener(JTextField userIDField, JTextField nameField, JTextField surnameField, JTextField dobField, JTextField registrationField, JTextField paymentMethodField, JTextField goldLevelField) {
            this.nameField = nameField;
            this.surnameField = surnameField;
            this.dobField = dobField;
            this.registrationField = registrationField;
            this.paymentMethodField = paymentMethodField;
            this.userID = userIDField;
            this.goldLevelField = goldLevelField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean all_is_well=true,correct_user_id_entered=true;
            int user_id=0,different_users_id;
            String name = nameField.getText();
            String surname = surnameField.getText();
            Date dob=null;
            Date regDate = null;
            JFrame frame = new JFrame("Error message");
            String payment_method="unspecified";
            int gold_level=-1;

            try { //I checked whether the user id and gold level entered are correct.
                user_id = Integer.parseInt(userID.getText());
                gold_level=Integer.parseInt(goldLevelField.getText());
                if(user_id<0){
                    JOptionPane.showMessageDialog(frame, "Error: User ID cannot be less than 0", "Error", JOptionPane.ERROR_MESSAGE);
                    all_is_well=false;
                    correct_user_id_entered=false;
                }
                if(gold_level<0 || gold_level>3){
                    JOptionPane.showMessageDialog(frame, "Error: Gold Level can only be 1,2 or 3", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(!dobField.getText().isEmpty()){
                    dob = createDate(registrationField.getText());
                    System.out.println("dob is: "+dob);
                    if(dob==null) {
                        JOptionPane.showMessageDialog(frame, "Error: You entered the birth date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
                if(!registrationField.getText().isEmpty()){
                    regDate=createDate(registrationField.getText());
                    if(regDate==null){
                        JOptionPane.showMessageDialog(frame, "Error: You entered the registration date in a wrong style", "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well = false;
                    }
                }
                if(!paymentMethodField.getText().isEmpty()){
                    payment_method=paymentMethodField.getText();
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID and goldLevel", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
                correct_user_id_entered=false;
            }
            if(correct_user_id_entered){ //Checked whether the entered user id has a duplicate.
                for(int i = 0; i < users.size(); i++) {
                    different_users_id = users.get(i).getUserId(); //Here I got the user's id.
                    if (different_users_id == user_id) { //Here I checked and gave warning if the id is already there.
                        String message = "A user with the id of " + user_id + " already exists. Please enter a unique id!";
                        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
                        all_is_well=false;
                        break;
                    }
                }
            }

            if(all_is_well) { //If there are no trouble, my code creates and adds a gold user to users of BASIC
                //System.out.println("Name: " + name + "Surname: " + surname+"Tax Number: " + taxNumber+"Date of Birth: " + dob+"Registration Date: " + regDate+"User ID: " + user_id);
                Gold gold_user_to_add = new Gold();
                gold_user_to_add.setUserId(user_id);
                if(!nameField.getText().isEmpty()){ gold_user_to_add.setFirstName(name); }
                if(!surnameField.getText().isEmpty()){ gold_user_to_add.setLastName(surname); }
                if(dob!=null){ gold_user_to_add.setDateOfBirth(dob); }
                if(regDate!=null){ gold_user_to_add.set_Registration_Date(regDate); }
                if(payment_method!=null){gold_user_to_add.setPreferredPaymentMethod(payment_method);}
                if(gold_level!=-1){gold_user_to_add.setGoldLevel(gold_level);}
                users.add(gold_user_to_add);
                JOptionPane.showMessageDialog(null, "Gold User added successfully!");
            }

            JFrame hostFrame = (JFrame) SwingUtilities.getWindowAncestor(nameField);
            if (hostFrame != null) {
                hostFrame.dispose();
            }
        }
    }
    //-----------------------------END OF THE ADDING USER--------------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR DELETING USER------------------------------------------------------
    public void deleteUser(){ //Created a GUI for delete user
        JFrame hostFrame = new JFrame("Delete User");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter User ID to delete"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new deleteUserButtonListener(userIDField,hostFrame));
        //hostPanel.add(nextButton);

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }

    /**
     * This method gets the fields entered by the user.
     * Gives warning in case of an error and deletes if a valid id entered
     */
    private class deleteUserButtonListener implements ActionListener {
        private JTextField userIDField;
        private JFrame hostFrame;
        public deleteUserButtonListener(JTextField userIDField, JFrame hostFrame) {
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int user_id=0,different_users_id,user_index=0;
            boolean all_is_well=true,existing_user_id_entered=false;
            JFrame frame = new JFrame();
            try { //Checked the validity of the entered user id.
                user_id = Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
            }
            if(all_is_well){ //Checked whether the entered user id exist.
                for(int i = 0; i < users.size(); i++) {
                    different_users_id = users.get(i).getUserId(); //Here I got the user's id.
                    if (different_users_id == user_id) {
                        existing_user_id_entered=true;
                        user_index=i;
                        break;
                    }
                }
            }
            if(!existing_user_id_entered){
                all_is_well=false;
            }
            if(all_is_well){
                users.remove(users.get(user_index));
                String message = "A user with the id of " + user_id + " is found. Now deleting";
                JOptionPane.showMessageDialog(frame, message);
            }
            else{
                String message = "Deletion operation is UNSUCCESFUL";
                JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Close the hostFrame (if needed)
            hostFrame.dispose();
        }
    }
    //-----------------------------END OF THE DELETE USER--------------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING USER DETAILS-----------------------------------------------
    public void getUserDetails(){ //Created a GUI that asks for user id to be entered
        JFrame hostFrame = new JFrame("Get User Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter user ID to see their details"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new getUserDetailsButtonListener(userIDField,hostFrame));
        //hostPanel.add(nextButton);//Buna gerek kalmadı

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }

    /**
     * This method gets the user id.
     * Checks it validity and gives details if the valid id is entered. Gives warning otherwise.
     */
    private class getUserDetailsButtonListener implements ActionListener {
        private JTextField userIDField;
        private JFrame hostFrame;
        public getUserDetailsButtonListener(JTextField userIDField, JFrame hostFrame) {
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int user_id=0,different_users_id,user_index=0;
            boolean all_is_well=true,existing_user_id_entered=false;
            JFrame frame = new JFrame();
            try { //Checked a correct form of user id is entered.
                user_id = Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
            }
            if(all_is_well){ //Checked whether the entered user id exist.
                for(int i = 0; i < users.size(); i++) {
                    different_users_id = users.get(i).getUserId(); //Here I got the user's id.
                    if (different_users_id == user_id) { //Here I checked its existence in our array list.
                        existing_user_id_entered=true;
                        user_index=i;
                        break;
                    }
                }
            }
            if(!existing_user_id_entered){
                all_is_well=false;
            }
            if(all_is_well){ //I gave different info in panels with respect to the users type.
                //users.remove(users.get(user_index));
                if(users.get(user_index) instanceof Standard) {
                    String message = "ID: " + users.get(user_index).getUserId() + "\n BirthDay: "+users.get(user_index).getDateOfBirth()+"\n First Name: "+users.get(user_index).getFirstName()+"\n Last Name: "+users.get(user_index).getLastName()+"\n RegistrationDate: "+users.get(user_index).get_Registration_Date()+"\n Preferred Payment method: "+((Standard) users.get(user_index)).getPreferredPaymentMethod();
                    JOptionPane.showMessageDialog(frame, message);
                }
                else if(users.get(user_index) instanceof Gold) {
                    String message = "ID: " + users.get(user_index).getUserId() + "\n BirthDay: "+users.get(user_index).getDateOfBirth()+"\n First Name: "+users.get(user_index).getFirstName()+"\n Last Name: "+users.get(user_index).getLastName()+"\n RegistrationDate: "+users.get(user_index).get_Registration_Date()+"\n Preferred Payment method: "+((Gold) users.get(user_index)).getPreferredPaymentMethod()+"\n Gold Level:"+((Gold) users.get(user_index)).getGoldLevel();
                    JOptionPane.showMessageDialog(frame, message);
                }
                else if(users.get(user_index) instanceof Host){
                    String message = "ID: " + users.get(user_index).getUserId() + "\n BirthDay: "+users.get(user_index).getDateOfBirth()+"\n First Name: "+users.get(user_index).getFirstName()+"\n Last Name: "+users.get(user_index).getLastName()+"\n RegistrationDate: "+users.get(user_index).get_Registration_Date()+"\n tax Number: "+((Host) users.get(user_index)).getTaxNumber();
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
            else{
                String message = "Wasn't able to find the user with the specified ID. Operation UNSUCCESFUL";
                JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
            hostFrame.dispose();
        }
    }

    //-----------------------------END FOR GETTING USER DETAILS--------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR ADDING PROPERTY----------------------------------------------------
    public void addProperty(){ //Created a GUI that forces user to select either shared or full.
        JFrame frame = new JFrame("Add Property");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Select whether you want to add a shared or full Property");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Shared", "Full"});
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(comboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton moveForwardButton = new JButton("Move Forward");

        addPropertyButtonListener listener = new addPropertyButtonListener(comboBox);

        moveForwardButton.addActionListener(listener);

        buttonPanel.add(moveForwardButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(comboBoxPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    /**
     * Gets what kind of property does the user wants to add.
     */
    private class addPropertyButtonListener implements ActionListener { // I listened the users decision and go to the correct method with respect to it.
        private final JComboBox<String> comboBox;

        public addPropertyButtonListener(JComboBox<String> comboBox) {
            this.comboBox = comboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedOption = (String) comboBox.getSelectedItem();
            Window window = SwingUtilities.windowForComponent(comboBox);
            if (window instanceof JFrame) {
                JFrame frame = (JFrame) window;
                frame.dispose();
            }
            System.out.println("User selected: " + selectedOption);
            if(selectedOption.equals("Shared")){
                addSharedProperty();
            }
            else{
                addFullProperty();
            }
        }
    }
    public void addFullProperty(){ // I created a GUI that asks user to enter some information about property and its owner.
        JFrame hostFrame = new JFrame("Full Property Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(400, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(8, 2));
        hostPanel.add(new JLabel("(*)ID of the Property Owner"));
        JTextField hostIDField = new JTextField();
        hostPanel.add(hostIDField);
        hostPanel.add(new JLabel("(*)ID of the property"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);
        hostPanel.add(new JLabel("Number of Bedrooms"));
        JTextField bedroomnumberField = new JTextField();
        hostPanel.add(bedroomnumberField);
        hostPanel.add(new JLabel("Number of Rooms"));
        JTextField roomnumberField = new JTextField();
        hostPanel.add(roomnumberField);
        hostPanel.add(new JLabel("City"));
        JTextField cityField = new JTextField();
        hostPanel.add(cityField);
        hostPanel.add(new JLabel("Price Per Day"));
        JTextField pricePerDayField = new JTextField();
        hostPanel.add(pricePerDayField);
        hostPanel.add(new JLabel("Property Size"));
        JTextField propertySizeField = new JTextField();
        hostPanel.add(propertySizeField);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new addFullPropertyListener(hostIDField, propertyIDField, bedroomnumberField, roomnumberField, cityField, pricePerDayField, propertySizeField, hostFrame));
        hostPanel.add(nextButton);

        hostFrame.add(hostPanel);
        hostFrame.setVisible(true);
    }

    /**
     * Listens the fields entered. Gives warning in case of an error, adds full property if there is no error
     */
    private class addFullPropertyListener implements ActionListener { //I listened what the user has entered.
        private JTextField hostIDField;
        private JTextField propertyIDField;
        private JTextField bedroomnumberField;
        private JTextField roomnumberField;
        private JTextField cityField;
        private JTextField pricePerDayField;
        private JTextField propertySizeField;
        private JFrame hostFrame;
        public addFullPropertyListener(JTextField hostIDField, JTextField propertyIDField, JTextField bedroomnumberField, JTextField roomnumberField, JTextField cityField, JTextField pricePerDayField, JTextField propertySizeField,JFrame hostFrame){
            this.hostIDField = hostIDField;
            this.propertyIDField = propertyIDField;
            this.bedroomnumberField = bedroomnumberField;
            this.roomnumberField = roomnumberField;
            this.cityField = cityField;
            this.pricePerDayField = pricePerDayField;
            this.propertySizeField = propertySizeField;

            this.hostFrame = hostFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) { //Basically checked the validity of the entries and created if there are no problems.
            int host_id=-1,property_id=-1,host_index=-1,property_index=-1,bedroom=-1,room=-1,ppd=-1,prop_size=-1;
            String city="nowhere";
            boolean correct_id_formats_entered=true,host_exists=false,property_exists=false,so_far_all_is_well=true;
            JFrame frame = new JFrame();
            try{ //Tried to get ids. If the user enters a string it gives warning.
                host_id=Integer.parseInt(hostIDField.getText());
                property_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for both IDs", "Error", JOptionPane.ERROR_MESSAGE);
                correct_id_formats_entered=false;
            }
            if(correct_id_formats_entered){ // If the user entered a number I check whether the user exist and the property doesn't have a duplicate.
                for(int i=0;i<users.size();i++){ //Here I checked whether the host exists.
                    if(host_id==users.get(i).getUserId()){
                        host_exists=true;
                        host_index=i;
                        break;
                    }
                }
                if(!host_exists){
                    JOptionPane.showMessageDialog(frame, "Error: The ID of the user you have entered couldn't been found. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!(users.get(host_index) instanceof Host)){ // If the user entered is not a host I gave warning.
                    JOptionPane.showMessageDialog(frame, "Error: The ID of the user you have entered is not a Host\nTherefore he/she can't be the owner of the property ", "Error", JOptionPane.ERROR_MESSAGE);
                    host_exists=false;
                }
                for(int i=0;i<properties.size();i++){
                    if(property_id==properties.get(i).getPropertID()){
                        property_exists=true;
                        break;
                    }
                }
                if(property_exists){
                    JOptionPane.showMessageDialog(frame, "Error: The Property with the given ID already exists. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(!property_exists && host_exists){ // If there are no problems regarding the host and property I create and add property to my properties.
                Host host_of_the_property = (Host) users.get(host_index);
                FullProperty property_to_add = new FullProperty();
                property_to_add.setProperty_owner(host_of_the_property);
                property_to_add.setPropertID(property_id);

                if(!bedroomnumberField.getText().isEmpty()){
                    try {
                        bedroom=Integer.parseInt(bedroomnumberField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for bedroom", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(bedroom);
                }
                so_far_all_is_well=true;

                if(!roomnumberField.getText().isEmpty()){
                    try {
                        room=Integer.parseInt(roomnumberField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for Room", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(room);
                }
                so_far_all_is_well=true;

                if(!cityField.getText().isEmpty()){
                    property_to_add.setCity(cityField.getText());
                }

                if(!pricePerDayField.getText().isEmpty()){
                    try {
                        ppd=Integer.parseInt(pricePerDayField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for both Price Per Day", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(ppd);
                }
                so_far_all_is_well=true;

                if(!propertySizeField.getText().isEmpty()){
                    try {
                        prop_size=Integer.parseInt(propertySizeField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for Property Size", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setPropertySize(prop_size);
                }
                properties.add(property_to_add);
            }
            // Host frame'i kapat
            this.hostFrame.dispose();
        }
    }
    public void addSharedProperty(){ // I created a GUI that asks user to enter some information about property and its owner.
        JFrame hostFrame = new JFrame("Shared Property Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(400, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(8, 2));
        hostPanel.add(new JLabel("ID of the Property Owner"));
        JTextField hostIDField = new JTextField();
        hostPanel.add(hostIDField);
        hostPanel.add(new JLabel("ID of the property"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);
        hostPanel.add(new JLabel("Number of Bedrooms"));
        JTextField bedroomnumberField = new JTextField();
        hostPanel.add(bedroomnumberField);
        hostPanel.add(new JLabel("Number of Rooms"));
        JTextField roomnumberField = new JTextField();
        hostPanel.add(roomnumberField);
        hostPanel.add(new JLabel("City"));
        JTextField cityField = new JTextField();
        hostPanel.add(cityField);
        hostPanel.add(new JLabel("Price Per Day"));
        JTextField pricePerDayField = new JTextField();
        hostPanel.add(pricePerDayField);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new addSharedPropertyListener(hostIDField, propertyIDField, bedroomnumberField, roomnumberField, cityField, pricePerDayField,hostFrame));
        hostPanel.add(nextButton);

        hostFrame.add(hostPanel);
        hostFrame.setVisible(true);
    }
    /**
     * Listens the fields entered. Gives warning in case of an error, adds shared property if there is no error
     */
    private class addSharedPropertyListener implements ActionListener {
        private JTextField hostIDField;
        private JTextField propertyIDField;
        private JTextField bedroomnumberField;
        private JTextField roomnumberField;
        private JTextField cityField;
        private JTextField pricePerDayField;
        private JFrame hostFrame;

        public addSharedPropertyListener(JTextField hostIDField, JTextField propertyIDField, JTextField bedroomnumberField, JTextField roomnumberField, JTextField cityField, JTextField pricePerDayField,JFrame hostFrame){
            this.hostIDField = hostIDField;
            this.propertyIDField = propertyIDField;
            this.bedroomnumberField = bedroomnumberField;
            this.roomnumberField = roomnumberField;
            this.cityField = cityField;
            this.pricePerDayField = pricePerDayField;
            this.hostFrame = hostFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int host_id=-1,property_id=-1,host_index=-1,property_index=-1,bedroom=-1,room=-1,ppd=-1,prop_size=-1;
            String city="nowhere";
            boolean correct_id_formats_entered=true,host_exists=false,property_exists=false,so_far_all_is_well=true;
            JFrame frame = new JFrame();
            try{ // Checked if the user entered an integer for ids.
                host_id=Integer.parseInt(hostIDField.getText());
                property_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for both IDs", "Error", JOptionPane.ERROR_MESSAGE);
                correct_id_formats_entered=false;
            }
            if(correct_id_formats_entered){ //Checked whether the entered host exists.
                for(int i=0;i<users.size();i++){
                    if(host_id==users.get(i).getUserId()){
                        host_exists=true;
                        host_index=i;
                        break;
                    }
                }
                if(!host_exists){
                    JOptionPane.showMessageDialog(frame, "Error: The ID of the user you have entered couldn't been found. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!(users.get(host_index) instanceof Host)){//Checked whether the host is host.
                    JOptionPane.showMessageDialog(frame, "Error: The ID of the user you have entered is not a Host\nTherefore he/she can't be the owner of the property ", "Error", JOptionPane.ERROR_MESSAGE);
                    host_exists=false;
                }
                for(int i=0;i<properties.size();i++){
                    if(property_id==properties.get(i).getPropertID()){
                        property_exists=true;
                        break;
                    }
                }
                if(property_exists){
                    JOptionPane.showMessageDialog(frame, "Error: The Property with the given ID already exists. ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(!property_exists && host_exists){
                Host host_of_the_property = (Host) users.get(host_index);
                SharedProperty property_to_add = new SharedProperty();
                property_to_add.setProperty_owner(host_of_the_property);
                property_to_add.setPropertID(property_id);

                if(!bedroomnumberField.getText().isEmpty()){
                    try {
                        bedroom=Integer.parseInt(bedroomnumberField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for bedroom", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(bedroom);
                }
                so_far_all_is_well=true;

                if(!roomnumberField.getText().isEmpty()){
                    try {
                        room=Integer.parseInt(roomnumberField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for Room", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(room);
                }
                so_far_all_is_well=true;

                if(!cityField.getText().isEmpty()){
                    property_to_add.setCity(cityField.getText());
                }

                if(!pricePerDayField.getText().isEmpty()){
                    try {
                        ppd=Integer.parseInt(pricePerDayField.getText());
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for both Price Per Day", "Error", JOptionPane.ERROR_MESSAGE);
                        so_far_all_is_well=false;
                    }
                }
                if(so_far_all_is_well){
                    property_to_add.setNoBedRooms(ppd);
                }

                System.out.println("Property added is: ");
                properties.add(property_to_add);
            }
            this.hostFrame.dispose();
        }
    }

    //-----------------------------END FOR ADDING PROPERTY-------------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR DELETING PROPERTY -------------------------------------------------

    public void deleteProperty(){ // Created a GUI where it asks user to enter a property id.
        JFrame hostFrame = new JFrame("Delete Property");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter property ID"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new deletePropertyButtonListener(propertyIDField,hostFrame));
        //hostPanel.add(nextButton);//Buna gerek kalmadı

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }
    /**
     * This method gets the fields entered by the user.
     * Gives warning in case of an error and deletes if a valid id entered
     */
    private class deletePropertyButtonListener implements ActionListener {
        private JTextField propertyIDField;
        private JFrame hostFrame;
        public deletePropertyButtonListener(JTextField propertyIDField, JFrame hostFrame){
            this.propertyIDField=propertyIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame();
            int prop_id=-1,prop_index=-1;
            boolean correct_input_entered=true,property_id_found=false;
            try{ //Checked if the user entered integer for id.
                prop_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
                correct_input_entered=false;
            }
            if(correct_input_entered) { //If the entered id is in correct format(is integer) I checked the existence of property.
                for (int i = 0; i < properties.size(); i++) {
                    if (properties.get(i).getPropertID() == prop_id) {
                        prop_index=i;
                        property_id_found=true;
                        break;
                    }
                }
                if(!property_id_found){
                    JOptionPane.showMessageDialog(frame, "Error: The ID specified couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    properties.remove(properties.get(prop_index));
                }
            }
            hostFrame.dispose();
        }
    }

    //-----------------------------END FOR DELETING PROPERTY-----------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING PROPERTY DETAILS-------------------------------------------
    public void getPropertyDetails(){ // Created a GUI that asks the entry of a property id.
        JFrame hostFrame = new JFrame("Get Property Details");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter property ID to see the details"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new getPropertyDetailsButtonListener(propertyIDField,hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }
    /**
     * Listens the id field entered. Checks their validity and gives warning in case of an error.
     * Gives their details if there is no error.
     */
    private class getPropertyDetailsButtonListener implements ActionListener {
        private JTextField propertyIDField;
        private JFrame hostFrame;
        public getPropertyDetailsButtonListener(JTextField propertyIDField, JFrame hostFrame) {
            this.propertyIDField=propertyIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int prop_id=0,different_prop_id,prop_index=0;
            boolean valid_prop_id=true,prop_id_found=false;
            JFrame frame = new JFrame();
            try { //Checked if the user entered an integer for id.
                prop_id = Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID", "Error", JOptionPane.ERROR_MESSAGE);
                valid_prop_id=false;
            }
            if(valid_prop_id){ //If the user enters id it checks the existence of the property.
                for(int i=0;i<properties.size();i++){
                    if(prop_id==properties.get(i).getPropertID()){
                        prop_index=i;
                        prop_id_found=true;
                        break;
                    }
                }
            }
            if(valid_prop_id && prop_id_found){ //Here I shine my message to the user.
                if(properties.get(prop_index) instanceof SharedProperty) {
                    String message = "Property ID: " + properties.get(prop_index).getPropertID() + "\nBedroom: " + properties.get(prop_index).getNoBedRooms() + "\nRoom: " + properties.get(prop_index).getNoRooms() + "\nCity: "+properties.get(prop_index).getCity()+"\nPrice per Day: "+properties.get(prop_index).getPricePerDay();
                    JOptionPane.showMessageDialog(frame, message);
                }
                else if(properties.get(prop_index) instanceof FullProperty){
                    String message = "Property ID: " + properties.get(prop_index).getPropertID() + "\nBedroom: " + properties.get(prop_index).getNoBedRooms() + "\nRoom: " + properties.get(prop_index).getNoRooms() + "\nCity: "+properties.get(prop_index).getCity()+"\nPrice per Day: "+properties.get(prop_index).getPricePerDay()+((FullProperty) properties.get(prop_index)).getPropertySize();
                    JOptionPane.showMessageDialog(frame, message);
                }
            }
            hostFrame.dispose();
        }
    }
    //-----------------------------END FOR GETTING PROPERTY DETAILS----------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR ADDING BOOKING ----------------------------------------------------
    public void addBooking(){ //Creates a GUI for adding a booking.
        JFrame hostFrame = new JFrame("Add Booking");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(300, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(6, 1));
        hostPanel.add(new JLabel("(*)Enter property ID"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        hostPanel.add(new JLabel("(*)Enter user ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        hostPanel.add(new JLabel("Enter starting date"));
        JTextField startingdateField = new JTextField();
        hostPanel.add(startingdateField);

        hostPanel.add(new JLabel("Enter ending date"));
        JTextField endingdateField = new JTextField();
        hostPanel.add(endingdateField);

        hostPanel.add(new JLabel("Does the user made payment?(Y/N)"));
        JTextField paymentInfoField = new JTextField();
        hostPanel.add(paymentInfoField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new addBookingButtonListener(propertyIDField,userIDField,startingdateField,endingdateField,paymentInfoField,hostFrame));
        //hostPanel.add(nextButton);//Buna gerek kalmadı

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }
    /**
     * Listens the user id and property id. Checks their validity and gives warning in case of an error.
     * If there is no error creates and adds a booking
     */
    private class addBookingButtonListener implements ActionListener {
        private JTextField propertyIDField;
        private JTextField userIDField;
        private JTextField startingdateField;
        private JTextField endingdateField;
        private JTextField paymentInfoField;
        private JFrame hostFrame;
        public addBookingButtonListener(JTextField propertyIDField,JTextField userIDField,JTextField startingdateField,JTextField endingdateField,JTextField paymentInfoField,JFrame hostFrame) {
            this.propertyIDField=propertyIDField;
            this.userIDField=userIDField;
            this.startingdateField=startingdateField;
            this.endingdateField=endingdateField;
            this.paymentInfoField=paymentInfoField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame();
            int user_id=-1, user_index=-1;
            int prop_id=-1, prop_index=-1;
            Date starting_date=null,ending_date=null;
            Booking booking_to_add;
            boolean is_paid=false;
            try{ //Checks if the user entered an integer for property id.
                prop_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{ //Checks if the user entered an integer for user id.
                user_id=Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{ //Tries to get starting date.
                starting_date=createDate(startingdateField.getText());
                ending_date= createDate(endingdateField.getText());
            }
            catch (Exception ex){
                System.out.println(ex);
            }
            for(int i=0;i<users.size();i++){ //I checked whether the user exists.
                if(user_id==users.get(i).getUserId()){
                    user_index=i;
                    break;
                }
            }
            for(int i=0;i<properties.size();i++){//I checked whether the property exists.
                if(prop_id==properties.get(i).getPropertID()){
                    prop_index=i;
                    break;
                }
            }
            if(prop_id==-1){ // If property doesn't exist I gave a warning.
                JOptionPane.showMessageDialog(frame, "Error: Property with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(user_index==-1){// If user doesn't exist I gave a warning.
                JOptionPane.showMessageDialog(frame, "Error: User with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(user_index!=-1 && prop_index!=-1){
                if(users.get(user_index) instanceof Customer) {//If user and property exists  and if the user entered is a customer not a host, it creates a booking and stores it in the user.
                    booking_to_add = new Booking();
                    booking_to_add.setStartDate(starting_date);
                    booking_to_add.setEndDate(ending_date);
                    booking_to_add.setPaid(false);// I don't want to deal with this
                    ((Customer) users.get(user_index)).setUsers_Booking(booking_to_add);
                    JOptionPane.showMessageDialog(frame, "BOOKING IS ADDED");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Error: User specified is not a Customer", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            hostFrame.dispose();
        }
    }

    //-----------------------------END FOR ADDING BOOKING--------------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING BOOKING COST ----------------------------------------------
    // Complete it
    public void getBookingCost(){ //Created a GUI for getting the booking cost.
        JFrame hostFrame = new JFrame("Get Booking Cost");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(300, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter property ID"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        hostPanel.add(new JLabel("Enter user ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new getBookingCostButtonListener(propertyIDField, userIDField, hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }

    /**
     * Listens the field. Checks the validity of inputs. Gives warning in case of an error
     * It was supposed to return booking cost. But I didn't have time, unfortunately.
     */
    private class getBookingCostButtonListener implements ActionListener {
        private JTextField propertyIDField;
        private JTextField userIDField;
        private JFrame hostFrame;
        public getBookingCostButtonListener(JTextField propertyIDField,JTextField userIDField, JFrame hostFrame) {
            this.propertyIDField=propertyIDField;
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame();
            int user_id=-1, user_index=-1;
            int prop_id=-1, prop_index=-1;
            try{//In these try catch blocks I checked the validity of the inputs
                prop_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{
                user_id=Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            for(int i=0;i<users.size();i++){
                if(user_id==users.get(i).getUserId()){
                    user_index=i;
                    break;
                }
            }
            for(int i=0;i<properties.size();i++){
                if(prop_id==properties.get(i).getPropertID()){
                    prop_index=i;
                    break;
                }
            }
            if(prop_id==-1){
                JOptionPane.showMessageDialog(frame, "Error: Property with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(user_index==-1){
                JOptionPane.showMessageDialog(frame, "Error: User with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(user_index!=-1 && prop_index!=-1){
                JOptionPane.showMessageDialog(frame, "Not finished yet.\nTerrible sorry for inconvenience.");
            }
            hostFrame.dispose();
        }
    }

    //-----------------------------END FOR GETTING BOOKING COST -------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING THE USERS BOOKING -----------------------------------------
    //NOT FINISHED Complete it
    public void getUserBooking(){
        JFrame hostFrame = new JFrame("Get Booking Cost");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));

        hostPanel.add(new JLabel("Enter user ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new getUserBookingButtonListener(userIDField,hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }

    /**
     * Listens the fields. Gives warning in case of an error.
     * It was supposed to give the user bookings. But I wasn't able to time manage to complete.
     */
    private class getUserBookingButtonListener implements ActionListener {
        private JTextField userIDField;
        private JFrame hostFrame;
        public getUserBookingButtonListener(JTextField userIDField, JFrame hostFrame) {
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) { // Wasn't able to finish this either. I was able to get values and checked whether they are valid or not.
            JFrame frame = new JFrame();
            int user_id=-1,user_index;
            try{
                user_id=Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            for(int i=0;i<users.size();i++){
                if(user_id==users.get(i).getUserId()){
                    user_index=i;
                    break;
                }
            }
            hostFrame.dispose();
        }
    }

    //-----------------------------THIS IS THE END FOR GETTING THE USERS BOOKING --------------------------------------

    //*****************************************************************************************************************

    //-----------------------------THIS PART IS FOR GETTING THE Listing Users -----------------------------------------
    public void listUsers(){ //I listed the users here.
        int height = 50*users.size();
        JFrame hostFrame = new JFrame("List Users");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(500, height);
        hostFrame.setLocationRelativeTo(null);

        JLabel current_user;
        JPanel current_user_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for(int i=0;i<users.size();i++){
            current_user = new JLabel("Name: "+users.get(i).getFirstName()+"/// Surname: "+users.get(i).getLastName()+"/// ID: "+users.get(i).getUserId()+"/// BirthDay: "+users.get(i).getDateOfBirth()+"\n");
            current_user_panel.add(current_user);
            hostFrame.add(current_user_panel);
        }
        hostFrame.setVisible(true);
    }
    //-----------------------------THIS PART IS END FOR Listing Users -------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING THE Listing Properties ------------------------------------
    public void listProperties(){ //I listed the properties here.
        int height = 50*properties.size();
        JFrame hostFrame = new JFrame("List Properties");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(500, height);
        hostFrame.setLocationRelativeTo(null);

        JLabel current_properties;
        JPanel current_properties_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for(int i=0;i<properties.size();i++){
            current_properties = new JLabel("ID: "+properties.get(i).getPropertID()+"/// # of Bedrooms: "+properties.get(i).getNoBedRooms()+"/// # of Rooms: "+properties.get(i).getNoRooms()+"/// City: "+properties.get(i).getCity());
            current_properties_panel.add(current_properties);
            hostFrame.add(current_properties_panel);
        }
        hostFrame.setVisible(true);
    }
    //----------------------------- END FOR Listing Properties  -------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR GETTING THE Discount Percentage -----------------------------------
    public void getUserDiscount(){ //I created a GUI for user to enter the user ID.
        JFrame hostFrame = new JFrame("Get User Discount");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(100, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter user ID"));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new getUserDiscountButtonListener(userIDField,hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }

    /**
     * Listens user id entered. Checks if a valid id entered and whether it is a Gold or not.
     * Because only the gold users have discounts.
     */
    private class getUserDiscountButtonListener implements ActionListener {
        private JTextField userIDField;
        private JFrame hostFrame;
        public getUserDiscountButtonListener(JTextField userIDField, JFrame hostFrame) {
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int user_id=0,different_users_id,user_index=0;
            boolean all_is_well=true,existing_user_id_entered=false;
            JFrame frame = new JFrame();
            try { // As usual by now, I checked whether the user entered an integer.
                user_id = Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for user ID", "Error", JOptionPane.ERROR_MESSAGE);
                all_is_well=false;
            }
            if(all_is_well){ //Checked whether the entered user id exist.
                for(int i = 0; i < users.size(); i++) {
                    different_users_id = users.get(i).getUserId();
                    if (different_users_id == user_id) { //Here I checked with other IDs.
                        existing_user_id_entered=true;
                        user_index=i;
                        break;
                    }
                }
            }
            if(!existing_user_id_entered){
                all_is_well=false;
            }
            if(all_is_well){//The user is eligeble for discount if it is a gold member.
                if(users.get(user_index) instanceof Gold){
                    double discount = ((Gold) users.get(user_index)).discountPercentage();
                    String message = "Discount for user "+user_id+" is: "+discount;
                    JOptionPane.showMessageDialog(frame, message);
                }
                else{
                    String message = "Only gold users are available for discount";
                    JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                String message = "Wasn't able to find the user with the specified ID. Operation UNSUCCESSFUL";
                JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
            hostFrame.dispose();
        }
    }
    //----------------------------- END FOR GETTING THE Discount Percentage -------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR Comparing The Properties  -----------------------------------------
    public void comparePropertyClasses(){ //Created a GUI that asks for the entry of 2 property IDs.
        JFrame hostFrame = new JFrame("Compare Property Prices");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(450, 100);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(2, 1));
        hostPanel.add(new JLabel("Enter property ID to see the details:"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        hostPanel.add(new JLabel("Enter user second property ID:"));
        JTextField secondPropID = new JTextField();
        hostPanel.add(secondPropID);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new comparePropertyClassesButtonListener(propertyIDField,secondPropID,hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }
    /**
     * Listens the property IDs and checks their validity.
     * If they are valid checks if the properties exists.
     * If they exist, compares their prices and gives an output in form of GUI.
     */
    private class comparePropertyClassesButtonListener implements ActionListener {
        private JTextField propertyIDField,second_property_id;
        private JFrame hostFrame;
        public comparePropertyClassesButtonListener(JTextField propertyIDField, JTextField secondPropID,JFrame hostFrame) {
            this.propertyIDField=propertyIDField;
            this.second_property_id=secondPropID;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            int prop_id=-1,different_prop_id,prop_index=-1,second_prop_id=-1,second_prop_index=-1;
            boolean valid_prop_id=true;
            JFrame frame = new JFrame();
            try { //Checked whether the user entered an integer or not.
                prop_id = Integer.parseInt(propertyIDField.getText());
                second_prop_id= Integer.parseInt(second_property_id.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for property ID", "Error", JOptionPane.ERROR_MESSAGE);
                valid_prop_id=false;
            }
            if(valid_prop_id){//Here I checked whether the given properties exists.
                for(int i=0;i<properties.size();i++){
                    if(prop_id==properties.get(i).getPropertID()){
                        prop_index=i;
                        break;
                    }
                }
                for(int i=0;i<properties.size();i++){
                    if(second_prop_id==properties.get(i).getPropertID()){
                        second_prop_index=i;
                        break;
                    }
                }
            }
            if(prop_index!=-1 && second_prop_index!=-1){ //Here I compared.
                if(properties.get(prop_index).getPricePerDay()<properties.get(second_prop_index).getPricePerDay()){
                    JOptionPane.showMessageDialog(frame, "Price for first one is less than second one");
                }
                else if(properties.get(prop_index).getPricePerDay()>properties.get(second_prop_index).getPricePerDay()){
                    JOptionPane.showMessageDialog(frame, "Price for first one is more than second one");
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Their prices are same.");
                }
            }
            hostFrame.dispose();
        }
    }
    //----------------------------- END FOR Comparing Properties ------------------------------------------------------
    //*****************************************************************************************************************
    //-----------------------------THIS PART IS FOR ADDING INSPECTION  ------------------------------------------------
    public void addInspection(){ //Created a GUI that asks for the entry of a property and user id.
        JFrame hostFrame = new JFrame("Add Inspection");
        hostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hostFrame.setSize(300, 300);
        hostFrame.setLocationRelativeTo(null);

        JPanel hostPanel = new JPanel(new GridLayout(6, 1));
        hostPanel.add(new JLabel("Enter property ID:"));
        JTextField propertyIDField = new JTextField();
        hostPanel.add(propertyIDField);

        hostPanel.add(new JLabel("Enter user ID: "));
        JTextField userIDField = new JTextField();
        hostPanel.add(userIDField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new addInspectionButtonListener(propertyIDField,userIDField,hostFrame));

        hostFrame.add(hostPanel,BorderLayout.CENTER);
        hostFrame.add(nextButton,BorderLayout.SOUTH);
        hostFrame.setVisible(true);
    }
    /**
     * Listens the user id and property id. Checks their validity and gives warning in case of an error.
     * It is only partially working. It gives warning in case of an error but it doesn't add inspection.
     */
    private class addInspectionButtonListener implements ActionListener {
        private JTextField propertyIDField;
        private JTextField userIDField;
        private JFrame hostFrame;
        public addInspectionButtonListener(JTextField propertyIDField,JTextField userIDField,JFrame hostFrame) {
            this.propertyIDField=propertyIDField;
            this.userIDField=userIDField;
            this.hostFrame=hostFrame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame();
            int user_id=-1, user_index=-1;
            int prop_id=-1, prop_index=-1;
            Date starting_date=null,ending_date=null;
            Booking booking_to_add;
            boolean is_paid=false;
            try{ //Checked whether the id entered is an integer.
                prop_id=Integer.parseInt(propertyIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try{//Checked whether the id entered is an integer.
                user_id=Integer.parseInt(userIDField.getText());
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Error: You have to enter a number for ID", "Error", JOptionPane.ERROR_MESSAGE);
            }

            for(int i=0;i<users.size();i++){//Checked whether the id entered exist.
                if(user_id==users.get(i).getUserId()){
                    user_index=i;
                    break;
                }
            }
            for(int i=0;i<properties.size();i++){//Checked whether the id entered exist.
                if(prop_id==properties.get(i).getPropertID()){
                    prop_index=i;
                    break;
                }
            }
            if(prop_id==-1){
                JOptionPane.showMessageDialog(frame, "Error: Property with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(user_index==-1){
                JOptionPane.showMessageDialog(frame, "Error: User with the specified ID couldn't been found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //I know what is left is very easy but I legitimately don't have brain capacity to write anything new. I was asleep for roughly 30 hours when I am writing this.
            //if(user_index!=-1 && prop_index!=-1){}
            hostFrame.dispose();
        }
    }
    //----------------------------- END FOR Comparing Properties ------------------------------------------------------
    //*****************************************************************************************************************

    /**
     * This method creates a Date. There are a lot of things to consider when creating a date.
     * For example user should enter 3 "/" operators. If more or less entered the method should warn the user.
     * It checks if the dates and the months are making sense. For example, a user shouldn't be able to enter 14th month. Or 37th day.
     * @return to_return Returns the date it has created.
     */
    public Date createDate(String date_entered){ //In this part of my code I basically created the date. I checked whether or not the user provided some non-sensical data. For example 13'th month or 32th day of the month.
        Date to_return=new Date();
        Scanner input_scanner=new Scanner(System.in);
        boolean exit_condition=false;
        int day,month,year;
        String [] parts= date_entered.split("/"); //Splitted the parts
        if (parts.length == 3 && parts[0].length() <= 2 && parts[1].length() <= 2 && parts[2].length() == 4){ //If more than necessary "/" entered gave error.
            day=Integer.parseInt(parts[0]);
            if(day<0 || day >31){ //If day is out of the limit I gave warning.
                //System.out.println("Day is wrong");
                to_return=null;
            }
            else{
                month=Integer.parseInt(parts[1]);
                if(month<0 || month > 12){
                    //System.out.println("You entered an invalid month!!!");
                    to_return=null;
                }
                else{
                    year=Integer.parseInt(parts[2]);
                    to_return=new Date(year-1900,month,day);
                    exit_condition=true;
                }
            }
        }
        else{
            //System.out.println("Not in 3 pieces");
            to_return=null;
        }
        return to_return;
    }

}
