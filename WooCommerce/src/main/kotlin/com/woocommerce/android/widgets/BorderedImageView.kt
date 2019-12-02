package com.woocommerce.android.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.woocommerce.android.R

/**
 * ImageView with a built-in border so we can avoid adding a parent ViewGroup to provide the border
 */
class BorderedImageView @JvmOverloads constructor(ctx: Context, attrs: AttributeSet? = null) : AppCompatImageView(ctx, attrs) {
    private val borderPaint: Paint
    private val borderSize = context.resources.getDimensionPixelSize(R.dimen.image_border_size).toFloat()

    init {
        val color = ContextCompat.getColor(context, R.color.list_divider)

        borderPaint = Paint().also { paint ->
            paint.setAntiAlias(true)
            paint.setStyle(Paint.Style.STROKE)
            paint.setColor(color)
            paint.setStrokeWidth(borderSize)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(borderSize, borderSize, width - borderSize, height - borderSize, borderPaint)
    }
}
