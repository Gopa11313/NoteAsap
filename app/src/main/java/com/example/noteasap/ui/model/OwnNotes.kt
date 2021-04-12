package com.example.noteasap.ui.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class OwnNotes (
    @PrimaryKey(autoGenerate = true) val primaryKey:Int=0,
                val _id:String?="",
                val userId: String? =null,
                val level:String?=null,
                val subject:String?=null,
                val c_name:String?=null,
                val file:String?=null,
                val topic:String?=null,
                val description:String?=null,
                val noofRating:Int?=null,
                val ratting:Int?=null):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(primaryKey)
        parcel.writeString(_id)
        parcel.writeString(userId)
        parcel.writeString(level)
        parcel.writeString(subject)
        parcel.writeString(c_name)
        parcel.writeString(file)
        parcel.writeString(topic)
        parcel.writeString(description)
        parcel.writeValue(noofRating)
        parcel.writeValue(ratting)
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