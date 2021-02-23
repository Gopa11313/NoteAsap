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
        sViewsWithIds.put(R.id.download, 6);
        sViewsWithIds.put(R.id.linearLayout, 7);
        sViewsWithIds.put(R.id.textView6, 8);
        sViewsWithIds.put(R.id.linearLayout2, 9);
        sViewsWithIds.put(R.id.comment, 10);
        sViewsWithIds.put(R.id.recycler_view1, 11);
        sViewsWithIds.put(R.id.bookmark, 12);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityContentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityContentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.EditText) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.Button) bindings[6]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.RatingBar) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[1]
            );
        this.Universityname.setTag(null);
        this.commentbar.setTag(null);
        this.dis.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.ratingBar1.setTag(null);
        this.topic.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
            setContentViewModel((com.example.noteasap.ui.content.ContentviewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setContentViewModel(@Nullable com.example.noteasap.ui.content.ContentviewModel ContentViewModel) {
        this.mContentViewModel = ContentViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
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
                return onChangeContentViewModelUniName((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeContentViewModelTopic((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeContentViewModelDis((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 4 :
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
    private boolean onChangeContentViewModelUniName(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelUniName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentViewModelTopic(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelTopic, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentViewModelDis(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelDis, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeContentViewModelCmnt(androidx.lifecycle.LiveData<java.lang.String> ContentViewModelCmnt, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        java.lang.String contentViewModelDisGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Integer> contentViewModelRating = null;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelUniName = null;
        java.lang.String contentViewModelUniNameGetValue = null;
        java.lang.Integer contentViewModelRatingGetValue = null;
        java.lang.String contentViewModelTopicGetValue = null;
        java.lang.String contentViewModelCmntGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelTopic = null;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelDis = null;
        int androidxDatabindingViewDataBindingSafeUnboxContentViewModelRatingGetValue = 0;
        androidx.lifecycle.LiveData<java.lang.String> contentViewModelCmnt = null;
        com.example.noteasap.ui.content.ContentviewModel contentViewModel = mContentViewModel;

        if ((dirtyFlags & 0x7fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

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
            if ((dirtyFlags & 0x62L) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.uniName
                        contentViewModelUniName = contentViewModel.getUniName();
                    }
                    updateLiveDataRegistration(1, contentViewModelUniName);


                    if (contentViewModelUniName != null) {
                        // read ContentViewModel.uniName.getValue()
                        contentViewModelUniNameGetValue = contentViewModelUniName.getValue();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.topic
                        contentViewModelTopic = contentViewModel.getTopic();
                    }
                    updateLiveDataRegistration(2, contentViewModelTopic);


                    if (contentViewModelTopic != null) {
                        // read ContentViewModel.topic.getValue()
                        contentViewModelTopicGetValue = contentViewModelTopic.getValue();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.dis
                        contentViewModelDis = contentViewModel.getDis();
                    }
                    updateLiveDataRegistration(3, contentViewModelDis);


                    if (contentViewModelDis != null) {
                        // read ContentViewModel.dis.getValue()
                        contentViewModelDisGetValue = contentViewModelDis.getValue();
                    }
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (contentViewModel != null) {
                        // read ContentViewModel.cmnt
                        contentViewModelCmnt = contentViewModel.getCmnt();
                    }
                    updateLiveDataRegistration(4, contentViewModelCmnt);


                    if (contentViewModelCmnt != null) {
                        // read ContentViewModel.cmnt.getValue()
                        contentViewModelCmntGetValue = contentViewModelCmnt.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.Universityname, contentViewModelUniNameGetValue);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.commentbar, contentViewModelCmntGetValue);
        }
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dis, contentViewModelDisGetValue);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar1, androidxDatabindingViewDataBindingSafeUnboxContentViewModelRatingGetValue);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.topic, contentViewModelTopicGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ContentViewModel.rating
        flag 1 (0x2L): ContentViewModel.uniName
        flag 2 (0x3L): ContentViewModel.topic
        flag 3 (0x4L): ContentViewModel.dis
        flag 4 (0x5L): ContentViewModel.cmnt
        flag 5 (0x6L): ContentViewModel
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}