package com.example.kotlinxwcf.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class xData(

//order
var StoreId: String?,
var CustomerId: String?,
var BillingAddressId: String?,
var ShippingAddressId: String?,
var PickUpInStore: String?,
var OrderTotal: String?,
var CardType: String?,
var CardName: String?,
var CardNumber: String?,
var CardCvv2: String?,
var CardExpirationMonth: String?,
var CardExpirationYear: String?,
var CustomOrderNumber: String?,
var OrderItem: MutableList<classUser>?,
//General
var Email:String?,
var Catid:String?
    //@SerializedName("categories") val categories : List<Categories>
)
