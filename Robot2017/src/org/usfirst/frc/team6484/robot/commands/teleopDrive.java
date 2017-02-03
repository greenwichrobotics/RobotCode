package org.usfirst.frc.team6484.robot.commands;

import org.usfirst.frc.team6484.robot.OI;
import org.usfirst.frc.team6484.robot.Robot;
import org.usfirst.frc.team6484.robot.RobotMap;
import org.usfirst.frc.team6484.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class teleopDrive extends Command {

    public teleopDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try{
    		if(DriveSystem.myDrive == null)
    			DriveSystem.myDrive = new RobotDrive(RobotMap.rightMotor1, RobotMap.rightMotor2, RobotMap.leftMotor1, RobotMap.leftMotor2);
    	}
    	catch(Exception ex)
    	{
    		String temp = ex.getMessage();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveSystem.Drive(OI.driveStick.getY(), -OI.driveStick.getX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
