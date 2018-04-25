package teste.teste.marvelheroes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Heroes(@field:SerializedName("id") val blockID:String,
             @field:SerializedName("name") val name: String,
             @field:SerializedName("thumbnail") val thumbnail: Thumbnail,
             @field:SerializedName("comics") val comics: Comics, var isLast:Boolean = false) : Parcelable