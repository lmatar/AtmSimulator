import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AtmMain
{
  private static JFrame frame;
  private static JLabel atmlbl,userlbl,passlbl,withlbl,depolbl,totallbl;
  private static JTextField usertxt,withtxt,deptxt;
  private static JPasswordField passtxt;
  private static JPanel panel,menuPanel,withPanel,depoPanel,totalPanel;
  private static JButton loginbttn, withdrawbttn,depositbttn,totalbttn,exitbttn,returnbttn,wenterbttn,denterbttn;
  private static double total;
  private static String user;
  private static String password;

  public AtmMain(double t, String u, String p)
  {
    total = t;
    user = u;
    password = p;
  }

  public static void deposit(double i)
  {
       total += i;
  }

  public static void withdraw(double j)
  {
        if (j  > total)
        {
              JOptionPane.showMessageDialog(null, "Error you only have " + getTotal() + " on your account");
              wClicked();
        }
        else
        {
              total -= j;
        }
  }

  public static double getTotal()
  {
       return total;
  }

  public static String getUser()
  {
        return user;
  }

  public static String getPassword()
  {
        return password;
  }
  public static void login()
  {
    atmlbl = new JLabel("ATM LOGIN",JLabel.CENTER);
    atmlbl.setFont(new Font("Comic Sans", Font.BOLD, 20));
    userlbl = new JLabel("Enter Username: ",JLabel.LEFT);
    userlbl.setFont(new Font("Comic Sans",  Font.BOLD, 10));
    usertxt = new JTextField();
    usertxt.setColumns(20);
    passlbl = new JLabel("Enter Password:", JLabel.LEFT);
    passlbl.setFont(new Font("Comic Sans",  Font.BOLD, 10));
    passtxt = new JPasswordField();//Makes a text field with * to cover what is typed
    passtxt.setColumns(20);
    loginbttn = new JButton("Login");
    loginbttn.setBounds(100,200,50,100);
    frame = new JFrame("ATM Machine");
    panel = new JPanel();
    frame.setSize(500,500);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(panel);
    panel.setBackground(new Color(204, 166, 166));
    panel.setLayout(new GridLayout(10,0));
    panel.add(atmlbl);
    panel.add(userlbl);
    panel.add(usertxt);
    panel.add(passlbl);
    panel.add(passtxt);
    panel.add(loginbttn);
    panel.setVisible(true);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginbttn.addActionListener(new ActionListener()
   {
     public void actionPerformed(ActionEvent e)
     {
      if(e.getSource() == loginbttn)
      {
        String us= usertxt.getText();
        String pa = String.valueOf(passtxt.getPassword());
        if(getUser().equals(us) && getPassword().equals(pa))
        {
          panel.removeAll();
          panel.revalidate();
          panel.repaint();
          menu();
        }else
        {
        JOptionPane.showMessageDialog(null, "Login failed");
        }
       }
     }
   });
}

  public static void menu()
  {
    menuPanel = new JPanel();
    withdrawbttn = new JButton("Withdraw");
    depositbttn = new JButton("Deposit");
    totalbttn = new JButton("View Total");
    frame.setContentPane(menuPanel);
    menuPanel.setBackground(new Color(166, 250, 166));
    menuPanel.setLayout(new GridLayout(5,0));
    menuPanel.add(atmlbl);
    menuPanel.add(withdrawbttn);
    menuPanel.add(depositbttn);
    menuPanel.add(totalbttn);
    withdrawbttn.addActionListener(new ActionListener()
   {
     public void actionPerformed(ActionEvent e)
     {
      if(e.getSource() == withdrawbttn)
      {
        menuPanel.removeAll();
        menuPanel.revalidate();
        menuPanel.repaint();
        wClicked();
      }
      }
   });
   depositbttn.addActionListener(new ActionListener()
  {
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource() == depositbttn)
     {
       menuPanel.removeAll();
       menuPanel.revalidate();
       menuPanel.repaint();
       dClicked();
     }
     }
  });
  totalbttn.addActionListener(new ActionListener()
 {
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource() == totalbttn)
    {
      menuPanel.removeAll();
      menuPanel.revalidate();
      menuPanel.repaint();
      tClicked();
    }
    }
 });
}

  public static void wClicked()
  {
    withPanel = new JPanel();
    withlbl = new JLabel("How much would you like to withdraw?", JLabel.CENTER);
    withtxt = new JTextField();
    wenterbttn = new JButton("Enter");
    withlbl.setFont(new Font("Comic Sans", Font.BOLD,18));
    withtxt.setColumns(20);
    withPanel.setBackground(new Color(166, 166, 222));
    withPanel.setLayout(new GridLayout(6,0));
    withPanel.add(withlbl);
    withPanel.add(withtxt);
    withPanel.add(wenterbttn);
    frame.setContentPane(withPanel);
    wenterbttn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource() == wenterbttn)
        {
          if(withtxt.getText().isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Error please enter something valid");
            wClicked();
          }else
           {
              String amount = withtxt.getText();
              double a = Double.parseDouble(amount);
              withdraw(a);
        }
          withPanel.removeAll();
          withPanel.revalidate();
          withPanel.repaint();
          tClicked();
        }
      }
    });
  }


  public static void dClicked()
  {
    depoPanel = new JPanel();
    depolbl = new JLabel("How much would you like to deposit?",JLabel.CENTER);
    deptxt = new JTextField();
    denterbttn = new JButton("Enter");
    depolbl.setFont(new Font("Comic Sans", Font.BOLD,18));
    deptxt.setColumns(20);
    depoPanel.setLayout(new GridLayout(6,0));
    depoPanel.setBackground(new Color(166, 166, 222));
    depoPanel.add(depolbl);
    depoPanel.add(deptxt);
    depoPanel.add(denterbttn);
    frame.setContentPane(depoPanel);
    denterbttn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource() == denterbttn)
        {
          if(deptxt.getText().isEmpty())
          {
            JOptionPane.showMessageDialog(null, "Error please enter something valid");
            dClicked();
          }else
          {
            String amount = deptxt.getText();
            double a = Double.parseDouble(amount);
            deposit(a);
          }
          depoPanel.removeAll();
          depoPanel.revalidate();
          depoPanel.repaint();
          tClicked();
        }
      }
    });
  }


  public static void tClicked()
  {
    totalPanel = new JPanel();
    totallbl = new JLabel(getUser() + "'s account has $" + getTotal() + " currently");
    exitbttn = new JButton("Exit");
    returnbttn = new JButton("Return to menu");
    totalPanel.setLayout(new GridLayout(10,0));
    totalPanel.setBackground(new Color(166, 166, 222));
    totalPanel.add(totallbl);
    totalPanel.add(returnbttn);
    totalPanel.add(exitbttn);
    frame.setContentPane(totalPanel);
    returnbttn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource() == returnbttn)
        {
          totalPanel.removeAll();
          totalPanel.revalidate();
          totalPanel.repaint();
          menu();
        }
      }
    });
    exitbttn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource() == exitbttn)
        {
          frame.setVisible(false);
          frame.dispose();
        }
      }
    });
  }
  public static void main (String[] args)
  {
    AtmMain bank1 = new AtmMain(0,"Lynn Matar","github");
    login();
  }
}
