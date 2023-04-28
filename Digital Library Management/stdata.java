import java.util.Scanner;

public class stdata {

  Scanner input = new Scanner(System.in);
  registerSt theStudents[] = new registerSt[50];

  public static int count = 0;

  public void addStudent(registerSt s) {
    for (int i = 0; i < count; i++) {
      if (s.regNum.equalsIgnoreCase(theStudents[i].regNum)) {
        System.out.println(
          "Student of Reg Num " + s.regNum + " is Already Registered."
        );

        return;
      }
    }

    if (count <= 50) {
      theStudents[count] = s;
      count++;
    }
  }

  public void showAllStudents() {
    System.out.println("Student Name\t\tReg Number");
    for (int i = 0; i < count; i++) {
      System.out.println(
        theStudents[i].studentName + "\t\t" + theStudents[i].regNum
      );
    }
  }

  public int isStudent() {
    System.out.println("Enter Reg Number:");

    String regNum = input.nextLine();

    for (int i = 0; i < count; i++) {
      if (theStudents[i].regNum.equalsIgnoreCase(regNum)) {
        return i;
      }
    }

    System.out.println("Student is not Registered.");
    System.out.println("Get Registered First.");

    return -1;
  }

  public void checkOutBook(bookData book) {
    int studentIndex = this.isStudent();

    if (studentIndex != -1) {
      System.out.println("Checking Out");

      book.showAllBooks();
      addBook b = book.checkOutBook();

      System.out.println("Checking Out");
      if (b != null) {
        if (theStudents[studentIndex].booksCount <= 3) {
          System.out.println("Adding Book");
          theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] =
            b;
          theStudents[studentIndex].booksCount++;

          return;
        } else {
          System.out.println("Student Can not Borrow more than 3 Books.");
          return;
        }
      }
      System.out.println("Sorry! Book is not Available.");
    }
  }

  public void checkInBook(bookData book) {
    int studentIndex = this.isStudent();
    if (studentIndex != -1) {
      System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");

      registerSt s = theStudents[studentIndex];

      for (int i = 0; i < s.booksCount; i++) {
        System.out.println(
          s.borrowedBooks[i].sNo +
          "\t\t\t\t" +
          s.borrowedBooks[i].bookName +
          "\t\t\t\t" +
          s.borrowedBooks[i].authorName
        );
      }

      System.out.println("Enter Serial Number of Book to be Checked In:");

      int sNo = input.nextInt();

      for (int i = 0; i < s.booksCount; i++) {
        if (sNo == s.borrowedBooks[i].sNo) {
          book.checkInBook(s.borrowedBooks[i]);
          s.borrowedBooks[i] = null;

          return;
        }
      }

      System.out.println("Book of Serial No " + sNo + "not Found");
    }
  }
}
