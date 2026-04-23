public class main {
    public static void main(String[] args) {
        // Instancia con el nuevo constructor
        Pdf miDocumento = new Pdf("TallerPOO.pdf", 2);

        // Uso de getters para mostrar info
        System.out.println("Trabajando con: " + miDocumento.getNombre());

        // Ejecución de métodos
        miDocumento.guardar();
        miDocumento.exportar();
        miDocumento.imprimir();
    }
}