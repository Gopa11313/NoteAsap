package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityUploadNotesBindingImpl extends ActivityUploadNotesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView3, 4);
        sViewsWithIds.put(R.id.chooseFile, 5);
        sViewsWithIds.put(R.id.spinner1, 6);
        sViewsWithIds.put(R.id.spinner2, 7);
        sViewsWithIds.put(R.id.submit, 8);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityUploadNotesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityUploadNotesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.AutoCompleteTextView) bindings[1]
            , (android.widget.Button) bindings[5]
            , (android.widget.EditText) bindings[3]
            , (android.widget.Spinner) bindings[6]
            , (android.widget.Spinner) bindings[7]
            , (android.widget.Button) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[2]
            );
        this.cName.setTag(null);
        this.desc.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.topic.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.UploadNoteViewModel == variableId) {
            setUploadNoteViewModel((com.example.noteasap.ui.uploadNotes.UploadNotesViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUploadNoteViewModel(@Nullable com.example.noteasap.ui.uploadNotes.UploadNotesViewModel UploadNoteViewModel) {
        this.mUploadNoteViewModel = UploadNoteViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.UploadNoteViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUploadNoteViewModelDesc((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeUploadNoteViewModelCName((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeUploadNoteViewModelTopic((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUploadNoteViewModelDesc(androidx.lifecycle.LiveData<java.lang.String> UploadNoteViewModelDesc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUploadNoteViewModelCName(androidx.lifecycle.LiveData<java.lang.String> UploadNoteViewModelCName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUploadNoteViewModelTopic(androidx.lifecycle.LiveData<java.lang.String> UploadNoteViewModelTopic, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        java.lang.String uploadNoteViewModelCNameGetValue = null;
        java.lang.String uploadNoteViewModelTopicGetValue = null;
        java.lang.String uploadNoteViewModelDescGetValue = null;
        com.example.noteasap.ui.uploadNotes.UploadNotesViewModel uploadNoteViewModel = mUploadNoteViewModel;
        androidx.lifecycle.LiveData<java.lang.String> uploadNoteViewModelDesc = null;
        androidx.lifecycle.LiveData<java.lang.String> uploadNoteViewModelCName = null;
        androidx.lifecycle.LiveData<java.lang.String> uploadNoteViewModelTopic = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (uploadNoteViewModel != null) {
                        // read UploadNoteViewModel.desc
                        uploadNoteViewModelDesc = uploadNoteViewModel.getDesc();
                    }
                    updateLiveDataRegistration(0, uploadNoteViewModelDesc);


                    if (uploadNoteViewModelDesc != null) {
                        // read UploadNoteViewModel.desc.getValue()
                        uploadNoteViewModelDescGetValue = uploadNoteViewModelDesc.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (uploadNoteViewModel != null) {
                        // read UploadNoteViewModel.CName
                        uploadNoteViewModelCName = uploadNoteViewModel.getCName();
                    }
                    updateLiveDataRegistration(1, uploadNoteViewModelCName);


                    if (uploadNoteViewModelCName != null) {
                        // read UploadNoteViewModel.CName.getValue()
                        uploadNoteViewModelCNameGetValue = uploadNoteViewModelCName.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (uploadNoteViewModel != null) {
                        // read UploadNoteViewModel.topic
                        uploadNoteViewModelTopic = uploadNoteViewModel.getTopic();
                    }
                    updateLiveDataRegistration(2, uploadNoteViewModelTopic);


                    if (uploadNoteViewModelTopic != null) {
                        // read UploadNoteViewModel.topic.getValue()
                        uploadNoteViewModelTopicGetValue = uploadNoteViewModelTopic.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cName, uploadNoteViewModelCNameGetValue);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.desc, uploadNoteViewModelDescGetValue);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.topic, uploadNoteViewModelTopicGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): UploadNoteViewModel.desc
        flag 1 (0x2L): UploadNoteViewModel.CName
        flag 2 (0x3L): UploadNoteViewModel.topic
        flag 3 (0x4L): UploadNoteViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}