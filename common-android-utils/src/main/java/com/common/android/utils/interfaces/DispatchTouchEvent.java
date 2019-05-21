package com.common.android.utils.interfaces;

import androidx.annotation.NonNull;
import android.view.MotionEvent;

/**
 * Created by Jan Rabe on 28/09/15.
 */
public interface DispatchTouchEvent {

    boolean dispatchTouchEvent(@NonNull final MotionEvent event);
}

