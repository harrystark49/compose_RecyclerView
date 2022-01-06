package com.example.compose_recyclerviewlazycolumn

import android.os.Parcel
import android.os.Parcelable

data class items(var id:Int, var name:String?, var img: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<items> {
        override fun createFromParcel(parcel: Parcel): items {
            return items(parcel)
        }

        override fun newArray(size: Int): Array<items?> {
            return arrayOfNulls(size)
        }
    }
}