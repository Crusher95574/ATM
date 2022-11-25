
package ATM.manangement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,  Withdrawl,Fastcash,Balance,Exit;
    String pinno;
    Transactions( String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
             Image i2 =i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);//bec there is no image class in swing awt package is used//image sizing
             ImageIcon i3=new ImageIcon(i2);
             JLabel img =new JLabel(i3);
             img.setBounds(0,0,900,800);//placing image
             add(img);// for pasting icon onto frame
             
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(230,260,700,35);  
        text.setFont(new Font("verdana",Font.ITALIC,14));
        text.setForeground(Color.WHITE);
        img.add(text);// used to add text on image
        
        //deposit button
        
     deposit=new JButton("Deposit");
     deposit.setFont(new Font("Verdana",Font.ITALIC,15));
     deposit.setBounds(190,375,100,18);
     deposit.addActionListener(this);
     img.add(deposit);
     
     //withdrawal
        
       Withdrawl=new JButton("  Withdraw");
       Withdrawl.setFont(new Font("Verdana",Font.ITALIC,15));
       Withdrawl.setBounds(370,375,100,18);
       Withdrawl.addActionListener(this);
     img.add(  Withdrawl);
     
     //Fastcash
    Fastcash=new JButton("Fastcash");
    Fastcash.setFont(new Font("Verdana",Font.ITALIC,15));
    Fastcash.setBounds(370,405,100,18);
    Fastcash.addActionListener(this);
     img.add(  Fastcash);
     
      //Balance enquiry
    Balance=new JButton("Balance ");
    Balance.setFont(new Font("Verdana",Font.ITALIC,15));
    Balance.setBounds(190,405,100,18);
    Balance.addActionListener(this);
     img.add(  Balance);
     
     
      
     
      //Exit
    Exit=new JButton("Exit");
    Exit.setFont(new Font("Verdana",Font.ITALIC,15));
    Exit.setBounds(370,435,100,18);
    Exit.addActionListener(this);
     img.add(  Exit);
     
     
        //frame
    setSize(900,800);
    setLocation(340,12);
    setUndecorated(true);
    setVisible(true);
    
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Exit){
            System.exit(0);
        }else if(ae.getSource() ==deposit){
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }else if(ae.getSource() == Withdrawl){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
        }else if(ae.getSource() == Fastcash){
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        }else if(ae.getSource() == Balance){
            setVisible(false);
            new Balance(pinno).setVisible(true);}
        
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
