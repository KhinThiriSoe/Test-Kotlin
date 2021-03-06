package com.khinthirisoe.test.core.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class ServiceResponse {

    @SerializedName("services")
    @Expose
    var services: ArrayList<Service>? = null
}
