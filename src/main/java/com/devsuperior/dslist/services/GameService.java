package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameRequestDto;
import com.devsuperior.dslist.dto.GameResponseDto;
import com.devsuperior.dslist.dto.GameResponseMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepository;
	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public GameResponseMinDto save(GameRequestDto gameRequestDto) {
		Game newGame = gameRequestDto.converterParaEntidade();
		Game savedGame = gameRepository.save(newGame);
		GameResponseMinDto gameDto = new GameResponseMinDto(savedGame);
		
		return gameDto; 
	}
	
	@Transactional(readOnly = true)
	public GameResponseDto findById(Long id) {
		Game game = gameRepository.findById(id).get();
		return new GameResponseDto(game);
	}
	
	@Transactional(readOnly = true)
	public List<GameResponseMinDto> findAll() {
		List<Game> allGames = gameRepository.findAll();
				
		return allGames.stream().map(game -> new GameResponseMinDto(game)).toList();
	}
}
