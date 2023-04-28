import java.util.Scanner;

public class registerSt {

  String studentName;
  String regNum;

  addBook borrowedBooks[] = new addBook[3];
  public int booksCount = 0;
  Scanner input = new Scanner(System.in);

  // Constructor
  public registerSt() {
    System.out.println("Enter Student Name:");

    this.studentName = input.nextLine();

    System.out.println("Enter Registration Number:");
    this.regNum = input.nextLine();
  }
}
