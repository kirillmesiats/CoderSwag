package relsys.eu.coderswag.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import relsys.eu.coderswag.R
import relsys.eu.coderswag.utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

    }
}
