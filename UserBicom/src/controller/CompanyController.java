package controller;

import util.Settings;

/**
 *Classe para a inicialização do servidor que o usuário está conectado
 * @author Juliana Aragão Pinto
 */
public class CompanyController {
    private Settings.Servidores company;

    public void setCompany(String value) {
        switch (value) {
            case "Azul":
                company = Settings.Servidores.AZUL;
                break;
            case "Gol":
                company = Settings.Servidores.GOL;
                break;
            case "Latam":   
                company = Settings.Servidores.LATAM;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String getHost(){
        return company.getHost();
    }
    
    public int getPort(){
        return company.getPort();
    }
    
    public String getNome(){
        return company.getNome();
    }
}
