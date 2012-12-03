package com.acmetelecom;
import com.acmetelecom.time.Time;


public class lolClass implements Comparable<lolClass>{
		
		private final String type;
		private final Time time;
		
		public lolClass(String type, Time time) {
			this.time = time;
			this.type = type;
		}
		
		public String getType(){
			return type;
		}
		
		public Time getTime(){
			return time;
		}

		@Override
		public int compareTo(lolClass o) {
			return time.compareTo(o.time);
		}
		
		
	}
