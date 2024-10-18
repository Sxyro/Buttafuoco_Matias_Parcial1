package primerparcialprogii;

import java.time.LocalDate;
import primerparcialprogii.models.*;

/**
 *
 * @author Bu_ma
 */
public class PrimerParcialProgII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CodigoInvalidoException, PromocionInvalidaException {
        System.out.println("1-1");
        LocalDate fechaActual = LocalDate.of(2024, 10, 18);
        try {
            Servicio nuevaGastronomia1 = new Gastronomia("4892", 15, true, fechaActual, "Hamburguesa Criolla", 180, 4);
            System.out.println(nuevaGastronomia1);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        System.out.println("\n1-2");
        try {
            Servicio nuevaGastronomia2 = new Gastronomia("489235", 15, true, fechaActual, "Hamburguesa Criolla", 180, 4);
            System.out.println(nuevaGastronomia2);
            System.out.println("\n2-1");
            LocalDate fechaParaCalculo = LocalDate.of(2020, 10, 28);
            System.out.println(nuevaGastronomia2.calcularPrecioFinal(fechaParaCalculo));
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        System.out.println("\n1-3");
        try {
            Servicio nuevoHospedaje1 = new Hospedaje("2872", 10, true, fechaActual, "Cabaña para 3 personas", 1500);
            System.out.println(nuevoHospedaje1);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        System.out.println("\n1-4");
        try {
            Servicio nuevoHospedaje2 = new Hospedaje("287282", 10, true, fechaActual, "Cabaña para 3 personas", 1500);
            System.out.println(nuevoHospedaje2);
            System.out.println("\n2-2");
            LocalDate fechaParaCalculo = LocalDate.of(2020, 10, 27);
            System.out.println(nuevoHospedaje2.calcularPrecioFinal(fechaParaCalculo));
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }

        System.out.println("\n3");
        Sistema sistema = new Sistema();
        LocalDate fechaParaConsultas4 = LocalDate.of(2020, 10, 28); // Esto es para el punto 4
        try {
            sistema.agregarGastronomia("858927", 15, true, fechaActual, "Milanesa con pure", 350, 3);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        try {
            sistema.agregarHospedaje("489259", 10, true, fechaParaConsultas4, "Habitacion Triple", 2200);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        try {
            sistema.agregarGastronomia("182835", 20, false, fechaParaConsultas4, "Gaseosa", 120, 3);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }
        try {
            sistema.agregarHospedaje("758971", 15, false, fechaActual, "Habitacion Simple", 1000);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (PromocionInvalidaException e1) {
            System.out.println(e1.getMessage());
        }       
        System.out.println(sistema.getLstServicio());
        
        System.out.println("4-1");
        System.out.println(sistema.traerServicio(true));
        System.out.println("4-2");
        System.out.println(sistema.traerServicio(true, fechaParaConsultas4));
        
    }

}
