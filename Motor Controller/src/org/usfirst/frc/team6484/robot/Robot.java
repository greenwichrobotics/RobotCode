package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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

	myDrive = new RobotDrive(0,1,2,3);
	private Joystick stick = new Joystick(0); // initialize the joystick on port
												// 0

	private final double kUpdatePeriod = 0.005; // update every 0.005 seconds/5
												// milliseconds (200Hz)

	public Robot() {
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
//			motor1.set(-1 * stick.getY());
//			motor2.set(-1 * stick.getY());
//			motor3.set(stick.getY());
//			motor4.set(stick.getY());
			if (stick.getX() > .2 || stick.getX() < -.2){
				motor1.set(.5 * stick.getX());
				motor2.set(.5 * stick.getX());
				motor3.set(.5 * stick.getX());
				motor4.set(.5 * stick.getX());
			}else if (stick.getX() > -.2 && stick.getX() < .2){
				motor1.set(0);
				motor2.set(0);
				motor3.set(0);
				motor4.set(0);
			}
//			motor1.set(.2 * stick.getX());
//			motor2.set(.2 * stick.getX());
//			motor3.set(.2 * stick.getX());
//			motor4.set(.2 * stick.getX());
			
			

			Timer.delay(kUpdatePeriod); // wait 5ms to the next update
		}
	}
}
