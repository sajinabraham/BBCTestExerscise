package `in`.sajin.bbctestexerscise.adapter


import `in`.sajin.bbctestexerscise.R
import `in`.sajin.bbctestexerscise.model.Fruit
import `in`.sajin.bbctestexerscise.model.Fruit__1
import `in`.sajin.bbctestexerscise.model.Root
import `in`.sajin.bbctestexerscise.sync.GsonRequest
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.Volley

class CategoryAdapter(
    private val context: Context, private val category: ArrayList<Root>,
    private val listener: (Root) -> Unit
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(category[position], listener)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mRequestStartTime: Long = 0
        var totalRequestTime: Long = 0
        fun bind(item: Root, listener: (Root) -> Unit) = with(itemView) {

            val title: TextView = itemView.findViewById(R.id.tvCategoryName)

            title.text = item.id

            //Glide.with(context).load( item.image).into(ivCategoryImage)

            setOnClickListener { listener(item) }
        }
    }
}