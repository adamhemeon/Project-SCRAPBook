package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.content.*;

public class ScoreActivity extends AppCompatActivity {

    // Controls
    TextView textViewScore, textViewWinner;
    Button btnPlayAgain;

    // Animations
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Controls
        textViewScore = findViewById(R.id.textViewScore);
        textViewWinner = findViewById(R.id.textViewWinner);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);

        // Animations
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        //Getting the intent from the last Activity
        Intent intent = getIntent();

        //getting the scores from the intent
        int playerScore = intent.getIntExtra("playerScore",0);
        int computerScore = intent.getIntExtra("computerScore",0);

        String finalScore = playerScore + " - " + computerScore;
        textViewScore.setText(finalScore);

        if(playerScore > computerScore)
        {
            textViewWinner.setText(R.string.textViewYouWin);
        }
        else if(computerScore > playerScore)
        {
            textViewWinner.setText(R.string.textViewYouLose);
        }
        else
        {
            textViewWinner.setText(R.string.textViewYouTied);
        }

        // Listeners
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Do Animations
                btnPlayAgain.startAnimation(scaleUp);
                btnPlayAgain.startAnimation(scaleDown);

                // Return to Title Activity
                Intent i = new Intent(ScoreActivity.this, TitleActivity.class); // Goto Title Activity
                startActivityForResult(i,1);
            }
        });
    }//end onCreate

    /* ---- Stubs for Activity Lifestyle Code ---- */
    @Override
    protected void onStart(){
        super.onStart();

        // Put onStart code here

        // Test
        // Toast notification on start
        // Toast.makeText(TitleActivity.this,"On Start",Toast.LENGTH_SHORT).show();

    }//end onStart

    @Override
    protected void onResume(){
        super.onResume();

        // Put onResume code here

        // Test
        // Toast notification on resume
        // Toast.makeText(TitleActivity.this,"On Resume",Toast.LENGTH_SHORT).show();

    }//end onResume

    @Override
    protected void onPause(){
        super.onPause();

        // Put onPause code here

        // Test
        // Toast notification on pause
        // Toast.makeText(TitleActivity.this,"On Pause",Toast.LENGTH_SHORT).show();

    }//end onPause

    @Override
    protected void onRestart(){
        super.onRestart();

        // Put onRestart code here

        // Test
        // Toast notification on restart
        // Toast.makeText(TitleActivity.this,"On Restart",Toast.LENGTH_SHORT).show();

    }//end onRestart

    @Override
    protected void onStop(){
        super.onStop();

        // Put onStop code here

        // Test
        // Toast notification on stop
        // Toast.makeText(TitleActivity.this,"On Stop",Toast.LENGTH_SHORT).show();

    }//end onStop

    @Override
    protected void onDestroy(){
        super.onDestroy();

        // Put onDestroy code here

        // Test
        // Toast notification on destroy
        // Toast.makeText(TitleActivity.this,"On Destroy",Toast.LENGTH_SHORT).show();

    }//end onDestroy
}
