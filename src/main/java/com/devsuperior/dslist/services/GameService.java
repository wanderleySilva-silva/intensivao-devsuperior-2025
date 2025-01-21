package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameRequestDto;
import com.devsuperior.dslist.dto.GameResponseDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepository;
	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public GameResponseDto save(GameRequestDto gameRequestDto) {
		Game newGame = gameRequestDto.converterParaEntidade();
		Game savedGame = gameRepository.save(newGame);
		GameResponseDto gameDto = new GameResponseDto(savedGame);
		
		return gameDto; 
	}
	
	public List<GameResponseDto> findAll() {
		List<Game> allGames = gameRepository.findAll();
				
		return allGames.stream().map(game -> new GameResponseDto(game)).toList();
	}
}
