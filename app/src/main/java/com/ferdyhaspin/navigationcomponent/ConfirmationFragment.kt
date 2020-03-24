package com.ferdyhaspin.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {

    private lateinit var recipient: String
    private lateinit var test: String
    private lateinit var money: Money

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
        test = arguments?.getString("test").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "onResume $this", Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val amount = money.amount
        val confirmationMessage = "You have sent $amount to $recipient, data test : $test"
        confirmation_message.text = confirmationMessage

        btnNext.setOnClickListener {
            val test = input_test.text.toString()
            if (test.isNotEmpty()) {
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to money,
                    "test" to test
                )

                navController.navigate(
                    R.id.action_confirmationFragment_self,
                    bundle
                )
            }
        }

        btnBack.setOnClickListener {
            requireActivity().onBackPressed()
        }


    }
}
