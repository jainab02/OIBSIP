import java.util.Scanner;

public class bookData {

  addBook theBooks[] = new addBook[50];
  public static int count;

  Scanner input = new Scanner(System.in);

  //  comparing books
  public int compareBookObjects(addBook b1, addBook b2) {
    // book name matches
    if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
      System.out.println("Book of this Name Already Exists.");
      return 0;
    }

    // serial no matches
    if (b1.sNo == b2.sNo) {
      System.out.println("Book of this Serial No Already Exists.");

      return 0;
    }
    return 1;
  }

  // adding book
  public void addBook(addBook b) {
    for (int i = 0; i < count; i++) {
      if (this.compareBookObjects(b, this.theBooks[i]) == 0) return;
    }

    if (count < 50) {
      theBooks[count] = b;
      count++;
    } else {
      System.out.println("No Space to Add More Books.");
    }
  }

  public void searchBySno() {
    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        System.out.println(
          theBooks[i].sNo +
          "\t\t" +
          theBooks[i].bookName +
          "\t\t" +
          theBooks[i].authorName +
          "\t\t" +
          theBooks[i].priceCopy +
          "\t\t" +
          theBooks[i].price
        );
        flag++;
        return;
      }
    }
    if (flag == 0) System.out.println(
      "No Book for Serial No " + sNo + " Found."
    );
  }

  public void searchByAuthorName() {
    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

    input.nextLine();

    System.out.println("Enter Author Name:");
    String authorName = input.nextLine();

    int flag = 0;

    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

    for (int i = 0; i < count; i++) {
      if (authorName.equalsIgnoreCase(theBooks[i].authorName)) {
        System.out.println(
          theBooks[i].sNo +
          "\t\t" +
          theBooks[i].bookName +
          "\t\t" +
          theBooks[i].authorName +
          "\t\t" +
          theBooks[i].priceCopy +
          "\t\t" +
          theBooks[i].price
        );
        flag++;
      }
    }
    if (flag == 0) System.out.println("No Books of " + authorName + " Found.");
  }

  public void showAllBooks() {
    System.out.println("\t\t********SHOWING ALL BOOKS********\n");
    System.out.println(
      "S.No\t\t\tName\t\t\t\t\tAuthor\t\t\t\tAvail Qty\t\tTotal Qty"
    );

    for (int i = 0; i < count; i++) {
      System.out.println(
        theBooks[i].sNo +
        "\t\t\t\t" +
        theBooks[i].bookName +
        "\t\t\t\t\t\t" +
        theBooks[i].authorName +
        "\t\t\t\t\t" +
        theBooks[i].priceCopy +
        "\t\t\t\t\t" +
        theBooks[i].price
      );
    }
  }

  public void upgradeprice() {
    System.out.println("\t\t********UPGRADE PRICE OF A BOOK********\n");
    System.out.println("Enter Serial No. of Book : ");

    int sNo = input.nextInt();

    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        System.out.println("Enter No. of Books to be Added :");

        int addingQty = input.nextInt();
        theBooks[i].price += addingQty;
        theBooks[i].priceCopy += addingQty;

        return;
      }
    }
  }

  public void dispMenu() {
    // Displaying menu
    System.out.println(
      "----------------------------------------------------------------------------------------------------------"
    );
    System.out.println("1 : Add new Book");
    System.out.println("2 : Upgrade Price of a Book");
    System.out.println("3 : Search a Book");
    System.out.println("4 : Show All Books");
    System.out.println("5 : Register Student");
    System.out.println("6 : Show All Registered Students");
    System.out.println("7 : Check Out Book");
    System.out.println("8 : Check In Book");
    System.out.println("0 : Exit!!");
    System.out.println(
      "-----------------------------------------------------------------------------------------------------------"
    );
  }

  public int isAvailable(int sNo) {
    for (int i = 0; i < count; i++) {
      if (sNo == theBooks[i].sNo) {
        if (theBooks[i].priceCopy > 0) {
          System.out.println("Book is Available.");
          return i;
        }
        System.out.println("Book is Unavailable");
        return -1;
      }
    }

    System.out.println("No Book of Serial Number " + " Available in Library.");
    return -1;
  }

  public addBook checkOutBook() {
    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = input.nextInt();

    int bookIndex = isAvailable(sNo);

    if (bookIndex != -1) {
      theBooks[bookIndex].priceCopy--;
      return theBooks[bookIndex];
    }
    return null;
  }

  public void checkInBook(addBook b) {
    for (int i = 0; i < count; i++) {
      if (b.equals(theBooks[i])) {
        theBooks[i].priceCopy++;
        return;
      }
    }
  }
}
