package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class TestDeIntegracion {
        
        Escenario escenario;
        NaveMilitarControlada algo42;
        FabricaDeNaves fabricaDeNaves;
        double i;
        
        @Before
        public void arrange(){
                escenario = new Escenario (new Rectangle(new Dimension(50,50)));
                fabricaDeNaves = new FabricaDeNaves (escenario,"equipoAlgo42",null);
                algo42 = fabricaDeNaves.crearAlgo42En(new Point(0,0));
                fabricaDeNaves.setEquipoDeLaNave("enemigos");
                i = 1;
        }

        @Test
        public void testIntegracion1(){
                //Vamos a crear un escenario, a ubicar al Algo42 enfrentado a algunas avionetas sin disparar. Entonces vamos a hacer que la nave le dispare a las avionetas destruyéndolas. La puntuación del escenario debería subir
                while(i < 6){
                        fabricaDeNaves.crearAvionetaEn(new Point(0,(100 + (10 * i))));
                        i++;
                }
                //Primero veamos que hayan 12 objetos en el escenario hay 6 naves y 6 armas viviendo en el escenario
                Assert.assertTrue(escenario.getObjetos().size() == 12);
                
                //Ahora que tenemos 5 avionetas enfrentadas al Algo42, lo hacemos disparar su láser y en menos de 2 unidades de tiempo las 5 avionetas deberían estar destruídas
                algo42.iniciarFuegoConArmaDeId("CanonLaser");
                for (i=0; i<=2; i = i + 0.02) {
                        escenario.avanzarTiempoEn(0.02);
                }
                
                Assert.assertTrue(escenario.getPuntuacion() == 100);
                
                //Ahora ponemos un avión civil en medio de la lluvia de lásers. La puntuación del escenario debería volver a cero después de un tiempo
                fabricaDeNaves.crearAvionCivilEn(new Point(0,20));
                for (i=0; i<=2; i = i + 0.02) {
                        escenario.avanzarTiempoEn(0.02);
                }
                Assert.assertTrue(escenario.getPuntuacion() == 0);
                
        }
        
        @Test
        public void testIntegracion2(){
                //Vamos a crear un escenario, a ubicar al Algo42 y luego un explorador tal que su trayectoria pase por donde está la nave. Vamos a hacer lo mismo con dos naves enemigas
                 fabricaDeNaves.crearExploradorEn(new Point(-40,50));
                 
                 //El explorador se mueve recto hacia el (0,50), luego describe un círculo con centro en (0 @ 20), con lo cual llega al (0 @ 10) en la parte más baja de su círculo. Como estas naves no pueden estar a 10 de distancia sin haberse tocado, el Algo42 es destruído. El explorador debería tardar más de 4 unidades de tiempo (más o menos entre 5 y 10)
                 for (i=0; i<=4; i = i + 0.02){
                         escenario.avanzarTiempoEn(0.02);                
                 }
                 
                 //Todavía no tienen que haber chocado
                 Assert.assertFalse(algo42.estaDestruido());
                 for (i=0; i<=10; i = i + 0.02){
                         escenario.avanzarTiempoEn(0.02);
                 }
                 Assert.assertTrue(algo42.estaDestruido());
                 
                 //Ahora ponemos a una avioneta persiguiendo de atrás a un avión civil. Nos fijamos (como son del mismo equipo) que se atraviesen sin que les pase nada
                 fabricaDeNaves.crearAvionetaEn(new Point(50,50));
                 Nave nave2 = fabricaDeNaves.crearAvionCivilEn(new Point(50,0));
                 for (i=0; i<=10; i = i + 0.02){
                         escenario.avanzarTiempoEn(0.02);
                 }
                 Assert.assertFalse(nave2.estaDestruido());
                 
                 //Lo mismo de antes pero con una pequeña modificación (para que quede claro que todo depende de los equipos)
                 fabricaDeNaves.crearAvionetaEn(new Point(500,50));
                 fabricaDeNaves.setEquipoDeLaNave("ahora la avioneta no es mi aliada");
                 nave2 = fabricaDeNaves.crearAvionCivilEn(new Point(500,0));
                 for (i=0; i<=10; i = i + 0.02){
                         escenario.avanzarTiempoEn(0.02);
                 }
                 Assert.assertTrue(nave2.estaDestruido());
        }
}

