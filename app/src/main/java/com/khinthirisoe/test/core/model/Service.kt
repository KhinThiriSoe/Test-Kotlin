package com.khinthirisoe.test.core.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Service protected constructor(`in`: Parcel) : Parcelable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("currency_id")
    @Expose
    var currencyId: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    var label: String? = null


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(this.id)
        dest.writeValue(this.currencyId)
        dest.writeString(this.name)
        dest.writeValue(this.price)
        dest.writeString(this.label)
    }

    init {
        this.id = `in`.readValue(Int::class.java.classLoader) as Int
        this.currencyId = `in`.readValue(Int::class.java.classLoader) as Int
        this.name = `in`.readString()
        this.price = `in`.readValue(Int::class.java.classLoader) as Int
        this.label = `in`.readString()
    }

    companion object CREATOR : Parcelable.Creator<Service> {
        override fun createFromParcel(parcel: Parcel): Service {
            return Service(parcel)
        }

        override fun newArray(size: Int): Array<Service?> {
            return arrayOfNulls(size)
        }
    }
}
