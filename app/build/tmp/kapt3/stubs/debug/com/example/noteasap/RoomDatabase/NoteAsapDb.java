package com.example.noteasap.RoomDatabase;

import java.lang.System;

@androidx.room.Database(entities = {com.example.noteasap.ui.model.User.class, com.example.noteasap.ui.model.OwnNotes.class, com.example.noteasap.ui.model.BookMarkNotes.class, com.example.noteasap.RoomDatabase.dao.CommentDao.class}, version = 9, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/example/noteasap/RoomDatabase/NoteAsapDb;", "Landroidx/room/RoomDatabase;", "()V", "getBookmarkDao", "Lcom/example/noteasap/RoomDatabase/dao/BookmarkDao;", "getCommentDao", "Lcom/example/noteasap/RoomDatabase/dao/CommentDao;", "getNoteDao", "Lcom/example/noteasap/RoomDatabase/dao/NoteDao;", "getUserDao", "Lcom/example/noteasap/RoomDatabase/dao/UserDao;", "Companion", "app_debug"})
public abstract class NoteAsapDb extends androidx.room.RoomDatabase {
    private static volatile com.example.noteasap.RoomDatabase.NoteAsapDb instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.noteasap.RoomDatabase.NoteAsapDb.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.noteasap.RoomDatabase.dao.UserDao getUserDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.noteasap.RoomDatabase.dao.NoteDao getNoteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.noteasap.RoomDatabase.dao.BookmarkDao getBookmarkDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.noteasap.RoomDatabase.dao.CommentDao getCommentDao();
    
    public NoteAsapDb() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/noteasap/RoomDatabase/NoteAsapDb$Companion;", "", "()V", "instance", "Lcom/example/noteasap/RoomDatabase/NoteAsapDb;", "builderDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.noteasap.RoomDatabase.NoteAsapDb getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.example.noteasap.RoomDatabase.NoteAsapDb builderDatabase(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}