package mx.edu.ittepic.ladm_u2_practica3_castillofranquez

import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class hilo(p: MainActivity): Thread(){
    var puntero = p
    var ciclo = true
    var acumula1 = 0
    var acumula2 = 0
    var acumula3 = 0
    var acumula4 = 0

    var total = ArrayList<Int>()
    var gan = ""
    override fun run() {
        super.run()
        while (ciclo) {

            sleep(2000)
            puntero.runOnUiThread {

                if(puntero.jugador == 4 ) {
                    puntero.jugador=0
                    puntero.ronda++
                    puntero.rondaa.setText("RONDA: ${puntero.ronda}")


                    if(puntero.ronda == 5){
                        ciclo = false
                        puntero.jug2.setText("Esperando")
                        puntero.rondaa.setText("FIN DE RONDAS")
                    }
                }
                if(puntero.ronda <= 4) {
                    if (puntero.jugador == 0) {
                        puntero.jug1.setText("Jugando")
                        puntero.jug2.setText("Esperando")
                        puntero.jug3.setText("Esperando")
                        puntero.jug4.setText("Esperando")
                    }
                    if (puntero.jugador == 1) {
                        puntero.jug1.setText("Esperando")
                        puntero.jug2.setText("Jugando")
                        puntero.jug3.setText("Esperando")
                        puntero.jug4.setText("Esperando")
                    }
                    if (puntero.jugador == 2) {
                        puntero.jug1.setText("Esperando")
                        puntero.jug2.setText("Esperando")
                        puntero.jug3.setText("Jugando")
                        puntero.jug4.setText("Esperando")
                    }
                    if (puntero.jugador == 3) {
                        puntero.jug1.setText("Esperando")
                        puntero.jug2.setText("Esperando")
                        puntero.jug3.setText("Esperando")
                        puntero.jug4.setText("Jugando")
                    }

                    var d1= (1..6).random().toInt()
                    var d2 = (1..6).random().toInt()

                    when(d1){
                        1->{
                            puntero.imageView15.setImageResource(R.drawable.dado6)
                        }
                        2->{
                            puntero.imageView15.setImageResource(R.drawable.dado5)
                        }
                        3->{
                            puntero.imageView15.setImageResource(R.drawable.dado4)
                        }
                        4->{
                            puntero.imageView15.setImageResource(R.drawable.dado3)
                        }
                        5->{
                            puntero.imageView15.setImageResource(R.drawable.dado2)
                        }
                        6->{
                            puntero.imageView15.setImageResource(R.drawable.dado1)
                        }
                    }

                    when(d2){
                        1->{
                            puntero.imageView16.setImageResource(R.drawable.dado6)
                        }
                        2->{
                            puntero.imageView16.setImageResource(R.drawable.dado5)
                        }
                        3->{
                            puntero.imageView16.setImageResource(R.drawable.dado4)
                        }
                        4->{
                            puntero.imageView16.setImageResource(R.drawable.dado3)
                        }
                        5->{
                            puntero.imageView16.setImageResource(R.drawable.dado2)
                        }
                        6->{
                            puntero.imageView16.setImageResource(R.drawable.dado1)
                        }
                    }

                    if(puntero.jugador == 0){
                        acumula1 += d1+d2
                        puntero.j1.setText("$acumula1")
                    }
                    if(puntero.jugador == 1){
                        acumula2+=d1+d2
                        puntero.j2.setText("$acumula2")
                    }
                    if(puntero.jugador == 2){
                        acumula3+=d1+d2
                        puntero.j3.setText("$acumula3")
                    }
                    if(puntero.jugador == 3){
                        acumula4+=d1+d2
                        puntero.j4.setText("$acumula4")
                    }

                    sleep(1000)
                    puntero.jugador++
                }
            }
        }//while

        puntero.runOnUiThread {
            total.add(acumula1)
            total.add(acumula2)
            total.add(acumula3)
            total.add(acumula4)
            if (total[0] == total.max()) {
                puntero.mensaje("Jugador 1")
            }
            if (total[1] == total.max()) {
                puntero.mensaje("Jugador 2")
            }
            if (total[2] == total.max()) {
                puntero.mensaje("Jugador 3")
            }
            if (total[3] == total.max()) {
                puntero.mensaje("Jugador 4")
            }
        }

    }


}