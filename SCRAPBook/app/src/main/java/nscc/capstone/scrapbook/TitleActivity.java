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
    int CAMERA_CODE = 3;

    int CAMERA_PERMISSION_CODE = 100;
    int STORAGE_PERMISSION_CODE = 101;

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
        btnSettings = findViewById(R.id.btnSettings);

        checkPermission(Manifest.permission.CAMERA,
                CAMERA_CODE);

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

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(this, "Permission granted",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // Function referenced from: https://www.geeksforgeeks.org/android-how-to-request-permissions-in-android-application/
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this,  "Camera Permission Granted",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Camera Permission Denied",
                        Toast.LENGTH_SHORT).show();

            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage Permission Granted",
                        Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Storage Permission Denied",
                        Toast.LENGTH_SHORT).show();

            }
        }
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