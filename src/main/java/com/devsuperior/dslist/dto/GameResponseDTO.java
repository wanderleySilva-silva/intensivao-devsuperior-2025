package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

import io.swagger.v3.oas.annotations.media.Schema;

public class GameResponseDTO {

	@Schema(name = "Id")
	private Long id;
	
	@Schema(name = "Tittle")
	private String title;
	
	@Schema(name = "Year")
	private Integer year;
	
	@Schema(name = "Genre")
	private String genre;
	
	@Schema(name = "Platforms")
	private String platforms;
	
	@Schema(name = "Score")
	private Double score;
	
	@Schema(name = "Img Url")
	private String imgUrl;
	
	@Schema(name = "Short Description")
	private String shortDescription;
	
	@Schema(name = "Long Description")
	private String longDescription;

	public GameResponseDTO(Game game) {
		this.id = game.getId();
		this.title = game.getTitle();
		this.year = game.getYear();
		this.genre = game.getGenre();
		this.platforms = game.getPlatforms();
		this.score = game.getScore();
		this.imgUrl = game.getImgUrl();
		this.shortDescription = game.getShortDescription();
		this.longDescription = game.getLongDescription();
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

	public String getGenre() {
		return genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public Double getScore() {
		return score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

}
