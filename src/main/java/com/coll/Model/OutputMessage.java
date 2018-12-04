package com.coll.Model;

import java.util.Date;

public class OutputMessage extends Message
{
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public OutputMessage(Message original,Date time)
	{
		super(original.getId(),original.getMessage());
		this.time=time;
	}
}
