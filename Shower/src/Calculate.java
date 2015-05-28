public class Calculate {
	public static int discount(int sum){
		if(Login.loginC==1){
			sum=(int) (sum*0.8);
		}
		return sum;
	}
}
