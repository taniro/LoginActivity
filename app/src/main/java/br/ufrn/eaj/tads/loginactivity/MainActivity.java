package br.ufrn.eaj.tads.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "prefs";

    boolean logado;
    String login;
    String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE );
        logado = settings.getBoolean("logado", false);
        login = settings.getString("login", "" );
        senha = settings.getString("senha", "");

        if (logado){
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        }

    }

    public void login (View v){

        EditText loginEt = (EditText) findViewById(R.id.email);
        EditText senhaEt = (EditText) findViewById(R.id.senha);
        
        if(loginEt.getText().toString().equals("taniro") && senhaEt.getText().toString().equals("123")){

            login = loginEt.getText().toString();
            senha = senhaEt.getText().toString();
            logado = true;

            salvaDados();
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        }else{
            Toast.makeText(this, "Dados incorretos!", Toast.LENGTH_SHORT).show();
        }

    }

    private void salvaDados() {

        Log.i("login", "Salvando preferencias...");

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("logado", logado);
        editor.putString("login",login);
        editor.putString("senha", senha);
        // Commit the edits!
        editor.commit();
    }
}
