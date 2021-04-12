public class Profile {
    private final String Name;
    private final String Ign;
	private final String Country;
    private final String Email;
	private final int TotalGamePlayed;
	private final int TotalWinning;
	private final int TotalKill;
	
    
    public Profile(String name,String ign,String country,String email,int totalgameplayed,int totalwinning,int totalkill){
    
        this.Name = name;
        this.Ign = ign;
		this.Country= country;
        this.Email = email;
		this.TotalGamePlayed = totalgameplayed;
		this.TotalWinning = totalwinning;
		this.TotalKill= totalkill;
    }

    
    
    public String getName(){
        return Name;
    }
    
    public String getIgn(){
        return Ign;
    }
	
	public String getCountry(){
        return Country;
    }
	
	public String getEmail(){
        return Email;
    }
	
	public int getTotalGamePlayed(){
        return TotalGamePlayed;
    }
	
	public int getTotalWinning(){
        return TotalWinning;
    }
	
	public int getTotalKill(){
        return TotalKill;
    }
	
	
}