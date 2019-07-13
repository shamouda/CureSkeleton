
public class Commons {
	
	//number of data centers
	public static final int D = 3; 
	
	//number of partitions
	public static final int P = 2;
	
	public static Long max(Long a, Long b) {
		if (a > b)
			return a;
		else
			return b;
	}
	
	//identifies the home partition of the key
	public static int partition(String key) {
		return -1;
	}
	
	public static Partition getPartition(int d, int m) {
		//this just simulates a specific partition
		return new Partition(d, m);
	}
}
