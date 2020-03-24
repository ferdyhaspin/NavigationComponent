package com.ferdyhaspin.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipientFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        btnNext.setOnClickListener {
            val recipient = input_recipient.text.toString()
            if (recipient.isNotEmpty()) {
                val bundle = bundleOf("recipient" to recipient)
                navController.navigate(
                    R.id.action_chooseRecipientFragment_to_specifyAmountFragment,
                    bundle
                )
            }
        }

        btnCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}
