package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListResponseDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	private GameListRepository gameListRepository;
	
	public GameListService(GameListRepository gameListRepository) {
		this.gameListRepository = gameListRepository;
	}
	
	@Transactional(readOnly = true)
	public List<GameListResponseDTO> findAll() {
		List<GameList> allGamesList = gameListRepository.findAll();
				
		return allGamesList.stream().map(game -> new GameListResponseDTO(game)).toList();
	}
}
