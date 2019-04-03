public class Time {

	//Fields:
	private int hour;
	private int minute;
	private boolean amPM;
	
	//Constructors:
	public Time() {
		hour = 0;
		minute = 0;
	}
	
	public Time(int h, int m) {
		if ((h > 24 || h < 0) || (m >=60 || m < 0)) {
			throw new IllegalArgumentException(
			           "Hours or minutes is greater or less than logical input");
		}
		else if (h == 24) {
			hour = 0;
			minute = m;
		}
		else {
			hour = h;
			minute = m;
		}
	}
	
	public Time(int m) {
		while (m >= 1440) {
			m-=1440;
		}
		int count = 0;
		while (m%60 != 0) {
			m--;
			count++;
		}
		hour = m/60;
		minute = count;

	}
	
	public Time(Time t) {
		hour = t.hour;
		minute = t.minute;
	}
	
	public Time(int h, int m, boolean isAM) {
		if ((h >= 24 && isAM == true || h <= 0) || (m >=60 || m < 0)) {
			throw new IllegalArgumentException(
			           "Hours or minutes is greater or less than logical input");
		}
		else if (h == 24 && isAM == false) {
			hour = 0;
		}
		else {
			hour = h;
			minute = m;
			amPM = isAM;
		}
	}
	
	//Methods:
	public String toString() {
		String h = hour + "";
		String m = minute + "";
		if (amPM == false) {
			if (hour < 10) {
				h = "0" + hour;
			}
			if (minute < 10) {
				m = "0" + minute;
			}
			return h + ":" + m;
		}
		else {
			int h1 = hour;
			String am = "AM";
			if (h1 > 12) {
				h1-=12;
				h = String.valueOf(h1);
				am = "PM";
			}
			else if (h1 == 12) {
				am = "PM";
			}
			else if (h1 == 0) {
				h1 = 12;
				h = String.valueOf(h1);
			}
			else {
				am = "AM";
			}
			if (h1 < 10) {
				h = "0" + h1;
			}
			if (minute < 10) {
				m = "0" + minute;
			}
			return h + ":" + m + am; 
		}
	}
	
	public void setPrintAMPM(boolean AMPM) {
		amPM = AMPM;
		
	}
	
	//converts time to minutes
	private int toMins() {
		return hour*60 + minute;
	}
	
	//returns an integer based on if the parameter is earlier or later
	//than this object
	public int compareTo(Time t) {
		int time1 = this.toMins();
		int time2 = t.toMins();
		if (time1 < time2) {
			return -1;
		}
		else if (time1 == time2) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	//returns the number of minutes elapsed from the
	//parameter
	public int elapsedSince(Time t) {
		if (t.toMins() > this.toMins()) {
			return this.toMins() + 1440 - t.toMins();
		}
		else {
			return this.toMins()- t.toMins();
		}
	}
	
	//increments this time object by 1 minute
	public void increment() {
		if (hour == 23 && minute == 59) {
			hour =0;
			minute = 0;
		}
		else if (minute == 59) {
			hour += 1;
			minute = 0;
		}
		else {
			minute++;
		}
	}
	
	//adds two Time objects together to make a new Time object
	public Time addTime(Time t) {
		int time1 = this.toMins();
		int time2 = t.toMins();
		int newTime = time1+time2;
		while (newTime >=1440) {
			newTime-=1440;
		}
		Time nt = new Time(newTime);
		return nt;
	}
}
