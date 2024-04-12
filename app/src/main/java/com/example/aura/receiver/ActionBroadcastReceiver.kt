package com.example.aura.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.aura.service.NotificationService

class ActionBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ACTION_SHOW_NOTIFICATION) {
            val notificationContent = determineNotificationContent()
            NotificationService.showNotification(context, notificationContent)
        }
    }

    //TODO: add initializer for bootEventRepository
    //TODO: replace text with keys from resources
    private fun determineNotificationContent(): String {
//        val listOfEvents = bootEventRepository.getAllBootEvents()
//
//        return when (listOfEvents.size){
//            BOOT_LIST_SIZE_0 -> "No boots detected"
//            BOOT_LIST_SIZE_1 -> "The boot was detected = ${listOfEvents.last().timestamp}"
//            else -> {
//                val timeDifference =
//                    calculateTimeDifference(listOfEvents.last().timestamp, listOfEvents[listOfEvents.lastIndex - 1].timestamp)
//                "Last boots time delta = $timeDifference"
//            }
//        }
        return "" // TODO: must be deleted
    }

    private fun calculateTimeDifference(
        lastBootEventTime: Long,
        secondLastBootEventTime: Long
    ): String {
        val timeDifferenceMillis = lastBootEventTime - secondLastBootEventTime
        val minutes = (timeDifferenceMillis / (1000 * 60)) % 60
        val hours = (timeDifferenceMillis / (1000 * 60 * 60)) % 24
        val days = (timeDifferenceMillis / (1000 * 60 * 60 * 24))
        return "$days days, $hours hours, $minutes minutes"
    }

    companion object {
        const val ACTION_SHOW_NOTIFICATION = "action_show_notification"
    }
}