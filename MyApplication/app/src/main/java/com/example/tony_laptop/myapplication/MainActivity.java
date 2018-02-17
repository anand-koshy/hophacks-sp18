package com.example.tony_laptop.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String client_id = "7ac0f7aa647548e399cf74b3abad75ce";
        final String client_secret = "e0754f32dcec47aca665da75c4711431";
        final String endpoint = "http://api.thenounproject.com/icons/";

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText searchBar = (EditText) findViewById(R.id.search_edit_text);
                final String search = searchBar.getText().toString();

                if (search == "") {
                    return;
                }

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OAuthService service = new ServiceBuilder()
                                .provider(NounProjAPI.class)
                                .apiKey(client_id)
                                .apiSecret(client_secret)
                                .build();
                        OAuthRequest req = new OAuthRequest(Verb.GET, endpoint + search);
                        Token accessToken = new Token("", "");
                        service.signRequest(accessToken, req);

                        Response response = req.send();
                        Log.d("OAuthTask", response.getBody());
                        try {
                            JSONObject jObj = new JSONObject(response.getBody());
                            JSONArray icons =  (JSONArray) jObj.get("icons");
                            for (int i = 0; i < icons.length(); i++) {
                                JSONObject jIcon = (JSONObject) icons.get(i);
                                Log.d("JSONPARSE", (String) jIcon.get("preview_url"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();
            }
        });


        //GridView gridview = (GridView) findViewById(R.id.gridview);
    }
}
