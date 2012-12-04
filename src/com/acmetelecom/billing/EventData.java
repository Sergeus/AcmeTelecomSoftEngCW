package com.acmetelecom.billing;
import com.acmetelecom.time.TimeStamp;


class EventData implements Comparable<EventData>{
		
		private final EventType type;
		private final TimeStamp time;
		
		public EventData(EventType type, TimeStamp time) {
			this.time = time;
			this.type = type;
		}
		
		public EventType getType(){
			return type;
		}
		
		public TimeStamp getTime(){
			return time;
		}

		@Override
		public int compareTo(EventData o) {
			return time.compareTo(o.time);
		}
		
		
	}
