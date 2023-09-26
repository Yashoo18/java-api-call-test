import java.beans.BeanProperty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APICallExample {
    public int API(URL url){
        try {
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the HTTP request method (GET in this case)
            connection.setRequestMethod("GET");

            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response Data: " + response.substring(0, 200));

            // Close the connection
            connection.disconnect();
            return responseCode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}