package com.khinthirisoe.test.main.ui

import com.khinthirisoe.test.core.model.Service
import java.util.*

class MainContract {

    interface View {

        fun showProgress()

        fun hideProgress()

        fun showMessage(message: String)

        fun showData(services: ArrayList<Service>)
    }

    interface Presenter {

        fun getServices()

        fun onAttachView(view: View)

        fun onDetachView()

    }
}
