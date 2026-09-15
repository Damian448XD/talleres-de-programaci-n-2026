public class Reserva {

    private String usuario;
    private Plaza plaza;

    public Reserva(
            String usuario,
            Plaza plaza) {

        this.usuario = usuario;
        this.plaza = plaza;
    }

    public String getUsuario() {
        return usuario;
    }

    public Plaza getPlaza() {
        return plaza;
    }
}