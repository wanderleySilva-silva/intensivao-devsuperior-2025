package com.devsuperior.dslist.controllores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListResponseDTO;
import com.devsuperior.dslist.dto.GameResponseMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	private GameListService gameListService;
	private GameService gameService;

	public GameListController(GameListService gameListService, GameService gameService) {
		this.gameListService = gameListService;
		this.gameService = gameService;
	}

	@GetMapping
	public ResponseEntity<List<GameListResponseDTO>> findAll() {
		return ResponseEntity.ok(gameListService.findAll());
	}
	
	@GetMapping("/{listId}/games")
	public ResponseEntity<List<GameResponseMinDTO>> findAllGamesByList(@PathVariable Long listId) {
		return ResponseEntity.ok(gameService.findAllByList(listId));
	}

}
