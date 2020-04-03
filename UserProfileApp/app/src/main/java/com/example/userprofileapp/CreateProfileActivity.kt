package com.example.userprofileapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_profile.*

const val GALLERY_REQUEST_CODE = 100
private var profileImageUri: Uri? = null

class CreateProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        initViews()
    }

    private fun initViews(){
        btnOpenGallary.setOnClickListener{ onGalleryClick() }
        btnConfirm.setOnClickListener{ onConfirmClick() }
    }

    private fun onGalleryClick(){
        val galleryIntent = Intent(Intent.ACTION_PICK)

        galleryIntent.type = "image/*"

        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)

    }

    private fun onConfirmClick(){
        val profile = Profile(
            tiFirstName.text.toString(),
            tiLastName.text.toString(),
            tiDescription.text.toString(),
            profileImageUri
        )

        val profileActivityIntent = Intent(this, ProfileActivity::class.java)
            profileActivityIntent.putExtra(ProfileActivity.PROFILE_EXTRA, profile)
            startActivity(profileActivityIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                GALLERY_REQUEST_CODE -> {
                    profileImageUri = data?.data
                    ivprofile.setImageURI(profileImageUri)
                }
            }
        }
    }
}
