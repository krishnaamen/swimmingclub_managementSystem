import java.util.*;
import java.io.*;
import java.text.*;



public class Member{
   int id = 0;
   String firstName="";
   String lastName="";
   int age = 0;
   String phoneNumber = "";
   String email = "";
   String dateOfSubscription = "";
   String memberType = "";
   String statusOfActive ="";
   String discipline = "";
   int points=0;
         
   public void setPoint(int point){
      this.points = (this.points+point);
   
   }
   public int getPoint(){
      return this.points;
   }

}

   
   
      
   

