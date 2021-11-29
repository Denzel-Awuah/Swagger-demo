package com.swagger.demo.teams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swagger.demo.players.Player;
import com.thoughtworks.xstream.XStream;


@Controller
public class TeamsApiController implements TeamsApi {

    private static final Logger log = LoggerFactory.getLogger(TeamsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    public List<Team> teamList = new ArrayList<Team>();
    


    @Bean 
    public void createList() {
    	Team aTeam = new Team(7L , "Teadfdsfdsm");
    	Team aTeam1 = new Team(2L , "Tedfdsfsam");
    	Team aTeam2 = new Team(3L , "Tedsfsdfafsdfdm");
    	Team aTeam3 = new Team(6L , "Tdsfseam");
    	Team aTeam4 = new Team(8L , "Tfsdfsdeam");
    	teamList.add(aTeam);
    	teamList.add(aTeam1);
    	teamList.add(aTeam2);
    	teamList.add(aTeam3);
    	teamList.add(aTeam4);
    }
    

    @org.springframework.beans.factory.annotation.Autowired
    public TeamsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> getAllTeams() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
        	
        	 XStream xstream = new XStream();
             xstream.alias("teams", Team.class);
             
             String xmlOutput = xstream.toXML(teamList);
        	
            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
        }

        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
        }

        return new ResponseEntity<List<Team>>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }


	@Override
	public ResponseEntity<?> addNewTeam() {
		 String accept = request.getHeader("Accept");
	        if (accept != null && accept.contains("application/xml")) {
	        	
	        	 XStream xstream = new XStream();
	             xstream.alias("teams", Team.class);
	             
	             String xmlOutput = xstream.toXML(teamList);
	        	
	            return new ResponseEntity<String>(xmlOutput, HttpStatus.OK);
	        }

	        if (accept != null && accept.contains("application/json")) {
	            return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
	        }

	        return new ResponseEntity<List<Team>>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

}