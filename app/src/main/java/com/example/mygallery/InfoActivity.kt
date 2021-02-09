package com.example.mygallery

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.description_fragment.*
import kotlinx.android.synthetic.main.photo_fragment.*


class InfoActivity : AppCompatActivity() {

    var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val item = intent.getSerializableExtra("Item") as Image
        this.position = intent.getIntExtra("Position",0)
        fImage.setImageResource(item.imageId)
        imgDesc.text=item.description
        ratingBar.rating = item.rating

    }


    override fun onBackPressed() {
        val result = Intent()

        result.putExtra("Position", position)
        result.putExtra("Rating", ratingBar.rating)
        setResult(Activity.RESULT_OK, result)
        finish()
        super.onBackPressed()
    }
}
