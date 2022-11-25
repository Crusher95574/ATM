
package ATM.manangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;//for resultset

public class Fastcash extends JFrame implements ActionListener {
   JButton deposit,  Withdrawl,Fastcash,Balance,Back,pinchange,ten,five;
    String pinno;
    
    Fastcash( String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
             Image i2 =i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);//bec there is no image class in swing awt package is used//image sizing
             ImageIcon i3=new ImageIcon(i2);
             JLabel img =new JLabel(i3);
             img.setBounds(0,0,900,800);//placing image
             add(img);// for pasting icon onto frame
             
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(230,260,700,35);  
        text.setFont(new Font("verdana",Font.ITALIC,14));
        text.setForeground(Color.WHITE);
        img.add(text);// used to add text on image
        
        //50
        
     deposit=new JButton("Rs 50");
     deposit.setFont(new Font("Verdana",Font.ITALIC,15));
     deposit.setBounds(190,375,100,18);
     deposit.addActionListener(this);
     img.add(deposit);
     
     //100
        
       Withdrawl=new JButton("Rs 100");
       Withdrawl.setFont(new Font("Verdana",Font.ITALIC,15));
       Withdrawl.setBounds(370,375,100,18);
       Withdrawl.addActionListener(this);
     img.add(  Withdrawl);
     
     //500
    Fastcash=new JButton("Rs 500");
    Fastcash.setFont(new Font("Verdana",Font.ITALIC,15));
    Fastcash.setBounds(370,405,100,18);
    Fastcash.addActionListener(this);
     img.add(  Fastcash);
     
      //1000
    Balance=new JButton("Rs 1000 ");
    Balance.setFont(new Font("Verdana",Font.ITALIC,15));
    Balance.setBounds(190,405,100,18);
    Balance.addActionListener(this);
     img.add(  Balance);
     
     
      //pinchange
    pinchange=new JButton("Rs 2000");
    pinchange.setFont(new Font("Verdana",Font.ITALIC,15));
    pinchange.setBounds(190,435,100,18);
    pinchange.addActionListener(this);
     img.add(  pinchange);
     
     //5000
    five=new JButton("Rs 5000");
    five.setFont(new Font("Verdana",Font.ITALIC,15));
    five.setBounds(370,435,100,18);
    five.addActionListener(this);
     img.add(  five);
     
     //10000
    ten=new JButton("Rs 10000");
    ten.setFont(new Font("Verdana",Font.ITALIC,15));
    ten.setBounds(190,465,100,18);
    ten.addActionListener(this);
     img.add(  ten);
     
      //back
    Back=new JButton("Back");
    Back.setFont(new Font("Verdana",Font.ITALIC,15));
    Back.setBounds(370,465,100,18);
    Back.addActionListener(this);
     img.add(  Back);
     
     
        //frame
    setSize(900,800);
    setLocation(340,12);
    setUndecorated(true);
    setVisible(true);
    
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Back){
           setVisible(false);
           new Transactions(pinno).setVisible(true);
        }else{
            //taking amount written as text on a button by taking its substring
            String bamount =((JButton)ae.getSource()).getText().substring(3);
        try{
                     Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 
                 //implementing cash is withdraw only when deposit amount is greater
                 
                 //result set gives you all the possible trasactions made from same pinno
                 ResultSet rs=con.stmt.executeQuery("select * from money where pinno =\'"+pinno+"\'");
               int balance=0;
               //rs.next for each row looping
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance +=Integer.parseInt(rs.getString("amountTextField"));
                     }
                     else{
                           balance -=Integer.parseInt(rs.getString("amountTextField"));
                     }
                 }
                 
                 
                 // JOptionPane.showMessageDialog(null,"Rs"+samount+"\n Withdrawl Successful"  );
               
                 //checking withdraw only when deposit amount is greater
                 //button amount
                 if(ae.getSource() != Back && balance< Integer.parseInt(bamount)){
                      JOptionPane.showMessageDialog(null," Insufficient Balance"  );
                      return;
                 }
                 
                 Date date=new Date();
               String query="insert into money values('"+pinno+"','"+date+"','"+"Withdraw"+"','"+bamount+"')";
                 con.stmt.executeUpdate(query);
               
                 //info about amount
                  JOptionPane.showMessageDialog(null,"Rs"+bamount+"\n Debited Successful"  );
                  setVisible(false);
                  new Transactions(pinno).setVisible(true);
                }
                         catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    public static void main(String args[]){
        new Fastcash("");
    }
}

