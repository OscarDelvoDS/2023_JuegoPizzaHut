package com.oscardelvo.a2023_juegopizzahut;

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

public class GeoPreg02Activity extends Activity {
    Button btnPregunta02Opc01Geo, btnPregunta02Opc02Geo, btnPregunta02Opc03Geo,btnPregunta02Opc04Geo;
    Handler handler;
    Runnable runnable;
    int control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_geo_preg02);
        control = getIntent().getExtras().getInt("ControlPreguntas");
        pregunta01();
        btnPregunta02Opc01Geo.setEnabled(true);
        btnPregunta02Opc02Geo.setEnabled(true);
        btnPregunta02Opc03Geo.setEnabled(true);
        btnPregunta02Opc04Geo.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta02Opc01Geo = findViewById(R.id.btnPregunta02Opc01Geo);
        btnPregunta02Opc02Geo = findViewById(R.id.btnPregunta02Opc02Geo);
        btnPregunta02Opc03Geo = findViewById(R.id.btnPregunta02Opc03Geo);
        btnPregunta02Opc04Geo = findViewById(R.id.btnPregunta02Opc04Geo);

        btnPregunta02Opc01Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta02Opc01Geo.setEnabled(false);
                btnPregunta02Opc02Geo.setEnabled(false);
                btnPregunta02Opc03Geo.setEnabled(false);
                btnPregunta02Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta02Opc02Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta02Opc01Geo.setEnabled(false);
                btnPregunta02Opc02Geo.setEnabled(false);
                btnPregunta02Opc03Geo.setEnabled(false);
                btnPregunta02Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta02Opc03Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta02Opc01Geo.setEnabled(false);
                btnPregunta02Opc02Geo.setEnabled(false);
                btnPregunta02Opc03Geo.setEnabled(false);
                btnPregunta02Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta02Opc04Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta02Opc01Geo.setEnabled(false);
                btnPregunta02Opc02Geo.setEnabled(false);
                btnPregunta02Opc03Geo.setEnabled(false);
                btnPregunta02Opc04Geo.setEnabled(false);
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
        btn_video1 = new Intent(GeoPreg02Activity.this, MainActivity.class);
        btn_video1.putExtra("ControlPreguntas", control);
        startActivity(btn_video1);
        finish();

    }
}