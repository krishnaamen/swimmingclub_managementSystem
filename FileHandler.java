import java.util.*;
import java.io.*;
import java.time.*;
import java.text.*;




public class FileHandler{


   ArrayList<Member> membersList = new ArrayList<Member>();
   ArrayList<Member> activeMembers = new ArrayList<Member>();
   ArrayList<Member> updatedActiveMembers = new ArrayList<Member>();
   public int[] idArray = new int[activeMembers.size()];
   public int[] pointsArray = new int[idArray.length];
   public String[] nameArray = new String[pointsArray.length];
   ArrayList<Integer> pointsList = new ArrayList<Integer>();
   ArrayList<Integer> idList= new ArrayList<Integer>();
   ArrayList<String> nameList = new ArrayList<String>();
   String fileName = "members.txt";


   public FileHandler(){
      try{
      
         File myFile = new File(fileName);
         Scanner sc = new Scanner(myFile);
         int count = 0;
         int score = 0;
         int i =0;
      
         while(sc.hasNext()){
            Member m = new Member();
         
            m.firstName = sc.next();
            m.lastName = sc.next();
            m.age = sc.nextInt();
            m.phoneNumber = sc.next();
            m.email = sc.next();
            m.dateOfSubscription = sc.next();
            m.memberType = sc.next();
            m.statusOfActive = sc.next();
            m.discipline = sc.next();
         
            if(m.statusOfActive.equals("Active")){
               activeMembers.add(m);
               count++;
               idArray= addInt(idArray,i) ;;
            
            
               pointsArray = addInt(pointsArray,i);
               i++;}
         
            membersList.add(m);
         //getPoints();
         
         }}
      
      catch(IOException e){
         System.out.println("File is not found.");}
   
   
   }
    	 
 
 
 
   public void updateMemberList(String text){
      String myFile = "members.txt";
      PrintWriter wr = null;
      try {
         FileWriter fw = new FileWriter(myFile,true);
         wr = new PrintWriter(fw);
      }catch(FileNotFoundException e){
         e.printStackTrace();}
      catch(IOException e){
         e.printStackTrace();}
      wr.flush();
      wr.println(text);
      wr.close();
   }
 	 
   public void getPoints(){
      try{
         String file = "results.txt";
         File myFile = new File(file);
         Scanner sc = new Scanner(myFile);
         while(sc.hasNext()){
            Member m = new Member();
            m.id = sc.nextInt();
            m.firstName = sc.next();
            m.points = sc.nextInt();
            nameList.add(m.firstName);
            pointsList.add(m.points);
            idList.add(m.id);
         
         }}
      catch(IOException e){
         System.out.println("OOPS.....");
      }
   
   }
   public int[][] performTask(){
      int[][] mergeArray = new int [pointsArray.length][2];
      for (int i = 1; i < pointsArray.length; i++) {
         mergeArray[i][0] = idList.get(i);
         mergeArray[i][1] = pointsList.get(i);
      
      }
      Arrays.sort(mergeArray,(a,b) -> a[1]-b[1]);
      return mergeArray;
   
   }




   public void updateResult(String text){
      try{
         String fileName="results.txt";
         File myFile = new File(fileName);
      
         FileOutputStream fout=new FileOutputStream(myFile,false);  
         PrintStream pout=new PrintStream(fout);
         pout.flush();
         fout.flush();
         pout.println(text);
         pout.close();  
         fout.close();	 
      }catch(FileNotFoundException e){
         e.printStackTrace();}
      catch(IOException e){
         e.printStackTrace();}
   
   }

    
    
    
 
 
   public void seeActiveMembers(){
      int score = 0;
      int count = 1;
      System.out.println("************************************************************************************************************************************************************************");
      for(Member ms: activeMembers){
         System.out.println("Index  "+ count+"   "+ms.firstName+"  "+ms.lastName+"   "+ms.age+"  "+ms.phoneNumber+"   "+ms.email+"   "+ms.dateOfSubscription+"  "+ms.memberType+" "+ ms.statusOfActive+"\n");
         count++;
      }
      System.out.println("************************************************************************************************************************************************************************");  
   }
 
 
	 
   
   

 
   public void updateFileScore(String text){
      String file = "results.txt";
      File myFile = new File(file);
   
   
      try {
         PrintStream output = new PrintStream(myFile);
         output.print("");
         output.flush();
         output.print(text);
       	 
         output.close();
      }
      catch(Exception e) {
         e.getStackTrace();
      }
   
   }
 
 
    
   public int[] addInt(int[]arr, int newInt){
      int[] newArr = new int[arr.length+1];
      for(int i = 0;i<arr.length;i++){
         newArr[i]= arr[i];
      }
      newArr[newArr.length-1] = newInt;
      return newArr;
   
   
   }
   

}
