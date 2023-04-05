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

public class CultPreg03Activity extends Activity {
    Button btnPregunta03Opc01Cult, btnPregunta03Opc02Cult, btnPregunta03Opc03Cult,btnPregunta03Opc04Cult;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cult_preg03);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta03Opc01Cult.setEnabled(true);
        btnPregunta03Opc02Cult.setEnabled(true);
        btnPregunta03Opc03Cult.setEnabled(true);
        btnPregunta03Opc04Cult.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta03Opc01Cult = findViewById(R.id.btnPregunta03Opc01Cul);
        btnPregunta03Opc02Cult = findViewById(R.id.btnPregunta03Opc02Cul);
        btnPregunta03Opc03Cult = findViewById(R.id.btnPregunta03Opc03Cul);
        btnPregunta03Opc04Cult = findViewById(R.id.btnPregunta03Opc04Cul);

        btnPregunta03Opc01Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta03Opc01Cult.setEnabled(false);
                btnPregunta03Opc02Cult.setEnabled(false);
                btnPregunta03Opc03Cult.setEnabled(false);
                btnPregunta03Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta03Opc02Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta03Opc01Cult.setEnabled(false);
                btnPregunta03Opc02Cult.setEnabled(false);
                btnPregunta03Opc03Cult.setEnabled(false);
                btnPregunta03Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta03Opc03Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta03Opc01Cult.setEnabled(false);
                btnPregunta03Opc02Cult.setEnabled(false);
                btnPregunta03Opc03Cult.setEnabled(false);
                btnPregunta03Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta03Opc04Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta03Opc01Cult.setEnabled(false);
                btnPregunta03Opc02Cult.setEnabled(false);
                btnPregunta03Opc03Cult.setEnabled(false);
                btnPregunta03Opc04Cult.setEnabled(false);
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
        btn_video1 = new Intent(CultPreg03Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}