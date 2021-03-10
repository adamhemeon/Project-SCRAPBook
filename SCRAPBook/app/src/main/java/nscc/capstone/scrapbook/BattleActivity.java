package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleActivity extends AppCompatActivity {

    // Controls
    TextView textViewPlayerWins, textViewComputerWins, textViewBattleVS;
    ImageView imageViewPlayerPhoto, imageViewComputerPhoto;
    Button btnTempGoToScore;

    // AI Images
    Random random = new Random();
    ArrayList<String> aiImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        // Controls
        textViewPlayerWins = findViewById(R.id.textViewPlayerWins);
        textViewComputerWins = findViewById(R.id.textViewComputerWins);
        textViewBattleVS = findViewById(R.id.textViewBattleVS);

        imageViewPlayerPhoto = findViewById(R.id.imageViewPlayerPhoto);
        imageViewComputerPhoto = findViewById(R.id.imageViewComputerPhoto);

        //Added the photos by code, was having issues doing it by GUI.
        //imageViewPlayerPhoto.setImageResource(R.drawable.beach);
        imageViewPlayerPhoto.setAdjustViewBounds(true);
        imageViewPlayerPhoto.setMaxWidth(400);
        imageViewPlayerPhoto.setMaxHeight(400);
        //imageViewComputerPhoto.setImageResource(R.drawable.ballons);
        imageViewComputerPhoto.setAdjustViewBounds(true);
        imageViewComputerPhoto.setMaxHeight(400);
        imageViewComputerPhoto.setMaxWidth(400);

        ColorChooser colorChooser = new ColorChooser();
        int playerColorResult = colorChooser.DetermineColor(imageViewPlayerPhoto,this);
        int computerColorResult = colorChooser.DetermineColor(imageViewComputerPhoto,this);

        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        int versusResult = rockPaperScissors.DetermineWinner(playerColorResult,computerColorResult);


        btnTempGoToScore = findViewById(R.id.btnTempGoToScore);

        // Listeners
        btnTempGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BattleActivity.this, ScoreActivity.class); // Goto Score Activity
                startActivityForResult(i, 1);
            }
        });

        // Randomly get 10 photo names
        for (int i = 0; i < 10; i++){
            aiImages.add("img_" + random.nextInt(49));
        }

        // Set the AI image from the aiImages string titles
        imageViewComputerPhoto.setAdjustViewBounds(true);
        imageViewComputerPhoto.setMaxWidth(400);
        imageViewComputerPhoto.setMaxHeight(400);
        imageViewComputerPhoto.setImageResource(getResources().getIdentifier(aiImages.get(0), "drawable", getApplicationContext().getApplicationInfo().packageName));

        // Player image
        if(getIntent().hasExtra("Image")){
            // Get the byte array and convert it back into a bitmap
            Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("Image"),0,getIntent().getByteArrayExtra("Image").length);
            imageViewPlayerPhoto.setImageBitmap(bitmap);
        }


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
