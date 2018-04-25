package teste.teste.marvelheroes.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import teste.teste.marvelheroes.R
import teste.teste.marvelheroes.interactions.GenericNotification
import teste.teste.marvelheroes.interactions.GenericStringInteraction
import teste.teste.marvelheroes.utils.AlertUtil

open class GenericActivity : AppCompatActivity(), GenericStringInteraction, GenericNotification {
    val currentContext: Context
        get() = baseContext

    private var progress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress = ProgressDialog(this)
    }

    override fun getStringFromResource(resourceId: Int): String {
        return getString(resourceId)
    }

    override fun showLoading() {
        if (progress != null) {
            progress!!.dismiss()
        }
        progress!!.setMessage(resources.getString(R.string.loading))
        progress!!.setCancelable(false)
        progress!!.show()
    }

    override fun hideLoading() {
        progress!!.dismiss()
    }

    override fun openAlertDialog(message: String) {
        AlertUtil().showAlert(this, message)
    }
}