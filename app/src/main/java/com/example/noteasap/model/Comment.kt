package com.example.noteasap.model

import android.os.Parcel
import android.os.Parcelable

class Comment(
    val s_Id:Int?=null,
    val t_id:Int?=null,
    val Sname:String?=null,
   val comment:String?=null,
    val note_id:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(s_Id)
        parcel.writeValue(t_id)
        parcel.writeString(Sname)
        parcel.writeString(comment)
        parcel.writeString(note_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comment> {
        override fun createFromParcel(parcel: Parcel): Comment {
            return Comment(parcel)
        }

        override fun newArray(size: Int): Array<Comment?> {
            return arrayOfNulls(size)
        }
    }
}