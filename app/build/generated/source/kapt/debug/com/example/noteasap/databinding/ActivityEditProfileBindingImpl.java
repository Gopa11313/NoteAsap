package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditProfileBindingImpl extends ActivityEditProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.profile, 5);
        sViewsWithIds.put(R.id.chnageprofile, 6);
        sViewsWithIds.put(R.id.linearLayout3, 7);
        sViewsWithIds.put(R.id.linearLayout4, 8);
        sViewsWithIds.put(R.id.linearLayout5, 9);
        sViewsWithIds.put(R.id.linearLayout6, 10);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityEditProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[6]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[2]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[5]
            );
        this.conpassword.setTag(null);
        this.editText.setTag(null);
        this.logPassword.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.EditProfileViewModel == variableId) {
            setEditProfileViewModel((com.example.noteasap.ui.pupup.editProfile.EditProfileViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setEditProfileViewModel(@Nullable com.example.noteasap.ui.pupup.editProfile.EditProfileViewModel EditProfileViewModel) {
        this.mEditProfileViewModel = EditProfileViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.EditProfileViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeEditProfileViewModelPassword((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeEditProfileViewModelName((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeEditProfileViewModelConPassword((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeEditProfileViewModelEmail((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeEditProfileViewModelPassword(androidx.lifecycle.LiveData<java.lang.String> EditProfileViewModelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeEditProfileViewModelName(androidx.lifecycle.LiveData<java.lang.String> EditProfileViewModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeEditProfileViewModelConPassword(androidx.lifecycle.LiveData<java.lang.String> EditProfileViewModelConPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeEditProfileViewModelEmail(androidx.lifecycle.LiveData<java.lang.String> EditProfileViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        com.example.noteasap.ui.pupup.editProfile.EditProfileViewModel editProfileViewModel = mEditProfileViewModel;
        androidx.lifecycle.LiveData<java.lang.String> editProfileViewModelPassword = null;
        androidx.lifecycle.LiveData<java.lang.String> editProfileViewModelName = null;
        androidx.lifecycle.LiveData<java.lang.String> editProfileViewModelConPassword = null;
        androidx.lifecycle.LiveData<java.lang.String> editProfileViewModelEmail = null;
        java.lang.String editProfileViewModelEmailGetValue = null;
        java.lang.String editProfileViewModelNameGetValue = null;
        java.lang.String editProfileViewModelConPasswordGetValue = null;
        java.lang.String editProfileViewModelPasswordGetValue = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (editProfileViewModel != null) {
                        // read EditProfileViewModel.password
                        editProfileViewModelPassword = editProfileViewModel.getPassword();
                    }
                    updateLiveDataRegistration(0, editProfileViewModelPassword);


                    if (editProfileViewModelPassword != null) {
                        // read EditProfileViewModel.password.getValue()
                        editProfileViewModelPasswordGetValue = editProfileViewModelPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (editProfileViewModel != null) {
                        // read EditProfileViewModel.name
                        editProfileViewModelName = editProfileViewModel.getName();
                    }
                    updateLiveDataRegistration(1, editProfileViewModelName);


                    if (editProfileViewModelName != null) {
                        // read EditProfileViewModel.name.getValue()
                        editProfileViewModelNameGetValue = editProfileViewModelName.getValue();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (editProfileViewModel != null) {
                        // read EditProfileViewModel.conPassword
                        editProfileViewModelConPassword = editProfileViewModel.getConPassword();
                    }
                    updateLiveDataRegistration(2, editProfileViewModelConPassword);


                    if (editProfileViewModelConPassword != null) {
                        // read EditProfileViewModel.conPassword.getValue()
                        editProfileViewModelConPasswordGetValue = editProfileViewModelConPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (editProfileViewModel != null) {
                        // read EditProfileViewModel.email
                        editProfileViewModelEmail = editProfileViewModel.getEmail();
                    }
                    updateLiveDataRegistration(3, editProfileViewModelEmail);


                    if (editProfileViewModelEmail != null) {
                        // read EditProfileViewModel.email.getValue()
                        editProfileViewModelEmailGetValue = editProfileViewModelEmail.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.conpassword, editProfileViewModelConPasswordGetValue);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editText, editProfileViewModelEmailGetValue);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.logPassword, editProfileViewModelPasswordGetValue);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, editProfileViewModelNameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): EditProfileViewModel.password
        flag 1 (0x2L): EditProfileViewModel.name
        flag 2 (0x3L): EditProfileViewModel.conPassword
        flag 3 (0x4L): EditProfileViewModel.email
        flag 4 (0x5L): EditProfileViewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}