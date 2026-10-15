package ejercicio14.jobScheduler;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
    protected List<JobDescription> jobs;
    protected JobPolicy policy;

    public JobScheduler(JobPolicy policy) {
        this.jobs = new ArrayList<>();
        this.policy = policy;
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public JobPolicy getPolicy() {
        return this.policy; 
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }


    public JobDescription next() {
        JobDescription nextJob = this.policy.next(this.jobs);
        this.unschedule(nextJob);
        return nextJob;
    }
       

}
