package Herencia;

public class Carro extends Vehiculo {

    public Carro(String placa, String marca, String color) {
        super(placa, marca, color);
    }

    public void tipoVehiculo() {
        System.out.println("Este vehiculo es un carro");
    }
}
