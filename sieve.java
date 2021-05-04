import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

class sieve{
  private JPanel panel;
  private JFrame frame;
  private JButton[] label;
   sieve(int n) throws InterruptedException{
     frame = new JFrame("Sieve");
     // codes for dynamic size
     int width = n, height = 70;
     int panel_height = height;
     int col = 0;
     if(n < 10){
       width = 70 * width;
       col = n;
     } else{
       if(n <= 50){
         height = height * n/10;
         panel_height = height;
       } else{
         height = 500;
         if(70 % n == 0){
           panel_height = panel_height * (n/10);
         } else{
           panel_height = panel_height * (1 + (n/10));
         }   
       }
       width = 700;
       col = 10;
       
     }
     //panel initialization
     panel = new JPanel();
     panel.setLayout(new GridLayout(0,col));
     panel.setPreferredSize(new Dimension(width,panel_height));
     panel.setBackground(Color.GRAY);
     //populate labels[i]... label[n]
     int[] array = new int[n];
     label = new JButton[n];
     for(int i = 1; i <= n;i++){
       array[i-1] = i;
       String x = String.valueOf(i);
       label[i-1] = new JButton(x);
       label[i-1].setFont(new Font("Arial", Font.PLAIN, 10));
       label[i-1].setPreferredSize(new Dimension(70,70));
       label[i-1].setBackground(Color.GREEN);
       label[i-1].setHorizontalAlignment(SwingConstants.CENTER);
       panel.add(label[i-1]);  
     }
     JScrollPane pane = new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
     //sets 1 always to gray
     label[0].setBackground(Color.GRAY);
     //code for sieve algorithm
     for(int i = 2; i*i <=n; i++){      
       if (array[i-1] != 0){
         for(int j= i*i; j<=n;j+=i){
           remove(j-1);
           array[j-1] = 0;
         }
       }
     }
     frame.add(pane);
     frame.setSize(width + 20, height + 30);          
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setResizable(false);
     frame.setVisible(true);

  }
  //function to change the removed component's color to YELLOW
  public void remove(int index){
    label[index].setBackground(Color.YELLOW);
    label[index].revalidate();
    String x = label[index].getText();
  }


}
