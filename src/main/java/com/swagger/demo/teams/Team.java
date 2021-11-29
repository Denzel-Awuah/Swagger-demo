package com.swagger.demo.teams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.swagger.demo.players.Player;

import io.swagger.annotations.ApiModelProperty;

/**
 * Team
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-26T18:55:57.046Z")

@Entity
@Table(name = "team")
public class Team {

	@JsonProperty("teamid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teamid")
	private Long teamId = null;

	@JsonProperty("team_name")
	@Column(name = "team_name")
	private String teamName = null;

	@OneToMany(fetch=FetchType.LAZY, 
			mappedBy = "team", 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
						CascadeType.DETACH, CascadeType.REFRESH })
	private List<Player> players;

	
	public Team() {}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {

		this.players = players;
	}

	public void addPlayer(Player tempPlayer) {

		if (players == null) {
			players = new ArrayList<Player>();
		}

		players.add(tempPlayer);

		tempPlayer.setTeam(this);
	}

	public Team teamId(Long teamId) {
		this.teamId = teamId;
		return this;
	}

	public Team(Long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	/**
	 * Get teamId
	 * 
	 * @return teamId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Team teamName(String teamName) {
		this.teamName = teamName;
		return this;
	}

	/**
	 * Get teamName
	 * 
	 * @return teamName
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Team team = (Team) o;
		return Objects.equals(this.teamId, team.teamId) && Objects.equals(this.teamName, team.teamName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamId, teamName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Team {\n");

		sb.append("    teamId: ").append(toIndentedString(teamId)).append("\n");
		sb.append("    teamName: ").append(toIndentedString(teamName)).append("\n");
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
