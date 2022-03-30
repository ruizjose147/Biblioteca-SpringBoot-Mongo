package co.com.sofka.app.BibliotecaSpringBoot.Mongo.controller;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;
import co.com.sofka.app.BibliotecaSpringBoot.Mongo.services.impl.LibroServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("biblioteca/libros")
public class LibroController {

    @Autowired
    LibroServicesImpl libroServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LibroDto> mostrarPorID(@PathVariable() String id){
        return libroServices.getById(id).map(ebookDTO -> new ResponseEntity<>(
                ebookDTO, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/mostraTodos")
    public List<LibroDto> listarTodos(){
        return libroServices.mostrarTodos();
    }


    @PostMapping(value="crear")
    public ResponseEntity<LibroDto> crear (@RequestBody LibroDto libroDto){
        return new ResponseEntity<>(libroServices.agregarLibroDto(libroDto),HttpStatus.CREATED);
    }

    @PutMapping("/prestar/{id}")
    public ResponseEntity<String> libroPrestado(@PathVariable() String id){
        return new ResponseEntity<>(libroServices.libroDtoPrestado(id),HttpStatus.OK);
    }

    @PutMapping("/devolver/{id}")
    public ResponseEntity libroRegresado(@PathVariable("id") String id) {
        return new ResponseEntity(libroServices.libroDtoRegresado(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        if(libroServices.eliminarLibroDtoPorID(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/actualizar")
    public  ResponseEntity<LibroDto> actualizar(@RequestBody LibroDto libroDto){
        return new ResponseEntity<>(libroServices.actualizarLibroDto(libroDto), HttpStatus.OK);
    }

    @PutMapping(value = "/disponible")
    public ResponseEntity<String> libroDisponible(@PathVariable() LibroDto libroDto){
        return new ResponseEntity(libroServices.verificarDisponibleLibroDto(libroDto), HttpStatus.OK);
    }

    @GetMapping("/recomendar/tipo/{tipo}")
    public ResponseEntity<List<LibroDto>> recomendarPorTipo(@PathVariable() String tipo){
        return new ResponseEntity<>(libroServices.recomendarPorTipo(tipo),HttpStatus.OK);
    }

    @GetMapping("/recomendar/categoria/{categoria}")
    public ResponseEntity<List<LibroDto>> recomendarPorCategoria(@PathVariable() String categoria){
        return new ResponseEntity<>(libroServices.recomendarPorCategoria(categoria),HttpStatus.OK);
    }
}
