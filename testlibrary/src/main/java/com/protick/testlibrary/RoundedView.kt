package com.protick.testlibrary

import android.graphics.RectF
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.appcompat.widget.LinearLayoutCompat


class RoundedView : LinearLayoutCompat {

    /**
     * The corners than can be changed
     */
    private var topLeftCornerRadius: Float = 0.toFloat()
    private var topRightCornerRadius: Float = 0.toFloat()
    private var bottomLeftCornerRadius: Float = 0.toFloat()
    private var bottomRightCornerRadius: Float = 0.toFloat()

    constructor(@NonNull context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(@NonNull context: Context, @Nullable attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(
        @NonNull context: Context,
        @Nullable attrs: AttributeSet,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.RoundedView, 0, 0
        ).also {

            //get the default value form the attrs
            topLeftCornerRadius =
                it.getDimension(R.styleable.RoundedView_topLeftCornerRadius, 0f)
            topRightCornerRadius =
                it.getDimension(R.styleable.RoundedView_topRightCornerRadius, 0f)
            bottomLeftCornerRadius =
                it.getDimension(R.styleable.RoundedView_bottomLeftCornerRadius, 0f)
            bottomRightCornerRadius =
                it.getDimension(R.styleable.RoundedView_bottomRightCornerRadius, 0f)

            it.recycle()
        }
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    override fun dispatchDraw(canvas: Canvas) {
        val count = canvas.save()

        val path = Path()

        val cornerDimensions = floatArrayOf(
            topLeftCornerRadius,
            topLeftCornerRadius,
            topRightCornerRadius,
            topRightCornerRadius,
            bottomRightCornerRadius,
            bottomRightCornerRadius,
            bottomLeftCornerRadius,
            bottomLeftCornerRadius
        )

        path.addRoundRect(
            RectF(0f, 0f, canvas.width.toFloat(), canvas.height.toFloat()),
            cornerDimensions,
            Path.Direction.CW
        )

        canvas.clipPath(path)

        super.dispatchDraw(canvas)
        canvas.restoreToCount(count)
    }

    fun setTopLeftCornerRadius(topLeftCornerRadius: Float) {
        this.topLeftCornerRadius = topLeftCornerRadius
        invalidate()
    }

    fun setTopRightCornerRadius(topRightCornerRadius: Float) {
        this.topRightCornerRadius = topRightCornerRadius
        invalidate()
    }

    fun setBottomLeftCornerRadius(bottomLeftCornerRadius: Float) {
        this.bottomLeftCornerRadius = bottomLeftCornerRadius
        invalidate()
    }

    fun setBottomRightCornerRadius(bottomRightCornerRadius: Float) {
        this.bottomRightCornerRadius = bottomRightCornerRadius
        invalidate()
    }

    fun setRadius(radius: Float, apply: Boolean = true) {
        topLeftCornerRadius = radius
        topRightCornerRadius = radius
        bottomLeftCornerRadius = radius
        bottomRightCornerRadius = radius
        if (apply) apply()
    }

    fun setRadius(
        topLeft: Float = 0f,
        topRight: Float = 0f,
        bottomLeft: Float = 0f,
        bottomRight: Float = 0f,
        apply: Boolean = true
    ) {
        topLeftCornerRadius = topLeft
        topRightCornerRadius = topRight
        bottomLeftCornerRadius = bottomLeft
        bottomRightCornerRadius = bottomRight
        if (apply) apply()
    }

    fun apply() {
        invalidate()
    }
}

