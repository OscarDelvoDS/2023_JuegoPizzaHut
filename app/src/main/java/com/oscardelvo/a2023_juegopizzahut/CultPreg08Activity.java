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

public class CultPreg08Activity extends Activity {
    Button btnPregunta08Opc01Cult, btnPregunta08Opc02Cult, btnPregunta08Opc03Cult,btnPregunta08Opc04Cult;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cult_preg08);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta08Opc01Cult.setEnabled(true);
        btnPregunta08Opc02Cult.setEnabled(true);
        btnPregunta08Opc03Cult.setEnabled(true);
        btnPregunta08Opc04Cult.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta08Opc01Cult = findViewById(R.id.btnPregunta08Opc01Cul);
        btnPregunta08Opc02Cult = findViewById(R.id.btnPregunta08Opc02Cul);
        btnPregunta08Opc03Cult = findViewById(R.id.btnPregunta08Opc03Cul);
        btnPregunta08Opc04Cult = findViewById(R.id.btnPregunta08Opc04Cul);

        btnPregunta08Opc01Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta08Opc01Cult.setEnabled(false);
                btnPregunta08Opc02Cult.setEnabled(false);
                btnPregunta08Opc03Cult.setEnabled(false);
                btnPregunta08Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta08Opc02Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta08Opc01Cult.setEnabled(false);
                btnPregunta08Opc02Cult.setEnabled(false);
                btnPregunta08Opc03Cult.setEnabled(false);
                btnPregunta08Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta08Opc03Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta08Opc01Cult.setEnabled(false);
                btnPregunta08Opc02Cult.setEnabled(false);
                btnPregunta08Opc03Cult.setEnabled(false);
                btnPregunta08Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta08Opc04Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta08Opc01Cult.setEnabled(false);
                btnPregunta08Opc02Cult.setEnabled(false);
                btnPregunta08Opc03Cult.setEnabled(false);
                btnPregunta08Opc04Cult.setEnabled(false);
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
        btn_video1 = new Intent(CultPreg08Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}