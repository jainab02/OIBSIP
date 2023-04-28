import java.util.Scanner;

public class addBook {

  public int sNo;
  public String bookName;
  public String authorName;
  public int price;
  public int priceCopy;
  Scanner sc = new Scanner(System.in);

  // Method
  // To add book details
  public addBook() {
    // Display message for taking sc later
    // taking sc via
    // nextInt() and nextLine() standard methods
    System.out.println("Enter Serial Number of the Book :");
    this.sNo = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter Name of the book :");
    this.bookName = sc.nextLine();

    System.out.println("Enter Name of the Author:");
    this.authorName = sc.nextLine();

    System.out.println("Enter Price of the book:");
    this.price = sc.nextInt();
    priceCopy = this.price;
  }
}
