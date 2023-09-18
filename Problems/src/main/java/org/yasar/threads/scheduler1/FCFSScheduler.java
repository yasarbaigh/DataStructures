package org.yasar.threads.scheduler1;

import java.util.Collections;
import java.util.List;

public class FCFSScheduler implements Schedulers {

	int threadsCount;
	List<Job> jobs;

	public FCFSScheduler(List<Job> jobs, int threads) {
		this.jobs = jobs;
		this.threadsCount = threads;
	}

	public void schedule() {
		Collections.sort(jobs, JobComparators.fcfs);

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

	public void scheduleInDeadLine() {
		Collections.sort(jobs, JobComparators.fcfs);

		int[] timeConsumed = new int[threadsCount];

		String[] jobsAllocated = new String[threadsCount];
		String skippedJobs = "";
		int totalTimeCycles = 0;
		int count = 0;

		int timeCounter[] = new int[threadsCount];
		int currenThread = 0;

		for (Job item : jobs) {

			// if time-out reached b4 scheduling then skips
			if (timeConsumed[currenThread] <= item.getTimeoutDeadLine()) {
				jobsAllocated[currenThread] += "  " + item.getId() + ",";

				timeConsumed[currenThread] += item.getExecutionTime();
				totalTimeCycles += item.getExecutionTime();

				count++;
				currenThread = count % threadsCount;
			} else {
				skippedJobs += "  " + item.getId() + ",";
			}

		}

		count = 0;
		for (String item : jobsAllocated) {
			System.out.println("Thread T" + count++ + ": [" + item + "]");
		}
		System.out.println("Skipped Jobs: " + skippedJobs);
		System.out.println("Total time required for execution " + totalTimeCycles);
	}

}
