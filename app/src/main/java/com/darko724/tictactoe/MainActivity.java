package com.darko724.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 - 0
    String winner;
    boolean gameactive = true;
    //1 - 1
    int activeplayer = 0;
    int [] array = {2,2,2,2,2,2,2,2,2};
    int [][] win = {{0,1,2,},{3,4,5},{6,7,8},{0,3,6},{2,5,8},{0,4,8},{2,4,6},{1,4,7}};
    public void Player_tap(View view)
    {   ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {gameReset(view);}
        if(array[tappedimage] == 2&& gameactive){
            array[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                TextView status = findViewById(R.id.Status);
                status.setText("O Turn Tap To Play");
            }
            else{img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.Status);
                status.setText("X Turn Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winpostion : win)
        {if(array[winpostion[0]] == array[winpostion[1]] && array[winpostion[1]] == array[winpostion[2]] && array[winpostion[2]] != 2)
            { gameactive = false;

                if(array[winpostion[0]] == 0)
                {  winner = "X is Winner";
                    TextView status = findViewById(R.id.Status);
                    status.setText(winner);
                }
                else { winner = "O is Winner";
                    TextView status = findViewById(R.id.Status);
                    status.setText(winner);}
            }}}
        public void gameReset(View view) {
            gameactive = true;
            activeplayer = 0;
            for (int i = 0; i <array.length; i++)
            {array[i] = 2;}
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            TextView Status = findViewById(R.id.Status);
            Status.setText("X Turn Tap To Play");}

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
