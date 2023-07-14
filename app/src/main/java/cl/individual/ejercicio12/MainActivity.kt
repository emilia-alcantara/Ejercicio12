package cl.individual.ejercicio12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    // Declaracion de la lista
    var usuarios = mutableListOf<Usuario>()

    // Declaracion de variables
    var nombre: String = ""
    var apellido: String = ""
    var edad: Int
    var correo: String = ""
    var sistSalud: String = ""

    // Inicio del registro de datos
    println("Ingrese la cantidad de usuarios")
    val cantUsuarios = readln().toInt()

    for (i in 1..cantUsuarios) {

        do {
            println("Ingrese nombre: ")
            nombre = readLine() ?: ""
        } while (!validarNombre(nombre))

        do {
            println("Ingrese apellido: ")
            apellido = readln()
        } while (!validarApellido(apellido))

        do {
            println("Ingrese edad: ")
            val edadIgresada = readLine() ?: ""
            edad = edadIgresada.toIntOrNull() ?: -1
        } while (!validarEdad(edad))

        do {
            println("Ingrese correo: ")
            correo = readln()
        } while (!validarCorreo(correo))

        do {
            println("Ingrese sistema de salud: Fonasa, Isapre, o Particular")
            sistSalud = readln()
        } while (!validarSistemaSalud(sistSalud))

        // Se registran los datos de la data class Usuario ingresados por consola en una variable
        var usuarioIngresado = Usuario(nombre, apellido, edad, correo, sistSalud)
        // Se agrega esa variable a la lista
        usuarios.add(usuarioIngresado)
    }

    // Impresión de la lista completa
    for (users in usuarios.sortedBy { it.edad }) {
        println(users)
    }
}

// Data class Usuario con cada variable a registrar
data class Usuario(
    var nombre: String, var apellido: String, var edad: Int, var correo: String,
    var sistSalud: String
)

// Métodos de validación de la información
fun validarNombre(nombre: String): Boolean {
    val nombreValido =
        nombre.length in 1..20 && nombre.matches(Regex("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$"))

    if (!nombreValido) {
        println("Nombre ingresado invalido. Vuelva a ingresarlo")
    }

    return nombreValido
}

fun validarApellido(apellido: String): Boolean {
    val apellidoValido = apellido.matches(Regex("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$"))

    if (!apellidoValido) {
        println("Apellido ingresado invalido. Vuelva a ingresarlo")
    }
    return apellidoValido
}

fun validarEdad(edad: Int): Boolean {
    val edadValida = edad in 1..110
    if (!edadValida) {
        println("Edad ingresada invalida. Vuelva a ingresarla.")
    }

    return edadValida
}

fun validarCorreo(correo: String): Boolean {
    val correoValido = correo.length > 1 && correo.contains(Regex("^\\S+@\\S+\\.\\S+$"))

    if (!correoValido) {
        println("Correo invalido. Debe ingresarlo con formato ejemplo@correo.com")
    }
    return correoValido
}

fun validarSistemaSalud(sistSalud: String): Boolean {
    val opcionesValidas = listOf("FONASA", "ISAPRE", "PARTICULAR")
    val sistSaludValido = sistSalud.uppercase() in opcionesValidas

    if (!sistSaludValido) {
        println("Sistema de salud invalido. Escriba una de las opciones entregadas")
    }
    return sistSaludValido
}

