package com.example.noteasap.ui.uploadNotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/noteasap/ui/uploadNotes/UploadNotesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "c_name", "Landroid/widget/EditText;", "description", "Landroid/widget/TextView;", "level", "", "", "getLevel", "()[Ljava/lang/String;", "setLevel", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "selectedItem", "getSelectedItem", "()Ljava/lang/String;", "setSelectedItem", "(Ljava/lang/String;)V", "spinner1", "Landroid/widget/Spinner;", "spinner2", "subject", "getSubject", "setSubject", "submit", "Landroid/widget/Button;", "topic", "uploadNotesViewModel", "Lcom/example/noteasap/ui/uploadNotes/UploadNotesViewModel;", "clear", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "uploadnotes", "validation", "", "app_debug"})
public final class UploadNotesActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.Spinner spinner1;
    private android.widget.Spinner spinner2;
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
    private java.util.HashMap _$_findViewCache;
    
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
    
    public final void uploadnotes() {
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