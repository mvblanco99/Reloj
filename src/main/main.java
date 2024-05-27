/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Manuel Blanco
 */

/*
4)Elaborar un programa que permita crear un reloj, ajustarlo a una hora solicitada 
y mostrarla en formato “HH:MM:SS AM/PM” , tomando en cuenta que: (listo)
    a.Los atributos del reloj deben manejarse con métodos accesores. (listo)
    b.Si la hora, minutos y segundos están fuera de rango, mostrar un error en cada caso. (listo)
    c.El reloj debe tener una función para resetear.(listo)
*/
public class main {
    
    public static void main(String[] args) {
        RelojFrame relojFrame = new RelojFrame();
        relojFrame.setTitle("Reloj Super Sensacional");
        relojFrame.setVisible(true);
    }
}
