package traffic_assignmentv3;

import java.sql.Timestamp;
import java.util.Scanner;

public class roadNSEWR extends Thread{

	char roadNLightState= 'R';
	char roadSLightState = 'R';
	char roadEWRLightState = 'R';
	public synchronized void run() {
//		roadEWL.sensor = true;
//		while(true) {
		System.out.println((new Timestamp(System.currentTimeMillis()) + " L EWL " + roadEWL.roadEWLLightState));
		System.out.println((new Timestamp(System.currentTimeMillis()) + " L EWR " + roadEWRLightState));
		System.out.println((new Timestamp(System.currentTimeMillis()) + " L N " + roadNLightState));
		System.out.println((new Timestamp(System.currentTimeMillis()) + " L S " + roadSLightState));
		
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter signal (N/S/EWR): ");
		new roadEWL(input.next(),true);
//		}
		
	}

	public void changeOtherRoadLightState(String roadName) {
		System.out.print(new Timestamp(System.currentTimeMillis()));
		if(roadName.equals("N")) {
			roadNLightState = 'G';
			System.out.println(" N " + roadNLightState);
		}
		
		else if(roadName.equals("S")) {
			roadSLightState = 'G';
			System.out.println(" S " + roadSLightState);
		}
		
		else if(roadName.equals("EWR")) {
			roadEWRLightState = 'G';
			System.out.println(" EWR " + roadEWRLightState);
		}
		
	}
}
