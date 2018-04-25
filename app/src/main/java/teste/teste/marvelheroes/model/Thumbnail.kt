package teste.teste.marvelheroes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Thumbnail(@field:SerializedName("path") val path:String,
                @field:SerializedName("extension") val extension:String) : Parcelable