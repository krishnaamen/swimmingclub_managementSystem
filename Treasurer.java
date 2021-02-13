import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;  




public class Treasurer extends Staff {
   String userName;
   String password;
   public Treasurer(String userName,String password){
      super(userName,password);
      this.userName= userName;
      this.password = password;
   }

   Member m = new Member();
   FileHandler fh = new FileHandler();      
   
   
   public void checkLatePayment(){
      int count =1;
      try{
      
         for(Member m:fh.membersList){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = formatter.parse(m.dateOfSubscription);
            ZoneId dId = ZoneId.systemDefault();
            Instant instant = date1.toInstant();
            LocalDate lDate = instant.atZone(dId).toLocalDate();
            LocalDate today = LocalDate.now();
            Period p = Period.between(lDate,today);
            long totalDays = p.getYears()*365 + p.getMonths()*30+p.getDays();
            if (totalDays>365){
               System.out.println("-   "+m.firstName+" "+m.lastName+" Subscription date is expired for "+ (totalDays-365)+"  Days.");
            
            
            }
         }}
      catch(ParseException e){
         System.out.println("opps!");
      }
      System.out.println("***********************************************************************");
   }}
  


