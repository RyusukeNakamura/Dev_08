package com.lifeistech.android.dev_08;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    TextView nameTextView;
    ImageView imageView;
    int[] res = {R.drawable.apple, R.drawable.banana,R.drawable.orange,R.drawable.strawberry};
    String[]s={"りんご","ばなな","おれんじ","いちご"};
   // Bitmap[]b=new Bitmap[4];
    Word[]w=new Word[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout) findViewById(R.id.container);
        for (int i = 0; i < 4; i++) {
           // b[i] = BitmapFactory.decodeResource(getResources(), res[i]);
           // w[i] = new Word(b[i], s[i]);
            w[i]=new Word(res[i],s[i]);
            addWord(w[i]);
        }


    }

    public void addWord(Word word) {
        nameTextView = new TextView(this);
        nameTextView.setText(word.name);

        LinearLayout layout = new LinearLayout(getApplicationContext());//this でも可能
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1));
        layout.setOrientation(LinearLayout.HORIZONTAL);


       // ImageView[] imageView =new ImageView[4];
       imageView=new ImageView(this);
        imageView.setImageResource(word.resId);
        nameTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1));

        // Bitmap bitmap1 = Bitmap.createScaledBitmap(word.bb, 600, 400, false);
        //imageView.setImageBitmap(bitmap1);

                imageView.setLayoutParams(new LinearLayout.LayoutParams(-1,-1,1));
                layout.addView(nameTextView);
                layout.addView(imageView);
                container.addView(layout);

    }
}
