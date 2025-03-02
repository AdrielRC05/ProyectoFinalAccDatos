package as.ProyectoFinalAD.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion_rally")
public class ClasificacionRally {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "posicion_final")
    private int posicionFinal;

    @Column(name = "tiempo_total")
    private int tiempoTotal;

    @ManyToOne
    @JoinColumn(name = "rally_id")
    private Rally rally;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    public ClasificacionRally() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    public Rally getRally() {
        return rally;
    }

    public void setRally(Rally rally) {
        this.rally = rally;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }
}
