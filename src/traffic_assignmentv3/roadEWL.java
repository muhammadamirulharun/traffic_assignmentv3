package traffic_assignmentv3;

import java.sql.Timestamp;

public class roadEWL extends Thread {

	static char roadEWLLightState = 'G';
	static boolean sensor = false; // false means no signal receive, true means yes.
	String receiveRoadSignal; //which road the signal came from
	
	roadEWL(String receiveRoadSignal, boolean sensor){
		System.out.println();
		this.receiveRoadSignal = receiveRoadSignal;
		this.sensor = sensor;
		run();
	}
	
	public synchronized void run() {
		roadNSEWR roadN = new roadNSEWR();
		if (receiveRoadSignal.equals("N")||receiveRoadSignal.equals("S")||receiveRoadSignal.equals("EWR")) {
		try {
			while(sensor==true) {
				System.out.println(new Timestamp(System.currentTimeMillis()) + " EWL " + roadEWLLightState);
				System.out.println("6 seconds before Yellow\n.\n.\n.");
				wait(6000); 
				
				roadEWLLightState = 'Y';
				System.out.println(new Timestamp(System.currentTimeMillis()) + " EWL " + roadEWLLightState);
				System.out.println("6 seconds before Red\n.\n.\n.");
				wait(6000);
				
				roadEWLLightState = 'R';
				System.out.println(new Timestamp(System.currentTimeMillis()) + " EWL " + roadEWLLightState);
				roadN.changeOtherRoadLightState(receiveRoadSignal);
				sensor=false;
			}
			notifyAll();
		}catch (Exception e) {};
		} // end of if
			
	}
}
