package android.example.telegram.models

data class User(
    val id:String = "",
    var username:String = "",
    var bio:String = "",
    var fullname:String = "",
    val status:String = "",
    val phone:String = "",
    val photoUrl:String = ""

)