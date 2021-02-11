package android.example.telegram.models

data class User(
    val id:String = "",
    val username:String = "",
    val bio:String = "",
    var fullname:String = "",
    val status:String = "",
    val phone:String = "",
    val photoUrl:String = ""

)