package utp.edu.co.ZonasPromisorias.model.entities.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsociacionProductorId implements Serializable {
    private Integer nitAsociacion;
    private Integer nitProductor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsociacionProductorId that = (AsociacionProductorId) o;
        return Objects.equals(nitAsociacion, that.nitAsociacion) && Objects.equals(nitProductor, that.nitProductor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nitAsociacion, nitProductor);
    }
}
