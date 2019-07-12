import java.util.List;

public class Partition {
	//data center in 1..Commons.D
	public int d;
	
	//partition number in 1..Commons.P
	public int m;
	
	//partition vector clock
	//pvc[k] is the time of the latest update received from data center k 
	//regarding the same partition
	public VectorClockD pvc = new VectorClockD(); 

	
	//the globally stable snapshot
	public VectorClockD GSS = new VectorClockD(); 
	
	//current physical time
	public Long Clock;
	
	//prepared transactions
	public List<Transaction> prepTx;
	
	//committed transactions
	public List<Transaction> committedTx;
	
	//log of updates
	//TODO: do we need the class Log, can we use list of updates
	public Log log;
	
	//Matric of received pvcs
	public VectorClockD[][] PMC = new VectorClockD[Commons.D][Commons.P];
	
	
	public Partition(int dcId, int num) {
		d = dcId;
		m = num;
	}
	
}
