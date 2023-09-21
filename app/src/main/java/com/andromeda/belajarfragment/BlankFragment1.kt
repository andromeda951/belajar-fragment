package com.andromeda.belajarfragment

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class BlankFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment2 = BlankFragment2()

        // direct call findViewById() using view, in Activity not using view
        // val button1: Button = view.findViewById(R.id.button_one)
        view.findViewById<Button>(R.id.button_one).setOnClickListener {
            val bundle = Bundle()
            bundle.putString(BlankFragment2.EXTRA_NAME, "This is from fragment 1")
            val desc = "This fragment (fragment 2) will receive data from fragment 1"

            fragment2.arguments = bundle
            fragment2.desc = desc

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, fragment2, BlankFragment2::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }


    }
}