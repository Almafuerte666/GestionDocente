/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nico.gestiondocentes;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/docentes")
public class MiControlador {

    @GetMapping("/")
    @ResponseBody
    public String inicio() {
        return "Página de inicio de la Gestión de Docentes";
    }

    // Endpoint para mostrar un formulario de ingreso de datos para un docente titular
    @GetMapping("/titularForm")
    @ResponseBody
    public String mostrarFormularioTitular() {
        return "<form action='/docentes/titular' method='post'>" +
               "Legajo: <input type='text' name='legajo' required><br>" +
               "Nombre: <input type='text' name='nombre' required><br>" +
               "Apellido: <input type='text' name='apellido' required><br>" +
               "Fecha de Nacimiento: <input type='text' name='fechaNacimiento' required><br>" +
               "Edad: <input type='number' name='edad' required><br>" +
               "Salario: <input type='number' step='0.01' name='salario' required><br>" +
               "Antigüedad: <input type='number' name='antiguedad' required><br>" +
               "<button type='submit'>Crear Docente Titular</button>" +
               "</form>";
    }

    // Endpoint para manejar la creación de un docente titular
    @PostMapping("/titular")
    @ResponseBody
    public String crearDocenteTitular(
            @RequestParam int legajo,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String fechaNacimiento,
            @RequestParam int edad,
            @RequestParam double salario,
            @RequestParam int antiguedad) {
        
        Titular docenteTitular = new Titular(legajo, nombre, apellido, fechaNacimiento, edad, salario, antiguedad);
        double salarioConPlus = docenteTitular.calcularPlusSalarial();
        
        return "Docente Titular creado: " + docenteTitular.toString() + " - Salario con Plus: " + salarioConPlus;
    }

    // Endpoint para mostrar un formulario de ingreso de datos para un docente suplente
    @GetMapping("/suplenteForm")
    @ResponseBody
    public String mostrarFormularioSuplente() {
        return "<form action='/docentes/suplente' method='post'>" +
               "Legajo: <input type='text' name='legajo' required><br>" +
               "Nombre: <input type='text' name='nombre' required><br>" +
               "Apellido: <input type='text' name='apellido' required><br>" +
               "Fecha de Nacimiento: <input type='text' name='fechaNacimiento' required><br>" +
               "Edad: <input type='number' name='edad' required><br>" +
               "Salario: <input type='number' step='0.01' name='salario' required><br>" +
               "Zona Rural: <input type='text' name='zonaRural' required><br>" +
               "<button type='submit'>Crear Docente Suplente</button>" +
               "</form>";
    }

    // Endpoint para manejar la creación de un docente suplente
    @PostMapping("/suplente")
    @ResponseBody
    public String crearDocenteSuplente(
            @RequestParam int legajo,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String fechaNacimiento,
            @RequestParam int edad,
            @RequestParam double salario,
            @RequestParam String zonaRural) {
        
        Suplente docenteSuplente = new Suplente(legajo, nombre, apellido, fechaNacimiento, edad, salario, zonaRural);
        double salarioConPlus = docenteSuplente.calcularPlusSalarial();
        
        return "Docente Suplente creado: " + docenteSuplente.toString() + " - Salario con Plus: " + salarioConPlus;
    }
}
