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

public class CultPreg09Activity extends Activity {
    Button btnPregunta09Opc01Cult, btnPregunta09Opc02Cult, btnPregunta09Opc03Cult,btnPregunta09Opc04Cult;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cult_preg09);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta09Opc01Cult.setEnabled(true);
        btnPregunta09Opc02Cult.setEnabled(true);
        btnPregunta09Opc03Cult.setEnabled(true);
        btnPregunta09Opc04Cult.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta09Opc01Cult = findViewById(R.id.btnPregunta09Opc01Cul);
        btnPregunta09Opc02Cult = findViewById(R.id.btnPregunta09Opc02Cul);
        btnPregunta09Opc03Cult = findViewById(R.id.btnPregunta09Opc03Cul);
        btnPregunta09Opc04Cult = findViewById(R.id.btnPregunta09Opc04Cul);

        btnPregunta09Opc01Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta09Opc01Cult.setEnabled(false);
                btnPregunta09Opc02Cult.setEnabled(false);
                btnPregunta09Opc03Cult.setEnabled(false);
                btnPregunta09Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta09Opc02Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta09Opc01Cult.setEnabled(false);
                btnPregunta09Opc02Cult.setEnabled(false);
                btnPregunta09Opc03Cult.setEnabled(false);
                btnPregunta09Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta09Opc03Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta09Opc01Cult.setEnabled(false);
                btnPregunta09Opc02Cult.setEnabled(false);
                btnPregunta09Opc03Cult.setEnabled(false);
                btnPregunta09Opc04Cult.setEnabled(false);
            }
        });

        btnPregunta09Opc04Cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta09Opc01Cult.setEnabled(false);
                btnPregunta09Opc02Cult.setEnabled(false);
                btnPregunta09Opc03Cult.setEnabled(false);
                btnPregunta09Opc04Cult.setEnabled(false);
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
        btn_video1 = new Intent(CultPreg09Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}