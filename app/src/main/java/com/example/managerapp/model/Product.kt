package com.example.managerapp.model

import com.google.gson.annotations.SerializedName

data class Product (
        @SerializedName("products" ) var products : ArrayList<ProductData> = arrayListOf(),
        @SerializedName("total"    ) var total    : Int?                = null,
        @SerializedName("skip"     ) var skip     : Int?                = null,
        @SerializedName("limit"    ) var limit    : Int?                = null
        )
