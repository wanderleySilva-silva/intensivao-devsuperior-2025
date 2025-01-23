package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "GameList Response DTO", description = "GameList Response DTO")
public class GameListResponseDTO {

	@Schema(name = "Id")
	private Long id;
	@Schema(name = "Name")
	private String name;

	public GameListResponseDTO() {

	}

	public GameListResponseDTO(GameList gameList) {
		id = gameList.getId();
		name = gameList.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
