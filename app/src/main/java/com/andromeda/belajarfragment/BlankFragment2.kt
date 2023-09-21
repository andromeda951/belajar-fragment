package com.andromeda.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class BlankFragment2 : Fragment() {

    var desc: String? = null

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESC = "extra_desc"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment1 = BlankFragment1()

        // direct call findViewById() using view, in Activity not using view
        // val button2: Button = view.findViewById(R.id.button_one)
        view.findViewById<Button>(R.id.button_two).setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.container, fragment1, BlankFragment1::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }

        view.findViewById<TextView>(R.id.text_name)?.text = arguments?.getString(EXTRA_NAME)
        view.findViewById<TextView>(R.id.text_desc)?.text =
            savedInstanceState?.getString(EXTRA_DESC) ?: desc
    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//
//        view?.findViewById<TextView>(R.id.text_name)?.text = arguments?.getString(EXTRA_NAME)
//        view?.findViewById<TextView>(R.id.text_desc)?.text =
//            savedInstanceState?.getString(EXTRA_DESC) ?: desc
//
//    }
}