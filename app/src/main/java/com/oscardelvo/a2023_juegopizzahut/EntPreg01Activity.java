package com.oscardelvo.a2023_juegopizzahut;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.oscardelvo.a2023_juegopizzahut.R;

public class EntPreg01Activity extends Activity {
    Button btnPregunta01Opc01Ent, btnPregunta01Opc02Ent, btnPregunta01Opc03Ent,btnPregunta01Opc04Ent;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ent_preg01);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta01Opc01Ent.setEnabled(true);
        btnPregunta01Opc02Ent.setEnabled(true);
        btnPregunta01Opc03Ent.setEnabled(true);
        btnPregunta01Opc04Ent.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta01Opc01Ent = findViewById(R.id.btnPregunta01Opc01Ent);
        btnPregunta01Opc02Ent = findViewById(R.id.btnPregunta01Opc02Ent);
        btnPregunta01Opc03Ent = findViewById(R.id.btnPregunta01Opc03Ent);
        btnPregunta01Opc04Ent = findViewById(R.id.btnPregunta01Opc04Ent);

        btnPregunta01Opc01Ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta01Opc01Ent.setEnabled(false);
                btnPregunta01Opc02Ent.setEnabled(false);
                btnPregunta01Opc03Ent.setEnabled(false);
                btnPregunta01Opc04Ent.setEnabled(false);
            }
        });

        btnPregunta01Opc02Ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta01Opc01Ent.setEnabled(false);
                btnPregunta01Opc02Ent.setEnabled(false);
                btnPregunta01Opc03Ent.setEnabled(false);
                btnPregunta01Opc04Ent.setEnabled(false);
            }
        });

        btnPregunta01Opc03Ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc01Ent.setEnabled(false);
                btnPregunta01Opc02Ent.setEnabled(false);
                btnPregunta01Opc03Ent.setEnabled(false);
                btnPregunta01Opc04Ent.setEnabled(false);
            }
        });

        btnPregunta01Opc04Ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc01Ent.setEnabled(false);
                btnPregunta01Opc02Ent.setEnabled(false);
                btnPregunta01Opc03Ent.setEnabled(false);
                btnPregunta01Opc04Ent.setEnabled(false);
            }
        });

    }

    public void ganar() {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.ganopregunta);
        mp.start();
      /*  controlPreguntas = 1;
        cc.setTotalizarControl(controlPreguntas);

        puntajePreg = 1;
        cp.setTotalizarPuntaje(puntajePreg);*/

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
              /*  laRespuestaEs = "SI";
                puntajeEco = cp.getTotalizarPuntaje();
                controlPreguntasEco = cc.getTotalizarControl();*/
                pasarPregunta();
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                }
            }
        };
        handler.postDelayed(runnable, 2000);

    }

    public void perder() {

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.perdiopregunta);
        mp.start();
      /*  controlPreguntas = 1;
        cc.setTotalizarControl(controlPreguntas);
*/
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
              /*  laRespuestaEs = "NO";
                puntajeEco = cp.getTotalizarPuntaje();
                controlPreguntasEco = cc.getTotalizarControl();*/
                pasarPregunta();
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                }
            }
        };
        handler.postDelayed(runnable, 2000);


    }
    public void pasarPregunta() {
        Intent btn_video1;

     /*   Log.d("puntaje2", puntaje + "");
        Log.d("control2", control + "");*/
        btn_video1 = new Intent(EntPreg01Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}