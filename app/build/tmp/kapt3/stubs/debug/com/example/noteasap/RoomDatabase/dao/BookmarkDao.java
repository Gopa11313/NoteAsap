package com.example.noteasap.RoomDatabase.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/noteasap/RoomDatabase/dao/BookmarkDao;", "", "bookmarkNote", "", "list", "", "Lcom/example/noteasap/ui/model/BookMarkNotes;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "droptable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookmarkNote", "app_debug"})
public abstract interface BookmarkDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "Delete from BookMarkNotes")
    public abstract java.lang.Object droptable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object bookmarkNote(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.noteasap.ui.model.BookMarkNotes> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from BookMarkNotes")
    public abstract java.lang.Object getBookmarkNote(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.noteasap.ui.model.BookMarkNotes>> p0);
}