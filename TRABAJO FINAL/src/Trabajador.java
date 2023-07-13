import java.time.LocalDate;

public class Trabajador {
    String NombreApellido;
    String DNI;
    LocalDate FechaDeContratado;
    public Trabajador(String NombreApellido,String DNI,LocalDate date){
        this.NombreApellido=NombreApellido;
        this.DNI=DNI;
        this.FechaDeContratado=date; ;
    }
}
