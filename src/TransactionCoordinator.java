import java.util.ArrayList;
import java.util.List;

public class TransactionCoordinator {

	//simulating a transaction coordinator connected this partition
	public Partition partition;
	
	public List<Integer> updatedPartitions = new ArrayList<Integer>();
	
	//write set per partition
	public WriteSet[] writeSet = new WriteSet[Commons.D];
	
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
		
			//what until cvc[k] <= GSS[k]
			while (cvc.get(k) > partition.GSS.get(k));
		}
		
		Transaction T = new Transaction();
		T.svc = partition.GSS.clone();
		T.svc.clock[partition.d] = Commons.max(cvc.get(partition.d), partition.Clock);
		return T;
	}
	
	
	public void updateObjects(Transaction T, List<Update> updates) { 
		for (Update u: updates) {
			int i = Commons.partition(u.key);
			if (!updatedPartitions.contains(i))
				updatedPartitions.add(i);
			
			writeSet[i].updates.add(u);
		}
	}
	
	public List<String> readObjects(Transaction T, List<String> keys) {
		List<String> result = new ArrayList<String>();
		for (String key : keys) {
			int i = Commons.partition(key);
			Partition target = Commons.getPartition(partition.d, i);
			String val = target.sendReadKey(T.svc, key);
			//todo continue
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
	}
}
