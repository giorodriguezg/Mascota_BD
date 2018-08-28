package co.grgiral.mascota;

public class Mascota {

    private String nombre;
    private int id;
    private int likes;
    private int foto;

    public Mascota(String nombre, int id, int likes, int foto) {
        this.nombre = nombre;
        this.id = id;
        this.likes = likes;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
