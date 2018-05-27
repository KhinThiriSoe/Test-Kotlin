package com.khinthirisoe.test.core.model

import com.khinthirisoe.test.core.model.ApiUrl.GET_CURRENCY
import com.khinthirisoe.test.core.model.ApiUrl.GET_SERVICE
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @get:GET(GET_CURRENCY)
    val currencyLists: Call<CurrencyResponse>

    @get:GET(GET_SERVICE)
    val serviceLists: Call<ServiceResponse>
}
