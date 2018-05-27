package com.khinthirisoe.test.core.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Currency(@field:SerializedName("id")
               @field:Expose
               var id: Int?, @field:SerializedName("label")
               @field:Expose
               var label: String?)
