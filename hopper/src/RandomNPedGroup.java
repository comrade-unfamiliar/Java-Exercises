import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RandomNPedGroup implements StudentGroup {
	private RandomNPed nPed;
	private Image leftMansShoe, rightMansShoe;
    private int n;
	private DanceFloor danceFloor;

	private enum State {
		READY, MOVING, STOPPED
	}

	private State currentState;

	// Constructor
	public RandomNPedGroup(DanceFloor df, int numFeet) {
		danceFloor = df;
		leftMansShoe = (new ImageIcon("leftshoe.gif")).getImage();
		rightMansShoe = (new ImageIcon("rightshoe.gif")).getImage();
		n = numFeet;
	}

	// Sets up this group of participants
	public void setup(int floorDir, Dance steps1, Dance steps2) {
		int x = danceFloor.getWidth() / 2;
		int y = danceFloor.getHeight() / 2;
		if (floorDir == 0) {
			nPed = new RandomNPed(x, y + nPed.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe, n);
			nPed.turnLeft();
		} else {
			nPed = new RandomNPed(x, y - nPed.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe, n);
			nPed.turnRight();
		}
		currentState = State.READY;
		danceFloor.update(this);

		//nPed.learn(steps1);
	}

	// Moves the group by one step
	public void makeNextStep() {
		if (currentState == State.READY) {
			nPed.firstStep();
			currentState = State.MOVING;
		} else if (currentState == State.MOVING) {
			nPed.hop();
		} else if (currentState == State.STOPPED) // never happens
		{
			nPed.turnAround();
			currentState = State.READY;
		}

		danceFloor.update(this);
	}

	// Draws this group
	public void draw(Graphics g) {
		nPed.draw(g);
		
	}
}
