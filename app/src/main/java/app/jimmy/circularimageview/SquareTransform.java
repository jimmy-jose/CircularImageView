package app.jimmy.circularimageview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * @author Jimmy
 * Created on 17/12/18.
 */
public class SquareTransform implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }
        return  squaredBitmap;

//        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
//
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
//        paint.setShader(shader);
//        paint.setAntiAlias(true);
//
//        float r = size/2f;
//        canvas.drawCircle(r, r, r, paint);
//
//        squaredBitmap.recycle();
//        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }
}
