package teste.teste.marvelheroes.utils

import android.databinding.BindingAdapter
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import teste.teste.marvelheroes.R
import java.lang.Exception

object BindAdapterUtils {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun  setImageUrl(view: ImageView, url: String?) {
        if (url != null && view != null && !url.isEmpty()) {

           Picasso.get()
                    .load(url)
                    .into(view, object : Callback {
                        override fun onError(e: Exception?) {
                            Log.e("ERROR:", "COULD NOT LOAD IMAGE")
                        }

                        override fun onSuccess() {

                        }

                    })
        }
    }
}