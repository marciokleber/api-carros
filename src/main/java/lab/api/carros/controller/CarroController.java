package lab.api.carros.controller;

import jakarta.persistence.EntityNotFoundException;
import lab.api.carros.domain.Carro;
import lab.api.carros.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class CarroController {

    final private CarroRepository carroRepository;

    @GetMapping("carros")
    public ResponseEntity<List<Carro>> findAll(){
        var carros = carroRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Carro> findById(@PathVariable("id") Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        carroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carro not found"));
        carroRepository.deleteById(id);
    }

    @PostMapping()
    public ResponseEntity<Carro> save(@RequestBody Carro carro){
        return ResponseEntity.ok().body( carroRepository.save(carro));
    }

    @PutMapping("{id}")
    public ResponseEntity<Carro> update(@PathVariable("id") Long id, @RequestBody Carro updateCarro){
        var carro = carroRepository.findById(id);
        if(carro.isPresent()){
            BeanUtils.copyProperties(updateCarro, carro.get());
            return ResponseEntity.ok().body( carroRepository.save(carro.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
