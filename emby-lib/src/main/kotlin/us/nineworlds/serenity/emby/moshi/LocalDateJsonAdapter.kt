package us.nineworlds.serenity.emby.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

class LocalDateJsonAdapter : JsonAdapter<LocalDateTime>() {
  override fun fromJson(reader: JsonReader?): LocalDateTime? {

    val dateTime = reader?.nextString()!!.replaceAfter(".", "")
    val dateformater = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH':'mm':'ss'.'")
//      DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
//    } else if(dateTime!!.contains("+")) {
//    } else {
//      DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ")
//    }

    return LocalDateTime.parse(dateTime, dateformater)
  }

  override fun toJson(writer: JsonWriter?, value: LocalDateTime?) {
    writer?.value(value?.toString())
  }
}