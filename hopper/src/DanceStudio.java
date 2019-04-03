public class DanceStudio
{
  public static void main(String[] args)
  {
    DanceFloor danceFloor = new DanceFloor();
    //StudentGroup students = new DanceGroup(danceFloor);
   // StudentGroup students = new HoppingGroup(danceFloor);
   // StudentGroup students = new RandomHoppingGroup(danceFloor);   
    StudentGroup students = new RandomNPedGroup(danceFloor, 4);   
    new DanceLesson(students, danceFloor);
  }
}
