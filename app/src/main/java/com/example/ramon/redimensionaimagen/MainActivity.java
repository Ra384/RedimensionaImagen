package com.example.ramon.redimensionaimagen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    SeekBar seekBar;
    TextView txtLimite;
    private int iWidth = 65;
    private int iHeight = 52;
    float density;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;
        imagen =  findViewById(R.id.imageView);
        seekBar =  findViewById(R.id.seekBar);
        txtLimite =  findViewById(R.id.txtLimite);

        //Evento Redimensionar pantalla
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float ancho = (progress + iWidth) * density / 160;
                float alto = (progress + iHeight) * density / 160;
                imagen.getLayoutParams().height = (int)alto;
                imagen.getLayoutParams().width = (int)ancho;
                imagen.requestLayout();


                if(progress==100){
                    txtLimite.setText("Llegó al limite");
                }else if(progress!=100){
                    txtLimite.setText("En progreso: "+progress+" %");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
