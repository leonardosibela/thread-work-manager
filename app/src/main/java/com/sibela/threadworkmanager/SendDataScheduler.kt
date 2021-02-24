package com.sibela.threadworkmanager

import android.content.Context

interface SendDataScheduler {

    fun schedule(context: Context, data: String)

}