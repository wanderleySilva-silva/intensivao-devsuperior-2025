package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListResponseDTO {

	private Long id;
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
