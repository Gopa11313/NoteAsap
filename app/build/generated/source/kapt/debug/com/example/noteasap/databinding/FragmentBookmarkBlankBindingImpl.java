package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBookmarkBlankBindingImpl extends FragmentBookmarkBlankBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.recycler_view, 2);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.AutoCompleteTextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentBookmarkBlankBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentBookmarkBlankBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.AutoCompleteTextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.BookmarkViewModel == variableId) {
            setBookmarkViewModel((com.example.noteasap.ui.fragments.bookmarkFragment.BookMarkFragmentViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setBookmarkViewModel(@Nullable com.example.noteasap.ui.fragments.bookmarkFragment.BookMarkFragmentViewModel BookmarkViewModel) {
        this.mBookmarkViewModel = BookmarkViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.BookmarkViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBookmarkViewModelSearch((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBookmarkViewModelSearch(androidx.lifecycle.LiveData<java.lang.String> BookmarkViewModelSearch, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String bookmarkViewModelSearchGetValue = null;
        com.example.noteasap.ui.fragments.bookmarkFragment.BookMarkFragmentViewModel bookmarkViewModel = mBookmarkViewModel;
        androidx.lifecycle.LiveData<java.lang.String> bookmarkViewModelSearch = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (bookmarkViewModel != null) {
                    // read BookmarkViewModel.search
                    bookmarkViewModelSearch = bookmarkViewModel.getSearch();
                }
                updateLiveDataRegistration(0, bookmarkViewModelSearch);


                if (bookmarkViewModelSearch != null) {
                    // read BookmarkViewModel.search.getValue()
                    bookmarkViewModelSearchGetValue = bookmarkViewModelSearch.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, bookmarkViewModelSearchGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): BookmarkViewModel.search
        flag 1 (0x2L): BookmarkViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}