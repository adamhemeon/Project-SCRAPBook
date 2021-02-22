package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class PhotoActivity extends AppCompatActivity {

    // Controls
    TextView textViewSelectionHeader, textViewNumPhotos;
    Button btnCamera, btnGallery, btnStart;
    ImageView imageViewPhoto1, imageViewPhoto2, imageViewPhoto3,
            imageViewPhoto4, imageViewPhoto5, imageViewPhoto6,
            imageViewPhoto7, imageViewPhoto8, imageViewPhoto9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // Controls
        textViewSelectionHeader = findViewById(R.id.textViewSelectionHeader);
        textViewNumPhotos = findViewById(R.id.textViewNumPhotos);
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        btnStart = findViewById(R.id.btnStart);

        imageViewPhoto1 = findViewById(R.id.imageViewPhoto1);
        imageViewPhoto2 = findViewById(R.id.imageViewPhoto2);
        imageViewPhoto3 = findViewById(R.id.imageViewPhoto3);
        imageViewPhoto4 = findViewById(R.id.imageViewPhoto4);
        imageViewPhoto5 = findViewById(R.id.imageViewPhoto5);
        imageViewPhoto6 = findViewById(R.id.imageViewPhoto6);
        imageViewPhoto7 = findViewById(R.id.imageViewPhoto7);
        imageViewPhoto8 = findViewById(R.id.imageViewPhoto8);
        imageViewPhoto9 = findViewById(R.id.imageViewPhoto9);

        // Listeners
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PhotoActivity.this, BattleActivity.class); // Goto Battle Activity
                // TODO: Pack Bundle - send to Intent
//                Bundle extras = new Bundle();
//                extras.putString("NAME",textViewName); // Example: Bundle a name
//                i.putExtras(extras); // Put bundle in the intent
                startActivityForResult(i, 1);
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
