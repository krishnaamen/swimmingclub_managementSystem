import java.util.*;

public class Coach extends Staff{
   String userName;
   String password;
   public Coach(String userName,String password){
      super(userName,password);
      this.userName= userName;
      this.password = password;
   }
   FileHandler fh = new FileHandler();


   public void updateScore(int count, int score){
      fh.getPoints();
      int len = fh.pointsArray.length;
      fh.pointsArray[count]= fh.pointsArray[count]+score;
      String text = "";
      for(int i=0;i<len-1;i++){
         text=text+(i+" 	"+fh.nameList.get(i)+"  	"+fh.pointsList.get(i)+"\n");
      //fh.getPoints();
      }
      fh.updateResult(text);
      fh.getPoints();
   
   }


   public void getTFive(){
      int[][]newArray= fh.performTask();
      int plen = newArray.length;
      String result = "";
   
      for(int i = plen-1;i>plen-6;i--){
      
         result =result+(Arrays.toString(newArray[i])+"\n");
      
      
      }
      System.out.println("Top 5\n [memberId,Points]\n"+result);
   }



   @Override
   public String toString(){
      return (userName+"");
   
   }
}
