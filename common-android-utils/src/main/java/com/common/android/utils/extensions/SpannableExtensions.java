package com.common.android.utils.extensions;

import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import org.jetbrains.annotations.NotNull;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by Jan Rabe on 24/09/15.
 */
final public class SpannableExtensions {

    private SpannableExtensions() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Spannable colorize(@NotNull final Spannable spannable, @ColorRes final int color) {
        final Spannable result = new SpannableString(spannable);
        result.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(color)), 0, result.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

    public static Spannable strikeThrough(@NotNull final Spannable spannable) {
        final Spannable result = new SpannableString(spannable);
        result.setSpan(new StrikethroughSpan(), 0, spannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return result;
    }

    @NotNull
    public static Spannable bold(@NotNull final Spannable spannable) {
        final SpannableString result = new SpannableString(spannable);
        result.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, spannable.length(), 0);
        return result;
    }

    @NotNull
    public static Spannable boldItalic(@NotNull final Spannable spannable) {
        final SpannableString result = new SpannableString(spannable);
        result.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, spannable.length(), 0);
        return result;
    }
}
