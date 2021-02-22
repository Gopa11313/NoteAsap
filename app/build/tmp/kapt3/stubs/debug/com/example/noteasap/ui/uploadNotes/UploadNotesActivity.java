package com.example.noteasap.ui.uploadNotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0012\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\b\u0010(\u001a\u00020$H\u0002J\u0006\u0010)\u001a\u00020*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u000e\u0010\u001f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/noteasap/ui/uploadNotes/UploadNotesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "REQUEST_FILE_CODE", "", "c_name", "Landroid/widget/EditText;", "chooseFile", "Landroid/widget/Button;", "description", "Landroid/widget/TextView;", "fileUrl", "", "level", "", "getLevel", "()[Ljava/lang/String;", "setLevel", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "selectedItem", "getSelectedItem", "()Ljava/lang/String;", "setSelectedItem", "(Ljava/lang/String;)V", "spinner1", "Landroid/widget/Spinner;", "spinner2", "subject", "getSubject", "setSubject", "submit", "topic", "uploadNotesViewModel", "Lcom/example/noteasap/ui/uploadNotes/UploadNotesViewModel;", "clear", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openFile", "validation", "", "app_debug"})
public final class UploadNotesActivity extends androidx.appcompat.app.AppCompatActivity {
    private final int REQUEST_FILE_CODE = 0;
    private java.lang.String fileUrl;
    private android.widget.Spinner spinner1;
    private android.widget.Spinner spinner2;
    private android.widget.Button chooseFile;
    private android.widget.EditText c_name;
    private android.widget.EditText topic;
    private android.widget.TextView description;
    private android.widget.Button submit;
    private com.example.noteasap.ui.uploadNotes.UploadNotesViewModel uploadNotesViewModel;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedItem = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] level = {"University", "Masters", "Bachelors", "+2", "9/10"};
    @org.jetbrains.annotations.NotNull()
    private java.lang.String[] subject = {"Science", "Management"};
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedItem() {
        return null;
    }
    
    public final void setSelectedItem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getLevel() {
        return null;
    }
    
    public final void setLevel(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getSubject() {
        return null;
    }
    
    public final void setSubject(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openFile() {
    }
    
    public final boolean validation() {
        return false;
    }
    
    public final void clear() {
    }
    
    public UploadNotesActivity() {
        super();
    }
}