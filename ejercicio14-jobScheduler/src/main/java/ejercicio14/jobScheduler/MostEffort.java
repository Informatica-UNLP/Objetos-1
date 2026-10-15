package ejercicio14.jobScheduler;

import java.util.List;

public class MostEffort implements JobPolicy {
	
	
	public MostEffort(){
		
	}

	@Override
	public JobDescription next(List <JobDescription> jobs) { 
         JobDescription nextJob = jobs.stream()
                    .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                    .orElse(null);
                return nextJob;
	}
}