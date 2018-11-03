package org.yasar.threads.scheduler1;

public class Job {

	int executionTime, priority, timeoutDeadLine, id;
	String name, usertype;

	public Job(int i, String string, int j, int k, int l, String string2) {
		id = i;
		name = string;
		executionTime = j;
		priority = k;
		timeoutDeadLine = l;
		usertype = string2;

	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeoutDeadLine() {
		return timeoutDeadLine;
	}

	public void setTimeoutDeadLine(int timeoutDeadLine) {
		this.timeoutDeadLine = timeoutDeadLine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}
