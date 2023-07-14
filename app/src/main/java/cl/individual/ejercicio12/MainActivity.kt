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
    println("Ingrese la cantidad de usuarios")
    val cantUsuarios = readln().toInt()
    for (i in 1..cantUsuarios) {
        var nombre = readln()
        var apellido = readln()
        var edad = readln().toInt()
        var correo = readln()
        var sistSalud = readln()
    }
}

data class Usuario(
    var nombre: String, var apellido: String, var edad: Int, var correo: String,
    var sistSalud: String
)