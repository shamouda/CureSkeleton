
public class VectorClockD implements Cloneable{
	public Long[] clock = new Long[Commons.D];
	
	public VectorClockD() {
		
	}
	
	public VectorClockD(Long[] x) {
		clock = x;
	}

	public Long get(int dcId) {
		return clock[dcId];
	}
	
	public VectorClockD clone() {
		Long[] vc2 = new Long[Commons.D];
		for (int i = 0 ; i < Commons.D; i++)
			vc2[i] = clock[i];
		return new VectorClockD(vc2);
	}
}
