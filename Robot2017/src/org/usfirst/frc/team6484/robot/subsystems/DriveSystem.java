package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team6484.robot.ArcadeDrive;
import org.usfirst.frc.team6484.robot.OI;

public class DriveSystem  {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
//	public RobotDrive myDrive = new RobotDrive(0,1,2,3);
//	public Joystick driveStick = new Joystick(0); 
//	public Joystick driveStick;
	public ArcadeDrive myDrive;
	public static OI oi;
	
	public void initDefaultCommand() {
		oi = new OI();
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		myDrive = new ArcadeDrive(0,1,2,3);
//		driveStick = new Joystick(0); 
		
	}
	
//	public void initDrive(){
//	
//	}
	public void startDrive(){
		myDrive.arcadeDrive(oi.driveStick,  1, oi.driveStick, 0, true);
	}
	
}


	

