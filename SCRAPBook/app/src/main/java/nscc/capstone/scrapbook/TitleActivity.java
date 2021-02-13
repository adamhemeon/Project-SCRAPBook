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

    // Variables
    String userName;

    // Controls
    TextView titleTextView, nameLabelTextView;
    EditText nameEditText;
    Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        // Controls
//        titleTextView = findViewById(R.id.titleTextView);
//        nameLabelTextView  = findViewById(R.id.nameLabelTextView);
//        nameEditText = findViewById(R.id.nameEditText);
//        btnStart = findViewById(R.id.btnStart);

        // Listeners
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Get the user-entered name
//                userName = nameEditText.getText().toString();
//
//                // Validate name is not empty
//                if (!userName.isEmpty()) {
//                    Intent i = new Intent("QuizActivity"); // Goto Quiz Activity
//                    Bundle extras = new Bundle();
//                    extras.putString("NAME",userName); // Bundle the user-entered name
//                    i.putExtras(extras); // Put bundle in the intent
//                    startActivityForResult(i,1);
//                } else {
//                    Toast.makeText(TitleActivity.this,"Name cannot be empty",
//                            Toast.LENGTH_SHORT).show(); // Validate
//                }
//            }
//        });
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