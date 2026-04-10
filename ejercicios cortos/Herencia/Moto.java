package Herencia;

public class Moto extends Vehiculo {

    public Moto(String placa, String marca, String color) {
        super(placa, marca, color);
    }

    public void tipoVehiculo() {
        System.out.println("Este vehiculo es una moto");
    }
}
