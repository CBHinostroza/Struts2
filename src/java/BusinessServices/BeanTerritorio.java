package BusinessServices;

public class BeanTerritorio {

    private int codigoterritorio;
    private String departamento;
    private String provincia;
    private String distrito;

    public int getCodigoterritorio() {
        return codigoterritorio;
    }

    public void setCodigoterritorio(int codigoterritorio) {
        this.codigoterritorio = codigoterritorio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public BeanTerritorio() {
    }

    public BeanTerritorio(int codigoterritorio, String departamento, String provincia, String distrito) {
        this.codigoterritorio = codigoterritorio;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }
}
