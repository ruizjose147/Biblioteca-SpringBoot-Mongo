package co.com.sofka.app.BibliotecaSpringBoot.Mongo.repositories;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ILibrosRepositories extends MongoRepository<LibroDto, String> {
    List<LibroDto> findBytipo(final String tipo);
    List<LibroDto> findBycategoria(final String categoria);
}
