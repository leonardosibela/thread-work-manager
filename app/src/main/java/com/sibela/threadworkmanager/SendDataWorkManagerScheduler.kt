package com.sibela.threadworkmanager

import android.content.Context
import androidx.work.*

class SendDataWorkManagerScheduler : SendDataScheduler {

    override fun schedule(context: Context, data: String) {
        val pairs = workDataOf(
            SendDataWorker.DATA_KEY to data
        )

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val removeInstanceIdWorker = OneTimeWorkRequestBuilder<SendDataWorker>()
            .setInputData(pairs)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context)
            .beginUniqueWork(
                "SendDataWorkManagerScheduler_$data",
                ExistingWorkPolicy.REPLACE,
                removeInstanceIdWorker
            ).enqueue()
    }
}