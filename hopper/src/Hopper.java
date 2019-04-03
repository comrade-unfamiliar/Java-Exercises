// Represents a Biped that moves alternating the left and right foot

import java.awt.Image;

public class Hopper extends Biped
{
  private int stepLength;
  private int stepsCount;
  
  // Constructor
  public Hopper(int x, int y, Image leftPic, Image rightPic)
  {
    super(x, y, leftPic, rightPic);  // must be the first statement
    stepLength = PIXELS_PER_INCH * 12;
  }  

 //moves forward 1 step length if you hop
  public void firstStep()
  {
    getLeftFoot().moveForward(stepLength);
    getRightFoot().moveForward(stepLength);
  }

  // Makes next step
  public void nextStep()
  {
    //if (stepsCount % 2 == 0)  // if stepsCount is even
      getLeftFoot().moveForward(stepLength);
      getRightFoot().moveForward(stepLength);

    //stepsCount+=2;
  }

  // Stops this walker (brings its feet together)
  public void stop()
  {
      /*getLeftFoot().moveForward(stepLength);
      getRightFoot().moveForward(stepLength);*/
  }

  // Returns the distance walked
  public int distanceTraveled()
  {
    return stepsCount * stepLength;
  }
}
