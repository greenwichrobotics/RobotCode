package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a sample program to demonstrate how to use a gyro sensor to make a
 * robot drive straight. This program uses a joystick to drive forwards and
 * backwards while the gyro is used for direction keeping.
 */
public class Robot extends IterativeRobot {
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.007; // propotional turning constant

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	private static final double kVoltsPerDegreePerSecond = 0.0128;

	private static final int kLeftMotorFrontPort = 0;
	private static final int kLeftMotorBackPort = 1;
	private static final int kRightMotorFrontPort = 2;
	private static final int kRightMotorBackPort = 3;
	private static final int kGyroPort = 1;
	private static final int kJoystickPort = 0;

	private RobotDrive myRobot = new RobotDrive(kLeftMotorFrontPort, kLeftMotorBackPort, kRightMotorFrontPort, kRightMotorBackPort);
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	private Joystick joystick = new Joystick(kJoystickPort);
	private double compensation = .2;
	private Timer myTimer = new Timer();
	

	@Override
	public void robotInit() {
		
//		gyro.calibrate();
//		boolean buttonValue;

//		gyro.
//		gyro.setSensitivity(kVoltsPerDegreePerSecond);
	}
	
	/**
	 * The motor speed is set from the joystick while the RobotDrive turning
	 * value is assigned from the error between the setpoint and the gyro angle.
	 */
	@Override
	public void teleopInit(){
	
//		gyro.reset();
//		System.out.println(gyro.getAngle());
//		
//		gyro.reset();
//		System.out.println(gyro.getAngle());
//		Timer.delay(2.0);
//		System.out.println(gyro.getAngle());
		
//		gyro.calibrate();
		myTimer.start();
		
	}
	@Override
	public void teleopPeriodic() {
//		System.out.println(gyro.getAngle());
		//double turningValue = (kAngleSetpoint - gyro.getAngle()) * kP;
		
		double angle = gyro.getAngle();
		System.out.println(angle);
//		if (angle > 1){
//			angle = 1;
//		}
//		else if (angle < -1 ){
//			angle = -1;
//		}
//		System.out.println(angle);
		
//			SmartDashboard.putString("DB/String 7", "Gyro: " + Double.toString(angle));
//		double turningValue = -angle * kP;
		// Invert the direction of the turn if we are going backwards
//		turningValue = Math.copySign(turningValue, joystick.getY());
//		System.out.println(turningValue);
//		myRobot.arcadeDrive(joystick.getY(), compensation);
		
		double turningValue = (kAngleSetpoint - angle) * kP;
		System.out.println(turningValue);
//		System.out.println("turningValue=" + turningValue);
		double direction = Math.copySign(1, joystick.getY());
		double compensation = direction * turningValue;
		
//		if (compensation > 0.1){
//			compensation = 0.1;
//		}
//		else if (compensation < -0.1 ){
//			compensation = -0.1;
//		}
		System.out.println(compensation);
		myRobot.drive(joystick.getY(), compensation);
	
		
		
		
//		Timer.delay(0.01);
	}
}
