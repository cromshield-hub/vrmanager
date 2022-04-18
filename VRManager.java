import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRManager {
    private Scanner scanner = new Scanner(System.in);
    List<Customer> customers = new ArrayList<Customer>();
    List<Video> videos = new ArrayList<Video>();

    public VRManager() {

    }

    
    public void clearRentals() {
        System.out.println("Enter customer name: ");
        String customerName = getScanner().next();

        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            System.out.println("Name: " + foundCustomer.getName() +
                    "\tRentals: " + foundCustomer.getRentals().size());
            for (Rental rental : foundCustomer.getRentals()) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }

            List<Rental> rentals = new ArrayList<Rental>();
            foundCustomer.setRentals(rentals);
        }
    }

    private Customer findCustomer(String customerName) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ");
        String customerName = getScanner().next();

        Customer foundCustomer = findCustomer(customerName);
        if (foundCustomer == null) return;

        System.out.println("Enter video title to return: ");
        String videoTitle = getScanner().next();

        List<Rental> customerRentals = foundCustomer.getRentals();
        for (Rental rental : customerRentals) {
            rental.returnVideo();
            if (rental.isRented(videoTitle)) {
                rental.returnVideo();
                break;
            }
        }
    }

    void init() {
        Customer james = new Customer("James");
        Customer brown = new Customer("Brown");
        customers.add(james);
        customers.add(brown);

        Video v1 = VideoFactory.createVideo(2, "v1", Video.REGULAR, new Date());

        Video v2 = VideoFactory.createVideo(3, "v2", Video.NEW_RELEASE, new Date());
        videos.add(v1);
        videos.add(v2);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        james.addRental(r1);
        james.addRental(r2);
    }

    public void listVideos() {
        System.out.println("List of videos");

        for (Video video : videos) {
            System.out.println("Price code: " + video.getPriceCode() + "\tTitle: " + video.getTitle());
        }
        System.out.println("End of list");
    }

    public void listCustomers() {
        System.out.println("List of customers");
        for (Customer customer : customers) {
            System.out.println("Name: " + customer.getName() +
                    "\tRentals: " + customer.getRentals().size());
            for (Rental rental : customer.getRentals()) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }
        }
        System.out.println("End of list");
    }

    public void getCustomerReport() {
        System.out.println("Enter customer name: ");
        String customerName = getScanner().next();

        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = foundCustomer.getReport();
            System.out.println(result);
        }
    }

    public void rentVideo() {
        System.out.println("Enter customer name: ");
        String customerName = getScanner().next();

        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null) return;

        System.out.println("Enter video title to rent: ");
        String videoTitle = getScanner().next();

        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoTitle) && video.isRented() == false) {
                foundVideo = video;
                break;
            }
        }

        if (foundVideo == null) return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals();
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    public void register(String object) {
        if (object.equals("customer")) {
            System.out.println("Enter customer name: ");
            String name = getScanner().next();
            Customer customer = new Customer(name);
            customers.add(customer);
        } else {
            System.out.println("Enter video title to register: ");
            String title = getScanner().next();

            System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
            int videoType = getScanner().nextInt();

            System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
            int priceCode = getScanner().nextInt();

            Date registeredDate = new Date();
            Video video = VideoFactory.createVideo(videoType, title, videoType, registeredDate);
            videos.add(video);
        }
    }

    private Scanner getScanner() {
        return scanner;
    }
}