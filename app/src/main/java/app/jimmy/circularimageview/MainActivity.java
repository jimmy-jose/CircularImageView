package app.jimmy.circularimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageTop = findViewById(R.id.imageTop);
        ImageView imageCenter = findViewById(R.id.image);
        RoundedImageView imageBottom = findViewById(R.id.imageBottom);
        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .into(imageTop);
        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .transform(new SquareTransform())
                .into(imageCenter);

        imageBottom.loadImage("http://i.imgur.com/DvpvklR.png");
    }
}
