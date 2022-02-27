package com.hamdy.logo.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hamdy.logo.model.Response
import com.hamdy.logo.model.UserPostsItem
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


class MainViewModel : ViewModel() {
    val listPosts = MutableLiveData<List<UserPostsItem?>>()
    fun getJsonData(context: Context) {
        val jsonFile = jsonDataFromAssets(context)!!
        val gson = Gson()
        val listUserType = object : TypeToken<Response?>() {}.type
        val users: Response = gson.fromJson(jsonFile, listUserType)
        listPosts.value = users.userPosts
    }

    private fun jsonDataFromAssets(context: Context): String? {
        val json: String? = try {
            val inputStream: InputStream = context.assets.open("json_data.json")
            val size: Int = inputStream.available()
            val byteArray = ByteArray(size)
            inputStream.read(byteArray)
            inputStream.close()
            String(byteArray, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}