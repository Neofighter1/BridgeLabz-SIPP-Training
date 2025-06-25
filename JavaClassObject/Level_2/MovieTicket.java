package Level_2;
import java.util.Scanner;

public class MovieTicket {

    String movieName;
    int seatNumber;
    double price;

    void bookTicket(String movie, int seat, double price) {
        this.movieName = movie;
        this.seatNumber = seat;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie name: ");
        String movie = sc.nextLine();
        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();
        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket(movie, seat, price);
        ticket.displayDetails();
        sc.close();
    }
}

