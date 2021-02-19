package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive =true;
    //player representation
    //0-x
    //1-0
    int activePlayer =0;
    int[] gameState ={2,2,2,2,2,2,2,2,2};
    //State meaning
    // 0- X
    // 1-0
    //2-null

    int[][] winPostions={{0,1,2},{3,4,5},{6,7,8},
                         {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img =(ImageView) view;
     int tappedImage = Integer.parseInt(img.getTag().toString());//we get 0,1,2,3
        if (!gameActive){
            gameReset(view);

        }
        if (gameState[tappedImage]==2)//if game state is empty
        {     //if gmaestate is empty put active player 0 or x
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xx);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn-Tap to play");
            } else {
                img.setImageResource(R.drawable.zero);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn-Tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player has won
        for (int[] winPostion: winPostions){

           if ( gameState[winPostion[0]]==gameState[winPostion[1]] &&
                 gameState[winPostion[1]]==gameState[winPostion[2]] &&
           gameState[winPostion[0]]!=2){
               String winnerstr;
               gameActive =false;
               //sombedy hash won the game
               if (gameState[winPostion[0]]==0){
                   winnerstr ="X has Won";
               }else{
                   winnerstr="O' has won";
               }
               //Update the status bar for winner announcement
               TextView status = findViewById(R.id.status);
               status.setText(winnerstr);

           }
        }

    }



public void gameReset(View view){
        gameActive =true;
        activePlayer =0;
        for (int i =0;i<gameState.length;i++){
            gameState[i]=2;
        }
    ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}