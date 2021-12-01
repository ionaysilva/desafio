import com.example.desafio.android.ionay.silva.network.data.Comic
import com.google.gson.annotations.SerializedName

data class ComicsCharactersData(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val results: List<Comic>
)