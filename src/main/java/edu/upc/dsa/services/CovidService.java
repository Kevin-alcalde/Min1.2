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
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Api(value = "/Covid", description = "Endpoint to Text Service")
@Path("Covid")
public class CovidService {

    private Covid19Manager cm;

    public CovidService()
    {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizeBrotes()==0){
            this.cm.addBrote("brote1");
            this.cm.addBrote("brote2");


        }

        if(cm.sizeCasos()==0){

            this.cm.afegirCaso("Kevin","Alcalde","Caso1",new Date(32,34,3),new Date(23,34,43),"nocaso","masculino","kevinalca","423423","travLesCorts","brote1" );
            this.cm.afegirCaso("Joel","Alcalde","Caso2",new Date(32,34,3),new Date(23,34,43),"confirmado","masculino","kevinalca","423423","travLesCorts","brote1" );
            this.cm.afegirCaso("Majo","Garcia","Caso3",new Date(32,34,3),new Date(23,34,43),"sospechoso","femenino","kevinalca","423423","travLesCorts","brote1" );
        }


    }
    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes() {

        Collection<Brote> brotes = this.cm.broteDisp();

        GenericEntity<Collection<Brote>> entity = new GenericEntity<Collection<Brote>>(brotes) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @POST /*Añadimos un nuevoi brote */
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(String idBrotes) {

        /* if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();*/
        this.cm.addBrote(idBrotes);
        return Response.status(201).entity(idBrotes).build();
    }





















}
