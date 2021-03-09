package com.common.android.utils.extensions;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.common.android.utils.logging.Logger;
import com.common.android.utils.ui.components.SpriteImageView;

import jp.wasabeef.glide.transformations.CropTransformation;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by Jan Rabe on 30/09/15.
 */
final public class GlideExtensions {

    private static final String TAG = GlideExtensions.class.getSimpleName();

    private GlideExtensions() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void drawImageWithCenterCrop(final String imageUrl, @NonNull final ImageView imageView, @ColorRes final int placeHolderColor) {
        final ColorDrawable drawable = new ColorDrawable(Color.GRAY);
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(placeHolderColor).fitCenter().centerCrop().into(imageView);
    }

    public static void drawImageWithFitCenter(final String imageUrl, @NonNull final ImageView imageView, @ColorRes final int placeHolderColor) {
        final ColorDrawable drawable = new ColorDrawable(Color.GRAY);
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(placeHolderColor).fitCenter().into(imageView);
    }

    @NonNull
    public static CustomTarget<Bitmap> getSimpleTarget(final @NonNull SpriteImageView imageView, final int amountRows, final int amountColumns, final float density, final int columnWidth, final int rowHeight) {
        return new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                imageView.setImageBitmap(resource);
                imageView.setCoordinates((int) (amountColumns * columnWidth * density), (int) (amountRows * columnWidth * density), (int) (rowHeight * density), (int) (rowHeight * density));
            }
            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) { }
        };
    }

    public static void drawImageCenterCrop(@NonNull final String imageUrl, @NonNull final ImageView imageView, @ColorRes final int placeHolderColor) {
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(placeHolderColor).centerCrop().into(imageView);
    }

    public static void drawImageTopCrop(@NonNull final String imageUrl, @NonNull final ImageView imageView, @ColorRes final int placeHolderColor, final int width, final int height) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transform(new CropTransformation(getContext(), width, height, CropTransformation.CropType.TOP))
                .placeholder(placeHolderColor)
                .into(imageView);
    }

    public static void drawImageWithFitCenterNoFading(final String imageUrl, @NonNull final ImageView imageView, @ColorRes final int placeHolderColor) {
        Glide.with(imageView.getContext()).load(imageUrl).dontAnimate().placeholder(placeHolderColor).fitCenter().into(imageView);
    }

    public static void topCrop(@NonNull final String url, @NonNull final ImageView image, @ColorRes final int placeHolderColor, final int width, final int height, final int imageWidth, final int imageHeight) {
        drawImageTopCrop(url, image, placeHolderColor, width, height);
        Logger.v(TAG, String.format("[TopCrop | %dx%d | %dx%d | view %.2f | original %.2f | %s]", width, height, imageWidth, imageHeight, width / (float) height, imageWidth / (float) imageHeight, url));
    }

    public static void centerCrop(@NonNull final String url, @NonNull final ImageView image, @ColorRes final int placeHolderColor, final int width, final int height, final int imageWidth, final int imageHeight) {
        drawImageCenterCrop(url, image, placeHolderColor);
        Logger.v(TAG, String.format("[CenterCrop | %dx%d | %dx%d | view %.2f | original %.2f | %s]", width, height, imageWidth, imageHeight, width / (float) height, imageWidth / (float) imageHeight, url));
    }
}
