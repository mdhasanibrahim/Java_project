public class MyProfile {
    Save s;
    
   public MyProfile(Save s){
        this.s=s;
        ProfileDatabase profile = new ProfileDatabase(s);
   }
     
   
}