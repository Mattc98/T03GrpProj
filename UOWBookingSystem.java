import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class UOWBookingSystem {
    private static Scanner input;
    private static int userID;
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Room> roomList = new ArrayList<>();
    private static ArrayList<Room> occupiedRoomList = new ArrayList<>();

    private static void firstMenu() {
        System.out.println("\n----------------------");
        System.out.println("Main Menu");
        System.out.println("1.Create account");
        System.out.println("2.Login");
        System.out.println("3.Exit");
        System.out.print(".............\n");

        try {
            input = new Scanner(System.in);
            int userSelection;
            userSelection = input.nextInt();
            switch (userSelection) {
                case 1:
                    createMenu();
                case 2:
                    loginPage();
                case 3:
                    System.exit(0);
            }

            if (userSelection > 3 || userSelection < 1) {
                System.out.println("\nEnter a number between 1 and 3\n");
                firstMenu();
            }

        } catch (InputMismatchException e) {
            System.out.println("\nplease enter number");
            firstMenu();
        }
    }

    private static void createMenu() {
        input = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("==> Creating new account");
        System.out.print("----------------------\n");
        System.out.println("Are you a staff or student");
        System.out.println("1. UOWStaff");
        System.out.println("2. UOWStudent");
        System.out.println("3. Exit");
        System.out.print(".............\n");

        User user = new User();
        int t = input.nextInt();

        if (t == 1) {
            user.setIsStaff(true);
        } else if (t == 2) {
            user.setIsStaff(false);
        } else if (t == 3) {
            firstMenu();
        }

        System.out.print("----------------------\n");
        System.out.println("Set Username");
        System.out.print(".............\n");

        input.nextLine();
        String un;
        un = input.nextLine();
        user.setUsername(un);

        System.out.print("----------------------\n");
        System.out.println("Set Password");
        System.out.print(".............\n");

        String pw = input.nextLine();
        user.setPassword(pw);

        userList.add(user);
        System.out.println("\nAccount created");
        firstMenu();
    }

    private static void loginPage() {
        System.out.println("----------------------");
        System.out.println("==> Login Page");
        System.out.print("----------------------\n");
        System.out.println("Enter your username");
        System.out.print(".............\n");

        input.nextLine();
        String user;
        user = input.nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(user)) {
                userID = i;
            }
        }

        System.out.println("Enter your password");
        System.out.print(".............\n");

        String userpw = input.nextLine();

        if (userList.get(userID).getPassword().equals(userpw) && userList.get(userID).getUsername().equals(user)) {
            if (userList.get(userID).isStaff().equals(true)) {
                staffMenu();
            } else if (userList.get(userID).isStaff().equals(false)) {
                studentMenu();
            }
        } else {
            System.out.println("\nWrong la bodoh");
            firstMenu();
        }

    }

    private static void staffMenu() {
        System.out.println("----------------------");
        System.out.println("==> Staff Menu");
        System.out.print("----------------------\n");
        System.out.println("1.Create a room.");
        System.out.println("2.Edit room details");
        System.out.println("3.Log out");
        System.out.print(".............\n");

        try {
            int staffOption = 0;
            input = new Scanner(System.in);
            staffOption = input.nextInt();

            switch (staffOption) {
                case 1:
                    roomCreationMenu();
                case 2:
                    roomEditMenu();
                case 3:
                    firstMenu();
                default:
                    System.exit(0);
            }
            if (staffOption > 3 || staffOption < 1) {
                System.out.println("\nEnter a number between 1 and 3\n");
                staffMenu();
            }

        } catch (InputMismatchException e) {
            System.out.println("\nplease enter number");
            staffMenu();
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

        staffMenu();

    }

    private static void roomEditMenu() {
        System.out.print("----------------------\n");

        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        System.out.print(".............\n");

        int roomSelected = 0;
        roomSelected = input.nextInt();

        System.out.print("\n----------------------\n");
        System.out.println("1.Edit room availability");
        System.out.println("2.Edit room pricing");
        System.out.println("3.Edit room timing");
        System.out.println("4.Edit promocode for room");
        System.out.println("5.Edit room Capacity");
        System.out.print(".............\n");

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
                staffMenu();

            case 2:
                System.out.print("----------------------\n");
                System.out.println("Room Price");
                System.out.print(".............\n");

                double price = input.nextDouble();
                roomList.get(roomSelected - 1).setPricing(price);
                staffMenu();

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
                staffMenu();

            case 4:
                System.out.print("----------------------\n");
                System.out.println("Room PROMOCODE");
                System.out.print(".............\n");

                input.next();
                String PC = input.nextLine();
                roomList.get(roomSelected - 1).setPromocode(PC);
                staffMenu();

            case 5:
                System.out.print("----------------------\n");
                System.out.println("Room Capacity");
                System.out.print(".............\n");

                int c = input.nextInt();
                roomList.get(roomSelected - 1).setCapacity(c);
                staffMenu();
        }
    }

    private static void studentMenu() {
        System.out.println("----------------------");
        System.out.println("==> Student Menu");
        System.out.print("----------------------\n");
        System.out.println("1.View Room List");
        System.out.println("2.Make a room booking");
        System.out.println("3.Edit room booking");
        System.out.println("4.Delete room booking");
        System.out.println("5.Log out");
        System.out.print(".............\n");

        try {
            int studentOption;
            input = new Scanner(System.in);
            studentOption = input.nextInt();

            switch (studentOption) {
                case 1:
                    System.out.print("Vacant\n");
                    System.out.print("----------------------\n");

                    for (int i = 0; i < roomList.size(); i++) {
                        System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
                        System.out.println(roomList.get(i));
                        System.out.print("----------------------\n");
                    }

                    System.out.print("Occupied\n");
                    System.out.print("----------------------\n");

                    for (int i = 0; i < occupiedRoomList.size(); i++) {
                        System.out.printf("%nRoom %d is %s ", i + 1, occupiedRoomList.get(i).getAvailability());
                        System.out.println(occupiedRoomList.get(i));
                        System.out.print("----------------------\n");
                    }

                    studentMenu();

                case 2:
                    bookingMenu();

                case 3:
                    editRoomBooking();

                case 4:
                    roomRemoval();

                case 5:
                    firstMenu();

            }

            if (studentOption > 5 || studentOption < 1) {
                System.out.println("\nEnter a number between 1 and 4\n");
                studentMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nplease enter number");
            studentMenu();
        }

    }

    private static void editRoomBooking() {
        input = new Scanner(System.in);

        for (int i = 0; i < occupiedRoomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, occupiedRoomList.get(i).getAvailability());
            System.out.println(occupiedRoomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        System.out.print(".............\n");

        int roomSelected;
        roomSelected = input.nextInt();
        roomSelected -= 1;

        occupiedRoomList.get(roomSelected).setBooked("Vacant");
        Room temp = occupiedRoomList.get(roomSelected);
        roomList.add(temp);

        occupiedRoomList.remove(temp);

        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        System.out.print(".............\n");

        int roomSelected2;
        roomSelected2 = input.nextInt();
        roomSelected2 -= 1;

        roomList.get(roomSelected2).setBooked("Occupied");
        temp = roomList.get(roomSelected2);
        occupiedRoomList.add(temp);
        roomList.remove(temp);

        System.out.println("Room booked successfully");

        studentMenu();
    }

    private static void bookingMenu() {
        for (int i = 0; i < roomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, roomList.get(i).getAvailability());
            System.out.println(roomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        System.out.print(".............\n");

        int roomSelected;
        roomSelected = input.nextInt();
        roomSelected -= 1;

        if (roomList.get(roomSelected).getBooked() == "Vacant"
                && roomList.get(roomSelected).getAvailability() == "Available") {

            System.out.print("----------------------\n");
            System.out.println("Do you have a Promo Code?");
            System.out.print(".............\n");

            input.nextLine();
            String promo;
            promo = input.nextLine();

            if (roomList.get(roomSelected).getPromocode().equals(promo)) {
                double discountedPrice = roomList.get(roomSelected).getPricing() * 0.8;
                System.out.print("----------------------\n");
                System.out.printf("Room price after discount is %.2f%n", discountedPrice);

            } else {
                System.out.printf("Room price without discount is %.2f%n", roomList.get(roomSelected).getPricing());
            }

            roomList.get(roomSelected).setBooked("Occupied");
            Room temp = roomList.get(roomSelected);
            occupiedRoomList.add(temp);
            roomList.remove(temp);

            System.out.print("----------------------\n");
            System.out.println("Room booked successfully");

            studentMenu();

        } else {
            System.out.print("----------------------\n");
            System.out.printf("Room is already occupied or its unavailable for booking%nPlease select another room%n");
            System.out.print("----------------------\n");
            bookingMenu();
        }
    }

    private static void roomRemoval() {
        input = new Scanner(System.in);
        for (int i = 0; i < occupiedRoomList.size(); i++) {
            System.out.printf("%nRoom %d is %s ", i + 1, occupiedRoomList.get(i).getAvailability());
            System.out.println(occupiedRoomList.get(i));
            System.out.print("----------------------\n");
        }

        System.out.println("Select a room");
        System.out.print(".............\n");

        int roomSelected;
        roomSelected = input.nextInt();
        roomSelected -= 1;

        occupiedRoomList.get(roomSelected).setBooked("Vacant");

        Room temp = occupiedRoomList.get(roomSelected);
        roomList.add(temp);
        occupiedRoomList.remove(temp);

        studentMenu();
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

class User {
    String username;
    String password;
    Boolean isStaff;

    public User() {
        isStaff = false;
    }

    public User(String username, String password, Boolean isStaff) {
        this.username = username;
        this.password = password;
        this.isStaff = isStaff;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isStaff() {
        return isStaff;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public String toString() {
        return String.format("User: %s%nPassword: %s%nStaff: %b", getUsername(), password, isStaff);
    }
}
