package com.example.noteasap.ui.content.contentForBookmarkednote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/example/noteasap/ui/content/contentForBookmarkednote/ContentActivityForBookmark;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bookamark", "Landroid/widget/ImageView;", "comment", "commentbar", "Landroid/widget/TextView;", "contentviewModel", "Lcom/example/noteasap/ui/content/contentForNote/ContentviewModel;", "discriotion", "img", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "listcommet", "", "Lcom/example/noteasap/ui/model/Comment;", "noteid", "", "getNoteid", "()Ljava/lang/String;", "setNoteid", "(Ljava/lang/String;)V", "ratingBar1", "Landroid/widget/RatingBar;", "ratting", "", "getRatting", "()Ljava/lang/Integer;", "setRatting", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rattingNum", "getRattingNum", "setRattingNum", "recyleview", "Landroidx/recyclerview/widget/RecyclerView;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "topic", "universityname", "loadcomment", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ContentActivityForBookmark extends androidx.appcompat.app.AppCompatActivity {
    private java.util.List<com.example.noteasap.ui.model.Comment> listcommet;
    private androidx.recyclerview.widget.RecyclerView recyleview;
    public androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout;
    private android.widget.ImageView bookamark;
    private com.example.noteasap.ui.content.contentForNote.ContentviewModel contentviewModel;
    private android.widget.TextView topic;
    private android.widget.RatingBar ratingBar1;
    private android.widget.TextView universityname;
    private android.widget.TextView discriotion;
    private android.widget.ImageView img;
    private android.widget.ImageView comment;
    private androidx.constraintlayout.widget.ConstraintLayout layout;
    private android.widget.TextView commentbar;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer rattingNum;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer ratting;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String noteid;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.swiperefreshlayout.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public final void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRattingNum() {
        return null;
    }
    
    public final void setRattingNum(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRatting() {
        return null;
    }
    
    public final void setRatting(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNoteid() {
        return null;
    }
    
    public final void setNoteid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadcomment() {
    }
    
    public ContentActivityForBookmark() {
        super();
    }
}