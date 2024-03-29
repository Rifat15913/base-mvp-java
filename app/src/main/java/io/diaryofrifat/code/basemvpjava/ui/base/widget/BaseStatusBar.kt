package io.diaryofrifat.code.basemvpjava.ui.base.widget

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import io.diaryofrifat.code.utils.helper.ViewUtils
import kotlin.math.roundToInt

class BaseStatusBar : View {

    /**
     * Fields
     * */
    private var mStatusBarHeight: Int = 0

    /**
     * Constructors
     * */
    constructor(context: Context) : super(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
    }

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mStatusBarHeight = ViewUtils.dpToPx(24).roundToInt()
            return insets.consumeSystemWindowInsets()
        }
        return insets
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), mStatusBarHeight)
    }
}