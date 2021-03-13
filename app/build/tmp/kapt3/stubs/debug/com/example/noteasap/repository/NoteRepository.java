package com.example.noteasap.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/example/noteasap/repository/NoteRepository;", "Lcom/example/noteasap/api/MyApiRequest;", "()V", "myApi", "Lcom/example/noteasap/api/NoteApi;", "getMyApi", "()Lcom/example/noteasap/api/NoteApi;", "RateNote", "Lcom/example/noteasap/response/NoteResponse;", "id", "", "ratting", "noofRating", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllbookmarkedNotes", "Lcom/example/noteasap/response/ForBookmarkedNotesResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOwnNotes", "Lcom/example/noteasap/response/OwnNotesResponse;", "userId", "uploadfile", "file", "Lokhttp3/MultipartBody$Part;", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadnotes", "notes", "Lcom/example/noteasap/ui/model/Notes;", "(Lcom/example/noteasap/ui/model/Notes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NoteRepository extends com.example.noteasap.api.MyApiRequest {
    @org.jetbrains.annotations.NotNull()
    private final com.example.noteasap.api.NoteApi myApi = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.noteasap.api.NoteApi getMyApi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object uploadnotes(@org.jetbrains.annotations.NotNull()
    com.example.noteasap.ui.model.Notes notes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.NoteResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllNote(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.NoteResponse> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object uploadfile(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.NoteResponse> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllbookmarkedNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.ForBookmarkedNotesResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object RateNote(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String ratting, @org.jetbrains.annotations.NotNull()
    java.lang.String noofRating, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.NoteResponse> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOwnNotes(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.noteasap.response.OwnNotesResponse> p1) {
        return null;
    }
    
    public NoteRepository() {
        super();
    }
}