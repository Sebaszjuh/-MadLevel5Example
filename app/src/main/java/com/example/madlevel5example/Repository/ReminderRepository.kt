package com.example.madlevel5example.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5example.Model.Reminder
import com.example.madlevel5example.DAO.ReminderDao

class ReminderRepository(context: Context) {

    private var reminderDAO: ReminderDao

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getDatabase(context)
        reminderDAO = reminderRoomDatabase!!.reminderDao()
    }

     fun getAllReminders(): LiveData<List<Reminder>> {
        return reminderDAO.getAllReminders() ?: MutableLiveData(emptyList())

     }

    suspend fun insertReminder(reminder: Reminder) {
        reminderDAO.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDAO.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDAO.updateReminder(reminder)
    }
}