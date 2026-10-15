package ejercicio14.jobScheduler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobSchedulerTest {
	protected JobDescription firstJob;
	protected JobDescription highestPriorityJob;
	protected JobDescription mostEffortJob;
	protected JobDescription lastJob;

	private void initializeJobs() {

		firstJob = new JobDescription(1, 1, "Este es el primero");
		highestPriorityJob = new JobDescription(1, 100, "Este es el de más prioridad");
		mostEffortJob = new JobDescription(100, 1, "Este es el de más esfuerzo");
		lastJob = new JobDescription(1, 1, "Este es el último");
	}

	@BeforeEach
	void setUp() {
		this.initializeJobs();

	}

	private JobScheduler newFifoScheduler() {
		FIFO fifoPolicy = new FIFO();
		JobScheduler fifoScheduler = new JobScheduler(fifoPolicy);
		return fifoScheduler;
	}

	private JobScheduler newLifoScheduler() {
		LIFO lifoPolicy = new LIFO();
		JobScheduler lifoScheduler = new JobScheduler(lifoPolicy);
		return lifoScheduler;
	}

	private JobScheduler newPriorityScheduler() {
		HighestPriority priorityPolicy = new HighestPriority();
		JobScheduler priorityScheduler = new JobScheduler(priorityPolicy);
		return priorityScheduler;
	}

	private JobScheduler newEffortScheduler() {
		MostEffort effortPolicy = new MostEffort();
		JobScheduler effortScheduler = new JobScheduler(effortPolicy);
		return effortScheduler;
	}

	private void scheduleJobsIn(JobScheduler aJobScheduler) {
		aJobScheduler.schedule(firstJob);
		aJobScheduler.schedule(highestPriorityJob);
		aJobScheduler.schedule(mostEffortJob);
		aJobScheduler.schedule(lastJob);
	}

	@Test
	void testSchedule() {
		HighestPriority priorityPolicy = new HighestPriority();
		JobScheduler aScheduler = new JobScheduler(priorityPolicy);
		aScheduler.schedule(highestPriorityJob);
		assertTrue(aScheduler.getJobs().contains(highestPriorityJob));
	}

	@Test
	void testUnschedule() {
		LIFO lifoPolicy = new LIFO();
		JobScheduler aScheduler = new JobScheduler(lifoPolicy);
		this.scheduleJobsIn(aScheduler);
		aScheduler.unschedule(highestPriorityJob);
		assertFalse(aScheduler.getJobs().contains(highestPriorityJob));
	}

	@Test
	void testNextFIFO() {
		JobScheduler scheduler = this.newFifoScheduler();
		this.scheduleJobsIn(scheduler);
		assertEquals(firstJob, scheduler.next());
		assertFalse(scheduler.getJobs().contains(firstJob));
		assertEquals(3, scheduler.getJobs().size());

	}

	@Test
	void testNextLIFO() {
		JobScheduler scheduler = this.newLifoScheduler();
		this.scheduleJobsIn(scheduler);
		assertEquals(lastJob, scheduler.next());
		assertFalse(scheduler.getJobs().contains(lastJob));
		assertEquals(3, scheduler.getJobs().size());

	}

	@Test
	void testNextPriority() {
		JobScheduler scheduler = this.newPriorityScheduler();
		this.scheduleJobsIn(scheduler);
		assertEquals(highestPriorityJob, scheduler.next());
		assertFalse(scheduler.getJobs().contains(highestPriorityJob));
		assertEquals(3, scheduler.getJobs().size());
	}

	@Test
	void testNextEffort() {
		JobScheduler scheduler = this.newEffortScheduler();
		this.scheduleJobsIn(scheduler);
		assertEquals(mostEffortJob, scheduler.next());
		assertFalse(scheduler.getJobs().contains(mostEffortJob));
		assertEquals(3, scheduler.getJobs().size());
	}

}
