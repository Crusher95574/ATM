package ATM.manangement;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Sign_up2 extends JFrame implements ActionListener {
    JLabel religion,income,category,education,existing, panNo,occupation ,seniorCitizen,adharNo;
    JTextField  pannoTextField,adharTextField;
     JRadioButton syes,sno,eyes,eno;
     JComboBox religionx,Income,Occupation,Education,Category;
     JButton next;
    
     String formNo;
    
     
    Sign_up2(String formNo){
    //
    this.formNo=formNo;
    
    setLayout(null);
    //generating additional details

    setTitle("APPLICATION FORM");
    JLabel additionalDetails=new JLabel("Page 2: ADDITIONAL DETAILS ");
    add(additionalDetails);
    additionalDetails.setFont(new Font("Verdana",Font.ITALIC,30));
     additionalDetails.setBounds(170,20,700,40); 
     
     
      // religion
   
    religion=new JLabel("Religion" );
    add(religion);
    religion.setFont(new Font("Verdana",Font.ITALIC,18));
     religion.setBounds(150,140,200,18); 
     
     String varReligion[]={"Hindu","Muslim","Sikh","Cristian","Other"};
      religionx=new JComboBox(varReligion);//making box
     religionx.setFont(new Font("Verdana",Font.ITALIC,15));
     religionx.setBounds(350,140,200,20); 
     add(religionx);
     
     //category
     category=new JLabel("Category" );
    add(category);
    category.setFont(new Font("Verdana",Font.ITALIC,18));
     category.setBounds(150,190,200,18); 
     
      
     String varCategory[]={"General","OBC","SC","ST","Other"};
      Category=new JComboBox(varCategory);//making box
     Category.setFont(new Font("Verdana",Font.ITALIC,15));
     Category.setBounds(350,190,200,20); 
     add(Category);
   
     income=new JLabel("Income" );
    add(income);
    income.setFont(new Font("Verdana",Font.ITALIC,18));
    income.setBounds(150,240,200,18); 
    
     String varIncome[]={"NULL","<2,00,000","<5,00,000","<10,00,000",">10,00,000"};
     Income=new JComboBox(varIncome);//making box
     Income.setFont(new Font("Verdana",Font.ITALIC,15));
     Income.setBounds(350,240,200,20); 
     add(Income);
    
      // education
   
     String varEducation[]={"Matrix","Non Graduate","Graduate","Post Graduate","Doctarte","Others"};
      Education=new JComboBox(varEducation);//making box
     Education.setFont(new Font("Verdana",Font.ITALIC,15));
     Education.setBounds(350,290,200,20); 
     add(Education);
   
      
     //occupation
   
     occupation  =new JLabel("occupation " );
    add(occupation );
    occupation .setFont(new Font("Verdana",Font.ITALIC,18));
     occupation .setBounds(150,340,200,18); 
     
        
     String varOccupation[]={"Student","Self-Employed","Business","Salaried","Others"};
      Occupation=new JComboBox(varOccupation);//making box
     Occupation.setFont(new Font("Verdana",Font.ITALIC,15));
     Occupation.setBounds(350,340,200,20); 
     add(Occupation);
     

// city
   
     adharNo=new JLabel("Adhar No" );
    add(adharNo);
    adharNo.setFont(new Font("Verdana",Font.ITALIC,18));
     adharNo.setBounds(150,390,200,18); 
     
      adharTextField=new JTextField("");
     add(adharTextField);
     adharTextField.setBounds(350,390,200,15);
     adharTextField.setFont(new Font("Verdana",Font.ITALIC,15));
     
     
     // panNo
   
     panNo =new JLabel("PAN No" );
    add( panNo);
     panNo.setFont(new Font("Verdana",Font.ITALIC,19));
     panNo.setBounds(150,440,200,18); 

    pannoTextField=new JTextField("");
     add(pannoTextField);
     pannoTextField.setBounds(350,440,200,18);
     pannoTextField.setFont(new Font("Verdana",Font.ITALIC,15));
    
     //senior 
   
     seniorCitizen=new JLabel("Senior Citizen" );
    add(seniorCitizen);
    seniorCitizen.setFont(new Font("Verdana",Font.ITALIC,18));
     seniorCitizen.setBounds(150,490,200,18); 
     
//making yes no button
     
     syes=new JRadioButton("Yes");
     syes.setBounds(350,490,80,18);
     add(syes);
     
      sno=new JRadioButton("No");
     sno.setBounds(500,490,80,18);
     add(sno);
     
     ButtonGroup cs=new ButtonGroup();
     cs.add(syes);
     cs.add(sno);
     
     
     
     // existing account
   
     existing =new JLabel("Existing Account" );
    add(existing);
    existing.setFont(new Font("Verdana",Font.ITALIC,18));
    existing.setBounds(150,550,200,18); 
     
    eyes=new JRadioButton("Yes");
     eyes.setBounds(350,550,80,18);
     add(eyes);
     
      eno=new JRadioButton("No");
     eno.setBounds(500,550,80,18);
     add(eno);
     
     ButtonGroup es=new ButtonGroup();
     es.add(eyes);
     es.add(eno);
   

     
     //next button
     next=new JButton("Next");
     next.setBackground(Color.BLACK);
     next.setForeground(Color.BLACK);
     next.setFont(new Font("Verdana",Font.ITALIC,15));
     next.setBounds(590,580,120,28);
     next.addActionListener(this);
     add(next);
      education=new JLabel("Education" );
    add(education);
    education.setFont(new Font("Verdana",Font.ITALIC,18));
     education.setBounds(150,290,100,18); 
    
    //generating frame
    
    setSize(750,700);
    setLocation(340,12);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE); 
}
    public void actionPerformed(ActionEvent ae){
   
        String sreligion=(String)religionx.getSelectedItem();//as selected item return string we need to type cast it into string
         String scategory=(String)Category.getSelectedItem(); 
         String sincome=(String)Income.getSelectedItem(); 
         String seducation=(String)Education.getSelectedItem(); 
         String soccupation=(String)Occupation.getSelectedItem();
      
         String senior=null;
         if(syes.isSelected()){
             senior="Yes";
         } 
         else if(sno.isSelected()){
             senior="No";
         }
          String exist=null;
         if(syes.isSelected()){
             exist="Yes";
         } 
         else if(sno.isSelected()){
             exist="No";
         }
         
            String span=pannoTextField.getText();
            String sadhar=adharTextField.getText();
            
               //as thre can be run time error we create try and catch
               try{
               
                 Test con=new Test();///making con object for using connection class
                 // insert command for inserting data into database by making string
                 String query="insert into sign_up2 values('"+formNo+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+senior+"','"+exist+"')";
                 con.stmt.executeUpdate(query);
               
                 setVisible(false);
                //signup3 object
                new Sign_up4(formNo).setVisible(true);
               }
               catch(Exception e){
                   System.out.println(e);
               }
         
    }
    public static void main(String args[]){
    new Sign_up2("");//passing empty string as no //default constructor
}}
 