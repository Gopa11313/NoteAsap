package com.example.noteasap.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/noteasap/api/BookamarkApi;", "", "bookmarkTheNote", "Lretrofit2/Response;", "Lcom/example/noteasap/response/BookmarkResponse;", "token", "", "bookmark", "Lcom/example/noteasap/ui/model/Bookmark;", "(Ljava/lang/String;Lcom/example/noteasap/ui/model/Bookmark;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotes", "userId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParticularNote", "app_debug"})
public abstract interface BookamarkApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "bookmark/notes/{id}")
    public abstract java.lang.Object getAllNotes(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.noteasap.response.BookmarkResponse>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "note/bookmark")
    public abstract java.lang.Object bookmarkTheNote(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.noteasap.ui.model.Bookmark bookmark, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.noteasap.response.BookmarkResponse>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "bookmark/notes/by/note/user/{id}")
    public abstract java.lang.Object getParticularNote(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.noteasap.response.BookmarkResponse>> p2);
}