
package ATM.manangement;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Sign_up_form extends JFrame implements ActionListener {
    JLabel name,address,gender,email,dob,fathersname,city,state,pincode;
    JTextField nameTextField,addressTextField,fathernameTextField,emailTextField,cityTextField,stateTextField,pincodeTextField;
     JDateChooser dobx;
     JRadioButton male,female;
     JButton next;
     long random;
     
    Sign_up_form(){
    //
    setLayout(null);
    //generating application  number
    Random ra=new Random();
     random=Math.abs(ra.nextLong()% 9000L) +1000l;//to genrate random n umber using math.abs for positive number
    JLabel formNo=new JLabel("APPLICATION FORM NO - "+random);
    add(formNo);
    formNo.setFont(new Font("Verdana",Font.ITALIC,30));
     formNo.setBounds(170,20,700,40); 
     
     // personal details
   
    JLabel personalDetails=new JLabel("Page 1: Personal Details" );
    add(personalDetails);
    personalDetails.setFont(new Font("Verdana",Font.ITALIC,18));
     personalDetails.setBounds(300,80,400,30); 
     
      // name
   
    name=new JLabel("Name" );
    add(name);
    name.setFont(new Font("Verdana",Font.ITALIC,18));
     name.setBounds(150,140,200,18); 
     
     nameTextField=new JTextField("");
     add(nameTextField);
     nameTextField.setBounds(350,140,200,18);
     nameTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
       // dob
   
     dob=new JLabel("Date of Birth" );
    add(dob);
    dob.setFont(new Font("Verdana",Font.ITALIC,18));
    dob.setBounds(150,190,200,18); 
    
     dobx=new JDateChooser();//for calander
     add(dobx);
    dobx.setBounds(350,190,200,18);
    dobx.setForeground(new Color(105,105,105));
      // gender
   
    gender=new JLabel("Gender" );
    add(gender);
    gender.setFont(new Font("Verdana",Font.ITALIC,18));
     gender.setBounds(150,240,100,18); 
    
     // for male and female button
    male=new JRadioButton("Male");
    male.setBounds(350,240,150,18);
    add(male);
    
     female=new JRadioButton("Female");
    female.setBounds(450,240,150,18);
    add(female);
    
    //grouping button
     ButtonGroup genderGroup =new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
      // fathers name
   
    fathersname=new JLabel("Father's Name" );
    add(fathersname);
    fathersname.setFont(new Font("Verdana",Font.ITALIC,18));
     fathersname.setBounds(150,290,200,18); 
    
      fathernameTextField=new JTextField("");
     add(fathernameTextField);
     fathernameTextField.setBounds(350,290,200,18);
     fathernameTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
     //email
   
     email  =new JLabel("Email" );
    add(email);
    email.setFont(new Font("Verdana",Font.ITALIC,18));
     email.setBounds(150,340,200,18); 
     
    emailTextField=new JTextField("");
     add(emailTextField);
     emailTextField.setBounds(350,340,200,18);
     emailTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
// address
   
     address =new JLabel("Address" );
    add(address);
    address.setFont(new Font("Verdana",Font.ITALIC,18));
     address.setBounds(150,390,200,18); 
     
      addressTextField=new JTextField("");
     add(addressTextField);
     addressTextField.setBounds(350,390,200,15);
     addressTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
// city
   
     city=new JLabel("City" );
    add(city);
    city.setFont(new Font("Verdana",Font.ITALIC,18));
     city.setBounds(150,440,200,18); 
     
      cityTextField=new JTextField("");
     add(cityTextField);
     cityTextField.setBounds(350,440,200,15);
     cityTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
     
//state
   
    state =new JLabel("State" );
    add(state);
    state.setFont(new Font("Verdana",Font.ITALIC,18));
     state.setBounds(150,490,200,18); 
     
     stateTextField=new JTextField("");
     add(stateTextField);
     stateTextField.setBounds(350,490,200,18);
     stateTextField.setFont(new Font("Verdana",Font.ITALIC,15));
   
     // pincode
   
     pincode =new JLabel("Pin Code" );
    add(pincode);
    pincode.setFont(new Font("Verdana",Font.ITALIC,19));
    pincode.setBounds(150,540,200,18); 

    pincodeTextField=new JTextField("");
     add(pincodeTextField);
     pincodeTextField.setBounds(350,540,200,18);
     pincodeTextField.setFont(new Font("Verdana",Font.ITALIC,15));
    
     //next button
     next=new JButton("Next");
     next.setBackground(Color.BLACK);
     next.setForeground(Color.BLACK);
     next.setFont(new Font("Verdana",Font.ITALIC,15));
     next.setBounds(590,580,120,28);
     next.addActionListener(this);
     add(next);
     
    //generating frame
    
    setSize(750,700);
    setLocation(340,12);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE); 
}
    public void actionPerformed(ActionEvent ae){
       String formNo ="" +random;//long//converting into string
        String name=nameTextField.getText();//getting value from text
        String dob=((JTextField)dobx.getDateEditor().getUiComponent()).getText();
         String gender=null;
         if(male.isSelected()){
             gender="Male";
         } 
         else if(female.isSelected()){
             gender="Female";
         }
          String father_name=fathernameTextField.getText();
         String email=emailTextField.getText();
           String city=cityTextField.getText();
             String state=stateTextField.getText();
             String address=addressTextField.getText();
               String pin=pincodeTextField.getText();
              
               //as thre can be run time error we create try and catch
               try{
               if(name.equals("")){
                   JOptionPane.showMessageDialog(null,"Namee is Required");
               }
               else{
                 Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 String query="insert into sign_up values('"+formNo+"','"+name+"','"+dob+"','"+gender+"','"+father_name+"','"+email+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 con.stmt.executeUpdate(query);
                 
                 //calling signup2
                 setVisible(false);
                 //calling next page of form by passing string as form no
                 new Sign_up2(formNo).setVisible(true);
               }
               }
               catch(Exception e){
                   System.out.println(e);
               }
         
    }
    public static void main(String args[]){
    new Sign_up_form();
}}
 