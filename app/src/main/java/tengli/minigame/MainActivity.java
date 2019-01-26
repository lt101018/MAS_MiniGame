package tengli.minigame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int currentPlayer = 0;
    boolean gameIsActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    public void moveChess(View view){
        ImageView curGrid = (ImageView) view;
        int gridCounter = Integer.parseInt(curGrid.getTag().toString());
        if(gameState[gridCounter] == 2 && gameIsActive) {
            gameState[gridCounter] = currentPlayer;
            if (currentPlayer == 0) {
                curGrid.setTranslationY(-1000f);
                curGrid.setImageResource(R.drawable.lt);
                currentPlayer = 1;
                curGrid.animate().translationYBy(1000f).rotation(360).setDuration(1000);
            } else {
                curGrid.setTranslationY(1000f);
                curGrid.setImageResource(R.drawable.ly);
                currentPlayer = 0;
                curGrid.animate().translationYBy(-1000f).rotation(360).setDuration(1000);
            }
        }
        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {
                gameIsActive = false;
                String winner = "Player 1";
                if (gameState[winningPosition[0]] == 0) {
                    winner = "Player 2";
                }
                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText(winner + " has won!");
                LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                layout.setVisibility(View.VISIBLE);
            } else {
                boolean gameIsOver = true;
                for (int counterState : gameState) {
                    if (counterState == 2) gameIsOver = false;
                }
                if (gameIsOver) {
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText("Draw!");
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void playAgain(View view) {
        gameIsActive = true;
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        currentPlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
