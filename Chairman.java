import java.util.*;
import java.io.*;

public class Chairman extends Staff{
   String userName;
   String password;
   public Chairman(String userName,String password){
      super(userName,password);
      this.userName= userName;
      this.password = password;
   }
   FileHandler fh = new FileHandler();

   public void addMembers(){
      String discipline ="";
      String statusOfActive;
      Member m = new Member();
      Scanner sc = new Scanner(System.in);
      System.out.println("Please Enter first name:- ");
      String firstName= sc.next();
      System.out.println("Please Enter last name:- ");
      String lastName = sc.next();
      System.out.println("Please Enter your age:- ");
      int age = sc.nextInt();
      System.out.println("Please Enter phone number:- ");
      String phoneNumber = sc.next();
      System.out.println("Please Enter email:- ");
      String email = sc.next();
      System.out.println("Please Enter subscription date -dd/mm/yyyy-format ");
      String dateOfSubscription = sc.next();
      String memberType="";
      if(age<18){
         memberType = "Junior";}
      else if(age>=18&&age<60){
         memberType = "Senior1";}
      else if(age>60){
         memberType = "Senior2";}
      else{
         System.out.println("Please enter the valid age.");}
      System.out.println("Are you active Y/N ");
      String activeCheck = sc.next().toUpperCase();
      if (activeCheck.equals("Y")){
         if(age<60){
            System.out.println("Please select the disciplilne\n 1-Butterfly\n 2- Backstroke\n 3-Freestyle");
         
            int option =sc.nextInt();
            switch(option){
               case 1:
                  discipline = "Butterfly";
                  break;
               case 2: 
                  discipline = "Backstroke";
                  break;
               case 3:
                  discipline = "Freestyle";
                  break;
               default:
                  System.out.println("Please select the correct options.");
            }
         }
      
      }
      statusOfActive= "Active";
      if(age<18){
         memberType = "Junior";
         System.out.println("You will pay 1000 Dkk per year");
      }
      else if(age>=18&&age<60){
         memberType = "Senior1";
         System.out.println("You will pay 1600 Dkk per year");
      
      }
      else if(age>60){
         memberType = "Senior2";
         System.out.println("You will pay"+ (1600 - (1600 * 0.25)) +"Dkk per year");
      
      
      
      
      
      }
      else{
         statusOfActive="Passive";
         System.out.println("You will pay 500DKK per year.");
      }
   
      fh.updateMemberList(firstName+"           "+lastName+"            "+age+"           "+phoneNumber+"            "+email+"            "+dateOfSubscription+"           "+memberType+"          "+ statusOfActive+"     "+discipline+"\n");
   
   
   }



   public void seeSubscribers(){
      int count = 1;
      System.out.println("************************************************************************************************************************************************************************");
      for(Member ms: fh.membersList){
         System.out.println("Index  "+ count+"   "+ms.firstName+"  "+ms.lastName+"   "+ms.age+"  "+ms.phoneNumber+"   "+ms.email+"   "+ms.dateOfSubscription+"  "+ms.memberType+" "+ ms.statusOfActive+"\n");
         count++;
      }
      System.out.println("************************************************************************************************************************************************************************");  
   }

}