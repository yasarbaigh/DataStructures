package org.yasar.threads.scheduler1;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
	public static void main(String[] args) {

		List<Job> jobs = prepareJobs();
		
		Schedulers  scdlr = new FCFSScheduler(jobs, 3);
		scdlr.schedule();
		scdlr.scheduleInDeadLine();
		
		Schedulers  scdlr1 = new FPSscheduler(jobs, 3);
		scdlr1.schedule();
		scdlr1.scheduleInDeadLine();
		
		Schedulers  scdlr2 = new FPSscheduler(jobs, 3);
		
		scdlr2.scheduleInDeadLine();
	}

	private static List<Job> prepareJobs() {
		List<Job> jobs = new ArrayList<>();
		
		jobs.add(new Job(1, "J1", 10, 0, 10, "ROOT"));
		jobs.add(new Job(2, "J2", 20, 0, 40, "Admin"));
		jobs.add(new Job(3, "J3", 15, 2, 40, "ROOT"));
		jobs.add(new Job(4, "J4", 30, 1, 40, "User"));
		jobs.add(new Job(5, "J5", 10, 2, 30, "User"));
		
		return jobs;
		
	}
}
