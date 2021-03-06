package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * Joystick analog val7making it easy to work together. The program also delays a
 * short time in the loop to allow other threads to run. This is generally a
 * good idea, especially since the joystick values are only transmitted from the
 * Driver Station once every 20ms.
 */
public class Robot extends SampleRobot {

	 // initialize the motor as a
//	Compressor c = new Compressor(0);
//	DoubleSolenoid exampleDouble = new DoubleSolenoid(0, 1);
	Solenoid light1 = new Solenoid(0);
	Solenoid light2 = new Solenoid(1);
	boolean light1On = false;
	boolean light2On = false;
													// Talon on channel 0
	private XboxController stick = new XboxController(1); // initialize the joystick on port
												// 0

	private final double kUpdatePeriod = 0.005; // update every 0.005 seconds/5
												// milliseconds (200Hz)

	public Robot() {
//		c.setClosedLoopControl(false);
	}

	/**                                                                                                                                        
	 * Runs the motor from a joystick.
	 */
	@Override
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			
//			if (stick.getStartButton())
//				c.setClosedLoopControl(true);
//			else if (stick.getBackButton())
//				c.setClosedLoopControl(false);
			
			if (stick.getAButton()){
				light1On = !light1On;
				light1.set(light1On);
				Timer.delay(.5);
				
			}
			if (stick.getBButton()){
				light2On = !light2On;
				light2.set(light2On);
				Timer.delay(.5);
			}
			

			Timer.delay(kUpdatePeriod); // wait 5ms to the next update
		}
	}
}
