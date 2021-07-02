package `in`.sajin.bbctestexerscise.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fruit {
    @SerializedName("fruit")
    @Expose
    var fruit: List<Fruit__1>? = null
}

class Fruit__1 {
    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("weight")
    @Expose
    var weight: Int? = null
}