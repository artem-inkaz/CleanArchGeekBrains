package ui.smartpro.cleanarchgeekbrains.utils

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ui.smartpro.cleanarchgeekbrains.R

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .addToBackStack(null)
        .replace(R.id.container, fragment)
        .commit()
}

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    NavHostFragment.findNavController(this).navigate(resId, bundle)
}

fun Fragment.navigate(dir: NavDirections) {
    findNavController().navigate(dir)
}

fun Fragment.showAlertDialog(title: Int, message: Int) {
    AlertDialog.Builder(context).setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, _ -> dialog.cancel() }
            .show()
}

fun Fragment.showAlertDialog(body: Int, title: String, message: String) {
    AlertDialog.Builder(context).setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, _ ->
                dialog.cancel()

            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.cancel()
            }
            .show()
}

fun Fragment.showAlertDialog(title: String, message: String) {
    AlertDialog.Builder(context).setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.ok) { dialog, _ -> dialog.cancel() }
            .show()
}