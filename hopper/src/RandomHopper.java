import java.awt.Image;

public class RandomHopper extends Hopper{

	public RandomHopper(int x, int y, Image leftPic, Image rightPic) {
		super(x, y, leftPic, rightPic);
		// TODO Auto-generated constructor stub
	}
	
	public void firstStep() {
		super.firstStep();
	}
	
	public void turn(int d) {		
		for (int i=0; i<d;i++) {
			turnRight();
		}		
	}
	
	public void hop() {
		turn((int)(Math.random()*4));
		super.nextStep();
	}

}
