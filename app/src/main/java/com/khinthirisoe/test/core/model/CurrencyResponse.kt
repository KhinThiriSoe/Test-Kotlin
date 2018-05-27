package com.khinthirisoe.test.core.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class CurrencyResponse {

    @SerializedName("currencies")
    @Expose
    var currencies: ArrayList<Currency>? = null
}
