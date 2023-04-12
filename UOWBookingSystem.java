import java.util.ArrayList;
import java.util.Scanner;

class UOWBookingSystem {
    private static Scanner input;
    private static ArrayList<Room> roomList = new ArrayList<Room>();

    private static void firstMenu() {
        int userSelection = 0;
        System.out.println("\nAre you a UOWStaff or UOW student?");
        System.out.println("1.UOWStaff");
        System.out.println("2.UOWStudent");
        System.out.println("3.Exit");
        System.out.print("----------------------\n");
        input = new Scanner(System.in);
        userSelection = input.nextInt();

        switch (userSelection) {
            case 1:
                staffMenu();
            case 2:
                studentMenu();
            case 3:
                System.exit(0);
            default:
                System.exit(0);
        }

    }

    private static void staffMenu() {
        System.out.print("----------------------\n");
        System.out.println("1.Create a room.");
        System.out.println("2.Edit room details");
        System.out.print("----------------------\n");

        int staffOption = 0;
        input = new Scanner(System.in);
        staffOption = input.nextInt();

        switch (staffOption) {
            case 1:
                roomCreationMenu();
            case 2:
                roomEditMenu();
            default:
                System.exit(0);
        }
    }

    private static void roomCreationMenu() {
        Room room = new Room();
        System.out.print("----------------------\n");
        System.out.println("Room availability");
        System.out.println("1.Available");
        System.out.println("2.Unavailable");
        System.out.print(".............\n");
        input = new Scanner(System.in);
        int a = input.nextInt();
        if (a == 1) {
            room.setAvailability("Available");
        } else if (a == 2) {
            room.setAvailability("Unavailable");
        }

        System.out.print("----------------------\n");
        System.out.println("Room Price");
        System.out.print(".............\n");

        double price = input.nextDouble();
        room.setPricing(price);

        System.out.print("----------------------\n");
        System.out.println("Select room timing");
        System.out.println("1. 8:00AM - 10:00AM");
        System.out.println("2. 10:00AM - 12:00PM");
        System.out.println("3. 12:00PM - 2:00PM");
        System.out.println("4. 2:00PM - 4:00PM");
        System.out.println("5. 4:00PM - 6:00PM");
        System.out.print(".............\n");

        int t = input.nextInt();
        if (t == 1) {
            room.setTiming("8:00 AM - 10:00 AM");
        } else if (t == 2) {
            room.setTiming("10:00 AM - 12:00 PM");
        } else if (t == 3) {
            room.setTiming("12:00 PM - 2:00 PM");
        } else if (t == 4) {
            room.setTiming("2:00 PM - 4:00 PM");
        } else if (t == 5) {
            room.setTiming("4:00 PM - 6:00 PM");
        }

        System.out.print("----------------------\n");
        System.out.println("Room PROMOCODE");
        System.out.print(".............\n");

        input.next();
        String PC = input.nextLine();
        room.setPromocode(PC);

        System.out.print("----------------------\n");
        System.out.println("Room Capacity");
        System.out.print(".............\n");

        int c = input.nextInt();
        room.setCapacity(c);

        roomList.add(room);

        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        firstMenu();

    }

    private static void roomEditMenu() {
        System.out.print("----------------------\n");

        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        int roomSelected = 0;
        roomSelected = input.nextInt();

        System.out.print("\n----------------------\n");
        System.out.println("1.Edit room availability");
        System.out.println("2.Edit room pricing");
        System.out.println("3.Edit room timing");
        System.out.println("4.edit promocode for room");
        System.out.println("5.Edit room Capacity");
        System.out.print("----------------------\n");

        int option = 0;
        input = new Scanner(System.in);
        option = input.nextInt();
        switch (option) {
            case 1:
                System.out.print("----------------------\n");
                System.out.println("Room availability");
                System.out.println("1.Available");
                System.out.println("2.Unavailable");
                System.out.print(".............\n");
                input = new Scanner(System.in);
                int a = input.nextInt();
                if (a == 1) {
                    roomList.get(roomSelected - 1).setAvailability("Available");
                } else if (a == 2) {
                    roomList.get(roomSelected - 1).setAvailability("Unavailable");
                }
                firstMenu();

            case 2:
                System.out.print("----------------------\n");
                System.out.println("Room Price");
                System.out.print(".............\n");

                double price = input.nextDouble();
                roomList.get(roomSelected - 1).setPricing(price);
                firstMenu();

            case 3:
                System.out.print("----------------------\n");
                System.out.println("Select room timing");
                System.out.println("1. 8:00AM - 10:00AM");
                System.out.println("2. 10:00AM - 12:00PM");
                System.out.println("3. 12:00PM - 2:00PM");
                System.out.println("4. 2:00PM - 4:00PM");
                System.out.println("5. 4:00PM - 6:00PM");
                System.out.print(".............\n");

                int t = input.nextInt();
                if (t == 1) {
                    roomList.get(roomSelected - 1).setTiming("8:00 AM - 10:00 AM");
                } else if (t == 2) {
                    roomList.get(roomSelected - 1).setTiming("10:00 AM - 12:00 PM");
                } else if (t == 3) {
                    roomList.get(roomSelected - 1).setTiming("12:00 PM - 2:00 PM");
                } else if (t == 4) {
                    roomList.get(roomSelected - 1).setTiming("2:00 PM - 4:00 PM");
                } else if (t == 5) {
                    roomList.get(roomSelected - 1).setTiming("4:00 PM - 6:00 PM");
                }
                firstMenu();

            case 4:
                System.out.print("----------------------\n");
                System.out.println("Room PROMOCODE");
                System.out.print(".............\n");

                input.next();
                String PC = input.nextLine();
                roomList.get(roomSelected - 1).setPromocode(PC);
                firstMenu();

            case 5:
                System.out.print("----------------------\n");
                System.out.println("Room Capacity");
                System.out.print(".............\n");

                int c = input.nextInt();
                roomList.get(roomSelected - 1).setCapacity(c);
                firstMenu();
        }
    }

    private static void studentMenu() {
        System.out.print("----------------------\n");
        System.out.println("1.View Room List");
        System.out.println("2.Make a room booking");
        System.out.println("3.Edit room booking");
        System.out.println("4.Delete room booking");
        System.out.print("----------------------\n");
        int studentOption = 0;
        input = new Scanner(System.in);
        studentOption = input.nextInt();

        switch (studentOption) {
            case 1:
                for (int i = 0; i < roomList.size(); i++) {
                    System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
                    System.out.println(roomList.get(i));
                    System.out.print("----------------------\n");
                }
                studentMenu();

            case 2:
                bookingMenu();

            case 3:

        }

    }

    private static void bookingMenu() {
        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        int roomSelected = 0;
        roomSelected = input.nextInt();

        if (roomList.get(roomSelected - 1).getBooked() == "Vacant") {
            roomList.get(roomSelected - 1).setBooked("Occupied");
            System.out.println("Room booked successfully");
            firstMenu();
        } else {
            System.out.printf("Room is already occupied%nPlease Select another room");
            bookingMenu();
        }
    }

    public static void main(String[] args) {

        firstMenu();

    }
}

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
