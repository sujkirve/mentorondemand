package com.ibm.trainings.utility;

import java.time.LocalDate;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
	
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	  /**
     * Returns current system java.util.Date
     *
     * @return <code>Date</code>
     */
    public static Date getSystemDate() {
        return new java.util.Date();
    }
    
    /**
     * Converts java.util.Date into date String in given format
     *
     * @return <code>String</code>
     */
    public static String getformattedDateString(java.util.Date date,
                                                String format) {
        String dateString = null;
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    format);
            dateString = sdf.format(date);
        } catch (Exception pe) {
            if (log.isErrorEnabled()) {
                log.error("getformattedDateString() | ParseException "
                        + pe.getMessage());
            }
        }
        return dateString;
    }
    
    
    /**
     * Converts java.util.Date into date String in given format
     *
     * @return <code>String</code>
     */
    public static String getformattedDateString(LocalDate date,
                                                String format) {
        String dateString = null;
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    format);
            dateString = sdf.format(java.sql.Date.valueOf(date));
        } catch (Exception pe) {
            if (log.isErrorEnabled()) {
                log.error("getformattedDateString() | ParseException "
                        + pe.getMessage());
            }
        }
        return dateString;
    }
}
