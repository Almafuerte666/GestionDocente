/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nico.gestiondocentes;

/**
 *
 * @author gonza
 */

    public class Titular extends Docente {
    private int antiguedad;

    public Titular(int legajo, String nombre, String apellido, String fechaNacimiento, int edad, double salario, int antiguedad) {
        super(legajo, nombre, apellido, fechaNacimiento, edad, salario);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

   
    public double calcularPlusSalarial() {
        if (getEdad() > 30 && antiguedad > 6) {
            return getSalario() + PLUS_RURALIDAD; 
        }
        return getSalario();
    }
    }


