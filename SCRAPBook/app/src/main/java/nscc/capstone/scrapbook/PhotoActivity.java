package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

import java.io.FileNotFoundException;

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

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");

                // TODO: Photo select limit; non-necessary, but more polished
                i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                i.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(i,"Select Image"), 2);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK); // Goto Battle Activity
                // TODO: Camera functionality
//                Bundle extras = new Bundle();
//                extras.putString("NAME",textViewName); // Example: Bundle a name
//                i.putExtras(extras); // Put bundle in the intent
//                i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                i.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(i,"Select Image"), 1);
            }
        });


    }//end onCreate

    @Override
    protected void onActivityResult(int requestCode, int result, Intent intent) {
        super.onActivityResult(requestCode, result, intent);

        if(requestCode == 2) {
            ClipData cd = intent.getClipData();
            Bitmap bitmap;
            for (int i = 0; i < cd.getItemCount(); i++) {
                if (result == Activity.RESULT_OK) {
                    ClipData.Item item = cd.getItemAt(i);
                    Uri targetUri = item.getUri();
                    try {
                        // TODO: get width from somewhere else
                        bitmap = Bitmap.createScaledBitmap(BitmapFactory.
                                decodeStream(getContentResolver().openInputStream(targetUri)),
                                imageViewPhoto1.getWidth(),
                                imageViewPhoto1.getHeight(), true);

                        switch (i) {
                            case 0:
                                imageViewPhoto1.setImageBitmap(bitmap);
                                break;
                            case 1:
                                imageViewPhoto2.setImageBitmap(bitmap);
                                break;
                            case 2:
                                imageViewPhoto3.setImageBitmap(bitmap);
                                break;
                            case 3:
                                imageViewPhoto4.setImageBitmap(bitmap);
                                break;
                            case 4:
                                imageViewPhoto5.setImageBitmap(bitmap);
                                break;
                            case 5:
                                imageViewPhoto6.setImageBitmap(bitmap);
                                break;
                            case 6:
                                imageViewPhoto7.setImageBitmap(bitmap);
                                break;
                            case 7:
                                imageViewPhoto8.setImageBitmap(bitmap);
                                break;
                            case 8:
                                imageViewPhoto9.setImageBitmap(bitmap);
                                break;

//                    imageView.setImageBitmap(bitmap);
//                    imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(80,60));
//                    imageView.setMaxHeight(50);
//                    imageView.setMaxWidth(50);
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
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
