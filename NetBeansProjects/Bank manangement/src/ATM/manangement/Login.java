
package ATM.manangement;
import javax.swing.*;
import java.awt.event.*;// implemenst action listener 
import java.awt.*;//for font
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton clear,sign_in,sign_up;
    JTextField cardTextField;
    JPasswordField pinTextField;
      //constructor for making class object to make frame
       Login(){
             setTitle("ATM");
             setLayout(null);//for custom layout
             //making image class 
           
             ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/iiitvicd logo.jpg"));
             Image i2 =i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);//bec there is no image class in swing awt package is used//image sizing
             ImageIcon i3=new ImageIcon(i2);
             JLabel label =new JLabel(i3);
             label.setBounds(180,20,80,80);//placing image
             add(label);// for pasting icon onto frame
             
             // title making
             JLabel title=new JLabel("Welcome to ATM");
             add(title);
             title.setFont(new Font("Osward",Font.BOLD,30) );
             title.setBounds(280,40,400,40);
             
             // card no making
             JLabel cardNo=new JLabel("Card No");
             add(cardNo);
             cardNo.setFont(new Font("Verdana",Font.ITALIC,18) );
             cardNo.setBounds(120,150,400,40);
             
             cardTextField=new JTextField(); 
             add(cardTextField);
             cardTextField.setBounds(300,153,250,30);
             // pin  making
             JLabel pin=new JLabel("PIN");
             add(pin);
             pin.setFont(new Font("Verdana",Font.ITALIC,18) );
             pin.setBounds(120,210,400,40);
             
             pinTextField=new JPasswordField(); 
             add(pinTextField);
             pinTextField.setBounds(300,213,250,30);
             
             //button making
             //sign in
             sign_in=new JButton("SIGN IN");
             add(sign_in);
             sign_in.setFont(new Font("VERDANA",Font.ITALIC,18));
             sign_in.setBounds(135,270,180,50);
             sign_in.setForeground(Color.RED);
             sign_in.setBackground(Color.BLACK); 
             sign_in.addActionListener(this);// for button to perform action on clicking
             
             //sign up
              sign_up=new JButton("SIGN UP");
             add(sign_up);
             sign_up.setFont(new Font("VERDANA",Font.ITALIC,18));
             sign_up.setBounds(405,270,180,50);
             sign_up.setForeground(Color.RED);
             sign_up.setBackground(Color.BLACK);
             sign_up.addActionListener(this);
             
             //clear
             clear=new JButton("CLEAR");
             add(clear);
             clear.setFont(new Font("VERDANA",Font.ITALIC,18));
             clear.setBounds(270,330,220,50);
             clear.setBackground(Color.BLUE);
             clear.setForeground(Color.BLUE);
             clear.addActionListener(this);
             
             //frame making
            getContentPane().setBackground(Color.WHITE);//for frame background
            setSize(700,460);// frame size  
            setVisible(true); // for frame visibility
            setLocation(300,200);//frams location
          
       }
       
       public void actionPerformed(ActionEvent ae){
          if(ae.getSource()==clear){
              cardTextField.setText("");
              pinTextField.setText("");
          }else if(ae.getSource()==sign_in){
              Test con=new Test();
              String cardno=cardTextField.getText();
            String pinno=pinTextField.getText();
            //extracting data
              String query="select *from login where cardno ='"+cardno+"' and pinno ='"+pinno+"'";
              try{
                  ResultSet rs =con.stmt.executeQuery(query);
                  //if query matches it will be stored in reseult set object
                  if(rs.next()){
                      //if comes in this loop user has been successfully logined
                      //hence login page closed
                      setVisible(false);
                      //transaction page open
                      new Transactions(pinno).setVisible(true);
                  }
                  else{
                         JOptionPane.showMessageDialog(null,"Incorrect Card No or Pin");
                  }
              }catch(Exception e){
                  System.out.println(e);
              }
              
          }else if(ae.getSource()==sign_up){
              setVisible(false);//too close login window 
              //now to open sign_up window make a sign_up class object
              new Sign_up_form().setVisible(true);
          }
       }
       
   public static void main(String args[]){
        new Login();//class ka object
        
   }
    
}
