package Herencia;

public class Vehiculo {

    protected String placa;
    protected String marca;
    protected String color;

    public Vehiculo(String placa, String marca, String color) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public void mostrarDatos() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Color: " + color);
    }
}
