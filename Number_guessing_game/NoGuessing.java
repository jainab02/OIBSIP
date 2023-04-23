// Task-1
// numver guesssing system

import java.util.Random;
import javax.swing.JOptionPane;

public class NoGuessing {

  public static void main(String[] args) {
    int chances = 5; //number of chances you want
    int result = 0; // score

    // starting the app
    JOptionPane.showMessageDialog(null, "Let us play Number Guessing Game!!");

    //loop for generating random number
    for (int i = 1; i <= chances; i++) {
      Random rand = new Random();
      int randNumber = rand.nextInt(100) + 1;
      // JOptionPane.showMessageDialog(null, randNumber);
      String n = JOptionPane.showInputDialog(
        "Guess any number between 1 to 100"
      );
      int takenNo = Integer.parseInt(n);

      // if entered no is correct or not
      if (takenNo == randNumber) {
        JOptionPane.showMessageDialog(null, "Congratulations,you are right!");
        result++;
        continue;
      } else if (takenNo != randNumber) {
        JOptionPane.showMessageDialog(
          null,
          "Oops,you are wrong and you have " +
          (chances - i) +
          " chances left keep trying !!"
        );
      }
    }
    // printing score
    if (result > 0) {
      JOptionPane.showMessageDialog(null, "Your ScoreBoard is " + result);
    } else {
      JOptionPane.showMessageDialog(null, "Your ScoreBoard is " + result);
    }
  }
}
