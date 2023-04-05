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

public class CultPreg010Activity extends Activity {
    Button btnPregunta01Opc010Cult, btnPregunta010Opc02Cult, btnPregunta010Opc03Cult,btnPregunta010Opc04Cult;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cult_preg010);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta01Opc010Cult.setEnabled(true);
        btnPregunta010Opc02Cult.setEnabled(true);
        btnPregunta010Opc03Cult.setEnabled(true);
        btnPregunta010Opc04Cult.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta01Opc010Cult = findViewById(R.id.btnPregunta01Opc01Cul);
        btnPregunta010Opc02Cult = findViewById(R.id.btnPregunta010Opc02Cul);
        btnPregunta010Opc03Cult = findViewById(R.id.btnPregunta010Opc03Cul);
        btnPregunta010Opc04Cult = findViewById(R.id.btnPregunta010Opc04Cul);

        btnPregunta01Opc010Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta01Opc010Cult.setEnabled(false);
                btnPregunta010Opc02Cult.setEnabled(false);
                btnPregunta010Opc03Cult.setEnabled(false);
                btnPregunta010Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta010Opc02Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta01Opc010Cult.setEnabled(false);
                btnPregunta010Opc02Cult.setEnabled(false);
                btnPregunta010Opc03Cult.setEnabled(false);
                btnPregunta010Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta010Opc03Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc010Cult.setEnabled(false);
                btnPregunta010Opc02Cult.setEnabled(false);
                btnPregunta010Opc03Cult.setEnabled(false);
                btnPregunta010Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta010Opc04Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc010Cult.setEnabled(false);
                btnPregunta010Opc02Cult.setEnabled(false);
                btnPregunta010Opc03Cult.setEnabled(false);
                btnPregunta010Opc04Cult.setEnabled(false);
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
        btn_video1 = new Intent(CultPreg010Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}