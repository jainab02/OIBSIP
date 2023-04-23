// functions:
// login
// update profile and password
// selectiing ans for mcq
// timer and auto submit
// closing session and logout

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

class login extends JFrame implements ActionListener {

  JButton btn;
  JPanel panel;
  JLabel useridJLabel, passJLabel;
  JTextField tfield1, tfield2;

  login() {
    useridJLabel = new JLabel();
    useridJLabel.setText("UserName");
    tfield1 = new JTextField(15);
    passJLabel = new JLabel();
    passJLabel.setText("Password");
    tfield2 = new JPasswordField(8);
    btn = new JButton("Submit");
    panel = new JPanel(new GridLayout(3, 1));
    btn.setBounds(50, 10, 50, 70);
    panel.add(useridJLabel);
    panel.add(tfield1);
    panel.add(passJLabel);
    panel.add(tfield2);
    panel.add(btn, Component.CENTER_ALIGNMENT);
    add(panel, BorderLayout.PAGE_START);
    btn.addActionListener(this);
    setTitle("Login");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String userid = tfield1.getText();
    String pwd = tfield2.getText();
    if (!pwd.equals("")) {
      new McqSec(userid);
    } else {
      tfield2.setText("Please Enter Password");
      actionPerformed(e);
    }
  }
}

class McqSec extends JFrame implements ActionListener {

  JLabel label1;
  JLabel label2;
  JLabel label3;
  JRadioButton jb[] = new JRadioButton[6];
  JButton btn1, btn2, logoutButton;
  ButtonGroup bg;
  int count = 1;
  int curr = 0;
  int x = 1, y = 1, now = 0;
  int arr[] = new int[10];
  Timer time = new Timer();

