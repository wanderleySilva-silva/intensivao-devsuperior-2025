package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameRequestDTO;
import com.devsuperior.dslist.dto.GameResponseDTO;
import com.devsuperior.dslist.dto.GameResponseMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepository;
	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public GameResponseMinDTO save(GameRequestDTO gameRequestDto) {
		Game newGame = gameRequestDto.converterParaEntidade();
		Game savedGame = gameRepository.save(newGame);
		GameResponseMinDTO gameDto = new GameResponseMinDTO(savedGame);
		
		return gameDto; 
	}
	
	@Transactional(readOnly = true)
	public GameResponseDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		return new GameResponseDTO(game);
	}
	
	@Transactional(readOnly = true)
	public List<GameResponseMinDTO> findAll() {
		List<Game> allGames = gameRepository.findAll();
				
		return allGames.stream().map(game -> new GameResponseMinDTO(game)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameResponseMinDTO> findAllByList(Long listId) {
		List<GameMinProjection> allGames = gameRepository.searchByList(listId);
				
		return allGames.stream().map(game -> new GameResponseMinDTO(game)).toList();
	}
	
	public void deleteById(Long id) {
		gameRepository.deleteById(id);
	}
}
