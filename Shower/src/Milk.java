public class Milk extends Service{
	Shower shower;
	public Milk(Shower shower){
		this.shower=shower;
	}
	public int cost(){
		return 11+shower.cost();
	}
	public String getDescription() {
		return shower.getDescription()+"¡¢Å£ÄÌÔ¡";
	}
}

