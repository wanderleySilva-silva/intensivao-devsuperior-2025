package com.devsuperior.dslist.controllores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListResponseDTO;
import com.devsuperior.dslist.dto.GameResponseMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "GameList", description = "GameList Controller")
@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	private GameListService gameListService;
	private GameService gameService;

	public GameListController(GameListService gameListService, GameService gameService) {
		this.gameListService = gameListService;
		this.gameService = gameService;
	}
	
	@Operation(summary = "Listar todas")
	@GetMapping
	public ResponseEntity<List<GameListResponseDTO>> findAll() {
		return ResponseEntity.ok(gameListService.findAll());
	}
	
	@Operation(summary = "Listar todos games da lista de games")
	@GetMapping("/{listId}/games")
	public ResponseEntity<List<GameResponseMinDTO>> findAllGamesByList(@PathVariable Long listId) {
		return ResponseEntity.ok(gameService.findAllByList(listId));
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
	
	@Operation(summary = "Deletar")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		
		gameListService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
