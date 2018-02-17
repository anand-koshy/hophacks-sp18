import java.net.*;
import java.io.*;
public class NounProject {
  public static void main(String[] args) {
    String client_id = "7ac0f7aa647548e399cf74b3abad75ce";
    String client_secret = "e0754f32dcec47aca665da75c4711431";
    String endpoint = "http://api.thenounproject.com/icons/recent_uploads?limit=10&offset=0&page=1";

    try {
      URL url = new URL(endpoint);
      URLConnection conn = (HttpURLConnection) url.openConnection();
      System.out.println("TEST");
      conn.addRequestProperty("client_id", client_id);
      conn.addRequestProperty("client_secret", client_secret);
      //conn.setRequestProperty("Authorization", "Oauth " + token);

      InputStreamReader inStrm = new InputStreamReader(conn.getInputStream());
      BufferedReader in = new BufferedReader(inStrm);
      String inputLn;
      while ((inputLn = in.readLine()) != null) {
        System.out.println(inputLn);
      }

    } catch (IOException e) {
      System.err.println("Endpoint not found");

    }
  }

}
