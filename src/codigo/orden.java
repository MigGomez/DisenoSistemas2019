
package codigo;


public class orden {
        String id;
        String fecha;
        String mesero;
        String mesa;
        String cliente;
        String estado;
        String total;
        
        //*******************************************************************

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMesero() {
        return mesero;
    }

    public void setMesero(String mesero) {
        this.mesero = mesero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public orden(String id, String fecha, String mesero, String mesa, String cliente, String estado, String total) {
        this.id = id;
        this.fecha = fecha;
        this.mesero = mesero;
        this.mesa = mesa;
        this.cliente = cliente;
        this.estado = estado;
        this.total = total;
    }

    public orden() {
    }
        
}
