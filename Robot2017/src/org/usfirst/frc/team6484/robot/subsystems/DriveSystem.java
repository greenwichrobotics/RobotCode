package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveSystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
//	public RobotDrive myDrive = new RobotDrive(0,1,2,3);
//	public Joystick driveStick = new Joystick(0); 
	public Joystick driveStick;
	public RobotDrive myDrive;
	
	
	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		myDrive = new RobotDrive(0,1,2,3);
		driveStick = new Joystick(0); 
		
	}
	
//	public void initDrive(){
//	
//	}
	public void startDrive(){
		myDrive.arcadeDrive(driveStick);
	}
	
}


	
