package com.acmetelecom;
import com.acmetelecom.time.TimeStamp;


public class lolClass implements Comparable<lolClass>{
		
		private final String type;
		private final TimeStamp time;
		
		public lolClass(String type, TimeStamp time) {
			this.time = time;
			this.type = type;
		}
		
		public String getType(){
			return type;
		}
		
		public TimeStamp getTime(){
			return time;
		}

		@Override
		public int compareTo(lolClass o) {
			return time.compareTo(o.time);
		}
		
		
	}
