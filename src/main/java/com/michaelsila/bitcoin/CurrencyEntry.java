package com.michaelsila.bitcoin;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author michael sila
 * Simple Container for 
 */
public class CurrencyEntry {
	private final LocalDateTime entryTime;
	private final Double BTCValue;
	private final Double ETHValue;
	/**
	 * 
	 */
	public CurrencyEntry() {
		entryTime=LocalDateTime.now();
		BTCValue=-1.0;;
		ETHValue=-1.0;
	}
	public CurrencyEntry(Double BTCValue,Double ETHValue) {
		entryTime=LocalDateTime.now();
		this.BTCValue=BTCValue;
		this.ETHValue=ETHValue;
	}
	public Double getBTC() {
		return this.BTCValue;
	}
	public Double getETH() {
		return this.ETHValue;
	}
	public LocalDateTime getEntryTime() {
		return this.entryTime;
	}
	
}
