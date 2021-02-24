package com.sibela.threadworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SendDataWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    companion object {
        const val DATA_KEY = "DATA_KEY"
    }

    private val data = workerParameters.inputData.getString(DATA_KEY)!!

    override fun doWork(): Result {
        val success = MyBackend().sendData(data)
        return if (success) {
            Log.d("SendDataWorker", "Result.success()")
            Result.success()
        } else {
            Log.d("SendDataWorker", "Result.failure()")
            Result.failure()
        }
    }
}