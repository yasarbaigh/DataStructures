package org.yasar.threads.scheduler1;

import java.util.Comparator;

public class JobComparators {

	/**
	 * First come first serve jobs
	 */
	public static Comparator<Job> fcfs = new Comparator<Job>() {

		@Override
		public int compare(Job o1, Job o2) {
			return o1.getId() - o2.getId();
		}
	};
	
	/**
	 * Highly Priortized Job first
	 * 
	 * 
	 */
	public static Comparator<Job> prioritized = new Comparator<Job>() {

		@Override
		public int compare(Job o1, Job o2) {
			int diff=  o1.getPriority() - o2.getPriority();
			
			if(diff == 0) {
				// if priority is same, more execution gets opportunity
				return o2.getExecutionTime() - o1.getExecutionTime();
			} 
			return diff;
		}
	};
}
