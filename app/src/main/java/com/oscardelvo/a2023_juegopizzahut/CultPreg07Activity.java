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

public class CultPreg07Activity extends Activity {
    Button btnPregunta07Opc01Cult, btnPregunta07Opc02Cult, btnPregunta07Opc03Cult,btnPregunta07Opc04Cult;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cult_preg07);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta07Opc01Cult.setEnabled(true);
        btnPregunta07Opc02Cult.setEnabled(true);
        btnPregunta07Opc03Cult.setEnabled(true);
        btnPregunta07Opc04Cult.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta07Opc01Cult = findViewById(R.id.btnPregunta07Opc01Cul);
        btnPregunta07Opc02Cult = findViewById(R.id.btnPregunta07Opc02Cul);
        btnPregunta07Opc03Cult = findViewById(R.id.btnPregunta07Opc03Cul);
        btnPregunta07Opc04Cult = findViewById(R.id.btnPregunta07Opc04Cul);

        btnPregunta07Opc01Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta07Opc01Cult.setEnabled(false);
                btnPregunta07Opc02Cult.setEnabled(false);
                btnPregunta07Opc03Cult.setEnabled(false);
                btnPregunta07Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta07Opc02Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta07Opc01Cult.setEnabled(false);
                btnPregunta07Opc02Cult.setEnabled(false);
                btnPregunta07Opc03Cult.setEnabled(false);
                btnPregunta07Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta07Opc03Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta07Opc01Cult.setEnabled(false);
                btnPregunta07Opc02Cult.setEnabled(false);
                btnPregunta07Opc03Cult.setEnabled(false);
                btnPregunta07Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta07Opc04Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta07Opc01Cult.setEnabled(false);
                btnPregunta07Opc02Cult.setEnabled(false);
                btnPregunta07Opc03Cult.setEnabled(false);
                btnPregunta07Opc04Cult.setEnabled(false);
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
        btn_video1 = new Intent(CultPreg07Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}