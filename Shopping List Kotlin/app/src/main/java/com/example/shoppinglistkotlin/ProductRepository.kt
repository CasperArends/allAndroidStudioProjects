package com.example.shoppinglistkotlin

import android.content.Context

class ProductRepository (context: Context) {

    private val productDao: ProductDAO

    init {
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<ProductData> {
        return productDao.getAllProducts()
    }

    suspend fun insertProduct (product: ProductData){
        productDao.insertProduct(product)
    }

    suspend fun deleteProduct (product: ProductData){
        productDao.deleteProduct(product)
    }

    suspend fun deleteAllProducts() {
        productDao.deleteAllProducts()
    }
}