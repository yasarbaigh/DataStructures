package org.yasar.threads.scheduler1;

import java.util.Collections;
import java.util.List;

/**
 * Fixed Priority Scheduling
 * 
 * 
 * @author kingpin
 *
 */
public class FPSscheduler implements Schedulers {
	int threadsCount;
	List<Job> jobs;

	public FPSscheduler(List<Job> jobs, int threads) {
		this.jobs = jobs;
		this.threadsCount = threads;
	}

	@Override
	public void schedule() {
		Collections.sort(jobs, JobComparators.prioritized);

		int[] timeConsumed = new int[threadsCount];

		String[] jobsAllocated = new String[threadsCount];
		int totalTimeCycles = 0;

		int count = 0;

		int currenThread = 0;

		for (Job item : jobs) {
			jobsAllocated[currenThread] += "  " + item.getId() + ",";

			timeConsumed[currenThread] += item.getExecutionTime();
			totalTimeCycles += item.getExecutionTime();

			count++;
			currenThread = count % threadsCount;
		}

		count = 0;
		for (String item : jobsAllocated) {

			System.out.println("Thread T" + count++ + ": [" + item + "]");
		}

		System.out.println("Total time required for execution " + totalTimeCycles);

	}

	@Override
	public void scheduleInDeadLine() {
		// TODO Auto-generated method stub

	}

}
