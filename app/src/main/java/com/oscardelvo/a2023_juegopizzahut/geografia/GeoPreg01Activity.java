package com.oscardelvo.a2023_juegopizzahut.geografia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.oscardelvo.a2023_juegopizzahut.MainActivity;
import com.oscardelvo.a2023_juegopizzahut.R;

public class GeoPreg01Activity extends Activity {
    Button btnPregunta01Opc01Geo, btnPregunta01Opc02Geo, btnPregunta01Opc03Geo,btnPregunta01Opc04Geo;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_preg01);

        pregunta01();
        btnPregunta01Opc01Geo.setEnabled(true);
        btnPregunta01Opc02Geo.setEnabled(true);
        btnPregunta01Opc03Geo.setEnabled(true);
        btnPregunta01Opc04Geo.setEnabled(true);
    }

    public void pregunta01() {

        btnPregunta01Opc01Geo = findViewById(R.id.btnPregunta01Opc01Geo);
        btnPregunta01Opc02Geo = findViewById(R.id.btnPregunta01Opc02Geo);
        btnPregunta01Opc03Geo = findViewById(R.id.btnPregunta01Opc03Geo);
        btnPregunta01Opc04Geo = findViewById(R.id.btnPregunta01Opc04Geo);

        btnPregunta01Opc01Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                perder();
                btnPregunta01Opc01Geo.setEnabled(false);
                btnPregunta01Opc02Geo.setEnabled(false);
                btnPregunta01Opc03Geo.setEnabled(false);
                btnPregunta01Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta01Opc02Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganar();
                btnPregunta01Opc01Geo.setEnabled(false);
                btnPregunta01Opc02Geo.setEnabled(false);
                btnPregunta01Opc03Geo.setEnabled(false);
                btnPregunta01Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta01Opc03Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc01Geo.setEnabled(false);
                btnPregunta01Opc02Geo.setEnabled(false);
                btnPregunta01Opc03Geo.setEnabled(false);
                btnPregunta01Opc04Geo.setEnabled(false);
            }
        });

        btnPregunta01Opc04Geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perder();
                btnPregunta01Opc01Geo.setEnabled(false);
                btnPregunta01Opc02Geo.setEnabled(false);
                btnPregunta01Opc03Geo.setEnabled(false);
                btnPregunta01Opc04Geo.setEnabled(false);
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
        btn_video1 = new Intent(GeoPreg01Activity.this, MainActivity.class);
       /* btn_video1.putExtra("CategoriaRuleta", "Eco-nstrucción");
        btn_video1.putExtra("Puntaje", puntaje);
        btn_video1.putExtra("ControlPreguntas", control);
        btn_video1.putExtra("ListaPreguntas", listaPreguntaEco);
        btn_video1.putExtra("Respuesta", respuesta);*/
        startActivity(btn_video1);
        finish();

    }
}