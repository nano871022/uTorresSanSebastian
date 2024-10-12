package co.urtss.core.adapters.outbound

import android.content.ContentValues
import android.provider.BaseColumns
import android.util.Log
import co.urtss.core.adapters.outbound.contracts.MessageContract
import co.urtss.core.adapters.outbound.dbHelper.DbHelper
import co.urtss.core.model.Message
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject


class MessageLocalPort  @Inject constructor(private val svc:DbHelper?){

    fun getMessages():List<co.urtss.core.model.Message>{
        svc?.let {
            val db = it.readableDatabase
            val projection = arrayOf(
                BaseColumns._ID,
                MessageContract.MessageEntry.COLUMN_MESSAGE,
                MessageContract.MessageEntry.COLUMN_DATE
            )
            val cursor = db.query(
                MessageContract.MessageEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
            )
            val messages = mutableListOf<co.urtss.core.adapters.outbound.model.Message>()
            with(cursor) {
                while (moveToNext()) {
                    val id = getInt(getColumnIndexOrThrow(BaseColumns._ID))
                    val message =
                        getString(getColumnIndexOrThrow(MessageContract.MessageEntry.COLUMN_MESSAGE))
                    val date =
                        getLong(getColumnIndexOrThrow(MessageContract.MessageEntry.COLUMN_DATE))
                    messages.add(co.urtss.core.adapters.outbound.model.Message(id, message, date))
                }
            }
            return messages.map {Message(it.id, it.message, LocalDateTime.ofInstant(Instant.ofEpochMilli(it.date), ZoneOffset.UTC))}
        }
        return listOf()
    }


    fun addMessage(message:Message):Boolean{
        svc?.let {
            val db = it.writableDatabase
            val values = ContentValues().apply {
                put(MessageContract.MessageEntry.COLUMN_MESSAGE, message.message)
                put(MessageContract.MessageEntry.COLUMN_DATE, message.date?.toInstant(ZoneOffset.UTC)?.toEpochMilli())
            }
            return (db.insert(MessageContract.MessageEntry.TABLE_NAME, null, values) > 0).also {
                Log.d(this.javaClass.name,"addMessage: added id: $it")
            }
        }
        return false
    }
}