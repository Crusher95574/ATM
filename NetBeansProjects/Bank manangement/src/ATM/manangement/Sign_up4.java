
package ATM.manangement;
import java.util.*;//for randomm function
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sign_up4 extends JFrame implements ActionListener {
    JRadioButton s,f,c,r;
    JLabel type,card,no,pin,pno,Cinfo,Pinfo,ser;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo;
    
    Sign_up4(String formNo){
        this.formNo=formNo;
        
       setLayout(null);
    //generating additional details

    setTitle("APPLICATION FORM");
    JLabel additionalDetails=new JLabel("Page 3: ACCOUNT DETAILS ");
    add(additionalDetails);
    additionalDetails.setFont(new Font("Verdana",Font.ITALIC,30));
     additionalDetails.setBounds(170,20,700,40); 
     
     type=new JLabel("Account Type" );
    add(type);
    type.setFont(new Font("Verdana",Font.ITALIC,18));
     type.setBounds(150,140,200,18); 
     
     //button
     s=new JRadioButton("Saving Account");
     s.setFont(new Font("Verdana",Font.ITALIC,18));
     s.setBounds(150,200,200,18);
     add(s);
     
     f=new JRadioButton("Fixed Account");
     f.setFont(new Font("Verdana",Font.ITALIC,18));
     f.setBounds(350,200,200,18);
     add(f);
     
     c=new JRadioButton("Current Account");
     c.setFont(new Font("Verdana",Font.ITALIC,18));
     c.setBounds(150,240,200,18);
     add(c);
     
     r=new JRadioButton("Recurring Deposit Account");
     r.setFont(new Font("Verdana",Font.ITALIC,18));
     r.setBounds(350,240,400,18);
     add(r);
     
     // grouping account button
     ButtonGroup gA=new ButtonGroup();
     gA.add(r);
     gA.add(s);
     gA.add(f);
     gA.add(c);
     
     //cardno
     card=new JLabel("Card No" );
    add(card);
    card.setFont(new Font("Verdana",Font.ITALIC,15));
     card.setBounds(150,300,200,20); 
     
     //dummy card no
      no=new JLabel("XXXX-XXXX-XXXX-3846" );
    add(no);
    no.setFont(new Font("Verdana",Font.ITALIC,15));
     no.setBounds(350,300,200,20); 
     
     //info related to card number
      Cinfo=new JLabel("Your 16 Digit Card Number" );
    add(Cinfo);
    Cinfo.setFont(new Font("Verdana",Font.ITALIC,10));
     Cinfo.setBounds(150,320,200,20); 
     
      //info related to card number
      Pinfo=new JLabel("Your 16 Digit Card Number" );
    add(Pinfo);
    Pinfo.setFont(new Font("Verdana",Font.ITALIC,10));
     Pinfo.setBounds(150,375,200,20); 
     
     //pin
      pin=new JLabel("PIN" );
    add(pin);
    pin.setFont(new Font("Verdana",Font.ITALIC,15));
     pin.setBounds(150,355,200,20); 
     
     //pno
      pno=new JLabel("XXXX" );
    add(pno);
    pno.setFont(new Font("Verdana",Font.ITALIC,15));
     pno.setBounds(350,375,200,20); 
     
     //services req
     ser=new JLabel("Services Required" );
    add(ser);
    ser.setFont(new Font("Verdana",Font.ITALIC,20));
     ser.setBounds(150,420,200,20); 
     
     //check box making
     c1=new JCheckBox("ATM CARD");
     c1.setFont(new Font("Verdana",Font.ITALIC,15));
     c1.setBounds(150,465,200,20);
     add(c1);
     
     c2=new JCheckBox("INTERNET BANKING");
     c2.setFont(new Font("Verdana",Font.ITALIC,15));
     c2.setBounds(350,465,200,20);
      add(c2);
      
     c3=new JCheckBox("MOBILE BANKING");
     c3.setFont(new Font("Verdana",Font.ITALIC,15));
     c3.setBounds(150,515,200,20);
      add(c3);
      
     c4=new JCheckBox("EMAIL & SMS ALERTS");
     c4.setFont(new Font("Verdana",Font.ITALIC,15));
     c4.setBounds(350,515,200,20);
      add(c4);
      
     c5=new JCheckBox("CHEQUE BOOK");
     c5.setFont(new Font("Verdana",Font.ITALIC,15));
     c5.setBounds(150,565,200,20);
      add(c5);
      
     c6=new JCheckBox("E STATEMENT");
     c6.setFont(new Font("Verdana",Font.ITALIC,15));
     c6.setBounds(350,565,200,20);
      add(c6);
      
     
     c7=new JCheckBox("Above details are correct to best of my knowledge");
     c7.setFont(new Font("Verdana",Font.ITALIC,12));
     c7.setBounds(150,600 ,600,20);
      add(c7);
     
      
     //submit button
     submit=new JButton("SUBMIT");
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.BLACK);
     submit.setFont(new Font("Verdana",Font.ITALIC,15));
     submit.setBounds(330,650,120,28);
     submit.addActionListener(this);
     add(submit);
     
     
     //cancel button
     cancel=new JButton("CANCEL");
     cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.BLACK);
     cancel.setFont(new Font("Verdana",Font.ITALIC,15));
     cancel.setBounds(330,685,120,28);
     cancel.addActionListener(this);
     add(cancel);
      
     //frame
    setSize(750,800);
    setLocation(340,12);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE); 
    }
    
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
             String accountType=null;
             //radio button selection s,f,c,r
             if(s.isSelected()){
                accountType="Saving Account"; 
             }
             else if(f.isSelected()){
                accountType="Fixed Account"; 
          }
             else if(c.isSelected()){
                accountType="Current Account"; 
          }
             else if(r.isSelected()){
                accountType="Reccuring Deposit Account"; 
          }
              Random random=new Random();
              String cardno=""+Math.abs((random.nextLong()%9000000L)+5364546470000000L);
              
              String pinno=""+Math.abs((random.nextLong()%9000L)+3000L);
              
              //concatenating facilities in series of string
              String facility="";
              if(c1.isSelected()){
                  facility=facility+"ATM CARD";
              }else if(c2.isSelected()){
                  facility=facility+"INNTERNET BANKING";
              }else if(c3.isSelected()){
                  facility=facility+"MOBILE BANKING";
              }else if(c4.isSelected()){
                  facility=facility+"EMAIL & SMS ALERTS";
              }else if(c5.isSelected()){
                  facility=facility+"CHEQUE BOOK";
              }else if(c6.isSelected()){
                  facility=facility+"E STATEMENT";
              }
              
              try{
                  if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type Required");
               }
               else{
                 Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 
                 String query1="insert into sign_up4 values('"+formNo+"','"+accountType+"','"+cardno+"','"+pinno+"','"+facility+"')";
                  String query2="insert into login values('"+formNo+"','"+cardno+"','"+pinno+"')";
                  con.stmt.executeUpdate(query1);
                  con.stmt.executeUpdate(query2);
                 
                 //inform about cardno and pin
                 JOptionPane.showMessageDialog(null,"Card No:"+cardno+"\n Pin:"+pinno  );
                 
                 //as you cannot start with zero rupeess account
                 setVisible(false);
                 new Deposit(pinno).setVisible(false); 
                 
                  }}catch (Exception e){
                  System.out.println(e);
              }
        }
             else if(ae.getSource()==cancel){
              setVisible(false);
              new Login().setVisible(true);
          }
              setVisible(false);//too close login window 
              //now to open sign_up window make a sign_up class object
              new Sign_up_form().setVisible(true);
             
              
          
    } 
    public static void main(String args[]){
        new Sign_up4("");
    }
}
