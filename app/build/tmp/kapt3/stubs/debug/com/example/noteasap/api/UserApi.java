package com.example.noteasap.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/example/noteasap/api/UserApi;", "", "checkUSer", "Lretrofit2/Response;", "Lcom/example/noteasap/response/UserResponse;", "users", "Lcom/example/noteasap/ui/model/User;", "(Lcom/example/noteasap/ui/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUSer", "app_debug"})
public abstract interface UserApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/add")
    public abstract java.lang.Object registerUSer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.noteasap.ui.model.User users, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.noteasap.response.UserResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/login")
    public abstract java.lang.Object checkUSer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.noteasap.ui.model.User users, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.noteasap.response.UserResponse>> p1);
}