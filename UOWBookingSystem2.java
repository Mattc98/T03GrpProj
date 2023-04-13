import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

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
        staffMenu.setSize(650, 400);
        JPanel staffPanel = new JPanel();

        staffPanel.setLayout(new BoxLayout(staffPanel ,BoxLayout.Y_AXIS));
        staffMenu.add(staffPanel);

        JLabel header = new JLabel();
        
        JButton createRoomButton = new JButton("Create New Room");
        JButton editRoomButton = new JButton("Edit Existing Room");
        JButton logoutStaffButton = new JButton("Log out");

        JFrame studentMenu = new JFrame("Welcome to my booking system");
        studentMenu.setSize(650, 400);

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
                header.setText("==> Staff Menu");
                staffPanel.add(header);  

                staffPanel.add(createRoomButton);
                staffPanel.add(editRoomButton);
                staffPanel.add(logoutStaffButton);


                this.setVisible(false);
                staffMenu.setVisible(true);
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
