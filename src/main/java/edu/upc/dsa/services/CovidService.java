package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Api(value = "/Covid", description = "Endpoint to Text Service")
@Path("Covid")
public class CovidService {

    private Covid19Manager cm;

    public CovidService() {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizeBrotes() == 0) {
            this.cm.addBrote("brote1");
            this.cm.addBrote("brote2");


        }

        if (cm.sizeCasos() == 0) {

            this.cm.afegirCaso("Kevin", "Alcalde", "Caso1", new Date(32, 34, 3), new Date(23, 34, 43), "c/nocaso", "masculino", "kevinalca", "423423", "travLesCorts", "brote1");
            this.cm.afegirCaso("Joel", "Alcalde", "Caso2", new Date(32, 34, 3), new Date(23, 34, 43), "a/confirmado", "masculino", "kevinalca", "423423", "travLesCorts", "brote1");
            this.cm.afegirCaso("Majo", "Garcia", "Caso3", new Date(32, 34, 3), new Date(23, 34, 43), "b/sospechoso", "femenino", "kevinalca", "423423", "travLesCorts", "brote1");
        }


    }

    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes() {

        Collection<Brote> brotes = this.cm.broteDisp();

        GenericEntity<Collection<Brote>> entity = new GenericEntity<Collection<Brote>>(brotes) {
        };
        return Response.status(201).entity(entity).build();

    }

    @POST /*Añadimos un nuevo brote */
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addbrote/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(@PathParam("id") String idBrote) {

        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/
        Brote brote = this.cm.addBrote(idBrote);
        return Response.status(201).entity(brote).build();
    }


    @GET
    @ApiOperation(value = "update a ListaCaso", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Caso.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/prueba/{id}")
    public Response OrderLista(@PathParam("id")String  idBrote) {

         cm.ordenarCasos("brote1"); /* Esta mal el ordenamiento*/

        List <Caso> casos = this.cm.ordenarCasos(idBrote);


        GenericEntity<List<Caso>> entity = new GenericEntity<List<Caso>>(casos) {
        };
        return Response.status(201).entity(entity).build();

    }

    @POST /*Añadimos un nuevo CASO */
    @ApiOperation(value = "create a new Caso", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/caso/{nombre}/{apellido}/{idCaso}/{diaNacimiento}/{mesNacimiento}/{añoNacimiento}/{diaInformte}/{mesInforme}/{añoInforme}/{cLasificacion}/{genero}/{correo}/{telefono}/{direccion}/{idBrote}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCASO (@PathParam("nombre")String nombre, @PathParam("apellido")String apellido,@PathParam("idCaso")String idCaso,@PathParam("diaNacimiento") int diaNacimiento, @PathParam("mesNacimiento")int mesNacimiento,@PathParam("añoNacimiento")int añoNacimiento,@PathParam("diaInforme") int diaInforme,@PathParam("mesInforme")int mesInforme,@PathParam("añoInforme")int añoInforme,@PathParam("clasificación")String clasificacion,@PathParam("genero")String genero,@PathParam("correo")String correo, @PathParam("telefono")String telefono,@PathParam("direccion")String direccion,@PathParam("idBrote")String idBrote) {
        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/
        Date fechaNacimiento = new Date (diaNacimiento,mesNacimiento,añoNacimiento);
        Date fechaInforme = new Date(diaInforme,mesInforme,añoInforme);




        Caso caso = this.cm.afegirCaso(nombre,apellido,idCaso,fechaNacimiento,fechaInforme,clasificacion,genero,correo,telefono,direccion,idBrote);

        List  casos = this.cm.getBrote(idBrote).getCasosList();

        GenericEntity<List<Caso>> entity = new GenericEntity<List<Caso>>(casos) {
        };
        return Response.status(201).entity(entity).build();
    }
















}
