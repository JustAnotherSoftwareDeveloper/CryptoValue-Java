package com.michaelsila.bitcoin;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       //Make Post Request 
    	Double btcValue=0.0;
    	Double ethValue=0.0;
    	try {
    		btcValue=PriceRequest.requestPrice("btc");
    		ethValue=PriceRequest.requestPrice("eth");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	CurrencyEntry currencyEntry=new CurrencyEntry(btcValue,ethValue);
    	CryptoValueWriter cryptoValueWriter=new CryptoValueWriter(currencyEntry);
    	cryptoValueWriter.writeEntry();
    }
}
