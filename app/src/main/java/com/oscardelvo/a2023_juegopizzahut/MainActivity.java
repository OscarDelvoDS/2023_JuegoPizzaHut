package com.oscardelvo.a2023_juegopizzahut;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    Button btnrclock;
    ImageView img, imgLuzA, imgLuzB, imgPremio;
    Handler handler, handler3;
    Runnable runnable, runnable3;
    CountDownTimer x;
    String numeroRandom, texto, textoGano, item;
    String strPreguntaSelec;
    TextView txtPremioTexto, txtGanasteTexto;
    RelativeLayout rlJuego;
    MediaPlayer mpJugar, mpR;
    List<String> premioCantidad = new ArrayList<>();
    List<String> premioNombre = new ArrayList<>();
    Random randomGenerator;
    String TAG = MainActivity.class.getName();

    String strCategoriaSelecc;
    int oliveGarden, johnnyRockets, universal, oldNavy;

    int contadorCategorias, controlMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            controlMain = (int) b.get("ControlPreguntas");
            contadorCategorias = controlMain;
            if (controlMain == 5){
                contadorCategorias = 0;
            }
        }


        Log.d("controlMain", controlMain+"");
        iniciarVariables();
        countdown();

        btnrclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mpJugar = MediaPlayer.create(getApplicationContext(),R.raw.game);
                mpJugar.start();

                randomGenerator = new Random();
                int tamano=10;

                int index = randomGenerator.nextInt(tamano-0)+0;
                int indexPregSelec = index+1;

                if (contadorCategorias == 0){
                    strCategoriaSelecc = "Geografia";
                    contadorCategorias++;
                }else if (contadorCategorias == 1){
                    strCategoriaSelecc = "Entretenimiento";
                    contadorCategorias++;
                }
                else if (contadorCategorias == 2){
                    strCategoriaSelecc = "PizzaHut";
                    contadorCategorias++;
                }
                else if (contadorCategorias == 3){
                    strCategoriaSelecc = "CulturaGeneral";
                    contadorCategorias++;
                }
                else if (contadorCategorias == 4){
                    strCategoriaSelecc = "Deportes";
                    contadorCategorias = 0;
                }

                Log.d("contador", contadorCategorias+"");
                    /*    perderSiempre();

                        ganarSiempre();*/


                txtGanasteTexto.setText("");
                txtPremioTexto.setText("");
                btnrclock.setEnabled(false);
                imgPremio.setVisibility(View.INVISIBLE);
                img.setImageResource(R.mipmap.ruleta_girar);
                Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotar);
                img.startAnimation(aniRotate);


                if (strCategoriaSelecc.equals("Geografia")){
                    imgPremio.setImageResource(R.mipmap.ruleta_premio01);
                    texto = "Geografía";
                    textoGano = "GANASTE";
                 //   strPreguntaSelec = "GeoPreg01Activity";
                  strPreguntaSelec = "GeoPreg0"+indexPregSelec+"Activity";
                }
            else if (strCategoriaSelecc.equals("Entretenimiento")){
                    imgPremio.setImageResource(R.mipmap.ruleta_premio09);
                    texto = "Entretenimiento";
                    textoGano = "GANASTE";
                    strPreguntaSelec = "EntPreg0"+indexPregSelec+"Activity";
                }
                else if (strCategoriaSelecc.equals("PizzaHut")){
                    imgPremio.setImageResource(R.mipmap.ruleta_premio03);
                    texto = "Pizza Hut";
                    textoGano = "GANASTE";
                    strPreguntaSelec = "PizPreg0"+indexPregSelec+"Activity";
                }
                else if (strCategoriaSelecc.equals("CulturaGeneral")){
                    imgPremio.setImageResource(R.mipmap.ruleta_premio05);
                    texto = "Cultura General";
                    textoGano = "GANASTE";
                    strPreguntaSelec = "CultPreg0"+indexPregSelec+"Activity";
                }
                else if (strCategoriaSelecc.equals("Deportes")){
                    imgPremio.setImageResource(R.mipmap.ruleta_premio07);
                    texto = "Deportes";
                    strPreguntaSelec = "DepPreg0"+indexPregSelec+"Activity";
                }
Log.d("Preguntas",strPreguntaSelec);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        mpJugar.stop();

                        mpR = MediaPlayer.create(getApplicationContext(),R.raw.gano);
                        mpR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mediaPlayer) {
                                mpR.start();
                            }
                        });

                        img.setVisibility(View.INVISIBLE);
                        imgPremio.setVisibility(View.VISIBLE);

                        handler3 = new Handler();
                        runnable3 = new Runnable() {
                            @Override
                            public void run() {
                                txtPremioTexto.setText(texto);
                                txtGanasteTexto.setText(textoGano);
                                btnrclock.setEnabled(true);

                                if(mpJugar.isPlaying()){
                                    mpJugar.stop();
                                    mpJugar.release();
                                }
                            }
                        };
                        handler3.postDelayed(runnable3,700);
                        Intent preg = null;
                        try {
                            preg = new Intent(MainActivity.this, Class.forName("com.oscardelvo.a2023_juegopizzahut."+strPreguntaSelec));
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        preg.putExtra("ControlPreguntas", contadorCategorias);
                        startActivity(preg);
                        //   finish();
                        if(mpR.isPlaying()){
                            mpR.stop();
                            mpR.release();
                        }

                    }
                };
                handler.postDelayed(runnable,6000);
            }
        });
    }
    public void iniciarVariables(){
        txtPremioTexto = findViewById(R.id.txtPremioTexto);
        txtGanasteTexto = findViewById(R.id.txtGanasteTexto);
        rlJuego = findViewById(R.id.rlJuego);
        btnrclock = findViewById(R.id.btnRClk);
        imgLuzA = findViewById(R.id.imgAnimA);
        imgLuzB = findViewById(R.id.imgAnimB);
        img = findViewById(R.id.imgvw);
        imgPremio= findViewById(R.id.imgPremio);
        imgPremio.setVisibility(View.INVISIBLE);
    }

    public void countdown(){
        if(x != null){
            x.cancel();
        }
        x = new CountDownTimer(400, 400) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if (imgLuzA.getVisibility()== View.VISIBLE){
                    imgLuzA.setVisibility(View.INVISIBLE);
                    imgLuzB.setVisibility(View.VISIBLE);
                }else if (imgLuzA.getVisibility()== View.INVISIBLE){
                    imgLuzA.setVisibility(View.VISIBLE);
                    imgLuzB.setVisibility(View.INVISIBLE);
                }
                x.start();
            }
        };
    }
}