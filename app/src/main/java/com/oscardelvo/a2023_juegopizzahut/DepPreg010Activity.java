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

public class DepPreg010Activity extends Activity {
    Button btnPregunta010Opc01Dep, btnPregunta010Opc02Dep, btnPregunta010Opc03Dep,btnPregunta010Opc04Dep;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dep_preg010);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta010Opc01Dep.setEnabled(true);
        btnPregunta010Opc02Dep.setEnabled(true);
        btnPregunta010Opc03Dep.setEnabled(true);
        btnPregunta010Opc04Dep.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta010Opc01Dep = findViewById(R.id.btnPregunta10Opc01Dep);
        btnPregunta010Opc02Dep = findViewById(R.id.btnPregunta10Opc02Dep);
        btnPregunta010Opc03Dep = findViewById(R.id.btnPregunta10Opc03Dep);
        btnPregunta010Opc04Dep = findViewById(R.id.btnPregunta10Opc04Dep);

        btnPregunta010Opc01Dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta010Opc01Dep.setEnabled(false);
                btnPregunta010Opc02Dep.setEnabled(false);
                btnPregunta010Opc03Dep.setEnabled(false);
                btnPregunta010Opc04Dep.setEnabled(false);
            }
        });

        btnPregunta010Opc02Dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta010Opc01Dep.setEnabled(false);
                btnPregunta010Opc02Dep.setEnabled(false);
                btnPregunta010Opc03Dep.setEnabled(false);
                btnPregunta010Opc04Dep.setEnabled(false);
            }
        });

        btnPregunta010Opc03Dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta010Opc01Dep.setEnabled(false);
                btnPregunta010Opc02Dep.setEnabled(false);
                btnPregunta010Opc03Dep.setEnabled(false);
                btnPregunta010Opc04Dep.setEnabled(false);
            }
        });

        btnPregunta010Opc04Dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta010Opc01Dep.setEnabled(false);
                btnPregunta010Opc02Dep.setEnabled(false);
                btnPregunta010Opc03Dep.setEnabled(false);
                btnPregunta010Opc04Dep.setEnabled(false);
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
        btn_video1 = new Intent(DepPreg010Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}