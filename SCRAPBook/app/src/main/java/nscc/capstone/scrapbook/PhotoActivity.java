package nscc.capstone.scrapbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends Activity {

    // Controls
    TextView textViewSelectionHeader, textViewNumPhotos;
    Button btnCamera, btnGallery, btnStart;
    ImageView imageViewPhoto1, imageViewPhoto2, imageViewPhoto3,
            imageViewPhoto4, imageViewPhoto5, imageViewPhoto6,
            imageViewPhoto7, imageViewPhoto8, imageViewPhoto9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

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

                Intent i = new Intent("BattleActivity"); // Goto Quiz Activity
                // TODO: Pack Bundle - send to Intent
                startActivityForResult(i, 1);
            }
        });
    }//end onCreate
}
