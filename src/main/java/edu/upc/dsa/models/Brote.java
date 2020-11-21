package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;
import java.util.LinkedList;
import java.util.List;

public class Brote {


    public String idBrote;
    public List<Caso> casosList;
    Caso caso;




    public Brote() /*Constrcutor Vacio*/ {
    }


    public Brote(String idBrote) /*Constructor*/ {
        this.idBrote = idBrote;
    }

    public void setCasosList(List<Caso> casosList) {
        this.casosList = casosList;
    }

    public String getIdBrote() {
        return idBrote;
    }

    public void setIdBrote(String idBrote) {
        this.idBrote = idBrote;
    }

    public List<Caso> getCasosList() {
        return casosList;
    }

    public void  addCaso(Caso o)
    {
        casosList.add(o);
    }

}
