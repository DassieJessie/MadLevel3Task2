package com.example.portalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

const val REQ_PORTAL_KEY = "req_portal"
const val BUNDLE_PORTAL_KEY = "bundle_portal"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddPortal.setOnClickListener{
            onAddPortal()
        }
    }

    private fun onAddPortal(){
        val portalObject = Portal(etTitle.text.toString(), etURL.text.toString())

        if(portalObject.portalTitle.isNotBlank() && portalObject.portalURL.isNotBlank()){
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY, portalObject)))
            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.invalid_portal, Toast.LENGTH_SHORT
            ).show()
        }
    }
}