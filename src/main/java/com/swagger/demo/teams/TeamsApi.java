package com.swagger.demo.teams;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-26T18:55:57.046Z")

@Validated
@Api(value = "teams", description = "the teams API")
@RequestMapping(value = "/api")
public interface TeamsApi {

    @ApiOperation(value = "Get all teams", nickname = "getAllTeams", notes = "", response = Team.class, responseContainer = "List", tags={ "team", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Team.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/teams",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getAllTeams();
    
    @ApiOperation(value = "Add new team", nickname = "addNewTeam", notes = "", response = Team.class, responseContainer = "List", tags={ "team", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Team.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/teams",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<?> addNewTeam();

}