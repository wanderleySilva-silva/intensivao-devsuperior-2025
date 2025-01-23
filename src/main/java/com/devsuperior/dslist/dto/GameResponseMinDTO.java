package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "GameMínimo Response DTO", description = "GameMínimo Response DTO")
public class GameResponseMinDTO {

	@Schema(name = "Id")
	private Long id;
	
	@Schema(name = "Tittle")
	private String title;
	
	@Schema(name = "Year")
	private Integer year;
	
	@Schema(name = "Img Url")
	private String imgUrl;
	
	@Schema(name = "Short Description")
	private String shortDescription;
	
	public GameResponseMinDTO() {

	}

	public GameResponseMinDTO(Game game) {
		this.id = game.getId();
		this.title = game.getTitle();
		this.year = game.getYear();
		this.imgUrl = game.getImgUrl();
		this.shortDescription = game.getShortDescription();
	}
	
	public GameResponseMinDTO(GameMinProjection gameMinProjection) {
		this.id = gameMinProjection.getId();
		this.title = gameMinProjection.getTitle();
		this.year = gameMinProjection.getGameYear();
		this.imgUrl = gameMinProjection.getImgUrl();
		this.shortDescription = gameMinProjection.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

}
