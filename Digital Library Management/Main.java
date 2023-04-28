import java.util.Scanner;

public class Main {

  // Main method
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Displaying menu
    System.out.println(
      "\n********************Welcome to Library!********************"
    );
    System.out.println("\nSelect From The Options Given Below: ");

    bookData ob = new bookData();
    stdata obStudent = new stdata();

    int choice;
    int searchChoice;
    //menu
    do {
      ob.dispMenu();
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          addBook b = new addBook();
          ob.addBook(b);
          break;
        case 2:
          ob.upgradeprice();
          break;
        case 3:
          System.out.println(" 1 :  Search with Book Serial No.");
          System.out.println(" 2 : Search with Book's Author Name.");
          searchChoice = sc.nextInt();
          switch (searchChoice) {
            case 1:
              ob.searchBySno();
              break;
            case 2:
              ob.searchByAuthorName();
          }
          break;
        case 4:
          ob.showAllBooks();
          break;
        case 5:
          registerSt s = new registerSt();
          obStudent.addStudent(s);
          break;
        case 6:
          obStudent.showAllStudents();
          break;
        case 7:
          obStudent.checkOutBook(ob);
          break;
        case 8:
          obStudent.checkInBook(ob);
          break;
        default:
          System.out.println("Exit!!");
      }
    } while (choice != 0);
    sc.close();
  }
}
