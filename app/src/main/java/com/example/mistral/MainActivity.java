package com.example.mistral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView login;

    EditText user_edit, pass_edit;

    Button POST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.Login);
        user_edit = findViewById(R.id.username);
        pass_edit = findViewById(R.id.password);
        POST = findViewById(R.id.button);

        POST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_edit.getText().toString();
                String pass = pass_edit.getText().toString();
                try {
                    postDataUsingVolley(user, pass);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            private void postDataUsingVolley(final String username, final String password) throws JSONException {
//                String url = "http://192.168.56.1:80/dummy/sqlite.php";
//                String url = "http://localhost:80/dummy/sqlite.php";
                  String url="http://192.168.56.1:80/EM.php";
//                final JSONObject jsonBody = new JSONObject("{\"name\":\"username\",\"password\":\"password\"}");
                final JSONObject jsonBody = new JSONObject();
                jsonBody.put("username", username);
                jsonBody.put("password", password);

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest json = new JsonObjectRequest(Request.Method.POST,url, jsonBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                            int c = response.getInt("result");
                        try {
                            int c=response.getInt("result");
                            if (c==1) {
                                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,window1.class));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
//                        String resp=response.toString();
//                            Toast.makeText(MainActivity.this, "you"+response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Login failed" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("name", username);
                        params.put("password", password);
                        return params;
                    }
                };
                queue.add(json);
            }
        });
    }
}

//                @Override
//                    public void onResponse(String response) {
//                        int c=Integer.getInteger(response);
//
//                        if (response.equals("1")) {
//                            Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Login failed" + error.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                }) {
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> params = new HashMap<>();
//                        params.put("name", username);
//                        params.put("password", password);
//                        return super.getParams();
//                    }

//                };
//                queue.add(JSONObject);
//            };
//    }
//}