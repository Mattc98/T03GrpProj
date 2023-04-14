import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.Scanner;

import javax.swing.*;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Color;
class Room {
    private String availability;
    private double pricing;
    private String timing;
    private String promocode;
    private int capacity;
    private String booked;

    public Room() {
        this.availability = "Available";
        this.pricing = 15.00;
        this.timing = "8:00 AM - 10:00 AM";
        this.promocode = "";
        this.capacity = 4;
        this.booked = "Vacant";
    }

    public Room(String availability, double pricing, String timing, String promocode, int capacity, String booked) {
        this.availability = availability;
        this.pricing = pricing;
        this.timing = timing;
        this.promocode = promocode;
        this.capacity = capacity;
        this.booked = booked;
    }

    public String getAvailability() {
        return availability;
    }

    public double getPricing() {
        return pricing;
    }

    public String getTiming() {
        return timing;
    }

    public String getPromocode() {
        return promocode;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBooked() {
        return booked;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setBooked(String booked) {
        this.booked = booked;
    }

    public String toString() {
        return String.format(
                "%nPrice of room is $%.2f%nRoom is avaliable from %s%nMax Capacity of room is %d pax%nRoom is currently %s",
                pricing, timing, capacity, booked);
    }
}


class Demo extends JFrame{
    private static Scanner input;
    private static ArrayList<Room> roomList = new ArrayList<Room>();
    private static ArrayList<Room> occupiedRoomList = new ArrayList<Room>();

    public Demo() {
        super("Booking System Log in");

        setLayout(new BorderLayout());
        JPanel b1 = new JPanel();
        JPanel b2 = new JPanel();
        JPanel b3 = new JPanel();
        JPanel b4 = new JPanel();
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.SOUTH);
        add(b3, BorderLayout.EAST);
        add(b4, BorderLayout.WEST);

        JPanel loginPage = new JPanel();
        loginPage.setBackground(Color.darkGray);
        add(loginPage);

        JLabel a = new JLabel();
        a.setForeground(Color.white);
        a.setText("Select UOWStaff or UOWStudent");
        loginPage.add(a);

        ImageIcon welGif = new ImageIcon("welcome.gif");
        Image img = welGif.getImage().getScaledInstance(498, 354, Image.SCALE_DEFAULT);
        welGif = new ImageIcon(img);

        JLabel wel = new JLabel();
        wel.setIcon(welGif);
        loginPage.add(wel);


        JButton staffB = new JButton("UOWStaff");
        loginPage.add(staffB);

        JButton studentB = new JButton("UOWStudent");
        loginPage.add(studentB);

        JButton exitB = new JButton("Exit");
        loginPage.add(exitB);

        JFrame staffMenu = new JFrame("Welcome to my booking system");
        staffMenu.setSize(450, 250);
        JPanel staffPanel = new JPanel();

        staffPanel.setLayout(new BoxLayout(staffPanel ,BoxLayout.Y_AXIS));
        staffMenu.add(staffPanel);

        JLabel header = new JLabel();
        
        JButton createRoomButton = new JButton("Create New Room");
        JButton editRoomButton = new JButton("Edit Existing Room");
        JButton logoutStaffButton = new JButton("Log out");

        JFrame creatingMenu = new JFrame("Creating new room for booking");
        creatingMenu.setSize(450, 250);

        JPanel creatingPanel = new JPanel();
        creatingPanel.setLayout(new BoxLayout(creatingPanel,BoxLayout.Y_AXIS));
        creatingMenu.add(creatingPanel);
        //creatingPanel.setBackground(Color.darkGray);

        JLabel header1 = new JLabel();
        //header1.setForeground(Color.white);
        header1.setText("~~~ Settings for New Room ~~~");
        creatingPanel.add(header1);


        JRadioButton ava = new JRadioButton("Available");
        JRadioButton unava = new JRadioButton("Unavailable");
        ButtonGroup group1 = new ButtonGroup();
        JPanel radrioJPanel = new JPanel();
        radrioJPanel.setLayout(new BoxLayout(radrioJPanel,BoxLayout.X_AXIS));
       
        JLabel price = new JLabel("Price");
        JTextField t1 = new JTextField(10);
        t1.setBounds(10, 10, 150, 30);
        t1.setText("$");
        
        JPanel pricePanel = new JPanel();

        JFrame editMenu = new JFrame("Editing existing room for booking");

        JFrame studentMenu = new JFrame("Welcome to my booking system");
        studentMenu.setSize(450, 400);

        JPanel studentPanel = new JPanel();
        studentMenu.add(studentPanel);


        staffB.addActionListener(e -> {
            // if button is clicked
            if (e.getSource() == staffB) {

                staffMenu.add(b1, BorderLayout.NORTH);
                staffMenu.add(b2, BorderLayout.SOUTH);
                staffMenu.add(b3, BorderLayout.EAST);
                staffMenu.add(b4, BorderLayout.WEST);
                staffPanel.setBackground(Color.darkGray);

                header.setForeground(Color.white);
                header.setText("~~~ Staff Menu ~~~");
                staffPanel.add(header);  

                header.setAlignmentX(Component.CENTER_ALIGNMENT);
                createRoomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                editRoomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                logoutStaffButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                staffPanel.add(createRoomButton);
                staffPanel.add(editRoomButton);
                staffPanel.add(logoutStaffButton);


                this.setVisible(false);
                staffMenu.setVisible(true);
            }
        });

        createRoomButton.addActionListener(e -> {
            // if button is clicked
            if (e.getSource() == createRoomButton) {
                Room r1 = new Room();
                creatingMenu.add(b1, BorderLayout.NORTH);
                creatingMenu.add(b2, BorderLayout.SOUTH);
                creatingMenu.add(b3, BorderLayout.EAST);
                creatingMenu.add(b4, BorderLayout.WEST);

                header1.setAlignmentX(Component.CENTER_ALIGNMENT);
                group1.add(ava);group1.add(unava);
                radrioJPanel.add(ava);radrioJPanel.add(unava);
                //ava.setForeground(Color.white);unava.setForeground(Color.white);
                //radrioJPanel.setBackground(Color.darkGray);
                //ava.setBackground(Color.darkGray);unava.setBackground(Color.darkGray);
                creatingPanel.add(radrioJPanel);

                if(ava.isSelected()){
                    r1.setAvailability("Available");
                }

                if(unava.isSelected()){
                    r1.setAvailability("Unavailable");
                }

                pricePanel.add(price);
                price.setAlignmentX(CENTER_ALIGNMENT);
                pricePanel.add(t1);
                t1.setAlignmentX(CENTER_ALIGNMENT);
                creatingPanel.add(pricePanel);

                staffMenu.setVisible(false);
                creatingMenu.setVisible(true);
            }
        });

        editRoomButton.addActionListener(e -> {
            // if button is clicked
            if (e.getSource() == editRoomButton) {

                staffMenu.setVisible(false);
                editMenu.setVisible(true);
            }
        });

        logoutStaffButton.addActionListener(e -> {
            // if button is clicked
            if (e.getSource() == logoutStaffButton) {

                staffMenu.setVisible(false);
                this.setVisible(true);
            }
        });

        studentB.addActionListener(e -> {
            // if button is clicked
            if (e.getSource() == studentB) {

                this.setVisible(false);
                studentMenu.setVisible(true);


            }
        });

        exitB.addActionListener(e -> {
            if (e.getSource() == exitB) {
                System.exit(0);
            }
        });

    }
}

class UOWBookingSystem2{
    public static void main(String[] args) {
        Demo hehe = new Demo();

        hehe.setVisible(true);
        hehe.setSize(570, 500);
        hehe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
