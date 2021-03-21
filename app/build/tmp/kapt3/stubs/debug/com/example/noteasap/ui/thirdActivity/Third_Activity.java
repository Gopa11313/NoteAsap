package com.example.noteasap.ui.thirdActivity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/noteasap/ui/thirdActivity/Third_Activity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/hardware/SensorEventListener;", "()V", "Account", "Lcom/example/noteasap/ui/fragments/accountBlankFragment;", "Bookmark", "Lcom/example/noteasap/ui/fragments/bookmarkFragment/BookmarkBlankFragment;", "Home", "Lcom/example/noteasap/ui/fragments/homeFragment/HomeBlankFragment;", "bottom_navigation", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "frament_container", "Landroid/widget/FrameLayout;", "sensor", "Landroid/hardware/Sensor;", "sensorManager", "Landroid/hardware/SensorManager;", "thirdViewModel", "Lcom/example/noteasap/ui/thirdActivity/ThirdActivityViewModel;", "checkSensor", "", "onAccuracyChanged", "", "accuracy", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "replaceFragments", "fragment", "Landroidx/fragment/app/Fragment;", "app_debug"})
public final class Third_Activity extends androidx.appcompat.app.AppCompatActivity implements android.hardware.SensorEventListener {
    private android.widget.FrameLayout frament_container;
    private final com.example.noteasap.ui.fragments.homeFragment.HomeBlankFragment Home = null;
    private final com.example.noteasap.ui.fragments.bookmarkFragment.BookmarkBlankFragment Bookmark = null;
    private final com.example.noteasap.ui.fragments.accountBlankFragment Account = null;
    private com.google.android.material.bottomnavigation.BottomNavigationView bottom_navigation;
    private com.example.noteasap.ui.thirdActivity.ThirdActivityViewModel thirdViewModel;
    private android.hardware.SensorManager sensorManager;
    private android.hardware.Sensor sensor;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkSensor() {
        return false;
    }
    
    @java.lang.Override()
    public void onSensorChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.SensorEvent event) {
    }
    
    @java.lang.Override()
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    public final void replaceFragments(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    public Third_Activity() {
        super();
    }
}