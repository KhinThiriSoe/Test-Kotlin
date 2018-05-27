package com.khinthirisoe.test.second

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.khinthirisoe.test.R
import com.khinthirisoe.test.core.model.Service
import java.util.*

class SecondActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initView()

        setUpToolbar()

        getIntentData()

    }

    private fun setUpToolbar() {

        supportActionBar!!.title = "Service Lists"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun getIntentData() {
        val intent = intent
        if (intent != null) {
            val services = intent.getParcelableArrayListExtra<Service>(Service::class.java.simpleName)
            setData(services)
        }

    }

    private fun setData(services: ArrayList<Service>) {
        val mLayoutManager = LinearLayoutManager(applicationContext)
        mAdapter = RecyclerAdapter(this, services)
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        mRecyclerView!!.adapter = mAdapter
    }


    private fun initView() {
        mRecyclerView = findViewById(R.id.recycler_view)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
