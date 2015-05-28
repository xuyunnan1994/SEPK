public class Acupuncture extends Service{
	Shower shower;
	public Acupuncture(Shower shower){
		this.shower=shower;
	}
	public int cost(){
		return 15+shower.cost();
	}
	public String getDescription() {
		return shower.getDescription()+"¡¢Õë¾Ä";
	}
}
