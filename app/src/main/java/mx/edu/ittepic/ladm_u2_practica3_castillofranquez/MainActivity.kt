package mx.edu.ittepic.ladm_u2_practica3_castillofranquez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var jugador = 0
    var ronda = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener{
            var hilo = hilo(this)
            hilo.start()
            button.visibility = View.INVISIBLE
        }

    }
    fun mensaje(m: String){
        AlertDialog.Builder(this)
            .setTitle("Ganador")
            .setMessage("El ganador es:" + m)
            .setPositiveButton("OK"){p, i ->}
            .show()
    }
}
