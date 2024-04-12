package com.example.aura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.aura.databinding.ActivityMainBinding
import com.example.aura.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainActivityViewModel by viewModel()

}