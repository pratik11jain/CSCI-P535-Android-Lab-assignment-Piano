package com.iub.pervasivecomputing.piano;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int NO_OF_KEYS = 17;
    private static int[] finalMP = new int[NO_OF_KEYS];
    final MediaPlayer[] mp = new MediaPlayer[NO_OF_KEYS];
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        finalMP[0] = R.raw.a_1;
        finalMP[1] = R.raw.a_2;
        finalMP[2] = R.raw.a_3;
        finalMP[3] = R.raw.a_4;
        finalMP[4] = R.raw.a_5;
        finalMP[5] = R.raw.a_6;
        finalMP[6] = R.raw.a_7;
        finalMP[7] = R.raw.a_8;
        finalMP[8] = R.raw.a_9;
        finalMP[9] = R.raw.a_10;
        finalMP[10] = R.raw.a_11;
        finalMP[11] = R.raw.a_12;
        finalMP[12] = R.raw.a_13;
        finalMP[13] = R.raw.a_14;
        finalMP[14] = R.raw.a_15;
        finalMP[15] = R.raw.a_16;
        finalMP[16] = R.raw.a_17;

        for (int i = 0; i < NO_OF_KEYS; i++)
            mp[i] = MediaPlayer.create(this, finalMP[i]);

    }

    public void onClick(View v) {

        try {
            Button b = (Button) findViewById(v.getId());
            int id = b.getText().charAt(0) - 'a';

            if (mp[id].isPlaying()) {
                mp[id].stop();
                mp[id].release();
                mp[id] = MediaPlayer.create(context, finalMP[id]);
            }
            mp[id].start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
