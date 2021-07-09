package `in`.sajin.bbctestexerscise

import `in`.sajin.bbctestexerscise.adapter.CategoryAdapter
import `in`.sajin.bbctestexerscise.model.Fruit
import `in`.sajin.bbctestexerscise.model.Fruit__1
import `in`.sajin.bbctestexerscise.model.Root
import `in`.sajin.bbctestexerscise.sync.GsonRequest
import `in`.sajin.bbctestexerscise.utils.AppUtils
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.MutableSet
import kotlin.collections.set


class MainActivity : AppCompatActivity() {
    var langId: Int? = null
    var rvCategory: RecyclerView? = null
    private var mRequestStartTime: Long = 0
    private var totalRequestTime: Long = 0
    private var diplayStartTime: Long = 0
    private var diplayEndtTime: Long = 0

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    var model: ArrayList<Fruit__1> = ArrayList()
    var root: ArrayList<Root> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCategory = this.findViewById(R.id.rvCategory)

        init()

    }

    fun init() {
        diplayStartTime = System.currentTimeMillis();
        val gridLayoutManager = GridLayoutManager(this@MainActivity, 4)
        rvCategory?.layoutManager = gridLayoutManager

        loadCategories()
        diplayEndtTime = System.currentTimeMillis() - diplayStartTime

        val dis = diplayEndtTime - totalRequestTime
        Log.e("dis", "dis$dis")
        eventDiplay(dis)
    }

    fun loadCategories() {
        mRequestStartTime = System.currentTimeMillis();
        val queue = Volley.newRequestQueue(this)
        val url = "https://picsum.photos/v2/list"
        val request = GsonRequest(
            Request.Method.GET,
            url,
            Root::class.java,
            null,
            { response ->


                if (response != null) {
                    totalRequestTime = System.currentTimeMillis() - mRequestStartTime
                    eventLoad(totalRequestTime)
                    //Log.e("totalRequestTime", "totalRequestTime$totalRequestTime")
                    root.addAll(listOf(response))


                    val adapter = CategoryAdapter(this, root) { category ->
//                        FruitDetailsActivity.start(
//                            this,
//                            category.price,
//                            category.weight,
//                            category.type
//                        )
                    }

                    rvCategory?.adapter = adapter
                }

            },
            { error ->
                if (error.networkResponse != null) {
                    totalRequestTime = System.currentTimeMillis() - mRequestStartTime
                    Log.e("error", "error$totalRequestTime")
                    eventError(totalRequestTime)
                    if (error.networkResponse.statusCode == 404) {
                        Toast.makeText(this, " Url Not Found", Toast.LENGTH_SHORT).show()
                    } else if (error.networkResponse.statusCode == 500) {
                        Toast.makeText(
                            this,
                            " Internal Server Error. Please try again later",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

            })
        queue.add(request)

    }


    fun eventLoad(totalRequestTime: Long) {
        val queue = Volley.newRequestQueue(this)
        val params = HashMap<String, String>()
        params["event"] = "load"
        params["data"] = totalRequestTime.toString()
        val url = AppUtils.API_URL + "stats"
        val request = GsonRequest(
            Request.Method.GET,
            url,
            Fruit::class.java,
            params,
            { response ->


            },
            { error ->
                if (error.networkResponse != null) {
                    if (error.networkResponse.statusCode == 404) {
                        Toast.makeText(this, " Url Not Found", Toast.LENGTH_SHORT).show()
                    } else if (error.networkResponse.statusCode == 500) {
                        Toast.makeText(
                            this,
                            " Internal Server Error. Please try again later",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

            })
        queue.add(request)
    }

    fun eventDiplay(totalRequestTime: Long) {
        val queue = Volley.newRequestQueue(this)
        val params = HashMap<String, String>()
        params["event"] = "diplay"
        params["data"] = totalRequestTime.toString()
        val url = AppUtils.API_URL + "stats"
        val request = GsonRequest(
            Request.Method.GET,
            url,
            Fruit::class.java,
            params,
            { response ->


            },
            { error ->
                if (error.networkResponse != null) {
                    if (error.networkResponse.statusCode == 404) {
                        Toast.makeText(this, " Url Not Found", Toast.LENGTH_SHORT).show()
                    } else if (error.networkResponse.statusCode == 500) {
                        Toast.makeText(
                            this,
                            " Internal Server Error. Please try again later",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

            })
        queue.add(request)
    }

    fun eventError(totalRequestTime: Long) {
        val queue = Volley.newRequestQueue(this)
        val params = HashMap<String, String>()
        params["event"] = "error"
        params["data"] = totalRequestTime.toString()
        val url = AppUtils.API_URL + "stats"
        val request = GsonRequest(
            Request.Method.GET,
            url,
            Fruit::class.java,
            params,
            { response ->


            },
            { error ->
                if (error.networkResponse != null) {
                    if (error.networkResponse.statusCode == 404) {
                        Toast.makeText(this, " Url Not Found", Toast.LENGTH_SHORT).show()
                    } else if (error.networkResponse.statusCode == 500) {
                        Toast.makeText(
                            this,
                            " Internal Server Error. Please try again later",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

            })
        queue.add(request)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        return true
//    }


    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//
//        return false
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item!!.itemId) {
//           R.id.action_searchs -> {
//               HomeSearchActivity.start(this)
//               return true
//           }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }
}