package `in`.sajin.bbctestexerscise

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class FruitDetailsActivity : AppCompatActivity() {

    var type: String? = null
    var price: Int? = null
    var weight: Int? = null

    var tvfruitname: TextView? = null
    var tvprice: TextView? = null
    var tvweight: TextView? = null

    companion object {
        fun start(context: Context, price: Int?, weight: Int?, type: String?) {
            val starter = Intent(context, FruitDetailsActivity::class.java)
            starter.putExtra("price", price)
            starter.putExtra("weight", weight)
            starter.putExtra("type", type)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_details)

        type = intent.getStringExtra("type")
        price = intent.getIntExtra("price", 0)
        weight = intent.getIntExtra("weight", 0)

        tvfruitname = findViewById(R.id.tvFruit)
        tvprice = findViewById(R.id.tvPrice)
        tvweight = findViewById(R.id.tvWeight)

        tvfruitname!!.text = type
        tvprice!!.text = "£ " + price.toString()
        tvweight!!.text = weight.toString() + " Kg"
    }
}