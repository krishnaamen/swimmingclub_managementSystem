import java.util.*;
import java.io.*;
import java.time.*;



public class SwimmingClub{
   public static void main (String[]args){
      boolean sentinel = false;
      Scanner sc = new Scanner(System.in);
   
      Coach c = new Coach("Co","co");
      Chairman ch = new Chairman("Ch","ch");
      Treasurer tr = new Treasurer("Tr","tr");
   
      FileHandler fh = new FileHandler();
      Member m = new Member();
    
      while(sentinel==false){
         System.out.print("User name:");
         String userName = sc.next();
         System.out.print("Password: ");
         String password = sc.next();
         if((ch.logIn(userName,password))){
            System.out.println("Welcome Chairman Dashboard, please choose following options:-\nEnter 1 for add new members\n Enter 2 for members list.");
            int option1 = sc.nextInt();
            if(option1 ==1){
               ch.addMembers();}
            else if (option1 ==2){
               ch.seeSubscribers();
            }
            else{
               System.out.println("Please enter the valid number.");
            }
         }
         
         
         else if (tr.logIn(userName,password)){
            System.out.println("Welcome to Tresurers Dashboard, please choose following options\n 1 to see the subscription list\n 2 to see the late payers list.");
            int option = sc.nextInt();
            if(option==1){
            
               ch.seeSubscribers();
            }
            else if(option==2){
               tr.checkLatePayment();}}
         
         
         else if (c.logIn(userName,password)){
            System.out.print("Welcome Coach\n");
            System.out.println("Welcome to Coach Dashboard\n, please choose following options\n 1 to update Result \n 2- for see activeMembers\n3 Top 5");
            int option = sc.nextInt();
            if(option==1){
               boolean sen = true;
               while(sen){
                  System.out.println("Enter Y to update and N to exit");
                  String  yN = sc.next().toUpperCase();
                  if(yN.equals("Y")){
                     System.out.println("member index: ");
                     int resIn = sc.nextInt();
                     System.out.println("Points: ");
                     int resPt = sc.nextInt();
                  
                     c.updateScore(resIn,resPt);
                     fh.getPoints();
                  
                  }
                  else{
                     sen = false;
                  }}}
            else if(option==2){
               fh.seeActiveMembers();}
            else if(option==3){
               c.getTFive();
            
            
            }
         
         
         }
         else {
            System.out.println("authentication failed, please enter the valid userName and password");
         }
         System.out.println("Do you want to continue using this system? Y/N");
         String ans= sc.next().toUpperCase();
         if(ans.equals("N")){
            sentinel = true;
         }
         else{
            sentinel = false;
         }}}}