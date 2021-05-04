import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class input implements ActionListener{
  private JFrame menu;
  private JLabel prompt;
  private JTextField text_input;
  private JButton simulate_btn;
  private JButton cancel_btn;
  input(){
    //component declarations
    menu = new JFrame("Sieve of Erastosthenes");
    prompt = new JLabel("Enter an Integer greater than 1");
    text_input = new JTextField("Input Here");
    simulate_btn = new JButton("Simulate");
    cancel_btn = new JButton("Cancel");
    //prompt
    prompt.setBounds(48, 10, 250,30);
    prompt.setFont(new Font("Arial", Font.PLAIN, 12));
    //simulate_btn
    simulate_btn.setBounds(165, 85, 85, 30);
    simulate_btn.setFont(new Font("Arial", Font.PLAIN, 11));
    simulate_btn.addActionListener(this);
    //cancel_btn
    cancel_btn.setBounds(50, 85, 85, 30);
    cancel_btn.setFont(new Font("Arial", Font.PLAIN, 11));
    cancel_btn.addActionListener(this);
    //text_input
    text_input.setBounds(25,50,250,30);
    //menu
    menu.add(cancel_btn);
    menu.add(simulate_btn);
    menu.add(text_input);
    menu.add(prompt);
    menu.setSize(300,150);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setResizable(false);
    menu.setLayout(null);
    menu.setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e){
    //this part of the code checks where the event happen
    if(e.getSource() == simulate_btn){
      try{
        //checks input if its integer and input > 1
        String input = text_input.getText();
        int n = Integer.parseInt(input); 
        if(n>1){
          new sieve(n);
          menu.setVisible(false);
        }     
      }catch(Exception error){
        System.out.println("invalid input" + error);
      }
    }else if(e.getSource() == cancel_btn){
      //terminates the program
      System.out.println("Terminated");
      System.exit(0);
    }
    
  }
  
  public static void main(String[] args){
    new input();
  }
}
