package com.example.demoworkshop.imageView

import android.graphics.Matrix
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.activity.ComponentActivity
import com.example.demoworkshop.databinding.ActivityImageViewBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageViewBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.imageView.post {
            alignImageTopWithMatrix(binding.imageView)
        }


    }

    private fun alignImageTopWithMatrix(imageView: ImageView) {
        val drawable = imageView.drawable ?: return

        val drawableWidth = drawable.intrinsicWidth
        val drawableHeight = drawable.intrinsicHeight

        val imageViewWidth = imageView.width
        val imageViewHeight = imageView.height

        // 计算按宽度缩放的比例
        val scale = imageViewWidth.toFloat() / drawableWidth

        val matrix = Matrix()
        matrix.postScale(scale, scale) // 按宽度缩放
        // 不需要平移，默认是从左上角绘制

        imageView.imageMatrix = matrix
    }

}