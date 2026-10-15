package ejercicio14.jobScheduler;

import java.util.List;

public class LIFO implements JobPolicy {
	
	
	public LIFO() {
		
	}

	@Override
	public JobDescription next(List <JobDescription> jobs) {
        JobDescription nextJob = jobs.get(jobs.size()-1);
        return nextJob;
	}
}