package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable

class Bookmark(
        val c_id:Int?=null,
        val id:Int?=null,
        val universityname:String?=null,
        val file:String?=null,
        val topic:String?=null,
        val describption:String?=null
        ):Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(c_id)
                parcel.writeValue(id)
                parcel.writeString(universityname)
                parcel.writeString(file)
                parcel.writeString(topic)
                parcel.writeString(describption)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Bookmark> {
                override fun createFromParcel(parcel: Parcel): Bookmark {
                        return Bookmark(parcel)
                }

                override fun newArray(size: Int): Array<Bookmark?> {
                        return arrayOfNulls(size)
                }
        }
}