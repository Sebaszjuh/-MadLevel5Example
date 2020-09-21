package com.example.madlevel5example.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5example.Model.Reminder
import com.example.madlevel5example.Model.ReminderViewModel
import com.example.madlevel5example.R
import kotlinx.android.synthetic.main.fragment_add_reminder.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
//const val REQ_REMINDER_KEY = "req_reminder"
//const val BUNDLE_REMINDER_KEY = "bundle_reminder"

class AddReminderFragment : Fragment() {
    private val viewModel: ReminderViewModel by viewModels()



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddReminder.setOnClickListener {
            onAddReminder()
        }
    }

    private fun onAddReminder() {
        val reminderText = etReminderName.text.toString()

        if (reminderText.isNotBlank()) {
            //set the data as fragmentResult, we are listening for REQ_REMINDER_KEY in RemindersFragment!
//            setFragmentResult(REQ_REMINDER_KEY, bundleOf(Pair(BUNDLE_REMINDER_KEY, reminderText)))
            viewModel.insertReminder(Reminder(reminderText))

            findNavController().popBackStack()

        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_reminder, Toast.LENGTH_SHORT
            ).show()
        }
    }

}