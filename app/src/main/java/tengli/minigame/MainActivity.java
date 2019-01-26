package tengli.minigame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void moveChess(View view){
        ImageView curGrid = (ImageView) view;
        curGrid.setTranslationY(-1000f);
        curGrid.setImageResource(R.drawable.lt);
        curGrid.animate().translationYBy(1000f).rotation(360).setDuration(1000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
