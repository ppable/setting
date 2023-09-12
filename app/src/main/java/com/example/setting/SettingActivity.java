package com.example.setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {
    TextView textView;
    Button button_red, button_blue, button_green;
    ConstraintLayout layout;
    AudioManager maudioManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textView = findViewById(R.id.volume);
        SeekBar seekBar = findViewById(R.id.seekBar);
        maudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        button_red = findViewById(R.id.button_red);
        button_blue = findViewById(R.id.button_blue);
        button_green = findViewById(R.id.button_green);
        layout = findViewById(R.id.setting);

        button_red.setOnClickListener(ColorClick);
        button_blue.setOnClickListener(ColorClick);
        button_green.setOnClickListener(ColorClick);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress , boolean fromUser) {
                int maxvol = maudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                int volume = maxvol*progress/100;
                maudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,volume,AudioManager.FLAG_SHOW_UI);
                textView.setText(""+progress+"%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    View.OnClickListener ColorClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.button_red) {
                layout.setBackgroundColor(Color.rgb(255, 199, 234));
            } else if (id == R.id.button_blue) {
                layout.setBackgroundColor(Color.rgb(130, 160, 216));
            } else if (id == R.id.button_green) {
                layout.setBackgroundColor(Color.rgb(166, 255, 150));
            }
        }
    };
}