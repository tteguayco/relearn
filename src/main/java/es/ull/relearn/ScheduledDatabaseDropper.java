package es.ull.relearn;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.SQLException;
import java.sql.Timestamp;

/*
 * An object of this class checks periodically (MILISECS_AMONG_CHECKS ms)
 * which tables in the database are older than allowed.
 *  
 * Then, those tables are dropped.
 */
public class ScheduledDatabaseDropper extends TimerTask {
	
	private static final double MILISECS_AMONG_CHECKS = 8.64e7; // ms in one day
	
	/**
	 * The databases created on PostgreSQL are stored in a HashMap.
	 * The key is the name of the database (which is a session ID actually)
	 * and the value is a timestamp which states when that database was
	 * created.
	 */
	private HashMap<String, Timestamp> databases;
	private DatabaseManager databaseManager;
	private Timer time;
	
	public ScheduledDatabaseDropper(HashMap<String, Timestamp> databases, DatabaseManager databaseManager) {
		this.databases = databases;
		this.databaseManager = databaseManager;
		this.time = new Timer();
	}
	
	public void start() {
		time.schedule(this, 0, (long) MILISECS_AMONG_CHECKS);
	}
	
	/**
	 * Drops all databases which were created one or more days ago.
	 * 
	 * If the database to be dropped is already being used by any user,
	 * it will not be dropped (an exception is raised).
	 */
	@Override
	public void run() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		Date yesterday = null;
		Timestamp yesterdayTimestamp = null;
		Iterator it = databases.entrySet().iterator();
		
		System.out.println("[" + now + "] ScheduledDatabaseDropper has started running.");
		
		// Calculate yesterday's date
		cal.add(Calendar.DATE, -1);
		yesterday = cal.getTime();
		yesterdayTimestamp = new Timestamp(yesterday.getTime());
		
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry) it.next();
	        String databaseName = pair.getKey().toString();
	        Timestamp creationTimestamp = (Timestamp) pair.getValue();
	        
	        // Database is too old -> drop it
	        if (creationTimestamp.before(yesterdayTimestamp)) {
	        	// Remove database from PostgreSQL
				databaseManager.switchToDefaultSchema();
				databaseManager.dropSchemaCascade(databaseName);
				
				it.remove();
				System.out.println("Database " + databaseName + " was deleted.");
	        }
	    }
	}
}
