package com.sample.navigationdrawer

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.TintAwareDrawable

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern
import android.os.Environment
import java.io.File


fun ImageView.tintSrc(@ColorRes colorRes: Int) {
    val drawable = DrawableCompat.wrap(drawable)
    DrawableCompat.setTint(drawable, ContextCompat.getColor(context, colorRes))
    setImageDrawable(drawable)
    if (drawable is TintAwareDrawable) invalidate() // Because in this case setImageDrawable will not call invalidate()
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.visible(visible: Boolean, useGone: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else if (useGone) View.GONE else View.INVISIBLE
}

fun String.onlyDigits(): String = replace(Regex("\\D*"), "")

fun View.toggleKeyboard(show: Boolean) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (show) {
        if (requestFocus()) imm.showSoftInput(this, 0)
    } else {
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

/*inline fun <reified T> Gson.get(json: String): T =
    fromJson(json, object : TypeToken<T>() {}.type)

inline fun <T : BaseModel> T.toJson(): String = Gson().toJson(this)*/

/**
 * Loads image with Glide into the [ImageView].
 *
 * @param url url to load
 * @param previousUrl url that already loaded in this target. Needed to prevent white flickering.
 * @param round if set, the image will be round.
 * @param cornersRadius the corner radius to set. Only used if [round] is `false`(by default).
 * @param crop if set to `true` then [CenterCrop] will be used. Default is `false` so [FitCenter] is used.
 */
@SuppressLint("CheckResult")
fun ImageView.load(
    url: String,
    previousUrl: String? = null,
 /*   @DrawableRes placeholder: Int = R.mipmap.def_placeholder,*/
    round: Boolean = false,
    cornersRadius: Int = 0,
    crop: Boolean = false,
) {
    /*val requestOptions = *//*when*//**//* {
        round -> RequestOptions.circleCropTransform()
        cornersRadius > 0 -> {
            RequestOptions().transforms(
                if (crop) CenterCrop() else FitCenter(),
                RoundedCorners(cornersRadius)
            )
        }*//**//*
*//*
        else -> null*/
    }

   /* Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .let {
            // Apply request options
            if (requestOptions != null) {
                it.apply(requestOptions)
            } else {
                it
            }
        }
        .let {
            // Workaround for the white flickering.
            // See https://github.com/bumptech/glide/issues/527
            // Thumbnail changes must be the same to catch the memory cache.
            if (previousUrl != null) {
                it.thumbnail(
                    Glide
                        .with(context)
                        .load(previousUrl)
                        .let {
                            // Apply request options
                            if (requestOptions != null) {
                                it.apply(requestOptions)
                            } else {
                                it
                            }
                        }
                )
            } else {
                it
            }
        }
        .into(this)
}*/

/*fun displayTime(context: Context, millis: Int): String {
    val decimalFormat = DecimalFormat("00")
    val seconds = millis / 1000
    val mins = seconds / 60
    val secs = seconds % 60
    return context.getString(
       *//* R.string.time_specifier,*//*
        decimalFormat.format(mins),
        decimalFormat.format(secs)
    )

}*/

fun String.displayDate(): String {
    if (this.isEmpty())
        return ""
    val inputFormatter: DateTimeFormatter =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        } else {
            TODO("VERSION.SDK_INT < 0")
        }
    val outputFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("dd.MM.yyy", Locale.ENGLISH)
    val date: LocalDate = LocalDate.parse(this, inputFormatter)
    return outputFormatter.format(date)
}

/*
fun String.imageUrl() =
    if (this.isWebUrl()) this else String.format(Constants.UrlPrefix.image, this)

fun String.audioUrl() =
    if (this.isWebUrl()) this else String.format(Constants.UrlPrefix.audio, this)

fun String.videoUrl() =
    if (this.isWebUrl()) this else String.format(Constants.UrlPrefix.video, this)

fun String.fileUrl() = if (this.isWebUrl()) this else String.format(Constants.UrlPrefix.files, this)
*/

fun String.isWebUrl() = Patterns.WEB_URL.matcher(this).matches()

/*
fun getWaterMark(milliSeconds: Long): String {
    val simpleDateFormat = SimpleDateFormat("dd_MMM_yyyy_HH:mm")
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return "70 MM_" + App.instance.currUser?.name?.uppercase(Locale.ENGLISH) + "_" + simpleDateFormat.format(
        calendar.time
    ).uppercase(Locale.ENGLISH)
}
*/

fun generateSearchedDateLabel(milliSeconds: Long): String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return simpleDateFormat.format(calendar.time)
}

fun generateSearchDateReqField(milliSeconds: Long): String {
    val simpleDateFormat = SimpleDateFormat("dd MMM yyyy")
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return simpleDateFormat.format(calendar.time)
}

fun Context.toast(message: CharSequence, short: Boolean = true) =
    Toast.makeText(this, message, if (short) Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()

fun Context.toast(@StringRes message: Int, short: Boolean = true) =
    Toast.makeText(this, message, if (short) Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()

fun Context.showAlert(@StringRes message: Int, @StringRes title: Int = R.string.app_name) =
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(R.string.ok, null)
        .create()
        .show()

fun Context.showAlert(message: String, title: String = getString(R.string.app_name)) =
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(R.string.okay, null)
        .create()
        .show()

/*
fun Context.showConfirm(
    @StringRes title: Int = R.string.app_name,
    @StringRes message: Int,
    @StringRes confirmText: Int = R.string.yes,
    @StringRes cancelText: Int = R.string.no,
    confirmClickListener: DialogInterface.OnClickListener? = null,
) =
    this.showConfirm(
        getString(title),
        getString(message),
        getString(confirmText),
        getString(cancelText),
        confirmClickListener
    )

fun Context.showConfirm(
    title: String = getString(R.string.app_name),
    message: String,
    confirmText: String = getString(R.string.yes),
    cancelText: String = getString(R.string.no),
    confirmClickListener: DialogInterface.OnClickListener? = null,
) =
    AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton(confirmText, confirmClickListener)
        .setNegativeButton(cancelText, null).create().show()


fun String?.unwrapOrEmpty(): String =
    this ?: ""

fun String.isValidEmail(): Boolean {
    val pattern = Patterns.EMAIL_ADDRESS
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun String.isValidPhone() = !TextUtils.isEmpty(this) && this.length == 10



fun String.isValidPassword(): Boolean {
    val passPattern =
        "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*()\\-_=+{}|?>.<,:;~`’]{8,}$"
    val passwordTest = Pattern.compile(passPattern)
    val result = passwordTest.matcher(this)
    return result.matches()
}

fun Context.getColorRes(@ColorRes color: Int) =
    ContextCompat.getColor(this, color)

fun String.toDate(format: String): Date {
    val dateFormat = SimpleDateFormat(format)
    return dateFormat.parse(this)
}

fun Float.roundToTwoDecimal(): String {
    val decimalFormat =
        DecimalFormat("#.##", DecimalFormatSymbols(Locale.FRANCE)) // format for two decimal "#.##"
    decimalFormat.roundingMode = RoundingMode.CEILING
    return decimalFormat.format(this)
}

fun <T> Collection<T>?.isContentEqual(other: Collection<T>?): Boolean {
    if (this.isNullOrEmpty() && other.isNullOrEmpty())
        return true

    if (this?.size != other?.size)
        return false

    this?.forEach { item ->
        if (other?.contains(item) == false)
            return false
    }
    return true
*/

