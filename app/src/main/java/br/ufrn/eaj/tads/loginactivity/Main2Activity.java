package br.ufrn.eaj.tads.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String PREFS_NAME = "prefs";

    String login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE );
        login = settings.getString("login", "" );

        TextView nome = (TextView) findViewById(R.id.nome);
        nome.setText(login);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.ping);
        //mp.setLooping(true);
        mp.start();

    }

    /*Uma das maneiras de apagar os dados das preferencias é acessar o editor e remover chave pro chave
     */

    public void logout (View v){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putBoolean("logado", false);
        editor.putString("login","");
        editor.putString("senha", "");
        // Commit the edits!
        editor.commit();

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    /* Outra opção de apagar os dados das preferencias é invocar o método clear do editor. Todas as chaves
    serão pagadas.
     */

    public void logout2 (View v){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear(); // apaga todas as chaves
        editor.commit();

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
