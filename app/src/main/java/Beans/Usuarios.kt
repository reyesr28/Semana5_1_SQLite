package Beans

class Usuarios {

    var cod:Int=0
    var nombre:String
    var edad:Int
    var mail:String

    constructor(nombre: String, edad: Int, mail: String) {
        this.nombre = nombre
        this.edad = edad
        this.mail = mail
    }

    constructor(cod: Int, nombre: String, edad: Int, mail: String) {
        this.cod = cod
        this.nombre = nombre
        this.edad = edad
        this.mail = mail
    }
}