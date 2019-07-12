
public class Transaction {

	//snapshot vector clock
	public VectorClockD svc;
	
	//commit vector clock
	public VectorClockD ct;
	
	//write set of each partition
	public WriteSet[] ws = new WriteSet[Commons.D]; 
}
