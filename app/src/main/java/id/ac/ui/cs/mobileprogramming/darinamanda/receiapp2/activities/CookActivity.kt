package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import com.google.android.youtube.player.YouTubeStandalonePlayer
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.adapter.PagerAdapter
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel.RecipePhotoViewModel
import kotlinx.android.synthetic.main.activity_cookrecipe.*
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_cook_time
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_difficulty
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_image_title
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_prep_time
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_preptime
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_rating
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_servings
import android.app.ActivityManager
import android.net.ConnectivityManager
import android.net.NetworkInfo


class CookActivity : AppCompatActivity(){
    private lateinit var viewModelPhoto: RecipePhotoViewModel
    private var photoToUpload = ""
    private var apiKey = "AIzaSyAjPRWcFVxvkw1jo-mCA3JtFgjdd1uxUNI"
    private val SELECTED_ITEM_POSITION = "ItemPosition"
    private var mPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cookrecipe)

        viewModelPhoto = ViewModelProviders.of(this).get(RecipePhotoViewModel::class.java)
        val intImage: Int = Integer.parseInt(intent.getStringExtra("Image"))
        val strName: String = intent.getStringExtra("Name")
        val strRating: String = intent.getStringExtra("Rating")
        val strTotalTime: String = intent.getStringExtra("TotalTime")
        val strDifficulty: String = intent.getStringExtra("Difficulty")
        val strServings: String = intent.getStringExtra("Servings")
        val strPrepTime: String = intent.getStringExtra("PrepTime")
        val strCookTime: String = intent.getStringExtra("CookTime")
        val strVideoId: String = intent.getStringExtra("VideoID")
        val strId: String = intent.getStringExtra("RecipeId")
        Log.d("RecipeId", strId)

        val recipeId = Integer.parseInt(strId)

        card_view_image.setImageResource(intImage)
        card_view_image_title.text = strName
        card_view_rating.text = strRating
        card_view_preptime.text = strTotalTime
        card_view_difficulty.text = strDifficulty
        card_view_servings.text = strServings
        card_view_prep_time.text = strPrepTime
        card_view_cook_time.text = strCookTime

        val fragmentAdapter = PagerAdapter(supportFragmentManager, this, recipeId)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
        button_go_to_youtube.setOnClickListener{

            val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnected == true

            if(isConnected) {
                val intent = YouTubeStandalonePlayer.createVideoIntent(this, apiKey, strVideoId)
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Please make sure you are connected to the internet.")
                    .setTitle("Check your connection")

                builder.setPositiveButton("OK"
                ) { dialog, id ->
                    dialog.dismiss()
                }

                val dialog = builder.create()
                dialog.show()
            }
        }

        button_add_photo_from_gallery.setOnClickListener {
            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        val builder = AlertDialog.Builder(this)
                        builder.setMessage("Permission to access the external storage is needed for app to access your gallery.")
                                .setTitle("Permission required")

                        builder.setPositiveButton("OK"
                        ) { dialog, id ->
                            ActivityCompat.requestPermissions(this,
                                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                                PERMISSION_CODE)
                        }

                        val dialog = builder.create()
                        dialog.show()

                        button_add_photo_from_gallery.visibility = View.GONE
                        button_save_photo_from_gallery.visibility = View.VISIBLE
                        textview_change_photo.visibility = View.VISIBLE

                    } else {
                        // No explanation needed, we can request the permission.
                        ActivityCompat.requestPermissions(this,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            PERMISSION_CODE)
                    }
                }
                else{
                    //permission already granted
                    pickImageFromGallery();

                    button_add_photo_from_gallery.visibility = View.GONE
                    button_save_photo_from_gallery.visibility = View.VISIBLE
                    textview_change_photo.visibility = View.VISIBLE
                }
            }
            else{
                pickImageFromGallery();
                button_add_photo_from_gallery.visibility = View.GONE
                button_save_photo_from_gallery.visibility = View.VISIBLE
                textview_change_photo.visibility = View.VISIBLE
            }


        }

        button_save_photo_from_gallery.setOnClickListener{
            if(photoToUpload==""){
                Toast.makeText(this, getString(R.string.toast_empty_photo), Toast.LENGTH_SHORT)
                    .show()
            } else {
                saveList()
                finish()
            }
        }

        textview_change_photo.setOnClickListener{
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }



    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001

        val intId = 0
    }


    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, getString(R.string.toast_permission_denied), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            photoToUpload = (data?.data).toString()
            image_placeholder.setImageURI(data?.data)
        }
    }

    private fun saveList() {
        val newPhoto = RecipePhoto(
            photoToUpload)

        viewModelPhoto.insert(newPhoto)
        Toast.makeText(this,getString(R.string.toast_photo_uploaded), Toast.LENGTH_SHORT).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_ITEM_POSITION, mPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPosition = savedInstanceState.getInt(SELECTED_ITEM_POSITION)
    }


}