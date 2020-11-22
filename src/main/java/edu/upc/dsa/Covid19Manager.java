package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface Covid19Manager {
    public Brote addBrote(String IdBrote); /*Añadira un nuevo brote y nos devuelve este mismo a modo de revisar*/
    public Collection<Brote> broteDisp();
    public List<Caso> ordenarCasos(String idBrote);/* Me devuelve la lista con los casos*/
    public int sizeBrotes();
    public int sizeCasos();
    /* public void AddCaso (Caso o);*/
    public Caso afegirCaso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificacion, String genero, String correo, String telefono, String direccion, String idBrote);
    public List<Caso> casoBrote(String idBrote);
    public Brote getBrote(String idBrote);


}
