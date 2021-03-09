package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityContentBindingImpl extends ActivityContentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layout, 2);
        sViewsWithIds.put(R.id.topic, 3);
        sViewsWithIds.put(R.id.Universityname, 4);
        sViewsWithIds.put(R.id.dis, 5);
        sViewsWithIds.put(R.id.download, 6);
        sViewsWithIds.put(R.id.linearLayout, 7);
        sViewsWithIds.put(R.id.textView6, 8);
        sViewsWithIds.put(R.id.ratingBar1, 9);
        sViewsWithIds.put(R.id.linearLayout2, 10);
        sViewsWithIds.put(R.id.comment, 11);
        sViewsWithIds.put(R.id.recycler_view1, 12);
        sViewsWithIds.put(R.id.bookmark, 13);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityContentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityContentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RatingBar) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[0]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            );
        this.commentbar.setTag(null);
        this.swipe.setTag(null);
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
        if (BR.ContentViewModel == variableId) {
            setContentViewModel((com.example.noteasap.ui.content.contentForNote.ContentviewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setContentViewModel(@Nullable com.example.noteasap.ui.content.contentForNote.ContentviewModel ContentViewModel) {
        this.mContentViewModel = ContentViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.ContentViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContentViewModelCmnt((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentViewModelCmnt(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelCmnt, int fieldId) {
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
        java.lang.String contentViewModelCmntGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelCmnt = null;
        com.example.noteasap.ui.content.contentForNote.ContentviewModel contentViewModel = mContentViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (contentViewModel != null) {
                    // read ContentViewModel.cmnt
                    contentViewModelCmnt = contentViewModel.getCmnt();
                }
                updateLiveDataRegistration(0, contentViewModelCmnt);


                if (contentViewModelCmnt != null) {
                    // read ContentViewModel.cmnt.getValue()
                    contentViewModelCmntGetValue = contentViewModelCmnt.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.commentbar, contentViewModelCmntGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ContentViewModel.cmnt
        flag 1 (0x2L): ContentViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}