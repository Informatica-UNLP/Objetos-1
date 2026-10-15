package ejercicio14.jobScheduler;
import java.util.List;
public class FIFO implements JobPolicy {
	
	
	public FIFO() {
		
	}

	@Override
	public JobDescription next(List <JobDescription> jobs) {
		JobDescription nextJob = jobs.get(0);
        return nextJob;
	}
}
