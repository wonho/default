package edu.showcase.system.log;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogWriter implements BatchWriter<Object> {

	private static final Logger logger = LoggerFactory.getLogger(LogWriter.class);

	public void write(List<Object> logEvents) {
		
		int count = 0;
		
		for (Object logEvent : logEvents) {
			logger.info("logEvents[" + count + "] : " + logEvent);
			count++;
		}

	}

}
