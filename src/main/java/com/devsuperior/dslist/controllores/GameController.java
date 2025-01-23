package com.devsuperior.dslist.controllores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameRequestDTO;
import com.devsuperior.dslist.dto.GameResponseDTO;
import com.devsuperior.dslist.dto.GameResponseMinDTO;
import com.devsuperior.dslist.services.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Games", description = "Game Controller")
@RestController
@RequestMapping(value = "/games")
public class GameController {

	private GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@Operation(summary = "Listar Todos")
	@GetMapping
	public ResponseEntity<List<GameResponseMinDTO>> findAll() {
		return ResponseEntity.ok(gameService.findAll());
	}
	
	@Operation(summary = "Listar por id")
	@GetMapping("/{id}")
	public ResponseEntity<GameResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(gameService.findById(id));
	}
	
	@Operation(summary = "Salvar")
	@PostMapping
	public ResponseEntity<GameResponseMinDTO> save(@RequestBody GameRequestDTO gameRequestDto){
		GameResponseMinDTO savedGame = gameService.save(gameRequestDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
	}
	
	@Operation(summary = "Deletar")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		
		gameService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
