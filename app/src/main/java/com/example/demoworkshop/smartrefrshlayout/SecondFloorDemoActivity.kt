package com.example.demoworkshop.smartrefrshlayout

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoworkshop.databinding.ActivitySecondFloorDemoBinding


class SecondFloorDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondFloorDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondFloorDemoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()

        binding.refreshLayout.setOnRefreshListener {
            Toast.makeText(applicationContext, "下拉刷新", Toast.LENGTH_SHORT).show()
            binding.refreshLayout.finishRefresh(2000)
        }

        binding.refreshLayout.setOnLoadMoreListener {
            Toast.makeText(applicationContext, "上拉加载", Toast.LENGTH_SHORT).show()
            binding.refreshLayout.finishLoadMore(2000)
        }

        binding.header.setOnTwoLevelListener {
            Toast.makeText(applicationContext, "打开二楼", Toast.LENGTH_SHORT).show()
//            findViewById<View>(R.id.second_floor_content).animate().alpha(1f).setDuration(2000)
            true
        }

        binding.tvReturn.setOnClickListener {
            binding.header.finishTwoLevel()
        }
        binding.secondFloor.setOnClickListener {
            binding.header.finishTwoLevel()
        }
    }

    private fun initView() {


    }
}

