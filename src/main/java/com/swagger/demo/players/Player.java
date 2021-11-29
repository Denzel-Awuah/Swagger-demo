package com.swagger.demo.players;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swagger.demo.teams.Team;

import io.swagger.annotations.ApiModelProperty;

/**
 * Player
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-26T18:55:57.046Z")

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playerid")
	@JsonProperty("playerid")
	private Long playerId = null;

	@JsonProperty("player_name")
	@Column(name = "player_name")
	private String playerName = null;

	@JsonProperty("team")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
						   CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "teamid")
	private Team team = null;

	public Player() {}
	
	public Player playerId(Long playerId) {
		this.playerId = playerId;
		return this;
	}

	public Player(Long playerId, String playerName, Team team) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.team = team;
	}
	
	

	/**
	 * Get playerId
	 * 
	 * @return playerId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Player playerName(String playerName) {
		this.playerName = playerName;
		return this;
	}

	/**
	 * Get playerName
	 * 
	 * @return playerName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Player team(Team team) {
		this.team = team;
		return this;
	}

	/**
	 * Get team
	 * 
	 * @return team
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Player player = (Player) o;
		return Objects.equals(this.playerId, player.playerId) && Objects.equals(this.playerName, player.playerName)
				&& Objects.equals(this.team, player.team);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerId, playerName, team);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Player {\n");

		sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
		sb.append("    playerName: ").append(toIndentedString(playerName)).append("\n");
		sb.append("    team: ").append(toIndentedString(team)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}