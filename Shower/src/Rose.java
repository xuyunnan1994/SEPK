public class Rose extends Service{
	Shower shower;
	public Rose(Shower shower){
		this.shower=shower;
	}
	public int cost(){
		return 12+shower.cost();
	}
	public String getDescription() {
		return shower.getDescription()+"°¢√µπÂ‘°";
	}
}