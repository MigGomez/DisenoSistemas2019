package codigo;

public class variables_productos {
    int id;
    String nombre;
    Double precio;
    int categoria;
    int espreparado;

    public variables_productos(int id, String nombre, Double precio, int categoria, int espreparado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.espreparado = espreparado;
    }

    public variables_productos(String nombre, Double precio, int categoria, int espreparado) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.espreparado = espreparado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEspreparado() {
        return espreparado;
    }

    public void setEspreparado(int espreparado) {
        this.espreparado = espreparado;
    }
    
}
