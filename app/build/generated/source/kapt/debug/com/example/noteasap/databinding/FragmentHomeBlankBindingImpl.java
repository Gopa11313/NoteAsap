package com.example.noteasap.databinding;
import com.example.noteasap.R;
import com.example.noteasap.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBlankBindingImpl extends FragmentHomeBlankBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.recyclehome, 2);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBlankBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBlankBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (android.widget.AutoCompleteTextView) bindings[1]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[0]
            );
        this.search.setTag(null);
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
        if (BR.HomeFragmentViewModel == variableId) {
            setHomeFragmentViewModel((com.example.noteasap.ui.fragments.homeFragment.HomeFragmetViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHomeFragmentViewModel(@Nullable com.example.noteasap.ui.fragments.homeFragment.HomeFragmetViewModel HomeFragmentViewModel) {
        this.mHomeFragmentViewModel = HomeFragmentViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.HomeFragmentViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeHomeFragmentViewModelAttemptText((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeHomeFragmentViewModelAttemptText(androidx.lifecycle.LiveData<java.lang.String> HomeFragmentViewModelAttemptText, int fieldId) {
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
        com.example.noteasap.ui.fragments.homeFragment.HomeFragmetViewModel homeFragmentViewModel = mHomeFragmentViewModel;
        androidx.lifecycle.LiveData<java.lang.String> homeFragmentViewModelAttemptText = null;
        java.lang.String homeFragmentViewModelAttemptTextGetValue = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (homeFragmentViewModel != null) {
                    // read HomeFragmentViewModel.attemptText
                    homeFragmentViewModelAttemptText = homeFragmentViewModel.getAttemptText();
                }
                updateLiveDataRegistration(0, homeFragmentViewModelAttemptText);


                if (homeFragmentViewModelAttemptText != null) {
                    // read HomeFragmentViewModel.attemptText.getValue()
                    homeFragmentViewModelAttemptTextGetValue = homeFragmentViewModelAttemptText.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.search, homeFragmentViewModelAttemptTextGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): HomeFragmentViewModel.attemptText
        flag 1 (0x2L): HomeFragmentViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}