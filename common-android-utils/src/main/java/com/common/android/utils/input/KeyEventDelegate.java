package com.common.android.utils.input;

import androidx.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;

import com.common.android.utils.BuildConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Rabe on 03/08/15.
 */
public enum KeyEventDelegate implements KeyListener {

    instance;

    public static boolean LOGGING_ENABLED = BuildConfig.DEBUG;

    public static boolean isLoggingEnabled() {
        return LOGGING_ENABLED;
    }

    public static void setLoggingEnabled(final boolean loggingEnabled) {
        LOGGING_ENABLED = loggingEnabled;
    }

    private static final String TAG = KeyEventDelegate.class.getSimpleName();
    private final List<KeyListener> keyListeners = new ArrayList<>();

    public static void addKeyListener(@Nullable final KeyListener listener) {
        if (listener != null && !instance.keyListeners.contains(listener))
            instance.keyListeners.add(listener);
    }

    public static void removeKeyListener(@Nullable final KeyListener listener) {
        if (listener != null)
            instance.keyListeners.remove(listener);
    }

    @Override
    public boolean onKeyUp(final int keyCode, final KeyEvent event) {
        boolean hasBeenHandled = false;
        for (final KeyListener listener : keyListeners)
            if (!hasBeenHandled)
                hasBeenHandled = listener.onKeyUp(keyCode, event);
        return hasBeenHandled;
    }

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (LOGGING_ENABLED)
            Log.v(TAG, "[onKeyDown] " + keyCode + " event " + event);
        boolean hasBeenHandled = false;
        for (final KeyListener listener : keyListeners)
            if (!hasBeenHandled)
                hasBeenHandled = listener.onKeyDown(keyCode, event);
        return hasBeenHandled;
    }
}
