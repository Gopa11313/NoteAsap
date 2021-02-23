package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable

class OwnNotes(    val userId: String? =null,
                   val level:String?=null,
                   val subject:String?=null,
                  val c_name:String?=null,
                  val file:String?=null,
                  val topic:String?=null,
                  val description:String?=null ):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(c_name)
        parcel.writeString(level)
        parcel.writeString(subject)
        parcel.writeString(file)
        parcel.writeString(topic)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OwnNotes> {
        override fun createFromParcel(parcel: Parcel): OwnNotes {
            return OwnNotes(parcel)
        }

        override fun newArray(size: Int): Array<OwnNotes?> {
            return arrayOfNulls(size)
        }
    }
}