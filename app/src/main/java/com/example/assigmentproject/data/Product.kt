package com.example.assigmentproject.data

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    //done
    val images: List<String>,
    //done
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    //title
    val title: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readInt(),
        parcel.createStringArrayList()!!,
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeDouble(discountPercentage)
        parcel.writeInt(id)
        parcel.writeStringList(images)
        parcel.writeInt(price)
        parcel.writeDouble(rating)
        parcel.writeInt(stock)
        parcel.writeString(thumbnail)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}