package primerparcialprogii.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bu_ma
 */
public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate fechaServicio; // Adiciono la fecha como atributo para el correcto funcionamiento de las funciones
    protected static final Set<String> codigosExistentes = new HashSet<>(); // Almacenamiento de los codigos para evitar repetidos.

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha) throws CodigoInvalidoException, PromocionInvalidaException {
        if (codServicio == null) {
            throw new CodigoInvalidoException("Ese código es nulo");
        } else if (codServicio.length() != 6) {
            throw new CodigoInvalidoException("El código debe tener exactamente 6 caracteres");
        } else if (!codigosExistentes.add(codServicio)) {
            throw new CodigoInvalidoException("Ya existe un servicio con ese código");
        }
        this.codServicio = codServicio; // Asigno el valor por fuera ya que si no hubiese tirado excepcion.

        if (porcentajeDescuento <= 0) {
            throw new PromocionInvalidaException("El descuento no puede ser menor o igual a cero.");
        } else {
            this.porcentajeDescuento = porcentajeDescuento;
        }
        this.enPromocion = enPromocion;
        this.fechaServicio = fecha;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public LocalDate getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(LocalDate fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    @Override
    public String toString() {
        return " Codigo: " + codServicio + " | Porcentaje Descuento: " + porcentajeDescuento + " | En promocion: " + enPromocion + " | Fecha: " + fechaServicio;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);

}
