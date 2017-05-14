import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
public class NXTNew {
	static NXTRegulatedMotor rightMotor = Motor.A; // the right motor connected to port A
	static NXTRegulatedMotor leftMotor = Motor.C; // the left motor connected to port C
	static int squareLen = 2000;
	static int speedDrive = 300;
	
	public static void main(String[] args) {
	 travel(squareLen);
	}
	public static void travel (int distance){
	 int numDegrees = distance;
	 leftMotor.setSpeed(speedDrive); //set degrees/sec speed
	 rightMotor.setSpeed(speedDrive);
	 leftMotor.resetTachoCount(); // set tachometesr to 0
	 rightMotor.resetTachoCount();
	 leftMotor.forward();
	 rightMotor.forward();
	 //check whether either motors have more degrees to turn
	 while ((leftMotor.getTachoCount() <= numDegrees) || (rightMotor.getTachoCount()<= numDegrees)){
	 if (leftMotor.getTachoCount() > numDegrees) // //if either motor has gone far enough, stop it
	 leftMotor.stop();
	 if (rightMotor.getTachoCount() > numDegrees)
	 rightMotor.stop();
	 leftMotor.stop(); }//to be sure
	 rightMotor.stop();
	 rightMotor.rotateTo(14);
	} 
}