package com.michaelsila.bitcoin;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * 
 * @author michael sila Class where I'll make a post request and extract the
 *         value
 */
public class PriceRequest {
	/**
	 * 
	 * Gets the price of a type of cryto currency
	 * @param currency The currency type you'll be returning 
	 * @return a Double Currency Value
	 * @throws IOException A Failure in gson to parse the json
	 */
	public static Double requestPrice(String currency) throws IOException {
		/*
		 * Note: I ripped half this stuff off https://github.com/square/okhttp/wiki/Recipes
		 */
		final OkHttpClient client = new OkHttpClient();
		final Gson gson = new Gson();

		Request request = new Request.Builder().url("https://coinmarketcap-nexuist.rhcloud.com/api/"+currency+"/price").build();
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			return -1.0; //Request Failed
		}
		//Using Gson libraries to extract usd value as double
		JsonObject jsonObject = new JsonParser().parse(response.body().string()).getAsJsonObject();
		return Double.valueOf(jsonObject.get("usd").getAsDouble()); //Return double representation of currency
	}

}
