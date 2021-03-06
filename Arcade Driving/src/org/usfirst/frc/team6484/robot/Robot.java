package org.usfirst.frc.team6484.robot;



import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.ArcadeDrive;
//import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6484.robot.ArcadeDrive;
import org.usfirst.frc.team6484.robot.ArcadeDrive.MotorType;

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

	ArcadeDrive myDrive;
	Joystick driveStick;
	SpeedController motor;

	public void robotInit() {
		myDrive = new ArcadeDrive(1,0,3,2);
		driveStick = new Joystick(0);
		motor = new Talon(4);
		
//		 SmartDashboard.putNumber("DB/Sting 0", 0);
//		CameraServer.getInstance().startAutomaticCapture();
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
			
			double motorSpeed = (-1 * ((-1 + driveStick.getRawAxis(3)) / 2));
			myDrive.arcadeDrive(driveStick,  1, driveStick, 0, true);
			motor.set(motorSpeed);
			SmartDashboard.putString("DB/String 7", "Shooter: " + Double.toString(motorSpeed));
			Timer.delay(0.01); // wait 5ms to the next update
		}
	}
	
	
	
}


