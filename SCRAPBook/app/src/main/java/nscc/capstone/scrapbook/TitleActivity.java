package nscc.capstone.scrapbook;

/* Project SCRAPBook:
 * Nova Scotia Community College (2021) student project for INFT-3000 Capstone course.
 *
 * MIT License Copyright 2021
 *
 * Contributors:
 * Adam Hemeon
 * Brady Getson
 * Craysyn Trottier
 * Jayden Morehouse
 * Kieran London
 *
 * */
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

/**
 * Main Activity provides the app starting page.
 *
 *
 */
public class TitleActivity extends AppCompatActivity {

    // Controls
    ImageView imageViewTitle;
    Button btnPlayVsAI, btnPlayOnline, btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme); // sets the theme back to the app theme from the splashTheme
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        // Controls
        imageViewTitle = findViewById(R.id.imageViewTitle);

        btnPlayVsAI = findViewById(R.id.btnPlayVsAI);
        btnPlayOnline = findViewById(R.id.btnPlayOnline);
        btnSettings = findViewById(R.id.btnSettings);

        // Listeners
        btnPlayVsAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TitleActivity.this, PhotoActivity.class); // Goto Photo Activity
                startActivityForResult(i,1);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TitleActivity.this, SettingsActivity.class); // Goto Settings Activity
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