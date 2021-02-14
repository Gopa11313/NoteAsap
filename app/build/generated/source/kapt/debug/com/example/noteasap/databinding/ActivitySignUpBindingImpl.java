package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignUpBindingImpl extends ActivitySignUpBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.signup, 4);
        sViewsWithIds.put(R.id.pass, 5);
        sViewsWithIds.put(R.id.termsnCon, 6);
        sViewsWithIds.put(R.id.reister, 7);
        sViewsWithIds.put(R.id.already, 8);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivitySignUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.TextView) bindings[8]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[1]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.Button) bindings[7]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.CheckBox) bindings[6]
            );
        this.conPss.setTag(null);
        this.email.setTag(null);
        this.fullName.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.SignUpViewModel == variableId) {
            setSignUpViewModel((com.example.noteasap.ui.signUpViewModel.SignUpViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSignUpViewModel(@Nullable com.example.noteasap.ui.signUpViewModel.SignUpViewModel SignUpViewModel) {
        this.mSignUpViewModel = SignUpViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.SignUpViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSignUpViewModelFullname((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeSignUpViewModelEmail((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeSignUpViewModelConPassword((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSignUpViewModelFullname(androidx.lifecycle.LiveData<java.lang.String> SignUpViewModelFullname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSignUpViewModelEmail(androidx.lifecycle.LiveData<java.lang.String> SignUpViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSignUpViewModelConPassword(androidx.lifecycle.LiveData<java.lang.String> SignUpViewModelConPassword, int fieldId) {
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
        java.lang.String signUpViewModelConPasswordGetValue = null;
        com.example.noteasap.ui.signUpViewModel.SignUpViewModel signUpViewModel = mSignUpViewModel;
        androidx.lifecycle.LiveData<java.lang.String> signUpViewModelFullname = null;
        androidx.lifecycle.LiveData<java.lang.String> signUpViewModelEmail = null;
        androidx.lifecycle.LiveData<java.lang.String> signUpViewModelConPassword = null;
        java.lang.String signUpViewModelFullnameGetValue = null;
        java.lang.String signUpViewModelEmailGetValue = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (signUpViewModel != null) {
                        // read SignUpViewModel.fullname
                        signUpViewModelFullname = signUpViewModel.getFullname();
                    }
                    updateLiveDataRegistration(0, signUpViewModelFullname);


                    if (signUpViewModelFullname != null) {
                        // read SignUpViewModel.fullname.getValue()
                        signUpViewModelFullnameGetValue = signUpViewModelFullname.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (signUpViewModel != null) {
                        // read SignUpViewModel.email
                        signUpViewModelEmail = signUpViewModel.getEmail();
                    }
                    updateLiveDataRegistration(1, signUpViewModelEmail);


                    if (signUpViewModelEmail != null) {
                        // read SignUpViewModel.email.getValue()
                        signUpViewModelEmailGetValue = signUpViewModelEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (signUpViewModel != null) {
                        // read SignUpViewModel.conPassword
                        signUpViewModelConPassword = signUpViewModel.getConPassword();
                    }
                    updateLiveDataRegistration(2, signUpViewModelConPassword);


                    if (signUpViewModelConPassword != null) {
                        // read SignUpViewModel.conPassword.getValue()
                        signUpViewModelConPasswordGetValue = signUpViewModelConPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.conPss, signUpViewModelConPasswordGetValue);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.email, signUpViewModelEmailGetValue);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.fullName, signUpViewModelFullnameGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): SignUpViewModel.fullname
        flag 1 (0x2L): SignUpViewModel.email
        flag 2 (0x3L): SignUpViewModel.conPassword
        flag 3 (0x4L): SignUpViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}