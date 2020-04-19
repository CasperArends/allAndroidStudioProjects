package com.example.shoppinglistkotlin

import androidx.room.*


@Dao
interface ProductDAO {

    @Query("SELECT * FROM productTable")
            fun getAllProducts() : List<ProductData>

    @Insert
    fun insertProduct (product: ProductData)

    @Delete
    fun deleteProduct (product: ProductData)

    @Query ("DELETE FROM productTable")
    suspend fun deleteAllProducts()
}