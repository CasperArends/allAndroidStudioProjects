package com.example.shoppinglistkotlin;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/shoppinglistkotlin/ProductDAO;", "", "deleteAllProducts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "product", "Lcom/example/shoppinglistkotlin/ProductData;", "getAllProducts", "", "insertProduct", "app_debug"})
public abstract interface ProductDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM productTable")
    public abstract java.util.List<com.example.shoppinglistkotlin.ProductData> getAllProducts();
    
    @androidx.room.Insert()
    public abstract void insertProduct(@org.jetbrains.annotations.NotNull()
    com.example.shoppinglistkotlin.ProductData product);
    
    @androidx.room.Delete()
    public abstract void deleteProduct(@org.jetbrains.annotations.NotNull()
    com.example.shoppinglistkotlin.ProductData product);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM productTable")
    public abstract java.lang.Object deleteAllProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
}