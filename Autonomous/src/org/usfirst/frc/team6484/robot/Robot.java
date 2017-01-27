package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

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
	static final double Kp = 0.03;
	
    public void robotInit() {
    	myDrive = new RobotDrive(0,1,2,3);
    	System.out.println("Test2");
    }
    public void autonomousInit(){
    	while (isAutonomous() && isEnabled()) {
    		
    		myDrive.arcadeDrive(-1.0, Kp);
    		Timer.delay(0.01);
    	}
    }
    public void autonomous(){
    	System.out.println("Test3");
while (isAutonomous() && isEnabled()) {
    		
    		myDrive.arcadeDrive(-0.5, Kp);
    		Timer.delay(0.01);
    	}
    }
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();
    	System.out.println("Test");
    	while (isAutonomous() && isEnabled()) {
    		
    		myDrive.arcadeDrive(-1.0, Kp);
    		Timer.delay(0.01);
    	}
    }
}
