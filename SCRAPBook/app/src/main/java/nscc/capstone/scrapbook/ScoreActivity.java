package nscc.capstone.scrapbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends Activity {

    // Controls
    TextView textViewScore, textViewWinner;
    Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        // Controls
        textViewScore = findViewById(R.id.textViewScore);
        textViewWinner = findViewById(R.id.textViewWinner);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);

        // Listeners
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent("TitleActivity"); // Goto Quiz Activity
                startActivityForResult(i, 1);
            }
        });
    }//end onCreate
}
