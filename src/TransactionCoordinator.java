
public class TransactionCoordinator {

	//simulating a transaction coordinator connected this partition
	public Partition partition;
	
	// d: data center number
	// m: partitioin number
	public TransactionCoordinator(int d, int m) {
		partition = new Partition(d, m);
	}
	

	//cvc: the last snapshot seen by the client
	public Transaction startTransaction(VectorClockD cvc) {
		//TC ensures that it assigns T a snapshot no older than cvc
		for (int k = 1; k < Commons.D; k++) {
			if (k == partition.d)
				continue;
		
			//block if needed
			while (cvc.get(k) <= partition.GSS.get(k));
		}
		
		Transaction T = new Transaction();
		T.svc = partition.GSS.clone();
		T.svc.clock[partition.d] = Commons.max(cvc.get(partition.d), partition.Clock);
		return T;
	}
	
	
	public static void main(String[] args) {
		
	}
}
