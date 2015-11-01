package com.tripoin.util.time;

import java.util.Date;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TimeAgo {

	public static final String estimatedTime(Date startDate, Date endDate){
		long different = endDate.getTime() - startDate.getTime();		
		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;
		
		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;
		
		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;
		
		long elapsedSeconds = different / secondsInMilli;
		
		if(elapsedDays > 7)
			return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.ON).concat(ParameterConstantEstimate.FORMAT_DEFAULT.format(startDate));
		else if(elapsedDays > 0 && elapsedDays <= 7){
			if(elapsedDays == 1)
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.DAY);
			else
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.DAYS);				
		}else if(elapsedHours > 0){
			if(elapsedHours == 1)
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.HOUR);
			else
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.HOURS);				
		}else if(elapsedMinutes > 0){
			if(elapsedMinutes == 1)
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.MINUTE);
			else
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.MINUTES);				
		}else{
			if(elapsedSeconds <= 2)
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.SECOND);
			else
				return ParameterConstantEstimate.LAST_MODIFIED.concat(ParameterConstantEstimate.SECONDS);				
		}
	}
	
}
