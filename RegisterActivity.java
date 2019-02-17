package e.user.registeration;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private Object usercompany;
    private Object userID;
    private Object useremail;
    private Object username;
    private Object userpassword;
    private Object userphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText companyText = (EditText) findViewById(R.id.companyText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText phoneText = (EditText) findViewById(R.id.phoneText);

        Button registerButton = ( Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = idText.getText().toString();
                String userpassword = passwordText.getText().toString();
                String usercompany = companyText.getText().toString();
                String useremail = emailText.getText().toString();
                String username = nameText.getText().toString();
                int userphone = Integer.parseInt(phoneText.getText().toString());
            }
        });

        Response.Listener<String> responseListener = new Response.Listener<String>(){
                   @Override
                    public void onResponse(String response){
                     try {
                         JSONObject jsonResponse = new JSONObject(response);
                         boolean success = jsonResponse.getBoolean("success");
                         if (success) {
                             AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                             builder.setMessage("회원 등록에 성공 하였습니다.")
                                     .setPositiveButton("확인", null)
                                     .create()
                                     .show();
                             Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                             RegisterActivity.this.startActivity(intent);
                         }
                         else
                         {
                             AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                             builder.setMessage("회원 등록에 실패 하였습니다.")
                                     .setNegativeButton("다시 시도", null)
                                     .create()
                                     .show();

                       }
                   }

                   catch (JSONException e)
                   {
                       e.printStackTrace();
                   }

                   }
                };
        RegisterRequest registerRequest = new RegisterRequest(userID, usercompany, useremail, username, userpassword, userphone, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        queue.add(registerRequest);

    }
        });

    }
}
