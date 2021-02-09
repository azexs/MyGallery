package com.example.mygallery

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val opis = "dauifwenfmviuwnvmweuifvnws"


    private var images = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            images = savedInstanceState.getSerializable("Images") as ArrayList<Image>

        } else {
            for(i in 1..6) images.add(Image(resources.getIdentifier("jpg$i", "drawable", packageName),opis,0f))
        }


        galleryView.layoutManager = GridLayoutManager(this, 3)
        galleryView.adapter = MyAdapter(images, this) { position: Int ->
            val intent = Intent(this, InfoActivity::class.java)
            val item = images[position]
            intent.putExtra("Item", item)
            intent.putExtra("Position", position)
            startActivityForResult(intent, 666)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 666 && resultCode == Activity.RESULT_OK) {
            val position = data!!.getIntExtra("Position", 0)
            images[position].rating = data.getFloatExtra("Rating", 0f)
            images.sortByDescending { it.rating }
            galleryView.adapter?.notifyDataSetChanged()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putSerializable("Images", images)
        super.onSaveInstanceState(outState)
    }



}
