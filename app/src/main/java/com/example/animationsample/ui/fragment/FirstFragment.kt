package com.example.animationsample.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.animationsample.R
import kotlinx.android.synthetic.main.fragment_first.img_profile

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        img_profile?.setImageResource(R.drawable.profile)
    }

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}
