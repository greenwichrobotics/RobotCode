package org.usfirst.frc.team6484.robot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

import org.opencv.imgproc.Imgproc;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/*
 * @author: Elijah Kaufman and his team
 * 
 * Note From Author: If you use this code or the algorithm
 * please give credit to Elijah Kaufman and FRC team 3019, Firebird Robotics
 */


public class Vision{
	static NetworkTable table;
	static Thread Capture;
	static Thread Process;
	static Thread Send;
	//Color constants
	public static final Scalar 
		Red = new Scalar(0, 0, 255),
		Blue = new Scalar(255, 0, 0),
		Green = new Scalar(0, 255, 0),
		Yellow = new Scalar(0, 255, 255),
		//for tape
		thresh_Lower = new Scalar(0,110,0),
		thresh_Higher = new Scalar(255,255,134),
		//for grey tote
		grey_Lower = new Scalar(48,60,35),
		grey_higher = new Scalar(81,84,54);
	
	static final boolean Process_Gray = false;
	public static ArrayList<MatOfPoint> contours = new ArrayList<>();
	public static Mat frame,grey,original;
	static int counter = 0;
	public static void main(String[] args) {
		//required for openCV to work -call before any functions of oCV are used
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//initialize network tables
		NetworkTable.setClientMode();
		//the ip of the smartdashboard is "roborio-####.local" where #### is team number
		NetworkTable.setIPAddress("roborio-3019.local");
		table = NetworkTable.getTable("SmartDashboard");
		
		//main loop of the program
		while(true){
			try {
				while(table.isConnected()){
					processImage();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	//opens a new connection to the Axis camera and opens a new snapshot "instance"
	public static void processImage(){
		try {
			//the url of the camera snapshot to save ##.## with your team number
			//Url url = new URL("http://10.##.##.11/axis-cgi/jpg/image.cgi");
			
			//comment if testing a regular file
			URL url = new URL("http://meye-99e1ecfe.frc-robot.local:1780");
			URLConnection uc = url.openConnection();
			BufferedImage image = ImageIO.read(uc.getInputStream());
			ImageIO.write(image, "png", new File("frame.png"));
			//time for the OpenCV fun!
			//frame = new Mat();

		//mostly for debugging but errors happen
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
}