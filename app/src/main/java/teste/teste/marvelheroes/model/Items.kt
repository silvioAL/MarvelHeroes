package teste.teste.marvelheroes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Items(@field:SerializedName("resourceURI") val resourceUri:String,
            @field:SerializedName("name") val name:String) : Parcelable