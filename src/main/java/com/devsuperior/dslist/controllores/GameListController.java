package com.devsuperior.dslist.controllores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListResponseDTO;
import com.devsuperior.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	private GameListService gameListService;

	public GameListController(GameListService gameListService) {
		this.gameListService = gameListService;
	}

	@GetMapping
	public ResponseEntity<List<GameListResponseDTO>> findAll() {
		return ResponseEntity.ok(gameListService.findAll());
	}

}
