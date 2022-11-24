package tads.eaj.ufrn.remedioapp.ui.converters

import android.text.TextUtils
import androidx.databinding.InverseMethod

class DataBindingConverters {
    companion object {
        @InverseMethod("convertFloatToString")
        @JvmStatic
        fun convertStringToFloat(value: String): Float {
            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
                return 0f
            }
            return value.toFloat()
        }

        @JvmStatic
        fun convertFloatToString(value: Float?): String {
            return value?.toString() ?: ""
        }
    }
}