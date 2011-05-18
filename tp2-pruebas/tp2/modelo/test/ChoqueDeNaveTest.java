package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeNaveTest {
	
	 private ObjetoVolador nave;
	 private Comportamiento comportamiento; 
	 private ObjetoVolador aliado; 
	 private ObjetoVolador enemigo; 
	 private Escenario escenario;
	 private Proyectil proyectilAliado;
	 private Proyectil proyectilEnemigo;

	 public void Arrange1(){
		 aliado = new NaveCivil(new Point(0,0),1,escenario,1,100);
		 aliado.CambiarEquipoA("aliados");
		 enemigo =new NaveCivil(new Point(0,0),1,escenario,1,100);
		 enemigo.CambiarEquipoA("enemigos");
	 }
	 
	 public void Arrange2(){
		 aliado = new NaveMilitar(new Point(0,0),1,escenario,1,100);
		 aliado.CambiarEquipoA("aliados");
		 enemigo =new NaveMilitar(new Point(0,0),1,escenario,1,100);
		 enemigo.CambiarEquipoA("enemigos");
	 }	 
	 
	 @Before
	 public void Arrange(){
		 escenario = new Escenario(new Rectangle());
		 nave = new Nave(new Point(0,0),1,escenario,1,100);
		 nave.CambiarEquipoA("aliados");
		 comportamiento = nave.ObtenerComportamiento();
		 proyectilAliado = new Proyectil(new Point(0,0),0.1,0,10); 
		 proyectilAliado.cambiarEquipoA("aliados")
		 proyectilEnemigo = new Proyectil(new Point(0,0),0.1,0,10); 
		 proyectilEnemigo.cambiarEquipoA("enemigos")
	 }
	 
	 @Test
	 public void TestSufrirChoqueDeNaveCivil1(){
		 this.Arrange1();
		 //Pedimos que la nave no sea destruída al sufrir el choque del aliado
		 comportamiento.SufrirChoqueDeNaveCivil(aliado);
		 Assert.assertFalse(nave.EstaDestruido());
	 }

	 @Test
	 public void TestSufrirChoqueDeNaveCivil2(){
		 this.Arrange1();
		 //Pedimos que la nave no sea destruída al sufrir el choque del enemigo (civil)
		 comportamiento.SufrirChoqueDeNaveCivil(enemigo);
		 Assert.assertFalse(nave.EstaDestruido());
	 }
	 
	 @Test
	 public void TestSufrirChoqueDeNaveMilitar1(){
		 this.Arrange2();
		 //Pedimos que la nave no sea destruída al sufrir el choque del aliado
		 comportamiento.SufrirChoqueDeNaveMilitar(aliado);
		 Assert.assertFalse(nave.EstaDestruido());
	 }
	 
	 @Test
	 public void TestSufrirChoqueDeNaveMilitar2(){
		 this.Arrange2();
		 //Pedimos que la nave sea destruída al sufrir el choque del enemigo
		 comportamiento.SufrirChoqueDeNaveMilitar(enemigo);
		 Assert.assertTrue(nave.EstaDestruido());
	 }
	 
	 @Test
	 public void TestSufrirChoqueDeProyectil1(){
		 //Pedimos que la nave sufra el daño del proyectil enemigo al sufrir el choque
		 comportamiento.SufrirChoqueDeProyectil(proyectilEnemigo);
		 Assert.assertTrue(nave.ObtenerEnergia() = 5);
	 }

	 @Test
	 public void TestSufrirChoqueDeProyectil2(){
		 //Pedimos que la nave no sufra el daño del proyectil aliado al sufrir el choque
		 comportamiento.SufrirChoqueDeProyectil(proyectilAliado);
		 Assert.assertTrue(nave.ObtenerEnergia() = 15);
	 }
}
