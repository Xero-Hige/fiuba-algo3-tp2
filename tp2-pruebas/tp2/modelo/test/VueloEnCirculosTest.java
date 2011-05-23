package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class VueloEnCirculosTest {
	
	 private VueloEnCirculos vuelo;
	 private ObjetoVolador objetoVolador;
	 private double radioDeVuelo;
	 private int periodo;
	 private double velocidad;
	 private Point posicionActual;
	 private Point posicionInicial;
	 private Escenario escenario;
	 private double i;


	 @Before 
	 public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		// iniciamos un vuelo con centro en el origen, con cierto radio de vuelo y período
		 posicionActual = posicionInicial = new Point(4,3);
		 radioDeVuelo = posicionInicial.radio();		 
		 periodo = 17;
		 
		 velocidad = 2 * (Math.PI) * radioDeVuelo / periodo;
		 objetoVolador = new Nave(posicionInicial,1,escenario,velocidad,10);
		 vuelo = new VueloEnCirculos(objetoVolador,(objetoVolador.getPosicion().getOpuesto()),true); 
		 vuelo.iniciar();
	 }
	 	 
	 @Test
	 public void testAvanzarDurante1(){
		 // Hay que comprobar que la posición obtenida respete el radio de vuelo 
		 // siempre, y que finalmente, habiendo recorrido un número de veces el 
		 // período, la posición final sea igual a la inicial.
		 for (i=1; i<= (50 * periodo);i++){
			 posicionActual = posicionActual.sumarCon(vuelo.avanzarDurante(1));
			 System.out.println(posicionActual);
			 Assert.assertEquals(radioDeVuelo, posicionActual.radio(), 1E-10);
			 }
		 Assert.assertEquals(0, posicionActual.distance(posicionInicial), 1E-10);
	 }
	 
	 @Test
	 public void testAvanzarDurante2(){
		 // Avanzamos el vuelo en un cuarto del período y verificamos que esté 
		 // en la posición correcta.
		 posicionActual = posicionInicial.sumarCon(vuelo.avanzarDurante(periodo / 4.0));
		 Assert.assertEquals(0, posicionActual.distance(new Point(-3,4)), 1E-10);
		 
	 }
	 
	 @Test
	 public void testConfigurarConCentroYSentido(){
		 vuelo = new VueloEnCirculos(objetoVolador,new Point(1,0),false);
		 // Configuramos el vuelo con valores correctos
		 vuelo.configurarCon(new Point(23,10),true);	
		 // Intentamos darle un centro nulo
		 try {
			 vuelo.configurarCon(new Point(0,0),true);
			 Assert.fail("El vuelo fue configurado con un centro inválido.");
			 }
		 catch(ValorInvalido e){
				 Assert.assertTrue(true);
			 }		 
		 catch(Exception e){
				 Assert.fail("Falla con una excepccion invalida");
			 }
		 
		 //Intentamos configurar un vuelo ya iniciado
		 vuelo.iniciar();
		 try {
			 vuelo.configurarCon(new Point(1,0),true);
			 Assert.fail("Se configuró un vuelo iniciado.");
			 }		 
		 catch(VueloIniciado e){
			 Assert.assertTrue(true);
			 }		 
		 catch(Exception e){ 
			 Assert.fail("Falla con una excepccion invalida");
			 }
	 }
	 
	 @Test
	 public void testTrayectoriaPorPeriodo(){
		 //Configuramos un vuelo de radio igual a 10
		 vuelo = new VueloEnCirculos(new Nave(new Point(10,3),1,escenario,5,10), new Point(8,-6),true);
		 //Comprobamos que la trayectoria por período sea la esperada
		 Assert.assertTrue(vuelo.trayectoriaPorPeriodo() == (2 * Math.PI * 10));
	 }
}
