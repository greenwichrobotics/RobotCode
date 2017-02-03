// ******************************************************
// Description: Controls the motors used for driving.
// Year: 2017
package org.usfirst.frc.team6484.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.RobotMap;
import org.usfirst.frc.team6484.robot.commands.teleopDrive;

public class DriveSystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static RobotDrive myDrive;
	private static OI oi = new OI();
	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new teleopDrive());
	}
		
	public static void Drive(double moveValue, double turnValue){
		myDrive.arcadeDrive(moveValue, turnValue, true);
	}
	
}


	

