package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	SmartDashboard db = new SmartDashboard();
//	private Gyro gyro;
//	static final double Kp = 0.0;
	double Kp = 0.03;
	
//	String speedString =  SmartDashboard.getString("DB/String 0", "0.0");
//	String timeString = SmartDashboard.getString("DB/String 1", "0.0");
//	double speed =  -1.0 * Double.parseDouble(speedString);
//	double time = Double.parseDouble(timeString);
	
    public void robotInit() {
//    	gyro = new AnalogGyro(1);
    	myDrive = new RobotDrive(0,1,2,3);
    	System.out.println("Test2");
    	myDrive.setSafetyEnabled(true);
    	
//    	 double speed = db.getNumber("DB/Slider 0", 0.0);
////    	 db.getDouble("Speed");
//    	 System.out.println(speed);
    	 
    }

    
    public void autonomous() {
    	Timer timer = new Timer();
//        gyro.reset();
        timer.start();
        double speed = SmartDashboard.getNumber("DB/Slider 0", 0.0);
        System.out.println(speed);
//        SmartDashboard.putString("DB/String 0", "Speed " + Double.toString(speed));
        double fudge = SmartDashboard.getNumber("DB/Slider 1", 0.0);
//        SmartDashboard.putString("DB/String 1", "Fudge " + Double.toString(fudge));
        
        double time = SmartDashboard.getNumber("DB/Slider 2", 0.0);
//        SmartDashboard.putString("DB/String 2", "Time " + Double.toString(time));
          while (isAutonomous() && isEnabled()) {
//            double angle = gyro.getAngle(); // get current heading
        	
            myDrive.drive(-speed, -fudge); // drive towards heading 0
            Timer.delay(0.004);
            if (timer.get() > time){
    		myDrive.drive(0, 0.0);
    		timer.stop();
    		speed = 0.0;
    		time = 0.0;
    		fudge = 0.0;
    		break;
    		}
            
        }
        myDrive.drive(0.0, 0.0);
    }
    
    
    

}
