package teste.teste.marvelheroes.utils

import android.app.Activity
import android.support.v7.app.AlertDialog
import android.util.Log
import teste.teste.marvelheroes.R

open class AlertUtil {
    fun showAlert(activity: Activity, message: String) {
        try {
            val alertDialogBuilder = AlertDialog.Builder(activity)
            alertDialogBuilder.setTitle(activity.resources.getString(R.string.warning))
            alertDialogBuilder.setMessage(message)
            alertDialogBuilder.setNegativeButton(activity.resources.getString(R.string.ok), null)
            alertDialogBuilder.setCancelable(true)
            alertDialogBuilder.context.setTheme(R.style.DialogeMainTheme)

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        } catch (e: Exception) {
            Log.e(AlertUtil::class.java.toString(), e.message)
        }
    }
}