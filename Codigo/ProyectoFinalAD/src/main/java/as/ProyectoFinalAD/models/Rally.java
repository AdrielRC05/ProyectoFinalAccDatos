package as.ProyectoFinalAD.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rally")
public class Rally {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String localizacion;
    @Column(nullable = false, name = "fecha_celebracion")
    private String fechaCelebracion;

    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = false)
    private Campeonato campeonato;

    public Rally() {
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

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getFechaCelebracion() {
        return fechaCelebracion;
    }

    public void setFechaCelebracion(String fechaCelebracion) {
        this.fechaCelebracion = fechaCelebracion;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
