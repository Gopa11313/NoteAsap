package com.example.noteasap.ui.fragments.homeFragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/example/noteasap/ui/fragments/homeFragment/HomeBlankFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/example/noteasap/databinding/FragmentHomeBlankBinding;", "homeFragmetViewModel", "Lcom/example/noteasap/ui/fragments/homeFragment/HomeFragmetViewModel;", "listStudent", "", "Lcom/example/noteasap/ui/model/Notes;", "getListStudent", "()Ljava/util/List;", "setListStudent", "(Ljava/util/List;)V", "param1", "", "param2", "recyclehome", "Landroidx/recyclerview/widget/RecyclerView;", "search", "Landroid/widget/AutoCompleteTextView;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "getvalues", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "app_debug"})
public final class HomeBlankFragment extends androidx.fragment.app.Fragment {
    private java.lang.String param1;
    private java.lang.String param2;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.example.noteasap.ui.model.Notes> listStudent;
    private androidx.recyclerview.widget.RecyclerView recyclehome;
    private android.widget.AutoCompleteTextView search;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    private com.example.noteasap.ui.fragments.homeFragment.HomeFragmetViewModel homeFragmetViewModel;
    private com.example.noteasap.databinding.FragmentHomeBlankBinding binding;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.noteasap.ui.fragments.homeFragment.HomeBlankFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.example.noteasap.ui.model.Notes> getListStudent() {
        return null;
    }
    
    public final void setListStudent(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.noteasap.ui.model.Notes> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public final void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void getvalues() {
    }
    
    public HomeBlankFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/noteasap/ui/fragments/homeFragment/HomeBlankFragment$Companion;", "", "()V", "newInstance", "Lcom/example/noteasap/ui/fragments/homeFragment/HomeBlankFragment;", "param1", "", "param2", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.noteasap.ui.fragments.homeFragment.HomeBlankFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String param1, @org.jetbrains.annotations.NotNull()
        java.lang.String param2) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}