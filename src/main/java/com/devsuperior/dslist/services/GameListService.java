package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListResponseDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	private GameListRepository gameListRepository;
	
	private GameRepository gameRepository;
	
	public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
		this.gameListRepository = gameListRepository;
		this.gameRepository = gameRepository;
	}
	
	
	@Transactional(readOnly = true)
	public List<GameListResponseDTO> findAll() {
		List<GameList> allGamesList = gameListRepository.findAll();
				
		return allGamesList.stream().map(game -> new GameListResponseDTO(game)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex:sourceIndex;for (int i = min; i <= max; i++) {
		gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);}
	}
	
	public void deleteById(Long id) {
		gameListRepository.deleteById(id);
	}
}
