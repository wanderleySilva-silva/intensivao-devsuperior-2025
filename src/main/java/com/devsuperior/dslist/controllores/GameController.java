package com.devsuperior.dslist.controllores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameRequestDto;
import com.devsuperior.dslist.dto.GameResponseDto;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	private GameService gameService;

	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@GetMapping
	public ResponseEntity<List<GameResponseDto>> findAll() {
		return ResponseEntity.ok(gameService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<GameResponseDto> save(@RequestBody GameRequestDto gameRequestDto){
		GameResponseDto savedGame = gameService.save(gameRequestDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
	}

}
