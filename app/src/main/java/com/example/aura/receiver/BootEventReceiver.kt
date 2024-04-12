package com.example.aura.receiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.aura.data.db.BootEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BootEventReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            context?.let { ctx ->
                CoroutineScope(Dispatchers.IO).launch {
                    persistBootEvent(ctx)
                    scheduleRegularActions(ctx)
                }
            }
        }
    }

    private suspend fun persistBootEvent(context: Context) {
        val timestamp = System.currentTimeMillis()
        val bootEvent = BootEvent(timestamp = timestamp)
        //TODO: save event to room
//        bootEventRepository.insertBootEvent(bootEvent)
    }

    private fun scheduleRegularActions(context: Context?) {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, ActionBroadcastReceiver::class.java)
        intent.action = ActionBroadcastReceiver.ACTION_SHOW_NOTIFICATION
        val pendingIntent =
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val intervalMillis = 15 * 60 * 1000L
        val triggerAtMillis = System.currentTimeMillis() + intervalMillis
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            triggerAtMillis,
            intervalMillis,
            pendingIntent
        )
    }
}