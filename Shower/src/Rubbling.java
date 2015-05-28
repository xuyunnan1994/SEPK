public class Rubbling extends Service{
	Shower shower;
	public Rubbling(Shower shower){
		this.shower=shower;
	}
	public int cost(){
		return 8+shower.cost();
	}
	public String getDescription() {
		return shower.getDescription()+"¡¢´ê±³";
	}
}