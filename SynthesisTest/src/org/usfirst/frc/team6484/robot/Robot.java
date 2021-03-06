package org.usfirst.frc.team6484.robot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together. The program also delays a
 * short time in the loop to allow other threads to run. This is generally a
 * good idea, especially since the joystick values are only transmitted from the
 * Driver Station once every 20ms.
 */
public class Robot extends SampleRobot {

	RobotDrive myDrive;
	Joystick driveStick;

	public void robotInit() {
		myDrive = new RobotDrive(0,1,2,3);
		driveStick = new Joystick(1);
	}

	/**
	 * Runs the motor from a joystick. 
	 */
	@Override
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			// Set the motor's output.
			// This takes a number from -1 (100% speed in reverse) to +1 (100%
			// speed going forward)
			
			
			myDrive.arcadeDrive(driveStick,  1, driveStick,0);
			Timer.delay(0.01); // wait 5ms to the next update
		}
	}
	
	
	
}


