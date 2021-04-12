package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityUpdateNoteBindingImpl extends ActivityUpdateNoteBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView3, 1);
        sViewsWithIds.put(R.id.chooseFile, 2);
        sViewsWithIds.put(R.id.spinner1, 3);
        sViewsWithIds.put(R.id.spinner2, 4);
        sViewsWithIds.put(R.id.c_name, 5);
        sViewsWithIds.put(R.id.topic, 6);
        sViewsWithIds.put(R.id.desc, 7);
        sViewsWithIds.put(R.id.update, 8);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityUpdateNoteBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityUpdateNoteBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[5]
            , (android.widget.Button) bindings[2]
            , (android.widget.EditText) bindings[7]
            , (android.widget.Spinner) bindings[3]
            , (android.widget.Spinner) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.EditText) bindings[6]
            , (android.widget.Button) bindings[8]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): UploadNoteViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}