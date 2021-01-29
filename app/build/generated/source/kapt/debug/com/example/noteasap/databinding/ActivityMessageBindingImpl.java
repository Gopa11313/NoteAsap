package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMessageBindingImpl extends ActivityMessageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMessageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ActivityMessageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.EditText) bindings[1]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.message.setTag(null);
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
        if (BR.MessageViewModel == variableId) {
            setMessageViewModel((com.example.noteasap.ui.pupup.message.MessageViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMessageViewModel(@Nullable com.example.noteasap.ui.pupup.message.MessageViewModel MessageViewModel) {
        this.mMessageViewModel = MessageViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.MessageViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMessageViewModelMessage((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMessageViewModelMessage(androidx.lifecycle.LiveData<java.lang.String> MessageViewModelMessage, int fieldId) {
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
        androidx.lifecycle.LiveData<java.lang.String> messageViewModelMessage = null;
        com.example.noteasap.ui.pupup.message.MessageViewModel messageViewModel = mMessageViewModel;
        java.lang.String messageViewModelMessageGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (messageViewModel != null) {
                    // read MessageViewModel.message
                    messageViewModelMessage = messageViewModel.getMessage();
                }
                updateLiveDataRegistration(0, messageViewModelMessage);


                if (messageViewModelMessage != null) {
                    // read MessageViewModel.message.getValue()
                    messageViewModelMessageGetValue = messageViewModelMessage.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.message, messageViewModelMessageGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): MessageViewModel.message
        flag 1 (0x2L): MessageViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}