package primerparcialprogii.models;

import java.time.LocalDate;

/**
 *
 * @author Bu_ma
 */
public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha, String gastronomia, double precio, int diaSemDesc) throws CodigoInvalidoException, PromocionInvalidaException, IllegalArgumentException {
        super(codServicio, porcentajeDescuento, enPromocion, fecha);
        
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        if (diaSemDesc < 1 || diaSemDesc > 7) {
            throw new IllegalArgumentException("El dia de la semana tiene que estar entre 1 y 7.");
        }
        
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    /**
     * 
     * @param dia Es la fecha en la cual se calcula el precio
     * @return El precio final como double
     */
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.getPrecio();
        if (dia.getDayOfWeek().getValue() == this.getDiaSemDesc()) {
            precioFinal = precioFinal - (precioFinal * this.getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Gastronomia: " + gastronomia + super.toString() + " | Precio: " + precio + " | Dia con descuento: " + diaSemDesc;
    }

}
