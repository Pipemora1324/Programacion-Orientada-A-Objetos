package Herencia;

public class Main {

    public static void main(String[] args) {

        Carro carro1 = new Carro("ABC123", "Toyota", "Rojo");
        Moto moto1 = new Moto("XYZ789", "Yamaha", "Negro");

        System.out.println("Datos del carro:");
        carro1.tipoVehiculo();
        carro1.mostrarDatos();

        System.out.println("----------------------");

        System.out.println("Datos de la moto:");
        moto1.tipoVehiculo();
        moto1.mostrarDatos();
    }
}
