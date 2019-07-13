import java.util.ArrayList;
import java.util.List;

public class Log {
	public List<LogEntry> list = new ArrayList<LogEntry>();
	
	public String getSnapshot(String key, VectorClockD svc) {
		String value = null;
		LogEntry latest = null;
		for (LogEntry e: list) {
			if (!e.key.equals(key) || e.clock.compareTo(svc) > 0)
				continue;
			if (latest == null || latest.clock.compareTo(e.clock) < 0)
				latest = e;
		}
		if (latest == null) {
			//add initial value for the key
			return ""; //may need to add to
		} else
			return latest.value;
	}
	
}
