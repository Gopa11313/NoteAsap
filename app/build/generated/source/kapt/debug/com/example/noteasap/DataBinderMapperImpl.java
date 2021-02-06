package com.example.noteasap;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.noteasap.databinding.ActivityContentBindingImpl;
import com.example.noteasap.databinding.ActivityEditProfileBindingImpl;
import com.example.noteasap.databinding.ActivityLoginBindingImpl;
import com.example.noteasap.databinding.ActivityMessageBindingImpl;
import com.example.noteasap.databinding.ActivitySignUpBindingImpl;
import com.example.noteasap.databinding.ActivityUploadNotesBindingImpl;
import com.example.noteasap.databinding.FragmentBookmarkBlankBindingImpl;
import com.example.noteasap.databinding.FragmentForgetpasswordBindingImpl;
import com.example.noteasap.databinding.FragmentHomeBlankBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCONTENT = 1;

  private static final int LAYOUT_ACTIVITYEDITPROFILE = 2;

  private static final int LAYOUT_ACTIVITYLOGIN = 3;

  private static final int LAYOUT_ACTIVITYMESSAGE = 4;

  private static final int LAYOUT_ACTIVITYSIGNUP = 5;

  private static final int LAYOUT_ACTIVITYUPLOADNOTES = 6;

  private static final int LAYOUT_FRAGMENTBOOKMARKBLANK = 7;

  private static final int LAYOUT_FRAGMENTFORGETPASSWORD = 8;

  private static final int LAYOUT_FRAGMENTHOMEBLANK = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_content, LAYOUT_ACTIVITYCONTENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_message, LAYOUT_ACTIVITYMESSAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.activity_upload_notes, LAYOUT_ACTIVITYUPLOADNOTES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.fragment_bookmark_blank, LAYOUT_FRAGMENTBOOKMARKBLANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.fragment_forgetpassword, LAYOUT_FRAGMENTFORGETPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.noteasap.R.layout.fragment_home_blank, LAYOUT_FRAGMENTHOMEBLANK);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCONTENT: {
          if ("layout/activity_content_0".equals(tag)) {
            return new ActivityContentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_content is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEDITPROFILE: {
          if ("layout/activity_edit_profile_0".equals(tag)) {
            return new ActivityEditProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMESSAGE: {
          if ("layout/activity_message_0".equals(tag)) {
            return new ActivityMessageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_message is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUPLOADNOTES: {
          if ("layout/activity_upload_notes_0".equals(tag)) {
            return new ActivityUploadNotesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_upload_notes is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOOKMARKBLANK: {
          if ("layout/fragment_bookmark_blank_0".equals(tag)) {
            return new FragmentBookmarkBlankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_bookmark_blank is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGETPASSWORD: {
          if ("layout/fragment_forgetpassword_0".equals(tag)) {
            return new FragmentForgetpasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgetpassword is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOMEBLANK: {
          if ("layout/fragment_home_blank_0".equals(tag)) {
            return new FragmentHomeBlankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home_blank is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(1, "ContentViewModel");
      sKeys.put(2, "EditProfileViewModel");
      sKeys.put(3, "ForgetPasswordViewModel");
      sKeys.put(4, "HomeFragmentViewModel");
      sKeys.put(5, "LoginViewModel");
      sKeys.put(6, "MessageViewModel");
      sKeys.put(7, "SignUpViewModel");
      sKeys.put(8, "UploadNoteViewModel");
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_content_0", com.example.noteasap.R.layout.activity_content);
      sKeys.put("layout/activity_edit_profile_0", com.example.noteasap.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_login_0", com.example.noteasap.R.layout.activity_login);
      sKeys.put("layout/activity_message_0", com.example.noteasap.R.layout.activity_message);
      sKeys.put("layout/activity_sign_up_0", com.example.noteasap.R.layout.activity_sign_up);
      sKeys.put("layout/activity_upload_notes_0", com.example.noteasap.R.layout.activity_upload_notes);
      sKeys.put("layout/fragment_bookmark_blank_0", com.example.noteasap.R.layout.fragment_bookmark_blank);
      sKeys.put("layout/fragment_forgetpassword_0", com.example.noteasap.R.layout.fragment_forgetpassword);
      sKeys.put("layout/fragment_home_blank_0", com.example.noteasap.R.layout.fragment_home_blank);
    }
  }
}
