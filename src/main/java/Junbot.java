import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Junbot - a robot by (your name here)
 */
public class Junbot extends Robot
{
	/**
	 * run: Junbot's default behavior
	 */

	boolean ending = false;
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBodyColor(new Color(0, 200, 0));
		setGunColor(new Color(0, 150, 50));
		setRadarColor(new Color(0, 100, 100));
		setBulletColor(new Color(255, 255, 100));
		setScanColor(new Color(255, 200, 200));
		double heading = getHeading();
		turnLeft(heading);
		double gunheading = getGunHeading();
		turnGunLeft(gunheading);
		turnGunLeft(180);
		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			if (getNumSentries() < 5 && !ending) {
				ending = true;
				turnGunLeft(getGunHeading());
				turnGunRight(getHeading());
			}
			ahead(500);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		ahead(100);
	}

	public void onHitRobot(HitRobotEvent event){
		// Replace the next line with any behavior you would like
		turnRight(90);
		turnRadarRight(90);
		turnGunRight(90);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(90);
		turnRadarRight(90);
		turnGunRight(90);
	}
}
