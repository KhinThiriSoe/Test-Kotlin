package com.khinthirisoe.test.second

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.khinthirisoe.test.R
import com.khinthirisoe.test.core.model.Service
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    private var mAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        if (intent != null) {
            val services = intent.getParcelableArrayListExtra<Service>(Service::class.java.simpleName)
            setData(services)
        }

        setUpToolbar()

    }

    private fun setUpToolbar() {
        supportActionBar!!.title = "Service Lists"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun setData(services: ArrayList<Service>) {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        mAdapter = RecyclerAdapter(this, services)
        recycler_view!!.layoutManager = mLayoutManager
        recycler_view!!.itemAnimator = DefaultItemAnimator()
        recycler_view!!.adapter = mAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
