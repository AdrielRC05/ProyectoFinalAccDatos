package as.ProyectoFinalAD.models;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "participacion")
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "posicion_final")
    private int posicionFinal;

    @Column(name = "tiempo_total")
    private String tiempoTotal;

    @ManyToOne
    @JoinColumn(name = "rally_id")
    private Rally rally;

    @ManyToOne
    @JoinColumn(name = "piloto_id")
    private Piloto piloto;

    @ManyToOne
    @JoinColumn(name = "copiloto_id")
    private Copiloto copiloto;

    public Participacion() {
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

    public String getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(String tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
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

    public Copiloto getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(Copiloto copiloto) {
        this.copiloto = copiloto;
    }
}
