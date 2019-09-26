package model;

/**
 *
 * @author Juliana Aragão Pinto
 */
public class Semaforo {
    private boolean golQuer;
    private boolean LatamQuer;
    private boolean AzulQuer;
    private String permissao;

    public Semaforo() {
        AzulQuer = false;
        LatamQuer = false;
        AzulQuer = false;
        permissao = "nenhuma";
    }

    public boolean GolQuer() {
        return golQuer;
    }

    public void setGolQuer(boolean golQuer) {
        this.golQuer = golQuer;
    }

    public boolean LatamQuer() {
        return LatamQuer;
    }

    public void setLatamQuer(boolean LatamQuer) {
        this.LatamQuer = LatamQuer;
    }

    public boolean AzulQuer() {
        return AzulQuer;
    }

    public void setAzulQuer(boolean AzulQuer) {
        this.AzulQuer = AzulQuer;
    }

    public String getPermissao() {
        return permissao;
    }
    
    public boolean alguemQuer(){
        return AzulQuer || LatamQuer || golQuer;
    }
    
    public void tirarPermissao(String permissao){
        if(permissao.equalsIgnoreCase("Azul")){
            AzulQuer = false;
        }else if(permissao.equalsIgnoreCase("Latam")){
            LatamQuer = false;
        }else if(permissao.equalsIgnoreCase("Gol")){
            golQuer = false;
        }
        
        permissao = "nenhuma";
    }

    public void setPermissao(String permissao) {
        if(permissao.equalsIgnoreCase("Azul")){
            AzulQuer = true;
        }else if(permissao.equalsIgnoreCase("Latam")){
            LatamQuer = true;
        }else if(permissao.equalsIgnoreCase("Gol")){
            golQuer = true;
        }
        this.permissao = permissao;
    }

}
