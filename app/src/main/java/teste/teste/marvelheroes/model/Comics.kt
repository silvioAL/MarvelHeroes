package teste.teste.marvelheroes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Comics(@field:SerializedName("collectionURI") val collectionURI:String,
             @field:SerializedName("items") val items: List<Items>) : Parcelable