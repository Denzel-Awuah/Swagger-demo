package com.swagger.demo.players;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-26T18:55:57.046Z")

@Validated
@Api(value = "players", description = "the players API")
@RequestMapping(value = "/api")
public interface PlayersApi {

    @ApiOperation(value = "Get all players", nickname = "getAllPlayers", notes = "", response = Player.class, responseContainer = "List", tags={ "player", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Player.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/players",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getAllPlayers();
    
    
    @ApiOperation(value = "Get a player by id", nickname = "getPlayerById", notes = "", response = Player.class, responseContainer = "List", tags={ "player", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully retrieved player", response = Player.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/players/{playerid}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getPlayerById(@ApiParam(value = "player id to retrieve player",required=true) @PathVariable("playerid") Long playerid);
    
    
    @ApiOperation(value = "Add new Player", nickname = "addNewPlayer", notes = "", response = Player.class, responseContainer = "List", tags={ "player", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully retrieved player", response = Player.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/players",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<?> addNewPlayer(@ApiParam(value = "player object to add new player",required=true) @RequestBody Player thePlayer);
    
    
    @ApiOperation(value = "Update a Player", nickname = "updatePlayer", notes = "", response = Player.class, responseContainer = "List", tags={ "player", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully updated player", response = Player.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/players",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<?> updatePlayer(@ApiParam(value = "player id to update player",required=true) @RequestBody Player thePlayer);
    
    
    @ApiOperation(value = "Delete a Player", nickname = "deletePlayer", notes = "", response = Player.class, responseContainer = "List", tags={ "player", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successfully deleted player", response = Player.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "Nothing found") })
    @RequestMapping(value = "/players/{playerid}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<?> deletePlayer(@ApiParam(value = "player id to delete player",required=true) @PathVariable("playerid") Long playerid);
    
}

