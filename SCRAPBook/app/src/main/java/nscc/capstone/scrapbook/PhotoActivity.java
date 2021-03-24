package nscc.capstone.scrapbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.*;
import android.provider.MediaStore;
import android.view.*;
import android.widget.*;
import android.content.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.widget.Toast;

public class PhotoActivity extends AppCompatActivity {

    // Controls
    TextView textViewSelectionHeader, textViewNumPhotos;
    Button btnCamera, btnGallery, btnStart;
    ImageView imageViewPhoto1, imageViewPhoto2, imageViewPhoto3,
            imageViewPhoto4, imageViewPhoto5, imageViewPhoto6,
            imageViewPhoto7, imageViewPhoto8, imageViewPhoto9;

    ClipData cd;

    ArrayList<Bitmap> bitmapList = new ArrayList<Bitmap>();
    int photoCount;

    int CAMERA_CODE = 3;
    int GALLERY_CODE = 2;

    int CAMERA_PERMISSION_CODE = 100;
    int STORAGE_PERMISSION_CODE = 101;

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

        btnStart.setEnabled(false);
        //btnStart.setEnabled(true);

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
        imageViewPhoto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 1) {
                    bitmapList.remove(0);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 2) {
                    bitmapList.remove(1);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 3) {
                    bitmapList.remove(2);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 4) {
                    bitmapList.remove(3);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 5) {
                    bitmapList.remove(4);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 6) {
                    bitmapList.remove(5);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 7) {
                    bitmapList.remove(6);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 8) {
                    bitmapList.remove(7);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        imageViewPhoto9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bitmapList.size() >= 9) {
                    bitmapList.remove(8);
                    setDefaultImages();
                    setImages();
                    photoCount = bitmapList.size();
                    setImageCount();
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(PhotoActivity.this, BattleActivity.class); // Goto Battle Activity

                // Get first image and compress into a byte array to be passed on.
                sendBitmap(bitmapList.get(0), "Image", i);
                startActivity(i);
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

                try {
                    startActivityForResult(Intent.createChooser(i,"Select Image"),
                            GALLERY_CODE);
                } catch (ActivityNotFoundException e) {

                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission(Manifest.permission.CAMERA,
                        CAMERA_CODE);

                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(i, CAMERA_CODE);
                } catch (ActivityNotFoundException e) {

                }
            }
        });


    }//end onCreate

    @Override
    protected void onActivityResult(int requestCode, int result, Intent intent) {
        super.onActivityResult(requestCode, result, intent);

        Bitmap bitmap;
        photoCount = bitmapList.size();

        if(requestCode == GALLERY_CODE) {
            //bitmapList.clear();
            cd = ClipData.newPlainText("", "");
            cd = intent.getClipData();

            int cdSize = cd.getItemCount();

            if (photoCount + cdSize <= 9) {

                for (int i = 0; i < cdSize; i++) {
                    if (result == Activity.RESULT_OK) {
                        ClipData.Item item = cd.getItemAt(i);
                        Uri targetUri = item.getUri();
                        try {
                            bitmap = Bitmap.createScaledBitmap(BitmapFactory.
                                            decodeStream(getContentResolver().openInputStream(targetUri)),
                                    imageViewPhoto1.getWidth(),
                                    imageViewPhoto1.getHeight(), true);

                            bitmapList.add(bitmap);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                maxPhotoWarning();
            }
        } else if (requestCode == CAMERA_CODE) {
            if(photoCount + 1 <= 9) {
                Bundle extras = intent.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                bitmap = Bitmap.createScaledBitmap(imageBitmap,
                        imageViewPhoto1.getWidth(),
                        imageViewPhoto1.getHeight(), true);
                bitmapList.add(bitmap);
            } else {
                maxPhotoWarning();
            }
        }

        photoCount = bitmapList.size();

        if (photoCount <= 9) {

            setImages();

            if(photoCount == 9) {
                btnStart.setEnabled(true);
            }
            textViewNumPhotos.setText(photoCount + "/9");
        }

    }

    protected void maxPhotoWarning(){
        photoCount = bitmapList.size();

        if(photoCount != 9) {
            btnStart.setEnabled(false);
        }

        Context context = getApplicationContext();
        CharSequence text = "Too many images selected!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    protected void setImages(){
        int photoCount = bitmapList.size();
        for (int j = 0; j < photoCount; j++) {
            switch (j) {
                case 0:
                    imageViewPhoto1.setImageBitmap(bitmapList.get(j));
                    break;
                case 1:
                    imageViewPhoto2.setImageBitmap(bitmapList.get(j));
                    break;
                case 2:
                    imageViewPhoto3.setImageBitmap(bitmapList.get(j));
                    break;
                case 3:
                    imageViewPhoto4.setImageBitmap(bitmapList.get(j));
                    break;
                case 4:
                    imageViewPhoto5.setImageBitmap(bitmapList.get(j));
                    break;
                case 5:
                    imageViewPhoto6.setImageBitmap(bitmapList.get(j));
                    break;
                case 6:
                    imageViewPhoto7.setImageBitmap(bitmapList.get(j));
                    break;
                case 7:
                    imageViewPhoto8.setImageBitmap(bitmapList.get(j));
                    break;
                case 8:
                    imageViewPhoto9.setImageBitmap(bitmapList.get(j));
                    break;
            }
        }
    }

    protected void setDefaultImages(){
        imageViewPhoto1.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto2.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto3.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto4.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto5.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto6.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto7.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto8.setImageResource(R.drawable.ic_launcher_background);
        imageViewPhoto9.setImageResource(R.drawable.ic_launcher_background);
    }

    protected void setImageCount(){
        if(photoCount == 9) {
            btnStart.setEnabled(true);
        } else {
            btnStart.setEnabled(false);
        }
        textViewNumPhotos.setText(photoCount + "/9");
    }

    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(PhotoActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(PhotoActivity.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(PhotoActivity.this, "Permission granted",
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

                Toast.makeText(PhotoActivity.this,  "Camera Permission Granted",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(PhotoActivity.this, "Camera Permission Denied",
                        Toast.LENGTH_SHORT).show();

            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PhotoActivity.this, "Storage Permission Granted",
                        Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(PhotoActivity.this, "Storage Permission Denied",
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

    public void sendBitmap(Bitmap sendBitmap, String sendName, Intent i){
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.PNG, 50, byteStream);
        i.putExtra(sendName, byteStream.toByteArray());
    }
    
}
