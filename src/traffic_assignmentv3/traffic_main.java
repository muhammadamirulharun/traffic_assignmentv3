package traffic_assignmentv3;

public class traffic_main {
	
	public static void main(String[] args) {
		Thread EWL = new roadEWL("no",false);
		Thread N = new roadNSEWR();
		EWL.start();
		N.start();
	}

}
