package com.example.noteasap.Retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\'J8\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/noteasap/Retrofit/IMyServices;", "", "registerUser", "Lretrofit2/Call;", "Ljava/lang/Void;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "uploadNotes", "app_debug"})
public abstract interface IMyServices {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/insert")
    @retrofit2.http.Headers(value = {"Content-Type: application/json"})
    public abstract retrofit2.Call<java.lang.Void> registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> map);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/uploadnotes")
    public abstract retrofit2.Call<java.lang.Void> uploadNotes(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> map);
}