package com.swagger.demo.players;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swagger.demo.teams.Team;
import com.thoughtworks.xstream.XStream;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-26T18:55:57.046Z")

@Controller
public class PlayersApiController implements PlayersApi {

    private static final Logger log = LoggerFactory.getLogger(PlayersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private PlayerService service;
    
    private List<Player> tempList = new ArrayList<>();
    
    @Bean
    public void createPlayers() {
    	tempList.add(new Player(30L, "Denzel", new Team(20L , "Arsenal")));
    }
   

    @Autowired
    public PlayersApiController(ObjectMapper objectMapper, HttpServletRequest request, PlayerService theService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = theService;
    }
    

    @Override
    public ResponseEntity<?> getAllPlayers() {
        String accept = request.getHeader("Accept");
        List<Player> allPlayers = service.allPlayers();
        
        if (accept != null && accept.contains("application/xml")) {
            XStream xstream = new XStream();
            xstream.alias("players", Player.class);
            
            String xmlOutput = xstream.toXML(allPlayers);
            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<Player>>(allPlayers, HttpStatus.OK);
        }
        

        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }


	@Override
	public ResponseEntity<?> getPlayerById(@ApiParam(value = "player id to retrieve player",required=true) @PathVariable("playerid") Long playerid) {
		 String accept = request.getHeader("Accept");
		 Player playerById = service.getPlayerById(playerid);
	        if (accept != null && accept.contains("application/xml")) {
	        	
	            XStream xstream = new XStream();
	            xstream.alias("players", Player.class);
	            
	            String xmlOutput = xstream.toXML(playerById);
	        	
	            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
	        }

	        if (accept != null && accept.contains("application/json")) {
	            return new ResponseEntity<Player>(playerById, HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}


	@Override
	public ResponseEntity<?> addNewPlayer(@ApiParam(value = "player id to retrieve player",required=true) @RequestBody Player thePlayer) {
		 String accept = request.getHeader("Accept");
		 service.save(thePlayer);
	        if (accept != null && accept.contains("application/xml")) {
	        	
	            XStream xstream = new XStream();
	            xstream.alias("players", Player.class);
	            
	            String xmlOutput = xstream.toXML(thePlayer);
	        	
	            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
	        }

	        if (accept != null && accept.contains("application/json")) {
	            return new ResponseEntity<Player>(thePlayer, HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}


	@Override
	public ResponseEntity<?> updatePlayer(@ApiParam(value = "player id to retrieve player",required=true) @RequestBody Player thePlayer) {
		 String accept = request.getHeader("Accept");
		 service.save(thePlayer);
	        if (accept != null && accept.contains("application/xml")) {
	        	
	            XStream xstream = new XStream();
	            xstream.alias("players", Player.class);
	            
	            String xmlOutput = xstream.toXML(thePlayer);
	        	
	            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
	        }

	        if (accept != null && accept.contains("application/json")) {
	            return new ResponseEntity<Player>(thePlayer, HttpStatus.OK);
	        }
	        
	        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}


	@Override
	public ResponseEntity<?> deletePlayer(@ApiParam(value = "player id to retrieve player",required=true) @PathVariable("playerid") Long playerid) {
		String accept = request.getHeader("Accept");
		Player playerById = service.getPlayerById(playerid);
		service.deletePlayerById(playerid);
        if (accept != null && accept.contains("application/xml")) {
        	
            XStream xstream = new XStream();
            xstream.alias("players", Player.class);
            
            String xmlOutput = xstream.toXML(playerById);
        	
            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Player>(playerById, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}