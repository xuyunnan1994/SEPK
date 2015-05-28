public class Sulphur extends Service{
	Shower shower;
	public Sulphur(Shower shower){
		this.shower=shower;
	}
	public int cost(){
		return 13+shower.cost();
	}
	public String getDescription() {
		return shower.getDescription()+"°¢¡Úª«‘°";
	}
}