package com.zenhomes.counter.ws.vm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public enum FilterDate {

	_24H("24h") {
		@Override
		public Instant[] getDateTime() {
			LocalDateTime from = LocalDateTime.now()
					.minusHours(24)
					.withHour(0)
					.withMinute(0)
					.withSecond(0)
					.withMinute(0);
			LocalDateTime to = LocalDateTime.now();
			return new Instant[] { 
					from.atZone(ZoneId.systemDefault()).toInstant(),
					to.atZone(ZoneId.systemDefault()).toInstant() };
		}
	};
	private String value;

	private FilterDate(String value) {
		this.value = value;
	}

	public static FilterDate of(String value) {
		for (FilterDate filterDate : values()) {
			if (filterDate.value.equalsIgnoreCase(value)) {
				return filterDate;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}

	public String getValue() {
		return value;
	}

	public abstract Instant[] getDateTime();
}
