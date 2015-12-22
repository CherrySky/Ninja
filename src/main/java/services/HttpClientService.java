package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import models.HttpResponse;

import org.eclipse.jetty.http.HttpStatus;

public class HttpClientService implements HttpService {

	private final String USER_AGENT = "Mozilla/5.0";

	public HttpResponse query(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		HttpResponse httpResponse = new HttpResponse();
		httpResponse.setResponseCode(responseCode);
		if (responseCode != HttpStatus.OK_200) {
			// red dashboard color
		} else {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer responseContent = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				inputPredicate(inputLine, responseContent);
				// response.append(inputLine);
			}
			in.close();
			httpResponse.setResponseContent(responseContent.toString());;
		}
		return httpResponse;
	}

	public void inputPredicate(String inputLine, StringBuffer responseContent) {
		responseContent.append(inputLine.trim());
	}

}
