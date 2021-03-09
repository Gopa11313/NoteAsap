package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityContentForBookmarkBindingImpl extends ActivityContentForBookmarkBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layout, 3);
        sViewsWithIds.put(R.id.topic, 4);
        sViewsWithIds.put(R.id.Universityname, 5);
        sViewsWithIds.put(R.id.dis, 6);
        sViewsWithIds.put(R.id.download, 7);
        sViewsWithIds.put(R.id.linearLayout, 8);
        sViewsWithIds.put(R.id.textView6, 9);
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

    public ActivityContentForBookmarkBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityContentForBookmarkBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.Button) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RatingBar) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[0]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[4]
            );
        this.commentbar.setTag(null);
        this.ratingBar1.setTag(null);
        this.swipe.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.ContentViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContentViewModelRating((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeContentViewModelCmnt((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContentViewModelRating(androidx.lifecycle.LiveData<java.lang.Integer> ContentViewModelRating, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentViewModelCmnt(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelCmnt, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        java.lang.Integer contentViewModelRatingGetValue = null;
        java.lang.String contentViewModelCmntGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Integer> contentViewModelRating = null;
        int androidxDatabindingViewDataBindingSafeUnboxContentViewModelRatingGetValue = 0;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelCmnt = null;
        com.example.noteasap.ui.content.contentForNote.ContentviewModel contentViewModel = mContentViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.rating
                        contentViewModelRating = contentViewModel.getRating();
                    }
                    updateLiveDataRegistration(0, contentViewModelRating);


                    if (contentViewModelRating != null) {
                        // read ContentViewModel.rating.getValue()
                        contentViewModelRatingGetValue = contentViewModelRating.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(ContentViewModel.rating.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxContentViewModelRatingGetValue = androidx.databinding.ViewDataBinding.safeUnbox(contentViewModelRatingGetValue);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.cmnt
                        contentViewModelCmnt = contentViewModel.getCmnt();
                    }
                    updateLiveDataRegistration(1, contentViewModelCmnt);


                    if (contentViewModelCmnt != null) {
                        // read ContentViewModel.cmnt.getValue()
                        contentViewModelCmntGetValue = contentViewModelCmnt.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.commentbar, contentViewModelCmntGetValue);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar1, androidxDatabindingViewDataBindingSafeUnboxContentViewModelRatingGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ContentViewModel.rating
        flag 1 (0x2L): ContentViewModel.cmnt
        flag 2 (0x3L): ContentViewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}