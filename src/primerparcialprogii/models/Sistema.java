package primerparcialprogii.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bu_ma
 */
public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<Servicio>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    /**
     * 
     * @param codServicio El código unico del servicio.
     * @return El servicio que tiene el mismo codigo que fue pasado por parametro.
     * @throws CodigoInvalidoException Si el codigo es nulo, si su tamaño es distinto al pedido o si ya existe.
     */
    public Servicio traerServicio(String codServicio) throws CodigoInvalidoException {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        throw new CodigoInvalidoException("No se ha encontrado un servicio con ese codigo");
    }

    /**
     * 
     * @param enPromocion Indica si se busca un servicio que tenga promocion o no
     * @return Una lista de tipo Servicio con los servicios que hayan coincidido en el booleano.
     */
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> listaPromocion = new ArrayList<Servicio>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                listaPromocion.add(servicio);
            }
        }
        return listaPromocion;
    }

    /**
     * 
     * @param enPromocion Indica si se busca un servicio que tenga promocion o no
     * @param dia Indica la fecha que tendran los servicios que sean agregados a la lista.
     * @return Una lista de tipo Servicio con los servicios que hayan coincidido en ambos parametros
     */
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> listaPromocion = new ArrayList<>();

        for (Servicio servicio : lstServicio) {
            LocalDate fechaServicio = servicio.getFechaServicio();
            if (fechaServicio.equals(dia) && servicio.isEnPromocion() == enPromocion) {
                listaPromocion.add(servicio);
            }
        }
        return listaPromocion;
    }

    /**
     * 
     * @param codServicio El código unico del servicio.
     * @param porcentajeDescuento El porcentaje de descuento que se aplicará en días que exista promoción.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param fecha La fecha del servicio.
     * @param gastronomia El nombre del servicio ofrecido.
     * @param precio El precio base del servicio de gastronomía.
     * @param diaSemDesc El dia de la semana que se aplican descuentos.
     * @return true para confirmar que se agrego el servicio.
     * @throws CodigoInvalidoException Si el codigo es nulo, si su tamaño es distinto al pedido o si ya existe.
     * @throws PromocionInvalidaException Si el porcentaje es menor o igual a cero.
     * @throws IllegalArgumentException Si el dia de la semana no está entre 1 y 7.
     */
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha, String gastronomia, double precio, int diaSemDesc) throws CodigoInvalidoException,PromocionInvalidaException,IllegalArgumentException {
        Servicio nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, fecha, gastronomia, precio, diaSemDesc);
        return lstServicio.add(nuevoServicio);
    }

    /**
     * 
     * @param codServicio El código unico del servicio.
     * @param porcentajeDescuento El porcentaje de descuento que se aplicará en días que exista promoción.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param fecha La fecha del servicio.
     * @param hospedaje El nombre del servicio ofrecido.
     * @param precioPorNoche El precio por noche del servicio de hospedaje.
     * @return true para confirmar que se agrego el servicio.
     * @throws CodigoInvalidoException Si el codigo es nulo, si su tamaño es distinto al pedido o si ya existe.
     * @throws PromocionInvalidaException Si el porcentaje es menor o igual a cero.
     * @throws IllegalArgumentException Si el precio es menor o igual a cero.
     */
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate fecha, String hospedaje, double precioPorNoche) throws CodigoInvalidoException,PromocionInvalidaException,IllegalArgumentException {
        Servicio nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, fecha, hospedaje, precioPorNoche);
        return lstServicio.add(nuevoServicio);
    }

}
