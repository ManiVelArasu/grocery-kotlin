package Base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import com.sample.navigationdrawer.R


abstract class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: AlertDialog
    private var loaderCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressDialog = AlertDialog.Builder(this)
            .setView(R.layout.dialog_progress)
            .setCancelable(false)
            .create()
    }

    fun showLoader() {
        if (loaderCounter <= 0) {
            progressDialog.show()
            progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            loaderCounter = 1
        } else {
            loaderCounter++
        }
    }

    fun hideLoader() {
        loaderCounter--

        if (loaderCounter <= 0 && progressDialog.isShowing)
            progressDialog.dismiss()
    }
}
