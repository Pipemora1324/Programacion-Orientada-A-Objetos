public class Pdf implements Exportado, Guardado, imprimido {
    // Atributos
    private String nombre;
    private int paginas;

    // Constructor
    public Pdf(String nombre, int paginas) {
        this.nombre = nombre;
        this.paginas = paginas;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPaginas() {
        return paginas;
    }

    // Implementación de métodos de las interfaces
    @Override
    public void exportar() {
        System.out.println("Exportando " + nombre + " (" + paginas + " págs)");
    }

    @Override
    public void guardar() {
        System.out.println("Archivo " + nombre + " guardado con éxito.");
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo " + paginas + " páginas de: " + nombre);
    }
}