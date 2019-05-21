package com.common.android.utils.interfaces;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import android.view.View;

/**
 * Created by Jan Rabe on 16/09/15.
 */
public interface SearchBarProvider {
    @NonNull
    SearchView.OnQueryTextListener getOnQueryTextListener();

    @NonNull
    View.OnClickListener getOnCloseListener();

    @NonNull
    View.OnFocusChangeListener getOnFocusChangeListener();

    void setSearchView(SearchView mSearchView);

    void clearSearch();
}
