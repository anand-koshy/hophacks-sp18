import java.net.*;
import java.io.*;
import java.util.*;

public class WebApiTutorial {
  public static class Pair<K, V> {
    private K k;
    private V v;
    public Pair(K k, V v) {
      this.k = k;
      this.v = v;
    }
    public K getKey() {
      return this.k;
    }
    public V getValue() {
      return this.v;
    }
  }

  public static String buildURL(String url, List<Pair<String, String>> params) {
    StringBuilder fullURL = new StringBuilder(url + "?");
    for (Pair<String, String> entry : params) {
      fullURL.append(entry.getKey() + "=" + entry.getValue() + "&");
    }
    fullURL.deleteCharAt(fullURL.length()-1); //remove last &
    return fullURL.toString();

  }

  public static void main(String[] args) throws Exception {

    //COOPER HEWITT:
    String base = "https://api.collection.cooperhewitt.org/rest/";
    String token = "6512661135666f40ce1705d74f8270bc";
    String method = "cooperhewitt.departments.getList";

    //BUILD URL FROM PARAMETERS
    List<Pair<String, String>> params = new ArrayList<>();
    params.add(new Pair<String, String>("method", method));
    params.add(new Pair<String, String>("access_token", token));
    params.add(new Pair<String, String>("page", Integer.toString(1)));
    params.add(new Pair<String, String>("per_page", Integer.toString(100)));

    String url = buildURL(base, params);
    System.out.println(url);

    //CONNECT TO THE HTTP URL
    URL webApi = new URL(url);
    HttpURLConnection http = (HttpURLConnection) webApi.openConnection();

    //GET THE INPUT STREAM
    InputStreamReader inStrm = new InputStreamReader(http.getInputStream());
    BufferedReader in = new BufferedReader(inStrm);
    
    //PRINT OUTPUT
    String inputLn;
    while ((inputLn = in.readLine()) != null) {
      System.out.println(inputLn);
    }

    //CLOSE CONNECTION
    in.close();

    //To set to post
    //http.setRequestMethod("POST");
    //http.connect();
    //try {
    //  OutputStream os = http.getOutputSream()) {
    //  os.write(<Byte array>);
    //}
  }
}
