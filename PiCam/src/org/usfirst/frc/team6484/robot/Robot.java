package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Uses the CameraServer class to automatically capture video from a USB webcam
 * and send it to the FRC dashboard without doing any vision processing. This
 * is the easiest way to get camera images to the dashboard. Just add this to the
 * robotInit() method in your program.
 */
public class Robot extends IterativeRobot {
	private final NetworkTable grip = NetworkTable.getTable("grip");
	@Override
	public void robotInit() {
//		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().addServer("raspberrypi.frc-robot.local", 1180);
	}

}
