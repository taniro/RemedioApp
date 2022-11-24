package tads.eaj.ufrn.remedioapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Remedio (var nome:String, var dosagem:Float) {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}