  McqSec(String s) {
    // super(s);
    label1 = new JLabel();
    label2 = new JLabel();
    // label3 = new JLabel();
    add(label1);
    add(label2);
    bg = new ButtonGroup();
    for (int i = 0; i < 5; i++) {
      jb[i] = new JRadioButton();
      add(jb[i]);
      bg.add(jb[i]);
    }
    btn1 = new JButton("Save and Next");
    btn2 = new JButton("Review for Later");
    logoutButton = new JButton("Logout");
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    logoutButton.addActionListener(this);
    add(btn1);
    add(btn2);
    add(logoutButton);
    questions();
    label1.setBounds(40, 40, 500, 50);
    label2.setBounds(20, 20, 500, 50);
    jb[0].setBounds(50, 80, 100, 20);
    jb[1].setBounds(50, 110, 100, 20);
    jb[2].setBounds(50, 140, 100, 20);
    jb[3].setBounds(50, 170, 100, 20);
    btn1.setBounds(95, 240, 140, 30);
    btn2.setBounds(270, 240, 150, 30);
    logoutButton.setBounds(150, 280, 80, 18);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setLocation(250, 150);
    setVisible(true);
    setSize(1000, 500);
    setTitle("Java Test");
    time.scheduleAtFixedRate(
      new TimerTask() {
        int i = 600;

        public void run() {
          label2.setText("Time left: " + i);
          i--;
          if (i < 0) {
            time.cancel();
            label1.setText("Timer finished,better luck next time!!");
          }
        }
      },
      10,
      1000
    );
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btn1) {
      if (check()) {
        count++;
      }
      curr++;
      questions();
      if (curr == 9) {
        btn1.setEnabled(false);
        btn2.setText("Your Score");
      }
    }
    if (e.getActionCommand().equals("Review for Later")) {
      JButton btn3 = new JButton("Review" + x);
      btn3.setBounds(480, 20 + 30 * x, 100, 30);
      add(btn3);
      btn3.addActionListener(this);
      arr[x] = curr;
      x++;
      curr++;
      questions();
      if (curr == 9) {
        btn2.setText("Your Score");
      }
      setVisible(false);
      setVisible(true);
    }
    for (int i = 0, y = 1; i < x; i++, y++) {
      if (e.getActionCommand().equals("Review" + y)) {
        if (check()) {
          count++;
        }
        now = curr;
        curr = arr[y];
        questions();
        ((JButton) e.getSource()).setEnabled(false);
        curr = now;
      }
    }
    if (e.getActionCommand().equals("Your Score")) {
      if (check()) {
        count++;
      }
      curr++;
      JOptionPane.showConfirmDialog(this, "Your Score: " + (count - 1));
      System.exit(0);
    }
    if (e.getSource() == logoutButton) {
      System.exit(0);
    }
  }

  //Mcq setter
  void questions() {
    jb[4].setSelected(true);
    if (curr == 0) {
      label1.setText("Q:1  Who invented Java Programming?");
      jb[0].setText("Guido van Rossum");
      jb[1].setText("James Gosling");
      jb[2].setText("Dennis Ritchie");
      jb[3].setText("Bjarne Stroustrup");
    }
    if (curr == 1) {
      label1.setText(
        "Q:2  Which component is used to compile, debug and execute the java programs?"
      );
      jb[0].setText("JRE");
      jb[1].setText("JIT");
      jb[2].setText("JDK");
      jb[3].setText("JVM");
    }
    if (curr == 2) {
      label1.setText("Q:3  Which one of the following is not a Java feature?");
      jb[0].setText("Object-oriented");
      jb[1].setText("Use of Pointers");
      jb[2].setText("Portable");
      jb[3].setText("Dynamic and Extensible");
    }
    if (curr == 3) {
      label1.setText("Q:4  What is the extension of java code files?");
      jb[0].setText(".txt");
      jb[1].setText(".js");
      jb[2].setText(".class");
      jb[3].setText(".java");
    }
    if (curr == 4) {
      label1.setText(
        "Q:5  Which of these cannot be used for a variable name in Java?"
      );
      jb[0].setText("identifier & keyword");
      jb[1].setText("identifier");
      jb[2].setText("Keyword");
      jb[3].setText("None of the above");
    }
    if (curr == 5) {
      label1.setText(
        "Q:6  Which of the following is not an OOPS concept in Java?"
      );
      jb[0].setText("Polymorphism");
      jb[1].setText("Inheritance");
      jb[2].setText("Compilation");
      jb[3].setText("Encapsulation");
    }
    if (curr == 6) {
      label1.setText("Q:7  What is the extension of compiled java classes?");
      jb[0].setText(".txt");
      jb[1].setText(".js");
      jb[2].setText(".class");
      jb[3].setText(".java");
    }
    if (curr == 7) {
      label1.setText("Q:8  Which of these are selection statements in Java??");
      jb[0].setText("Break");
      jb[1].setText("continue");
      jb[2].setText("for()");
      jb[3].setText("if()");
    }
    if (curr == 8) {
      label1.setText("Q:9  What is not the use of “this” keyword in Java?");
      jb[0].setText(
          "Referring to the instance variable when a local variable has the same name"
        );
      jb[1].setText("Passing itself to the method of the same class");
      jb[2].setText("Passing itself to another method");
      jb[3].setText("Calling another constructor in constructor chaining");
    }
    if (curr == 9) {
      label1.setText("Q:10  What is Truncation in Java?");
      jb[0].setText("Floating-point value assigned to a Floating type");
      jb[1].setText("Floating-point value assigned to an integer type");
      jb[2].setText("Integer value assigned to floating type");
      jb[3].setText("Integer value assigned to double type");
    }
    label1.setBounds(40, 40, 500, 50);
    for (int i = 0, j = 0; i <= 90; i += 30, j++) {
      jb[j].setBounds(50, 80 + i, 200, 20);
    }
  }

  //correct answers
  boolean check() {
    if (curr == 0) {
      return (jb[1].isSelected());
    }
    if (curr == 1) {
      return (jb[2].isSelected());
    }
    if (curr == 2) {
      return (jb[1].isSelected());
    }
    if (curr == 3) {
      return (jb[3].isSelected());
    }
    if (curr == 4) {
      return (jb[2].isSelected());
    }
    if (curr == 5) {
      return (jb[2].isSelected());
    }
    if (curr == 6) {
      return (jb[2].isSelected());
    }
    if (curr == 7) {
      return (jb[3].isSelected());
    }
    if (curr == 8) {
      return (jb[1].isSelected());
    }
    if (curr == 9) {
      return (jb[1].isSelected());
    }
    return false;
  }
}

public class ExamApp {

  public static void main(String[] args) throws Exception {
    login loginform = new login();
    loginform.setSize(400, 125);
    loginform.setVisible(true);
  }
}
