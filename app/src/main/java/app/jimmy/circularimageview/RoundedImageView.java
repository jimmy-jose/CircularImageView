package app.jimmy.circularimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * @author Jimmy
 * Created on 17/12/18.
 */
class RoundedImageView extends View implements Target {

private Drawable drawable = null;

    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void loadImage(String url) {
        if (url == null) {
            drawable = null;
        } else {

            Picasso.get()
                .load(url)
                .into(this);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(drawable!=null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.draw(canvas);
        }
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        drawable = placeHolderDrawable;
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
        drawable = errorDrawable;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Drawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        ((RoundedBitmapDrawable) roundedDrawable).setCornerRadius(4f);
        drawable = roundedDrawable;
    }


}