package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    private CalculadorDescuentos calcu = new CalculadorDescuentos();
    private Double tar;

    @Test
    public void validarDescuentoCinco(){

            tar = calcu.calculoTarifa(1000,9,17);
            double rta = 950;

            Assert.assertEquals(tar,rta,0.0f);

    }
    @Test
    public void validarDescuentoOcho(){

            tar = calcu.calculoTarifa(1000,9,66);
            double rta = 920;

            Assert.assertEquals(tar,rta,0.0f);
    }

    @Test
    public void validarEdadMenorCero() {
        try{
            tar = calcu.calculoTarifa(1000,8,-10);

        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validarEdadCero(){
        try{
            tar = calcu.calculoTarifa(1000,7,0);

        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void noDeberiaTenerTodosDescuentos(){
        tar = calcu.calculoTarifa(50000,25,69);
        double rta = 36000;

        Assert.assertNotEquals(tar,rta,0.0f);
    }

    @Test
    public void validarEdadMayorDeCientoCincuenta(){
        try{
            tar = calcu.calculoTarifa(20000,13,200);
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }

    @Test
	public void validarSinDescuento(){

            tar = calcu.calculoTarifa(3000,15,19);
            double rta = 3000;

            Assert.assertEquals(tar,rta,0.0f);
    }

    @Test
    public void validarDescuentoQuince(){

            tar = calcu.calculoTarifa(10000,21,20);
            double rta = 8500;

            Assert.assertEquals(tar,rta,0.0f);

    }

    @Test
    public void validarDescuentoVeinte(){

            tar = calcu.calculoTarifa(10000,40,8);
            double rta = 8000;
            System.out.println(tar);
            Assert.assertEquals(tar,rta,0.0f);

    }

    @Test
    public void validarDescuentoVeintiTres(){

            tar = calcu.calculoTarifa(50000,25,69);
            double rta = 38500;

            Assert.assertEquals(tar,rta,0.0f);

    }
}