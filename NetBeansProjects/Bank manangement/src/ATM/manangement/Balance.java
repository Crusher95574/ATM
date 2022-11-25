package ATM.manangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;//for resultset

public class Balance extends JFrame implements ActionListener {
  JButton Back;
  JLabel text;
    String pinno;
    
    Balance( String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);//bec there is no image class in swing awt package is used//image sizing
        ImageIcon i3=new ImageIcon(i2);
        JLabel img =new JLabel(i3);
        img.setBounds(0,0,900,800);//placing image
        add(img);// for pasting icon onto frame
             
        // balance is declared above so that we get access of balance outside scope of try and catch
        int balance=0;
        
        // for direct implementation of data on frame by not using button we have to writeb the query in constructor itself 
        try{
                     Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 
                 //implementing cash is withdraw only when deposit amount is greater
                 
                 //result set gives you all the possible trasactions made from same pinno
                 ResultSet rs=con.stmt.executeQuery("select * from money where pinno = \'"+pinno+"\'");
               
               //rs.next for each row looping
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance +=Integer.parseInt(rs.getString("amountTextField"));
                     }
                     else{
                           balance -=Integer.parseInt(rs.getString("amountTextField"));
                     }
                     
                 }}catch(Exception e){
                         System.out.println(e);
                         }
         
        text=new JLabel("Your Current Account Balance is "+balance);
        text.setBounds(210,260,700,35);  
        text.setFont(new Font("verdana",Font.ITALIC,14));
        text.setForeground(Color.WHITE);
        img.add(text);// used to add text on image
        
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
             public void actionPerformed(ActionEvent ae){
                 setVisible(false);
                 new Transactions(pinno).setVisible(true);
             }
           public static void main(String args[]){
        new Balance("");
    }}   