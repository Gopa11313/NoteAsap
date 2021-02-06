// Generated by data binding compiler. Do not edit!
package com.example.noteasap.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.noteasap.R;
import com.example.noteasap.ui.uploadNotes.UploadNotesViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityUploadNotesBinding extends ViewDataBinding {
  @NonNull
  public final Button button;

  @NonNull
  public final AutoCompleteTextView cName;

  @NonNull
  public final EditText desc;

  @NonNull
  public final Spinner spinner1;

  @NonNull
  public final Spinner spinner2;

  @NonNull
  public final Button submit;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final EditText topic;

  @Bindable
  protected UploadNotesViewModel mUploadNoteViewModel;

  protected ActivityUploadNotesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button button, AutoCompleteTextView cName, EditText desc, Spinner spinner1, Spinner spinner2,
      Button submit, TextView textView3, EditText topic) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button = button;
    this.cName = cName;
    this.desc = desc;
    this.spinner1 = spinner1;
    this.spinner2 = spinner2;
    this.submit = submit;
    this.textView3 = textView3;
    this.topic = topic;
  }

  public abstract void setUploadNoteViewModel(@Nullable UploadNotesViewModel UploadNoteViewModel);

  @Nullable
  public UploadNotesViewModel getUploadNoteViewModel() {
    return mUploadNoteViewModel;
  }

  @NonNull
  public static ActivityUploadNotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_upload_notes, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUploadNotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityUploadNotesBinding>inflateInternal(inflater, R.layout.activity_upload_notes, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityUploadNotesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_upload_notes, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUploadNotesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityUploadNotesBinding>inflateInternal(inflater, R.layout.activity_upload_notes, null, false, component);
  }

  public static ActivityUploadNotesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityUploadNotesBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityUploadNotesBinding)bind(component, view, R.layout.activity_upload_notes);
  }
}
