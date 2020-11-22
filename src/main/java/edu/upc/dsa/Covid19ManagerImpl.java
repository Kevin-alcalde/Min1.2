package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {



    private static Covid19ManagerImpl manager; /* SINGLETONE*/

    static final Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());

    HashMap<String, Brote> brotes;
    List<Caso> casos ;
    String id;
    List<Caso> casosBrotes;




    private Covid19ManagerImpl(){
        /* Señalizamos las estructuras de datos */

        this.brotes = new HashMap<String, Brote>();
        this.casos  = new LinkedList<Caso>();
        this.casosBrotes = new LinkedList<>();



    }
    public static Covid19ManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) manager = new Covid19ManagerImpl();
        return manager;


    }
    public static void delete(){
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");
    }


    @Override
    public Brote addBrote(String idBrote) {
        Brote broteNuevo = new Brote(idBrote); /* Creo un brote */
        this.brotes.put(idBrote,broteNuevo); /* Lo añado al Hashmap con un identificador*/
        logger.info("Identificador del brote a agregar: "+ idBrote);
        return broteNuevo;
    }

    @Override
    public Collection<Brote> broteDisp() { /* ??*/


        logger.info("Brotes disponibles");
        return this.brotes.values();



    }

    @Override
    public List<Caso> ordenarCasos(String idBrote) {
        Brote broteSeleccionado = brotes.get(idBrote);

        for (Caso f : broteSeleccionado.getCasosList()) {

            Collections.sort(broteSeleccionado.casosList, new Comparator<Caso>() {
                @Override
                public int compare(Caso o1, Caso o2) {
                    return o1.getClasificacion().compareTo(o2.getClasificacion());
                }
            });

                Collections.sort(broteSeleccionado.casosList, new Comparator<Caso>() {
                    @Override
                    public int compare(Caso o1, Caso o2) {

                        return o1.getFechaInforme().compareTo(o2.getFechaInforme());
                    }

                });


        }
        return broteSeleccionado.casosList;
    }


    @Override
    public int sizeBrotes() {
        int ret = this.brotes.size();
        logger.info("size brote" + ret);

        return ret;
    }

    @Override
    public int sizeCasos() {
        int ret = this.casos.size();
        logger.info("size casos" + ret);

        return ret;
    }

   /* @Override
    public void AddCaso(Caso o) {

     this.casos.add(o);


   } */

    @Override
    public Caso afegirCaso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificacion, String genero, String correo, String telefono, String direccion, String idBrote) {
        Caso nuevo = new Caso (nombre,apellidos,idCaso,fechaNacimiento,fechaInforme,clasificacion,genero,correo,telefono,direccion,idBrote);
        this.casos.add(nuevo);
        this.brotes.get(idBrote).setCasosList(casos);
        logger.info("se han añadido caso(s) al brote con id:"+idBrote);
        return nuevo;


    }

    @Override
    public List<Caso> casoBrote(String idBrote) {
        return null;
    }




    public Brote getBrote (String idBrote)
    {
        for(Brote b: this.brotes.values()){
            if(b.getIdBrote().equals(idBrote)){
                return b;
            }
        }
        return null;

    }



}
