public class Staff{
   private String userName;
   private String password;
      
      
   public Staff(String userName, String password){
      this.userName = userName;
      this.password = password;
   
   }
   public String getUserName(){
      return userName;
   }
   public String getPassword(){
      return password;
   }
   public  boolean logIn(String userName,String password){
      if(this.userName.equals(userName) && this.password.equals(password))
      {
         return true;}
      return false;
   }
   
   
   
   
   public void printCredentials(){
   
      System.out.println("UserName:-"+ getUserName()+ "Password is :-"+ getPassword());
   }
   public String toString(){
      return this.userName;
   
   }
   
}