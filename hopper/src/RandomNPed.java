import java.awt.Graphics;
import java.awt.Image;

//This abstract class represents a n-legged creature, where n is a positive integer.
//The rest is trivial and left as an exercise to the viewer.

public class RandomNPed extends Biped {

	private int stepLength=PIXELS_PER_INCH*12;
	private int stepsCount;
	private int n; 
	private Foot extraFoot1;
	private Foot extraFoot2;
	private Foot extraFoot3;
	private Foot extraFoot4;
	private Foot extraFoot5;
	private Foot extraFoot6;
	private Foot extraFoot7;
	private Foot extraFoot8;


	public RandomNPed(int x, int y, Image pic, Image pic2, int footNumber) {
		super(x, y, pic, pic);
		n=footNumber;
		for (int i = 0; i<=n ; i++) {
			if(i==1)extraFoot1=new Foot(x,y+i*6,pic);
			else if(i==2)extraFoot2=new Foot(x,y+i*6,pic);
			else if(i==3)extraFoot3=new Foot(x,y+i*6,pic);
			else if(i==4)extraFoot4=new Foot(x,y+i*6,pic);
			else if(i==5)extraFoot5=new Foot(x,y+i*6,pic);
			else if(i==6)extraFoot6=new Foot(x,y+i*6,pic);
			else if(i==7)extraFoot7=new Foot(x,y+i*6,pic);
			else if(i==8)extraFoot8=new Foot(x,y+i*6,pic);
		}
		// TODO Auto-generated constructor stub
	}
	
	// moves forward 1 step length if you hop
	public void firstStep() {		
		getLeftFoot().moveForward(stepLength);
		getRightFoot().moveForward(stepLength);
		for(int i = n; i>0; i--) {
			if(i==1)extraFoot1.moveForward(stepLength);
			if (i==2) extraFoot2.moveForward(stepLength);
			if (i==3) extraFoot3.moveForward(stepLength);
			if (i==4) extraFoot4.moveForward(stepLength);
			if (i==5) extraFoot5.moveForward(stepLength);
			if (i==6) extraFoot6.moveForward(stepLength);
			if (i==7) extraFoot7.moveForward(stepLength);
			if (i==8) extraFoot8.moveForward(stepLength);			
		}
		
	}

	// Makes next step
	public void nextStep() {
		getLeftFoot().moveForward(stepLength);
		getRightFoot().moveForward(stepLength);
		for(int i = n; i>0; i--) {
			if(i==1)extraFoot1.moveForward(stepLength);
			if (i==2) extraFoot2.moveForward(stepLength);
			if (i==3) extraFoot3.moveForward(stepLength);
			if (i==4) extraFoot4.moveForward(stepLength);
			if (i==5) extraFoot5.moveForward(stepLength);
			if (i==6) extraFoot6.moveForward(stepLength);
			if (i==7) extraFoot7.moveForward(stepLength);
			if (i==8) extraFoot8.moveForward(stepLength);			
		}
	}

	public void turn(int d) {		
		for (int i=0; i<d;i++) {
			turnRight();
		}		
	}
	
	public void hop() {
		turn((int)(Math.random()*4));
		nextStep();
	}
	// Stops this walker (brings its feet together)
	public void stop() {
		/*
		 * getLeftFoot().moveForward(stepLength);
		 * getRightFoot().moveForward(stepLength);
		 */
	}

	// Returns the distance walked
	public int distanceTraveled() {
		return stepsCount * stepLength;
	}


	public void draw(Graphics g) {
		super.draw(g);
		if (n>1)extraFoot1.draw(g);
		if (n>2)extraFoot2.draw(g);
		if (n>3)extraFoot3.draw(g);
		if (n>4)extraFoot4.draw(g);
		if (n>5)extraFoot5.draw(g);
		if (n>6)extraFoot6.draw(g);
		if (n>7)extraFoot7.draw(g);
		if (n>8)extraFoot8.draw(g);
		
	}

}
