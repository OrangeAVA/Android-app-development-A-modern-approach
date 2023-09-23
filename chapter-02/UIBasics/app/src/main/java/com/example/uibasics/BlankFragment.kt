package com.example.uibasics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BlankFragment : Fragment(R.layout.fragment_blank) {
    companion object {
        private const val TAG = "Lifecycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment - onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Fragment - onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Fragment - onViewCreated: ")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "Fragment - onViewStateRestored: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Fragment - onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment - onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Fragment - onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Fragment - onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "Fragment - onSaveInstanceState: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Fragment - onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment - onDestroy: ")
    }

}