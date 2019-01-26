package tengli.minigame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int currentPlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    public void moveChess(View view){
        ImageView curGrid = (ImageView) view;
        int gridCounter = Integer.parseInt(curGrid.getTag().toString());
        if(gameState[gridCounter] == 2) {
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
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
