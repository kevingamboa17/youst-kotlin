package mx.yellowme.youst.playground.nemo.domain

data class User(var name: String, var lastName: String? = null) {
    val fullName: String
        get() {
            return "$name $lastName"
        }
}
