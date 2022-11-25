
package ATM.manangement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;//for date

public class Deposit extends JFrame implements ActionListener {
   JLabel text;
   JTextField amountTextField;
   JButton deposit,back;
   String pinno;
    Deposit(String pinno){
        this.pinno=pinno;
         setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
             Image i2 =i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);//bec there is no image class in swing awt package is used//image sizing
             ImageIcon i3=new ImageIcon(i2);
             JLabel img =new JLabel(i3);
             img.setBounds(0,0,900,800);//placing image
             add(img);// for pasting icon onto frame
             
        text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(205,260,700,35);  
        text.setFont(new Font("verdana",Font.ITALIC,14));
       text.setForeground(Color.WHITE);
        img.add(text);// used to add text on image
        
        amountTextField=new JTextField(); 
        add(amountTextField);
        amountTextField.setBounds(205,305,270,30);
        img.add(amountTextField); 
        
        //deposit button
      deposit=new JButton("Deposit");
     deposit.setFont(new Font("Verdana",Font.ITALIC,15));
     deposit.setBounds(268,365,100,18);
     deposit.addActionListener(this);
     img.add(deposit);
     
     //back
     back=new JButton("Back");
     back.setFont(new Font("Verdana",Font.ITALIC,15));
     back.setBounds(268,395,100,18);
     back.addActionListener(this);
     img.add(back);
                //frame
    setSize(900,800);
    setLocation(340,12);
   // setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==deposit){
           String samount=amountTextField.getText();
           Date date =new Date();
           
                if(samount.equals("")){
                   JOptionPane.showMessageDialog(null,"No amount has been entered");
                }
                else {
                         try{
                     Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 String query="insert into money values('"+pinno+"','"+date+"','"+"Deposit"+"','"+samount+"')";
                 con.stmt.executeUpdate(query);
               
                 //info about amount
                  JOptionPane.showMessageDialog(null,"Rs"+samount+"\n Deposited Successfully"  );
               
                  setVisible(false);
                  new Transactions(pinno).setVisible(true);
                }
                         catch(Exception e){
                System.out.println(e);
            }
            }
            
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
    
}
