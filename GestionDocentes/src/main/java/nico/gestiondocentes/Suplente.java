/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nico.gestiondocentes;


/**
 *
 * @author gonza
 */

    public class Suplente extends Docente {
    private String zonaRural;

    public Suplente(int legajo, String nombre, String apellido, String fechaNacimiento, int edad, double salario, String zonaRural) {
        super(legajo, nombre, apellido, fechaNacimiento, edad, salario);
        this.zonaRural = zonaRural;
    }

    public String getZonaRural() {
        return zonaRural;
    }

    public void setZonaRural(String zonaRural) {
        this.zonaRural = zonaRural;
    }

    @Override
    public double calcularPlusSalarial() {
        if (getEdad() < 25 && "Zona Rural A".equals(zonaRural)) {
            return getSalario() + PLUS_RURALIDAD;
        }
        return getSalario();
    }
}


