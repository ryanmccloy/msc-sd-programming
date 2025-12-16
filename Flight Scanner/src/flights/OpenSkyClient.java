/**
 * Ryan McCloy
 */
package flights;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 
 */
public class OpenSkyClient {

	// 1. Creating the Client once
	private static final HttpClient client = HttpClient.newHttpClient();

	/**
	 * method sends an API request to OpenSky to query flights via a specific range calculated by given latitude and longitude
	 * @param lat
	 * @param lon
	 * @return
	 */
	public static String getLiveFlights(double lat, double lon) {
		// Step 1: Get the URL
		String url = buildURL(lat, lon);

		// Step 2: Create the Request
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

		// Step 3: Send it
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
			return response.body();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * method builds and returns the url to be used to the OpenSky API call
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public static String buildURL(double latitude, double longitude) {

		// coordinates for box
		Double lamin = latitude - 0.5;
		Double lamax = latitude + 0.5;
		Double lomin = longitude - 0.5;
		Double lomax = longitude + 0.5;

		// API call string
		String url = "https://opensky-network.org/api/states/all?lamin=" + lamin + "&lomin=" + lomin + "&lamax=" + lamax
				+ "&lomax=" + lomax;

		return url;
	}

}
