package primerparcialprogii.models;

import java.time.LocalDate;

/**
 *
 * @author Bu_ma
 */
public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha, String hospedaje, double precioPorNoche) throws CodigoInvalidoException, PromocionInvalidaException, IllegalArgumentException {
        super(codServicio, porcentajeDescuento, enPromocion, fecha);
        
        if (precioPorNoche <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    /**
     * 
     * @param dia Es la fecha en la cual se calcula el precio
     * @return El precio final como double
     */
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.getPrecioPorNoche();
        if (dia.getDayOfWeek().getValue() <= 5) {
            precioFinal = precioFinal - (precioFinal * this.getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Hospedaje: " + hospedaje + super.toString() + " | Precio por noche: " + precioPorNoche;
    }

}
