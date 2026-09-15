public class Plaza {

    private int id;
    private String codigo;
    private String estado;

    public Plaza(int id, String codigo) {
        this.id = id;
        this.codigo = codigo;
        this.estado = "LIBRE";
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public synchronized String getEstado() {
        return estado;
    }

    public synchronized void setEstado(String estado) {
        this.estado = estado;
    }

    public synchronized boolean reservar() {

        if (estado.equals("LIBRE")) {

            estado = "RESERVADA";

            return true;
        }

        return false;
    }

    public synchronized void ocupar() {

        estado = "OCUPADA";
    }

    public synchronized void liberar() {

        estado = "LIBRE";
    }
}