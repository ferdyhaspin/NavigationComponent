package com.ferdyhaspin.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.btnCancel
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipient"
        tvRecipient.text = message

        btnSend.setOnClickListener {
            val amount = input_amount.text.toString()
            if (amount.isNotEmpty()) {
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to Money(BigDecimal(amount))
                )

                navController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle
                )
            }
        }

        btnCancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}
