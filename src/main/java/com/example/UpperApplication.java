package com.example;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UpperApplication {

	private Logger logger = Logger.getLogger(UpperApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UpperApplication.class, args);
	}

	public String getFormattedTime() {
		long milliseconds = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(milliseconds);
		return sdf.format(calendar.getTime());
	}

	@RequestMapping(value = "/time", method = RequestMethod.POST)
	public String time(@RequestHeader HttpHeaders headers) {
		String time = getFormattedTime();
		logger.info("Time: " + time);
		return time;
	}
}
