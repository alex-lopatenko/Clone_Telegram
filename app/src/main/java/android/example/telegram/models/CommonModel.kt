package android.example.telegram.models

data class CommonModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var state: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",

    var tex:String = "",
    var type:String = "",
    var from:String = "",
    var timeStamp:String = ""
)