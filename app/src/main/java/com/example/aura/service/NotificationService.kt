package com.example.aura.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.aura.R
import com.example.aura.util.Constants.CHANNEL_ID

class NotificationService {
    companion object {
        fun showNotification(context: Context?, content: Any) {
            val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(CHANNEL_ID, "Boot Event Channel", NotificationManager.IMPORTANCE_DEFAULT)
                notificationManager.createNotificationChannel(channel)
            }

            //TODO: need to add logic to display correct logic for setContentText
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Boot Event")
                .setContentText(content.toString())
                .setAutoCancel(true)

            notificationManager.notify(System.currentTimeMillis().toInt(), builder.build())
        }

    }
}