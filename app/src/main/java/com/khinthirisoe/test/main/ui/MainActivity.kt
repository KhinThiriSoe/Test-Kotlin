package com.khinthirisoe.test.main.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.khinthirisoe.test.R
import com.khinthirisoe.test.core.App
import com.khinthirisoe.test.core.model.Service
import com.khinthirisoe.test.second.SecondActivity
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    @JvmField
    var presenter: MainContract.Presenter? = null

    var progressBar: ProgressBar? = null
    var btnContinue: Button? = null

    var services = ArrayList<Service>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.appComponent.inject(this)


        initView()

        presenter!!.getServices()

    }

    private fun initView() {
        progressBar = findViewById(R.id.progressbar)
        btnContinue = findViewById(R.id.btn_continue)
    }

    override fun onResume() {
        super.onResume()
        presenter!!.onAttachView(this)
    }

    override fun onDestroy() {
        presenter!!.onDetachView()
        super.onDestroy()
    }

    override fun showProgress() {
        btnContinue!!.visibility = View.GONE
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        btnContinue!!.visibility = View.VISIBLE
        progressBar!!.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }

    override fun showData(services: ArrayList<Service>) {
        this.services = services
    }

    fun OnContinue(view: View) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putParcelableArrayListExtra(Service::class.java.simpleName, services)
        startActivity(intent)
    }

}
