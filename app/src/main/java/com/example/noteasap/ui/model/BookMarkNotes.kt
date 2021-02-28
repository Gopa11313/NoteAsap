package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class BookMarkNotes (@PrimaryKey(autoGenerate = false) val _id:String="",
                          val userId: String? =null,
                          val level:String?=null,
                          val subject:String?=null,
                          val c_name:String?=null,
                          val file:String?=null,
                          val topic:String?=null,
                          val description:String?=null ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(userId)
        parcel.writeString(level)
        parcel.writeString(subject)
        parcel.writeString(c_name)
        parcel.writeString(file)
        parcel.writeString(topic)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookMarkNotes> {
        override fun createFromParcel(parcel: Parcel): BookMarkNotes {
            return BookMarkNotes(parcel)
        }

        override fun newArray(size: Int): Array<BookMarkNotes?> {
            return arrayOfNulls(size)
        }
    }
}