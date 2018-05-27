package com.khinthirisoe.test.main.presenter

import com.khinthirisoe.test.core.model.Service
import com.khinthirisoe.test.core.model.MainInteractor
import com.khinthirisoe.test.main.ui.MainContract
import java.util.*
import javax.inject.Inject

class MainPresenter @Inject
constructor(internal var interactor: MainInteractor) : MainContract.Presenter {
    var view: MainContract.View? = null

    var services: ArrayList<Service>? = null

    override fun getServices() {
        if (view != null) view!!.showProgress()
        interactor.getServices(object : OnServicesFetchListener {
            override fun onServicesFetched(services: ArrayList<Service>) {
                this@MainPresenter.services = services
                if (view != null) view!!.showData(services)
                view!!.hideProgress()
            }

            override fun onServicesFetchFailed() {
                if (view != null)
                    view!!.showMessage("Fetch data failed")
                view!!.hideProgress()
            }
        })
    }

    override fun onAttachView(view: MainContract.View) {
        this.view = view
    }

    override fun onDetachView() {
        this.view = null
    }

    interface OnServicesFetchListener {
        fun onServicesFetched(services: ArrayList<Service>)

        fun onServicesFetchFailed()
    }
}
