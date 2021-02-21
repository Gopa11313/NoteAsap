package com.example.noteasap.ui.signUpViewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/noteasap/ui/signUpViewModel/SignUpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "already", "Landroid/widget/TextView;", "con_pass", "Landroid/widget/EditText;", "email", "emailPattern", "", "fullname", "pass", "register", "Landroid/widget/Button;", "signup", "Landroid/widget/LinearLayout;", "signupViewModel", "Lcom/example/noteasap/ui/signUpViewModel/SignUpViewModel;", "termsnCon", "Landroid/widget/CheckBox;", "addUSerInRoomDatabse", "", "adduser", "clear", "nextact", "onBackPressed", "onClick", "p", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "validate", "", "app_debug"})
public final class SignUpActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private android.widget.EditText fullname;
    private android.widget.EditText email;
    private android.widget.EditText pass;
    private android.widget.EditText con_pass;
    private android.widget.CheckBox termsnCon;
    private android.widget.LinearLayout signup;
    private android.widget.Button register;
    private com.example.noteasap.ui.signUpViewModel.SignUpViewModel signupViewModel;
    private android.widget.TextView already;
    private final java.lang.String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p) {
    }
    
    public final boolean validate() {
        return false;
    }
    
    public final void nextact() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void adduser() {
    }
    
    public final void clear() {
    }
    
    public final void addUSerInRoomDatabse() {
    }
    
    public SignUpActivity() {
        super();
    }
}