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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.*;
import android.view.*;
import android.view.animation.*;
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
    Button btnPlayVsAI, btnPlayOnline, btnAbout;
    int CAMERA_CODE = 3;

    int CAMERA_PERMISSION_CODE = 100;
    int STORAGE_PERMISSION_CODE = 101;

    //Animations
    Animation scaleUp, scaleDown;

    boolean hasPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set the theme back to the app theme from the splashTheme
        setTheme(R.style.AppTheme); // must happen before super.onCreate() is called
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        // Controls
        imageViewTitle = findViewById(R.id.imageViewTitle);

        btnPlayVsAI = findViewById(R.id.btnPlayVsAI);
        btnPlayOnline = findViewById(R.id.btnPlayOnline);
        btnAbout = findViewById(R.id.btnAbout);

        // Animations
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        checkPermission(Manifest.permission.CAMERA,
                CAMERA_CODE);

        // Listeners
        btnPlayVsAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasPermission = checkPlayPermission(Manifest.permission.CAMERA,
                        CAMERA_CODE);

                // Play Animation
                btnPlayVsAI.startAnimation(scaleUp);
                btnPlayVsAI.startAnimation(scaleDown);

                // Go to Photo Activity
                if(hasPermission) {
                    Intent i = new Intent(TitleActivity.this, PhotoActivity.class); // Goto Photo Activity
                    startActivityForResult(i, 1);
                }
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Play Animation
                btnAbout.startAnimation(scaleUp);
                btnAbout.startAnimation(scaleDown);

                // Go to About Activity
                Intent i = new Intent(TitleActivity.this, AboutActivity.class); // Goto About Activity
                startActivityForResult(i,1);
            }
        });
    }//end onCreate

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this,
                    new String[] { permission },
                    requestCode);

        }
    }

    public boolean checkPlayPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_DENIED) {
            btnPlayVsAI.setEnabled(false);
            Toast.makeText(this, "Please accept the required permissions.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

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