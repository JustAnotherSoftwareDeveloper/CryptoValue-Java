package com.michaelsila.bitcoin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author michael sila
 * Writes values of crypto currency to CSV 
 */
public class CryptoValueWriter {
	private final String filename;
	private final String workingDirectory;
	private final CurrencyEntry currencyEntry;
	/**
	 * Default Constructor 
	 * @param currencyEntry the currency entry
	 * @param working Directory the directory the file is in
	 * @param filename the filename
	 */
	public CryptoValueWriter(CurrencyEntry currencyEntry,String workingDirectory,String filename) {
		this.filename=filename;
		this.workingDirectory=workingDirectory;
		this.currencyEntry=currencyEntry;
	}
	/**
	 * Specify filename, working directory defaults to user.home 
	 * @param currencyEntry the btc and eth values and timestamp
	 * @param filename the filename
	 */
	public CryptoValueWriter(CurrencyEntry currencyEntry, String filename) {
		this.filename=filename;
		this.workingDirectory=System.getProperty("user.home");
		this.currencyEntry=currencyEntry;
	}
	
	public CryptoValueWriter(CurrencyEntry currencyEntry ) {
		this.filename="cryptoValues.csv";
		this.workingDirectory=System.getProperty("user.home");
		this.currencyEntry=currencyEntry;
	}
	/**
	 * Writes an entry in the CSV. creates CSV if not available 
	 */
	public void writeEntry() {
		Path filePath=Paths.get(workingDirectory, filename);
		File toWrite=new File(filePath.toString());
		//Create CSV. Might make own method later
		if (!toWrite.exists()) {
			try {
				toWrite.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter initWrite=null;
			try {
				initWrite=new PrintWriter(toWrite.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			initWrite.println("Date/Time,BTC Value,ETH Value");
			initWrite.close();
		}
		//Write Entry
		PrintWriter entryWrite=null;
		try {
			entryWrite=new PrintWriter(new FileOutputStream(toWrite,true));
			//Build CSV Line
			StringBuilder currencyData=new StringBuilder();
			currencyData.append(this.currencyEntry.getEntryTime().toString());
			currencyData.append(",");
			currencyData.append(this.currencyEntry.getBTC());
			currencyData.append(",");
			currencyData.append(this.currencyEntry.getETH());
			//Write
			entryWrite.println(currencyData.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (entryWrite!=null) {
				entryWrite.close();
			}
		}
	}
	
}
