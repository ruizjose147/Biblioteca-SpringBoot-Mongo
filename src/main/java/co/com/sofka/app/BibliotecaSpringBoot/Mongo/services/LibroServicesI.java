package co.com.sofka.app.BibliotecaSpringBoot.Mongo.services;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;

import java.util.List;
import java.util.Optional;

public interface LibroServicesI {

    public Optional<LibroDto> consultarLibroDtoPorID(String id);
    List<LibroDto> mostrarTodos();
    public Optional<LibroDto> getById(String id);
    public LibroDto agregarLibroDto(LibroDto libroDto);
    public boolean eliminarLibroDtoPorID(String id);
    public LibroDto actualizarLibroDto(LibroDto libroDto);
    public boolean verificarDisponibleLibroDto(LibroDto libroDto);
    public List<LibroDto> recomendarPorCategoria(String categoria);
    public List<LibroDto> recomendarPorTipo(String tipo);
    public String libroDtoPrestado(String id);
    public String libroDtoRegresado(String id);
}
