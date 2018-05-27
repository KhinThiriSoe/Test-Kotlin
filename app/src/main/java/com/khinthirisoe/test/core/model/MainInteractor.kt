package com.khinthirisoe.test.core.model

import com.khinthirisoe.test.main.presenter.MainPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class MainInteractor @Inject
constructor(private val mApiService: ApiService) {

    fun getServices(listener: MainPresenter.OnServicesFetchListener) {

        mApiService.currencyLists
                .enqueue(object : Callback<CurrencyResponse> {
                    override fun onResponse(call: Call<CurrencyResponse>, response: Response<CurrencyResponse>) {
                        val currencyBody = response.body()
                        if (currencyBody == null) {
                            listener.onServicesFetchFailed()
                        } else {
                            getServiceList(currencyBody, listener)
                        }
                    }

                    override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                        listener.onServicesFetchFailed()
                    }
                })

    }

    private fun getServiceList(currencyBody: CurrencyResponse?, listener: MainPresenter.OnServicesFetchListener) {
        mApiService.serviceLists
                .enqueue(object : Callback<ServiceResponse> {
                    override fun onResponse(call: Call<ServiceResponse>, response: Response<ServiceResponse>) {
                        val serviceBody = response.body()
                        if (serviceBody == null) {
                            listener.onServicesFetchFailed()
                        } else {
                            for (service in serviceBody.services!!){
                                service.label = getCurrencyLabel(service.currencyId!!, currencyBody!!.currencies)
                            }
                            listener.onServicesFetched(serviceBody.services!!)
                        }
                    }

                    override fun onFailure(call: Call<ServiceResponse>, t: Throwable) {
                        listener.onServicesFetchFailed()
                    }
                })
    }


    fun getCurrencyLabel(id: Int, currencies: ArrayList<Currency>?): String? {
        return currencies!!
                .firstOrNull { it.id == id }
                ?.label
    }
}
