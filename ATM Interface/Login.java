import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

  String pin = "9099";
  int attempts = 3;

  public Login() {
    super("Login Screen");
    setLayout(new BorderLayout());
    setResizable(false);
    setLocationRelativeTo(null);
    buildApp();
    pack();
    setSize(250, 110);
    setVisible(true);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new Login();
  }

  void buildApp() {
    JLabel pinInstruction = new JLabel("Please enter your pin number");
    JPasswordField pinText = new JPasswordField(4);
    JButton entPin = new JButton("Enter");
    JButton quit = new JButton("Quit");
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(quit);
    buttonPanel.add(entPin);
    pinText.setBackground(Color.white);
    add(pinInstruction, BorderLayout.NORTH);
    add(pinText, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    quit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          System.exit(0);
        }
      }
    );

    pinText.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          char[] pinGuess = pinText.getPassword();
          String pinString = new String(pinGuess);
          if (pinString.equals(pin)) {
            JOptionPane.showMessageDialog(
              null,
              "The pin is correct! Opening Account..."
            );
            dispose();
            new ATM();
          } else {
            if (attempts != 1) {
              attempts--;
              JOptionPane.showMessageDialog(
                null,
                "That pin is incorrect! \n" + attempts + " attempts remaining!"
              );
            } else {
              JOptionPane.showMessageDialog(
                null,
                "No Attempts remaining! \n Closing Program"
              );
              System.exit(0);
            }
          }
        }
      }
    );
    entPin.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          char[] pinGuess = pinText.getPassword();
          String pinString = new String(pinGuess);
          if (pinString.equals(pin)) {
            JOptionPane.showMessageDialog(
              null,
              "That pin is correct! Opening Account..."
            );
            dispose();
            new ATM();
          } else {
            if (attempts != 1) {
              attempts--;
              JOptionPane.showMessageDialog(
                null,
                "That pin is incorrect! \n" + attempts + " attempts remaining!"
              );
            } else {
              JOptionPane.showMessageDialog(
                null,
                "No Attempts remaining! \n Closing Program"
              );
              System.exit(0);
            }
          }
        }
      }
    );
  }
}
